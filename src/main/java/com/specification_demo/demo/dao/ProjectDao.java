package com.specification_demo.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.specification_demo.demo.entity.Project;

public interface ProjectDao {

     /**
     * 
     * @author Mindbowser | pragati.gawade@mindbowser.com
     * @return {@link List}
     *
     */
    Page<Project> projectListByFilter(String projectName, String status, Pageable pageable);

    // List<Project> projectListByFilter(String projectName, String status);
    
}
