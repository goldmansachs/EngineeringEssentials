/**
 * Copyright 2018 Goldman Sachs.
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

package pojo;

/**
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
public class Company {

	// INSTANCE VARS
	String symbol;
	String name;
	String headquartersCity;
	String headquartersStateOrCountry;
	int numberOfEmployees;
	String sector;
	String industry;

	// CONSTRUCTOR
	public Company(String symbol, String name, String headquartersCity, 
				   String headquartersStateOrCountry, int numberOfEmployees,
				   String sector, String industry) {
		this.symbol = symbol;
		this.name = name;
		this.headquartersCity = headquartersCity;
		this.headquartersStateOrCountry = headquartersStateOrCountry;
		this.numberOfEmployees = numberOfEmployees;
		this.sector = sector;
		this.industry = industry;
	}

	// METHODS
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getHeadquartersCity() {
		return this.headquartersCity;
	}
	public void setHeadquartersCity(String headquartersCity) {
		this.headquartersCity = headquartersCity;
	}


	public String getHeadquartersStateOrCountry(String headquartersStateOrCountry) {
		return this.headquartersStateOrCountry;
	}
	public void setHeadquartersStateOrCountry(String headquartersStateOrCountry) {
		this.headquartersStateOrCountry = headquartersStateOrCountry;
	}


	public int getNumberOfEmployees() {
		return this.numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}


	public String getSector() {
		return this.sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}


	public String getIndustry() {
		return this.industry;
	}
	public void setIndustry(String industry) {

	}
}