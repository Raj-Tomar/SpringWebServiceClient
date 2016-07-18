package com.raj.test;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.raj.employee.dto.EmployeeDto;

public class SpringWebServiceClientTest {
	
	private static HttpHeaders headers = null;
	private static HttpEntity<String> entity = null;
	private static String url = null;
	private static RestTemplate restTemplate = null;
	private static JSONObject reqData = null;
	private static JSONObject input = null;
	
	public static void main(String[] args) {
		EmployeeDto dto = new EmployeeDto();
		dto.setFirstName("Raj");
		dto.setLastName("Tomar");
		dto.setDesignation("Software Engineer");
		dto.setCompanyName("SpSoft");
		dto.setAge("26");
		input = new JSONObject(dto);
		try {
			reqData = new JSONObject();
			reqData.put("reqData", input);
			System.out.println(reqData.toString());
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(reqData.toString(), headers);
			url = "http://localhost:8080/SpringWebServiceExample/getAllEmployee";
			//url = "http://localhost:8080/SpringWebServiceExample/saveOrUpdateEmployee";
			restTemplate = new RestTemplate();
			String result = restTemplate.postForObject(url, entity, String.class);
			System.out.println("Result From WebService:\n"+result);
		} catch (Exception e) {
			
		}
		
	}

}
