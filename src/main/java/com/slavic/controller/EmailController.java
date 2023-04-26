package com.slavic.controller;

import java.net.ConnectException;
import java.util.HashMap;

import javax.ws.rs.POST;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.slavic.dto.Response;
import com.slavic.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EmailService emailService;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/sendEmail-delay")
	public String method3() {
		LOG.info("Inside method3");
		String baseUrl = "http://localhost:8083/microservice4";
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {

		}
		String response=(String) restTemplate.exchange(baseUrl,
				HttpMethod.GET, null,String.class).getBody();
		LOG.info("The response recieved by method3 is "+ response);
		return response;
	}
	
	@PostMapping("/sendEmail")
	public @ResponseBody String sendEmail(@RequestBody HashMap<String, String> username) throws ConnectException{
		
		return emailService.sendEmail(username);
	}
	
	
}
