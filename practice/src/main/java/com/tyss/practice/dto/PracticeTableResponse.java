package com.tyss.practice.dto;

import java.util.List;

import lombok.Data;
@Data
public class PracticeTableResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<PracticeTable> userlist;
	
}
