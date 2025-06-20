package com.specification_demo.demo.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorResponse<T> {

    private String message;

	private Integer status;

	private Date timestamp;

	private String detail;

	private List<T> errors;

    
}
