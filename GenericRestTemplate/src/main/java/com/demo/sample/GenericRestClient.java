package com.demo.sample;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GenericRestClient<T , V> {

	private RestTemplate restTemplate = new RestTemplate();

	public V execute(RequestDetails requestDetails, T data,
			Class<V> genericClass){
		
		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<T> entity = new HttpEntity<>(data, headers);
		ResponseEntity<V> response = restTemplate.exchange(requestDetails.getUrl(), requestDetails.getRequestType(),
				entity, genericClass);
		return response.getBody();
	}

}
