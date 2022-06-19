package com.covid19.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.covid19.dto.Covid19DataDto;
import com.covid19.dto.Status;

@RestController
public class Covid19Controller {
	
	@Autowired
	RestTemplate restTemplate;
	private final static String RAPID_API = "X-RapidAPI-Key";
	private final static String RAPID_API_KEY = "98ed144181msh2319db7c80ee42ap1f04e8jsn300808bfbed8";
	private final static String RAPID_API_HOST_NAME = "X-RapidAPI-Host";
	private final static String RAPID_API_HOST = "covid-19-coronavirus-statistics.p.rapidapi.com";
	
	@RequestMapping(value="/covid19/world", method = RequestMethod.GET)
	public ResponseEntity<Covid19DataDto> getCovid19DataForWorld() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set(RAPID_API, RAPID_API_KEY);
		header.set(RAPID_API_HOST_NAME, RAPID_API_HOST);
		HttpEntity entityData = new HttpEntity<Covid19DataDto>(header);
		
		return restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats", HttpMethod.GET, entityData, Covid19DataDto.class, header);
		
		 
	}
	
	@RequestMapping(value="/covid19/usa", method = RequestMethod.GET)
	public ResponseEntity<Covid19DataDto> getCovid19DataForUsa() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set(RAPID_API, RAPID_API_KEY);
		header.set(RAPID_API_HOST_NAME, RAPID_API_HOST);
		HttpEntity entityData = new HttpEntity<Covid19DataDto>(header);
		
		return restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=USA", HttpMethod.GET, entityData, Covid19DataDto.class, header);
		
		 
	}
	
	@RequestMapping(value="/covid19/usa/{pageNo}", method = RequestMethod.GET)
	public ResponseEntity<List<Status>> getCovid19DataforUsaPagination(@PathVariable int pageNo) {
		    int initialPage = 0;
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set(RAPID_API, RAPID_API_KEY);
		header.set(RAPID_API_HOST_NAME, RAPID_API_HOST);
		HttpEntity entityData = new HttpEntity<Covid19DataDto>(header);
		ResponseEntity<Covid19DataDto> result = restTemplate.exchange("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=USA", HttpMethod.GET, entityData, Covid19DataDto.class, header);
		Covid19DataDto wholeData = result.getBody();
		List<Status> masterData=wholeData.getData().getCovid19Stats();
		List<Status> resultData=IntStream.range(initialPage, pageNo).mapToObj(index->masterData.get(index)).collect(Collectors.toList());
		
		return new ResponseEntity<>( resultData,HttpStatus.OK);
		
	}

}
