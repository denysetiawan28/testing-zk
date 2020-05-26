package com.testingzk.service.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testingzk.model.GlobalResponse;
import com.testingzk.model.dto.Ad1accessAuthenticateDTO;

public class Ad1accessService {
	public boolean doLogin(Ad1accessAuthenticateDTO data) {
		String location = "http://af-devnc04:99/Portsightdev/api/AuthenticateUser";
		boolean flag = false;
		
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			String json = new ObjectMapper().writeValueAsString(data);
			HttpEntity<String> entity = new HttpEntity<String>(json, headers);
			String response = template.postForObject(location, entity, String.class);
			
//			ObjectMapper mapper = new ObjectMapper();
//			String value = mapper.readValue(response, String.class);
			
			System.out.println("ad1acces response : "+response);
			
			if (response.equalsIgnoreCase("OK")) flag = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
