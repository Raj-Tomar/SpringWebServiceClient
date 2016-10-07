package com.raj.employee.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raj.employee.dto.EmployeeDto;
import com.raj.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public String home(Model model){
		logger.info("employee controller");
		try{
			model.addAttribute("employee", new EmployeeDto());
			model.addAttribute("employeeList", empService.getAllEmployee());
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());
		}
		return "employee";
	}
	
	
	@RequestMapping(value="/saveOrUpdateEmployee", method=RequestMethod.POST)
	public String saveOrUpdateEmployee(@ModelAttribute("employee") EmployeeDto employee){
		logger.info("saveOrUpdateEmployee controller");
		try{
			String status = empService.saveOrUpdateEmployee(employee);
			logger.info("Status of saveOrUpdate: "+status);
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());
		}
		return "redirect:/employee";
	}
	
	@RequestMapping(value="/updateEmployee/{id}", method=RequestMethod.GET)
	public String getEmployeeById(@PathVariable("id")String id, Model model){
		logger.info("getEmployeeById in controller");
		String status = null;
		EmployeeDto empDto = null;
		try {
			empDto = empService.getEmployeeById(id);
			if(null == empDto){
				status = "redirect:/employee";
			}
			else{
				model.addAttribute("employee", empDto);
				status = "employee";
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return status;
	}
	
	@RequestMapping(value="/deleteEmployee/{id}", method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id")String id){
		logger.info("deleteEmployee in controller");
		try {
			String status = empService.deleteEmployee(id);
			logger.info("deleteEmployee Status: "+status);
		} catch (Exception e) {
			logger.error("Exception : "+e.getMessage());
		}
		return "redirect:/employee";
	}
	
	// Datatable ajax call pagination
	/*
	@RequestMapping(value="/getSellHistory/{uid}", method = RequestMethod.POST)
	@ResponseBody
	public String getSellHistory(@RequestParam("draw") String draw,
			@RequestParam("start") String start,@RequestParam("length") String length,
			@PathVariable("uid")String uid,
			HttpServletRequest request,HttpServletResponse response){
		LOGGER.info("UserProfileController");
		String sessId = null;
		String au_id = null;
		List<KeyValueDto> sellingList = null;
		JSONObject sellHistory = new JSONObject();
		try {
			session = request.getSession(false);
			Cookie[] cookies = request.getCookies();
			if(cookies == null || session == null){
				//return sellingList;
				return sellHistory.toString();
			}
			else{
				sessId = geturl.getSessId(cookies);
		    	String validSession = userService.validateCsSessionToken(sessId);
		    	if (!AntelopeResourceConstants.SESSION_VALID.equals(validSession)) {
		    		au_id = geturl.getAuthId(cookies);
		    		String ulid = session.getAttribute("userloginid").toString();
	    			sessId = userService.getRenewalSessionAdmin(au_id, sessId, geturl.getCurrentURL(request), ulid);
	    			if (HTMLUtil.constructCookies(response, request.getCookies(), sessId)) {
	    				validSession =  AntelopeResourceConstants.SESSION_VALID;
	    			}
	    		}
	    		LOGGER.info("ValidateSession: "+validSession);
	    		if(AntelopeResourceConstants.SESSION_VALID.equals(validSession) ){
	    			sellingList = userProfileService.getSellingHistory(uid);
	    			LOGGER.info("Total Sellings: "+sellingList.size());
	    			int pageStart = Integer.parseInt(start);
	    			int pageLength = Integer.parseInt(length);
	    			int pageDraw = Integer.parseInt(draw);
	    			LOGGER.info("Draw: "+draw+" Start: "+start+" PageLength: "+length);
	    			
	    			for(int i = pageStart; i <= (pageDraw * pageLength); i++){
	    				KeyValueDto data = new KeyValueDto();
	    				data.setKey("I100"+i);
	    				data.setValue("P100"+i);
	    				sellingList.add(data);
	    			}
	    			Integer rowCount = 1000;
	    			sellHistory.put("data", sellingList);
	    			sellHistory.put("recordsFiltered", rowCount);
	    			sellHistory.put("recordsTotal", rowCount);
	    			sellHistory.put("draw", draw);
	    		}
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		//return sellingList;
		return sellHistory.toString();
	}
	*/
	
}
