package com.specification_demo.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.specification_demo.demo.constant.ProjectConstant;
import com.specification_demo.demo.entity.Project;
import com.specification_demo.demo.exception.CustomException;
import com.specification_demo.demo.repository.ProjectRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * 
 * @author Mindbowser | pragati.gawade@mindbowser.com
 *
 */
@Service
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    private final ProjectRepository projectRepository;

    public ProjectDaoImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * To get the project list from the database.
     * 
     * @author Mindbowser | pragati.gawade@mindbowser.com
     * @return {@link List}
     */
    // @Override
    // public List<Project> projectListByFilter(String projectName, String status) {
    //     try {
    //         Specification<Project> specification = new Specification<Project>() {
    //             @Override
    //             public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query,
    //                     CriteriaBuilder cb) {
    //                 List<Predicate> predicates = new ArrayList<>();
    //                 if (projectName != null) {
    //                     predicates.add( 
    //                             cb.like(cb.lower(root.get(ProjectConstant.NAME)),
    //                                     "%" + projectName.toLowerCase() + "%"));
    //                 }
    //                 if (status != null) {
    //                     predicates.add(cb.equal(root.get(ProjectConstant.STATUS), status));
    //                 }

    //                 return cb.and(predicates.toArray(new Predicate[predicates.size()]));

    //             }

    //         };
    //         return projectRepository.findAll(specification);
    //     } catch (Exception e) {
    //         throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }    

    @Override
    public Page<Project> projectListByFilter(String projectName, String status, Pageable pageable) {
        try {
            Specification<Project> specification = new Specification<Project>() {
                @Override
                public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query,
                        CriteriaBuilder cb) {
                    List<Predicate> predicates = new ArrayList<>();
                    if (projectName != null) {
                        predicates.add(
                                cb.like(cb.lower(root.get(ProjectConstant.NAME)),
                                        "%" + projectName.toLowerCase() + "%"));
                    }
                    if (status != null) {
                        predicates.add(cb.equal(root.get(ProjectConstant.STATUS), status));
                    }

                    return cb.and(predicates.toArray(new Predicate[predicates.size()]));

                }

            };
            return projectRepository.findAll(specification, pageable);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    
}
