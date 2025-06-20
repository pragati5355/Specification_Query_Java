package com.specification_demo.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.specification_demo.demo.constant.ProjectApiPath;
import com.specification_demo.demo.constant.ProjectSucessMessage;
import com.specification_demo.demo.dto.ProjectOutDto;
import com.specification_demo.demo.response.SuccessResponse;
import com.specification_demo.demo.service.ProjectService;
import com.specification_demo.demo.util.CustomResponseBuilder;

/**
 * @author Mindbowser | pragati.gawade@mindbowser.com
 */
@RestController
@RequestMapping(ProjectApiPath.PROJECT_BASE_URL)
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Environment env;

    @Autowired
    private CustomResponseBuilder customResponseBuilder;


    /**
        * ProjectByFilter is to return a List of project and project details.
        * 
        * @author Mindbowser | pragati.gawade@mindbowser.com
        * @param projectName
        * @param status
        * @return {@link ResponseEntity}
    */
    @GetMapping()
    public ResponseEntity<SuccessResponse<Page<ProjectOutDto>>> projectsByFilter(
                @RequestParam(required = false) String projectName,
                @RequestParam(required = false) String status,
                @PageableDefault(size = 10, sort = "id") Pageable pageable
                ) {
        // List<ProjectOutDto> response = projectService.projectsByFilter(projectName, status);
                    
        Page<ProjectOutDto> response = projectService.projectsByFilter(projectName, status, pageable);
        return customResponseBuilder.buildSuccessResponse(env.getProperty(ProjectSucessMessage.SUCESS),
                    response,
                    HttpStatus.OK);
    }

    
}
