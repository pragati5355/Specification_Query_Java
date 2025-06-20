package com.specification_demo.demo.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class SuccessResponse<T> {
    
    private String message;

	private Integer status;

	private T data;

	private Date timestamp;

}
