package com.raj.employee.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.raj.employee.dto.EmployeeDto;
import com.raj.employee.service.EmployeeService;
import com.raj.project.configuration.ProjectConfiguration;

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
		input = new JSONObject();
		input.put("emp", new JSONObject(dto));
		try {
			requestData = new JSONObject();
			requestData.put("requestData", input);
			LOGGER.info("Input for SaveOrUpdate:\n"+requestData);
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(requestData.toString(), headers);
			url = ProjectConfiguration.serviceUrl + "/saveOrUpdateEmployee";
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.postForObject(url, entity, String.class);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return serviceResponse;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		input = new JSONObject();
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		try {
			requestData = new JSONObject();
			requestData.put("requestData", input);
			if(LOGGER.isInfoEnabled())
				LOGGER.info("getAllEmployee Input:\n"+requestData.toString());
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(requestData.toString(), headers);
			url = ProjectConfiguration.serviceUrl + "/getAllEmployee";
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.postForObject(url, entity, String.class);
			JSONObject jObj = new JSONObject(serviceResponse);
			String status = jObj.get("status").toString();
			if("1".equals(status)){
				gson = new Gson();
				JSONArray jArray = jObj.getJSONArray("empList");
				for(int i=0; i<jArray.length(); i++){
					EmployeeDto dto = gson.fromJson(jArray.get(i).toString(), EmployeeDto.class);
					list.add(dto);
				}
				 LOGGER.info("Total Employees: "+list.size());
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return list;
	}

	@Override
	public EmployeeDto getEmployeeById(String id) {
		EmployeeDto dto = null;
		input = new JSONObject();
		input.put("empId", id);
		try {
			requestData = new JSONObject();
			requestData.put("requestData", input);
			if(LOGGER.isInfoEnabled())
				LOGGER.info("Input for getEmployeeById:\n"+requestData.toString());
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(requestData.toString(), headers);
			url = ProjectConfiguration.serviceUrl + "/getEmployeeById";
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.postForObject(url, entity, String.class);
			JSONObject jObj = new JSONObject(serviceResponse);
			String status = jObj.get("status").toString();
			if("1".equals(status)){
				gson = new Gson();
				LOGGER.info("\n"+jObj.get("emp").toString());
				dto = gson.fromJson(jObj.get("emp").toString(), EmployeeDto.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception: "+e.getMessage());
		}
		return dto;
	}

	@Override
	public String deleteEmployee(String id) {
		String status = null;
		input = new JSONObject();
		input.put("empId", id);
		try {
			requestData = new JSONObject();
			requestData.put("requestData", input);
			if(LOGGER.isInfoEnabled())
				LOGGER.info("Input for deleteEmployee:\n"+requestData.toString());
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(requestData.toString(), headers);
			url = ProjectConfiguration.serviceUrl + "/deleteEmployee";
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.postForObject(url, entity, String.class);
			JSONObject jObj = new JSONObject(serviceResponse);
			status = jObj.get("status").toString();
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return status;
	}

}
