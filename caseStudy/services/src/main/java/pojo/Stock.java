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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

	// INSTANCE VARS
    @JsonProperty
    private String symbol;
    @JsonProperty
    private int month;
    @JsonProperty
    private int day;
    @JsonProperty
    private int year;
    @JsonProperty
    private float endOfDayPrice;

    // CONSTRUCTOR
    public Stock(String symbol, int month, int day, int year,
    			 float endOfDayPrice) {
    	this.symbol = symbol;
    	this.month = month;
    	this.day = day;
    	this.year = year;
    	this.endOfDayPrice = endOfDayPrice;
    }

    // METHODS
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getDate() {
		return month + "/" + day + "/" + year;
	}
	public void setDate(String date) {
		this.month = Integer.parseInt(date.substring(0,2));
		this.day = Integer.parseInt(date.substring(2,4));
		this.day = Integer.parseInt(date.substring(5));
	}

}