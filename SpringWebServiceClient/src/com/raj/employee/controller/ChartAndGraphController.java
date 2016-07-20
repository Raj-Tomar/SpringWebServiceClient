package com.raj.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raj.employee.dto.CityDto;
import com.raj.employee.dto.CountryDto;
import com.raj.employee.dto.KeyValueDto;
import com.raj.employee.service.ChartAndGraphService;

@Controller
public class ChartAndGraphController {
	
	@Autowired
	ChartAndGraphService chartService;
	
	@RequestMapping(value="/googleCharts", method=RequestMethod.GET)
	public String googlePieChart(Model model){
		try {
			//List<KeyValueDto> list = chartService.googlePieChart();
			//model.addAttribute("googlePieChart", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "googleCharts";
	}
	
	@RequestMapping(value="/googlePieChartData", method=RequestMethod.POST)
	@ResponseBody
	public List<KeyValueDto> googlePieChartData(){
		List<KeyValueDto> list = null;
		try {
			list = chartService.areaWiseCountries();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/highCharts", method=RequestMethod.GET)
	public String highChartsPage(Model model){
		try {
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "high-charts";
	}
	
	@RequestMapping(value="/highChartData", method=RequestMethod.POST)
	@ResponseBody
	public List<KeyValueDto> highChartData(){
		List<KeyValueDto> list = null;
		try {
			list = chartService.areaWiseCountries();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/getAllCountryCode", method=RequestMethod.POST)
	@ResponseBody
	public List<String> getAllCountryCode(){
		List<String> list = null;
		try {
			list = chartService.getAllCountryCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/cityWisePopulation/{countryCode}", method=RequestMethod.POST)
	@ResponseBody
	public List<CityDto> cityWisePopulation(@PathVariable("countryCode")String countryCode){
		List<CityDto> list = null;
		try {
			list = chartService.cityWisePopulation(countryCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/getStateNames", method=RequestMethod.POST)
	@ResponseBody
	public List<String> getStateNames(){
		List<String> list = null;
		try {
			list = chartService.getStateNames();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/stateWisePopulation/{stateName}", method=RequestMethod.POST)
	@ResponseBody
	public List<CountryDto> stateWisePopulation(@PathVariable("stateName")String stateName){
		List<CountryDto> list = null;
		try {
			list = chartService.stateWisePopulation(stateName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/highChartGeoMap", method=RequestMethod.GET)
	public String highChartGeoMap(){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "highChartGeoMap";
	}
	
	@RequestMapping(value="/fusionCharts", method=RequestMethod.GET)
	public String fusionCharts(){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fusionCharts";
	}
}
