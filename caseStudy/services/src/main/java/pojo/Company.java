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
    private String symbol;
    private String name;
    private String headquartersCity;
    private String headquartersStateOrCountry;
    private int numberOfEmployees;
    private String sector;
    private String industry;

    public Company() {

    }
    public Company(String symbol, String name, String headquartersCity, String headquartersStateOrCountry, int numberOfEmployees, String sector, String industry) {
        this.symbol = symbol;
        this.name = name;
        this.headquartersCity = headquartersCity;
        this.headquartersStateOrCountry = headquartersStateOrCountry;
        this.numberOfEmployees = numberOfEmployees;
        this.sector = sector;
        this.industry = industry;
    }
    
    //GETTERS
    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getHeadquartersCity() {
        return headquartersCity;
    }
    
    public String getHeadquartersStateOrCountry() {
        return headquartersStateOrCountry;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getSector() {
        return sector;
    }

    public String getIndustry() {
        return industry;
    }
    

    //SETTERS
    public String setSymbol(String symbol) {
        this.symbol = symbol;
        return symbol;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setHeadquartersCity(String headquartersCity) {
        this.headquartersCity = headquartersCity;
        return headquartersCity;
    }
    
    public String setHeadquartersStateOrCountry(String headquartersStateOrCountry) {
        this.headquartersStateOrCountry = headquartersStateOrCountry;
        return headquartersStateOrCountry;
    }

    public int setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
        return numberOfEmployees;
    }

    public String setSector(String sector) {
        this.sector = sector;
        return sector;
    }

    public String setIndustry(String industry) {
        this.industry = industry;
        return industry;
    }
}
