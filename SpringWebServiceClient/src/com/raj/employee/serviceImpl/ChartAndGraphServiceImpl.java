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
import com.raj.employee.dto.KeyValueDto;
import com.raj.employee.service.ChartAndGraphService;

@Service
public class ChartAndGraphServiceImpl implements ChartAndGraphService{
	
	private HttpHeaders headers = null;
	private HttpEntity<String> entity = null;
	private RestTemplate restTemplate = null;
	private String url = null;
	private JSONObject input = null;
	private JSONObject requestData = null;
	private Gson gson = null;
	private String serviceResponse = null;
	
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphServiceImpl.class); 
	
	@Override
	public List<KeyValueDto> googlePieChart() {
		List<KeyValueDto> list = new ArrayList<KeyValueDto>();
		input = new JSONObject();
		try {
			requestData = new JSONObject();
			requestData.put("requestData",input);
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(requestData.toString(), headers);
			url = "http://localhost:8080/SpringWebServiceExample/googlePieChart";
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.postForObject(url, entity, String.class);
			JSONObject jObj = new JSONObject(serviceResponse);
			String status = jObj.getString("status");
			if(status.equals("1")){
				gson = new Gson();
				JSONArray jArray = jObj.getJSONArray("keyValue");
				for(int i=0; i<jArray.length(); i++){
					KeyValueDto dto = gson.fromJson(jArray.get(i).toString(), KeyValueDto.class);
					list.add(dto);
				}
				if(LOGGER.isInfoEnabled())
					LOGGER.info("Total Recoreds: "+list.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
