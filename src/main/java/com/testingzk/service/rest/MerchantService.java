package com.testingzk.service.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testingzk.model.GlobalResponse;
import com.testingzk.model.Merchant;
import com.testingzk.model.dto.JoinAsMerchantDTO;


public class MerchantService {
	
	public List<Merchant> getAllVoucher() {
		String location = "http://localhost:9080/public/api/merchant/get-all-merchant";
		List<Merchant> result = null;
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HashMap<String, Object> body = new HashMap<String, Object>();
		
		try {
			String json = new ObjectMapper().writeValueAsString(body);
			HttpEntity<String> entity = new HttpEntity<String>(json, headers);
			String response = template.postForObject(location, entity, String.class);
			System.out.println(response);
			ObjectMapper mapper = new ObjectMapper();
			GlobalResponse value = mapper.readValue(response, GlobalResponse.class);
			//
			System.out.println(value.getStatus());
			String jsonResult = mapper.writeValueAsString(value.getData());
			Merchant[] vou = mapper.readValue(jsonResult, Merchant[].class);
			System.out.println(vou[0].getMerchantName());
			List<Merchant> ppl2 = Arrays.asList(vou);
			result = ppl2;
			System.out.println("RESULT");
			System.out.println(new ObjectMapper().writeValueAsString(ppl2));
			//System.out.println(jsonResult);
			//System.out.println(ppl2.get(0).getMerchantName());
			
			//System.out.println(vou.getMerchantName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean joinAsMerchant(JoinAsMerchantDTO data) {
		String location = "http://localhost:9080/public/api/merchant/join-us";
		boolean flag = false;
		
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			String json = new ObjectMapper().writeValueAsString(data);
			HttpEntity<String> entity = new HttpEntity<String>(json, headers);
			String response = template.postForObject(location, entity, String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			GlobalResponse value = mapper.readValue(response, GlobalResponse.class);
			
			System.out.println(new ObjectMapper().writeValueAsString(value));
			
			if (value.getStatus().equalsIgnoreCase("201")) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
