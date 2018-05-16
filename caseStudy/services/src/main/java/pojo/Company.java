
package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
public class Company {

	// INSTANCE VARS
	@JsonProperty
	private String symbol;
	@JsonProperty
	private String name;
	@JsonProperty
	private String headquartersCity;
	@JsonProperty
	private String headquartersStateOrCountry;
	@JsonProperty
	private int numberOfEmployees;
	@JsonProperty
	private String sector;
	@JsonProperty
	private String industry;

//	// CONSTRUCTOR
//	public Company(String symbol, String name, String headquartersCity,
//				   String headquartersStateOrCountry, int numberOfEmployees,
//				   String sector, String industry) {
//		this.symbol = symbol;
//		this.name = name;
//		this.headquartersCity = headquartersCity;
//		this.headquartersStateOrCountry = headquartersStateOrCountry;
//		this.numberOfEmployees = numberOfEmployees;
//		this.sector = sector;
//		this.industry = industry;
//	}

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
	public void setIndustry(String industry) { this.industry = industry;}
}