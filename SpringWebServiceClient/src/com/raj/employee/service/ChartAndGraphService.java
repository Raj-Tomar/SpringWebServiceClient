package com.raj.employee.service;

import java.util.List;

import com.raj.employee.dto.CityDto;
import com.raj.employee.dto.CountryDto;
import com.raj.employee.dto.KeyValueDto;

public interface ChartAndGraphService {
	
	/**
	 * @return
	 */
	public List<KeyValueDto> areaWiseCountries();

	/**
	 * @return
	 */
	public List<String> getAllCountryCode();

	/**
	 * @param countryCode
	 * @return
	 */
	public List<CityDto> cityWisePopulation(String countryCode);

	/**
	 * @return
	 */
	public List<String> getStateNames();

	/**
	 * @param stateName
	 * @return
	 */
	public List<CountryDto> stateWisePopulation(String stateName);

}
