package com.demo.sample;

import org.springframework.http.HttpMethod;


public class GenericRestTemplateApplication {

	public static void main(String[] args) {
			
			String responseBody = new GenericRestClient<TestObject, String>().execute(
					new RequestDetails("http://localhost:8082/health", HttpMethod.GET),new TestObject(), String.class);

			System.out.println(responseBody);
			
			TestObject other = new GenericRestClient<String, TestObject>().execute(
					new RequestDetails("http://localhost:8082/create", HttpMethod.POST), "String Data", TestObject.class);
			
			System.out.println(other);
		
	}
	
}
