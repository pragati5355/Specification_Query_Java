package com.specification_demo.demo.entity;


import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Mindbowser | pragati.gawade@mindbowser.com
 *
 */
@Entity
@Data
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
@Table(name = "projects")
public class Project extends BaseEntity {

    @Column
    private String name;

    @Column(name = "status")
    private String status;
    
}
