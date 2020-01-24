package com.tyss.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.practice.dto.PracticeTable;
import com.tyss.practice.dto.PracticeTableResponse;
import com.tyss.practice.service.PracticeService;

@RestController
@RequestMapping
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
public class PracticeController {
	@Autowired
	private PracticeService service;
	
	
	@PostMapping(path = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PracticeTableResponse adduser(@RequestBody PracticeTable user) {
		PracticeTableResponse response=new PracticeTableResponse();
		if(service.adduser(user) != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully stored..");
			
		}
		else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
			
		}
		return response;
	}
	@PutMapping(path = "/updateuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PracticeTableResponse updateuser(@RequestBody PracticeTable user) {
		PracticeTableResponse response = new PracticeTableResponse();
		if(service.updateuser(user)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully updated..");
		}
		else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
					
		}

		return response;
	}
	@GetMapping(path = "/getalluser", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	public PracticeTableResponse getalluser() {
		PracticeTableResponse response = new PracticeTableResponse();
		List<PracticeTable> list=service.getuser();
		if(list != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully retrived..");
			response.setUserlist(list);
		}
		else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");	
		}
		return response;
	}

	@DeleteMapping(path = "/getalluser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PracticeTableResponse deleteuser(@RequestBody PracticeTable practice) {
		PracticeTableResponse response = new PracticeTableResponse();
		if(service.deleteuser(practice)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully retrived..");
			response.getUserlist();
		}
		else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");	
		}
		return response;
	}
}
