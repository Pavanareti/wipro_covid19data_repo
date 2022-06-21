package com.covid19.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.covid19.dto.Covid19DataDto;

@Component
public class Covid19Utils {
	
	@Autowired
	RestTemplate restTemplate;
	
	public  ResponseEntity<Covid19DataDto> restClientBuilder(String restUrl){
	  
			HttpHeaders header = new HttpHeaders();
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			header.set(Constants.RAPID_API, Constants.RAPID_API_KEY);
			header.set(Constants.RAPID_API_HOST_NAME, Constants.RAPID_API_HOST);
			HttpEntity entityData = new HttpEntity<Covid19DataDto>(header);
			return restTemplate.exchange(restUrl, HttpMethod.GET, entityData, Covid19DataDto.class, header);
			
	}
}
