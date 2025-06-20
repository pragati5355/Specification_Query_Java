package com.specification_demo.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.specification_demo.demo.dto.ProjectOutDto;

public interface ProjectService {

    /**
     * 
     * @author Mindbowser | pragati.gawade@mindbowser.com
     * @param projectName
     * @param status
     * @return {@link List}
     *
     */
    Page<ProjectOutDto> projectsByFilter(String projectName, String status, Pageable pageable);

    // List<ProjectOutDto> projectsByFilter(String projectName, String status);
    
}
