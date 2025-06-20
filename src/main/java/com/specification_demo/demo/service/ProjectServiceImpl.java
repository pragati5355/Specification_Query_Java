package com.specification_demo.demo.service;

import org.springframework.data.domain.Pageable; 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.specification_demo.demo.dao.ProjectDao;
import com.specification_demo.demo.dto.ProjectOutDto;
import com.specification_demo.demo.entity.Project;
import com.specification_demo.demo.repository.ProjectRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    private ModelMapper mapper;

	private ProjectRepository projectRepository;


    /**
	 * To Get List of Project
	 * 
	 * @author Mindbowser | pragati.gawade@mindbowser.com
	 * @param projectName
	 * @param status
	 * @return {@link List}
	 */
	// public List<ProjectOutDto> projectsByFilter(String projectName, String status) {

	// 	List<Project> projects = projectDao.projectListByFilter(projectName, status);
	// 	List<Project> sortedProjects = projects.stream().collect(Collectors.toList());
		
	// 	List<ProjectOutDto> listOfProject = sortedProjects.stream()
	// 			.map(project -> mapper.map(project, ProjectOutDto.class))
	// 			.collect(Collectors.toList());
				

	// 	return listOfProject;
	// }


	public Page<ProjectOutDto> projectsByFilter(String projectName, String status, Pageable pageable) {

		Page<Project> projects = projectDao.projectListByFilter(projectName, status, pageable);
		List<Project> sortedProjects = projects.stream().collect(Collectors.toList());
		
		List<ProjectOutDto> listOfProject = sortedProjects.stream()
				.map(project -> mapper.map(project, ProjectOutDto.class))
				.collect(Collectors.toList());
				

		return new PageImpl(listOfProject, pageable, projects.getTotalElements());
	}
}
