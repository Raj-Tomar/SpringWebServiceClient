package com.raj.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
			list = chartService.googlePieChart();
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
			list = chartService.googlePieChart();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
