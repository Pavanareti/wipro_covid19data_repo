package com.covid19.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.covid19.dto.Covid19DataDto;

@RestController
public class Covid19Controller {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping(value="/covid19/world", method = RequestMethod.GET)
	public ResponseEntity<Covid19DataDto> getCovid19DataForWorld() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set("X-RapidAPI-Key", "98ed144181msh2319db7c80ee42ap1f04e8jsn300808bfbed8");
		header.set("X-RapidAPI-Host", "covid-19-coronavirus-statistics.p.rapidapi.com");
		HttpEntity entityData = new HttpEntity<Covid19DataDto>(header);
		
		return restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats", HttpMethod.GET, entityData, Covid19DataDto.class, header);
		
		 
	}
	
	@RequestMapping(value="/covid19/usa", method = RequestMethod.GET)
	public ResponseEntity<Covid19DataDto> getCovid19DataForUsa() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set("X-RapidAPI-Key", "98ed144181msh2319db7c80ee42ap1f04e8jsn300808bfbed8");
		header.set("X-RapidAPI-Host", "covid-19-coronavirus-statistics.p.rapidapi.com");
		HttpEntity entityData = new HttpEntity<Covid19DataDto>(header);
		
		return restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=USA", HttpMethod.GET, entityData, Covid19DataDto.class, header);
		
		 
	}

}
