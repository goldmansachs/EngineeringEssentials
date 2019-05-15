/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pojo.Company;
import pojo.Stock;

/**
 * Utility class to validate inputs
 */
public class InputValidator {
	public static HashMap<Company,Stock> hMap;

    // TODO - write a method that will validate your JSON input files
	public boolean validateJSON(String input) {
		if (nullCheck(input))
			return false;
		if (input.equals("historicalStockData.json")) {
			return populateStock();
		} else if (input.contentEquals("companyInfo.json")) {
			return populateCompany();
		} else
			return false;		
	}

    // TODO - write a method that will validate the inputs to the Company Resource
	public boolean validateCompany(String input) {
		if (nullCheck(input))
			return false;
		return true;
	}

    // TODO - write a method that will validate the inputs to the Stock Resource
	public boolean validateStock(String input) {
		if (nullCheck(input))
			return false;
		return true;
	}
	
	private boolean nullCheck(String input) {
		if (input == null)
			return true;
		return false;
	}
	
	private boolean populateCompany() {
		JSONArray obj = null;
		try {
			obj = (JSONArray) new JSONParser().parse(new FileReader("C:\\Users\\clair\\Documents\\EngineeringEssentials\\caseStudy\\services\\src\\main\\java\\utility\\companyInfo.json"));
		} catch (IOException e) {
			return false;
		} catch (ParseException e) {
			return false;
		}
		boolean valid = true;
		
		for (int i = 0; i < obj.size(); i++) {
			JSONObject jobj = (JSONObject) obj.get(i);
			
			boolean symbolValid = jobj.get("symbol") instanceof String || jobj.get("symbol") == null;
			boolean nameValid = jobj.get("name") instanceof String || jobj.get("name") == null;
			boolean hqCityValid = jobj.get("headquartersCity") instanceof String || jobj.get("headquartersCity") == null;
			boolean hqStateValid = jobj.get("headquartersStateOrCountry") instanceof String || jobj.get("headquartersStateOrCountry") == null;
			boolean numEmployeesValid = jobj.get("numberOfEmployees") instanceof Integer && (int) jobj.get("numberOfEmployees") >= 0 || jobj.get("numberOfEmployees") == null;
			boolean sectorValid = jobj.get("sector") instanceof String || jobj.get("sector") == null;
			boolean industryValid = jobj.get("industry") instanceof String || jobj.get("industry") == null;
			
			if (symbolValid && nameValid && hqCityValid && hqStateValid && numEmployeesValid && sectorValid && industryValid)
				valid = false;
			else {
				String symbol = symbolValid ? (String) jobj.get("symbol") : null;
				String name = nameValid ? (String) jobj.get("name") : null;
				String hqCity = hqCityValid ? (String) jobj.get("headquartersCity") : null;
				String hqState = hqStateValid ? (String) jobj.get("headquartersStateOrCountry") : null;
				int numEmployees = numEmployeesValid ? (int) jobj.get("numberOfEmployees") : -1;
				String sector = sectorValid ? (String) jobj.get("sector") : null;
				String industry = industryValid ? (String) jobj.get("industry") : null;
				
				Company comp = new Company(symbol, name, hqCity, hqState, numEmployees, sector, industry);
				hMap.put(comp, null);
			}
		}
		return valid;
	}
	
	private boolean populateStock() {
		
		return true;
	}

}
