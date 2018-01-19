package com.example.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {

	private final RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	public BookService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingBook(String bookName) {
		/**
		 * Esta es la instrucción que usaramos si no existiera Eureka
		 */
		// URI uri = URI.create("http://eureka-client:8090/book/".concat(bookName));

		URI uri = URI.create(serviceUrl().concat("book").concat("/").concat(bookName));
		String book =  this.restTemplate.getForObject(uri, String.class);
		return book;
	}

	public String serviceUrl() {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-client", false);
		return instanceInfo.getHomePageUrl();
	}

	public String reliable(String bookName) {
		// return "Cloud Native Java (O'Reilly)";
		return "bookName is not available";
	}

}
