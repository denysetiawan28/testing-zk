package com.testingzk.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GlobalResponse {
	private String httpCode;
	private String status;
	private String message;
	private List<Object> data;
}
