package com.specification_demo.demo.repository;

import org.springframework.stereotype.Repository;

import com.specification_demo.demo.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project>{
    
}
