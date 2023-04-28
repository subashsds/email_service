package com.slavic.service;



import java.net.ConnectException;
import java.util.HashMap;

import javax.ws.rs.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.slavic.dto.ErrorMsg;
import com.slavic.dto.Response;
import com.slavic.dto.req.Login;


@Service
public class EmailService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	public  String sendEmail(HashMap<String, String> username) throws ConnectException {
		String response = null;
		try {
			Thread.sleep(50);
		} catch (Exception ex) {

		}
		if("employee1".equals(username.get("username"))) {
			LOG.info("Email Sent Successfully !");
			response ="success";
			
		}else if("participant1".equals(username.get("username"))) {
			LOG.info("Email Sent Successfully !");
			response ="success";
		}else {
			LOG.info("Email Sent Failed !");
			response ="failed";
			throw new ConnectException("Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely");	
		}
		return response;
		
	}

	public ErrorMsg error(Integer code,String message) {
		ErrorMsg error = new ErrorMsg();
		error.setErrorCode(0);
		error.setMessage(message);
		return error;
	}

}
