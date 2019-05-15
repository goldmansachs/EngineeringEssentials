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

package pojo;

/**
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
public class Company {

    private String symbol;
    private String name;
    private String hqCity;
    private String hqStateOrCountry;
    private int numEmployees;
    private String sector;
    private String industry;
    private Stock stockHistory;

    public Company(String symbol, String name, String hqCity, String hqStateOrCountry, int numEmployees, String sector, String industry) {
        this.symbol = symbol;
        this.name = symbol;
        this.hqCity = symbol;
        this.hqStateOrCountry = hqStateOrCountry;
        this.numEmployees = numEmployees;
        this.sector = sector;
        this.industry = industry;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarterCity() {
        return hqCity;
    }

    public void setHeadquarterCity(String hqCity) {
        this.hqCity = hqCity;
    }

    public String getHeadquarterStateOrCountry() {
        return this.hqStateOrCountry;
    }

    public void setHeadquarterStateOrCountry(String hqStateOrCountry) {
        this.hqStateOrCountry = hqStateOrCountry;
    }

    public int getNumEmployees() {
        return this.numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
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
        this.industry = industry;
    }

    public Stock getStockHistory() {
        return this.stockHistory;
    }

    public void setStockHistory(Stock stockHistory) {
        this.stockHistory = stockHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;

        Company company = (Company) o;

        if (getSymbol() != company.getSymbol()) return false;
        if (getName() != company.getName()) return false;
        if (getHeadquarterCity() != company.getHeadquarterCity()) return false;
        if (getHeadquarterStateOrCountry() != company.getHeadquarterStateOrCountry()) return false;
        if (getNumEmployees() != company.getNumEmployees()) return false;
        if (getSector() != company.getSector()) return false;
        return getIndustry() == company.getIndustry(); 

    }

    @Override
    public int hashCode() {
        int result = getSymbol().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getHeadquarterCity().hashCode();
        result = 31 * result + getHeadquarterStateOrCountry().hashCode();
        result = 31 * result + getNumEmployees();
        result = 31 * result + getSector().hashCode();
        result = 31 * result + getIndustry().hashCode();
        return result;
    }


}
