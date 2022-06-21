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
import com.covid19.entity.Covid19DataEntity;
import com.covid19.repo.Covid19Repo;
import com.covid19.util.Constants;
import com.covid19.util.Covid19Utils;

@RestController
public class Covid19Controller {
	
	@Autowired
	public Covid19Utils covid19Utils;
	
	@Autowired
	Covid19Repo covid19Repo;


	@RequestMapping(value="/covid19/world", method = RequestMethod.GET)
	public ResponseEntity<Covid19DataDto> getCovid19DataForWorld() {
		
		return covid19Utils.restClientBuilder(Constants.GLOBAL_DATA_URL);
		 
	}
	
	@RequestMapping(value="/covid19/usa", method = RequestMethod.GET)
	public ResponseEntity<Covid19DataDto> getCovid19DataForUsa() {
		return covid19Utils.restClientBuilder(Constants.DATA_FOR_USA_URL);
		 
	}
	
	@RequestMapping(value="/covid19/usa/{pageNo}", method = RequestMethod.GET)
	public ResponseEntity<List<Status>> getCovid19DataforUsaPagination(@PathVariable int pageNo) {
		    int initialPage = 0;
		ResponseEntity<Covid19DataDto> result = covid19Utils.restClientBuilder(Constants.PAGINATED_DATA_URL);
		Covid19DataDto wholeData = result.getBody();
		List<Status> masterData=wholeData.getData().getCovid19Stats();
		List<Status> resultData=IntStream.range(initialPage, pageNo).mapToObj(index->masterData.get(index)).collect(Collectors.toList());
		
		return new ResponseEntity<>( resultData,HttpStatus.OK);
		
	}

	@RequestMapping(value="/covid19/usa/save/{pageNo}", method = RequestMethod.GET)
	public ResponseEntity<List<Status>> saveCovid19DataforUsaPagination(@PathVariable int pageNo) {
		    int initialPage = 0;
		ResponseEntity<Covid19DataDto> result = covid19Utils.restClientBuilder(Constants.PAGINATED_DATA_URL);
		Covid19DataDto wholeData = result.getBody();
		List<Status> masterData=wholeData.getData().getCovid19Stats();
		List<Status> resultData=IntStream.range(initialPage, pageNo).mapToObj(index->masterData.get(index)).collect(Collectors.toList());
		
		resultData.forEach(entity ->{
			Covid19DataEntity daoObj =new Covid19DataEntity();
			daoObj.setCity(entity.getCity());
			daoObj.setConfirmed(entity.getConfirmed());
			daoObj.setCountry(entity.getCountry());
			daoObj.setDeaths(entity.getDeaths());
			daoObj.setKeyId(entity.getKeyId());
			daoObj.setLastUpdate(entity.getLastUpdate());
			daoObj.setProvince(entity.getProvince());
			daoObj.setRecovered(entity.getRecovered());
			covid19Repo.save(daoObj);
		});
		
		return new ResponseEntity<>( resultData,HttpStatus.OK);
		
	}
	

}
