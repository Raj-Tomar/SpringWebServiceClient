package com.raj.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raj.employee.dto.KeyValueDto;
import com.raj.employee.service.ChartAndGraphService;

@Controller
public class ChartAndGraphController {
	
	@Autowired
	ChartAndGraphService chartService;
	
	@RequestMapping(value="/googlePieChart", method=RequestMethod.GET)
	public String googlePieChart(Model model){
		try {
			List<KeyValueDto> list = chartService.googlePieChart();
			model.addAttribute("googlePieChart", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "googleCharts";
	}
}
