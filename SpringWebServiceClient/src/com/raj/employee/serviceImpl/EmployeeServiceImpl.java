package com.raj.employee.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.raj.employee.dto.EmployeeDto;
import com.raj.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private HttpHeaders headers = null;
	private HttpEntity<String> entity = null;
	private RestTemplate restTemplate = null;
	private String url = null;
	private JSONObject input = null;
	private JSONObject requestData = null;
	private Gson gson = null;
	private String serviceResponse = null;
	
	private static Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public String saveOrUpdateEmployee(EmployeeDto dto) {
		gson = new Gson();
		input = new JSONObject();
		input.put("emp", gson.toJson(dto));
		try {
			requestData = new JSONObject();
			requestData.put("requestData", input);
			if(LOGGER.isInfoEnabled())
				LOGGER.info("Input for SaveOrUpdate:\n"+requestData.toString());
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(requestData.toString(), headers);
			url = "http://localhost:8080/SpringWebServiceExample/saveOrUpdateEmployee";
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.postForObject(url, entity, String.class);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return serviceResponse;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		return null;
	}

	@Override
	public String getEmployeeById(String id) {
		return null;
	}

	@Override
	public String deleteEmployee(String id) {
		return null;
	}

}
