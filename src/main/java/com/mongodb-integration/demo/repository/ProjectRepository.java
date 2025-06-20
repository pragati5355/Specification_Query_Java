package com.specification_demo.demo.repository;

import org.springframework.stereotype.Repository;

import com.specification_demo.demo.entity.Project;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ProjectRepository extends MongoRepository<Project, String>, CustomProjectRepository{
    
}
