package com.country.india.controller.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CreateOrderRestClient {

	/**
	 * URI object
	 * Hashmap for the headers info
	 * request params in the url
	 * @throws URISyntaxException
	 */
	public void createUsingURIRestTemplete() throws URISyntaxException {

		//Resttemplate is the root object
		//fill url
		//fill path
		//fill path param variable
		//fill query param variables

		//fill header with accept and content-type info
		//fill accept
		//fill content-type

		//fill method {get or post}
		//fill response type

		//fill body
		RestTemplate restTemplate = new RestTemplate();

		URI uri = new URI("http://localhost:8080/cancelOrder?name=test");
		HttpMethod httpMethod = HttpMethod.GET;

		Map<String, MediaType> header = new HashMap<String, MediaType>();
		header.put("Accept", MediaType.APPLICATION_JSON);
		header.put("Content-Type", MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, String>> requestHttpEntity = new HttpEntity(header);

		ResponseEntity<HttpStatus> response = restTemplate.exchange(uri, httpMethod, requestHttpEntity, HttpStatus.class);

		System.out.println(response);
	}


	/**
	 * string url
	 * HttpHeaders Object instead of hashmap
	 * @throws URISyntaxException
	 */
	public void createRestTempleteUsingUriComponentBuilderRequestParam() throws URISyntaxException {


		RestTemplate restTemplate = new RestTemplate();

		//URI uri = new URI("http://localhost:8080/cancelOrder");
		String url = "http://localhost:8080/cancelOrder/uriComponentBuilder/requestParam";

		HttpMethod httpMethod = HttpMethod.GET;


		HttpHeaders header = new HttpHeaders();
		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		header.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("name", "test-mahender");

		UriComponentsBuilder uriComponentBuilder = UriComponentsBuilder.fromHttpUrl(url);
		//uriComponentBuilder.query(query)
		uriComponentBuilder.queryParams(params);
		UriComponents uriComponents = uriComponentBuilder.build();
		URI uri = uriComponents.toUri();


		HttpEntity<MultiValueMap<String, String>> requestHttpEntity = new HttpEntity(header);

		ResponseEntity<HttpStatus> response = restTemplate.exchange(uri, httpMethod, requestHttpEntity, HttpStatus.class);

		System.out.println(response);
	}
	
	
	public void createRestTempleteUsingPathParam() throws URISyntaxException {


		RestTemplate restTemplate = new RestTemplate();

		//URI uri = new URI("http://localhost:8080/cancelOrder");
		String url = "http://localhost:8080/cancelOrder/uriComponentBuilder/{name}";

		HttpMethod httpMethod = HttpMethod.GET;


		HttpHeaders header = new HttpHeaders();
		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		header.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("name", "test-mahender");

		/*UriComponentsBuilder uriComponentBuilder = UriComponentsBuilder.fromHttpUrl(url);
		//uriComponentBuilder.query(query)
		//uriComponentBuilder.queryParams(params);
		UriComponents uriComponents = uriComponentBuilder.build();
		URI uri = uriComponents.toUri();*/


		HttpEntity<MultiValueMap<String, String>> requestHttpEntity = new HttpEntity(header);

		ResponseEntity<HttpStatus> response = restTemplate.exchange(url, httpMethod, requestHttpEntity, HttpStatus.class, params);

		System.out.println(response);
	}



}
