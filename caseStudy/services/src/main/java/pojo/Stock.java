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
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    /** Private variables */
    private String name;
    private String startDate;
    private String endDate;

    /**Default constructor */
    public Stock(){
        name = "";
        startDate = "";
        endDate = "";
    }

    /**Constructor */
    public Stock(String companyName, String start, String end){
        name = companyName;
        startDate = start;
        endDate = end;
    }

    /** Getter method for name
     * @return String name variable
     */
    public String getname(){
        return name;
    }

    /** Getter method for start date
     * @return String start date variable
     */
    public String getStart(){
        return startDate;
    }

    /** Getter method for end date
     * @return String end date variable
     */
    public String getEnd(){
        return endDate;
    }

    /**Setter method for name
     * @return String new name
     */
    public String setName(String newName){
        name = newName;
        return name;
    }

    /**Setter method for start date
     * @return String new start date
     */
    public String setStart(String newStart){
        startDate = newStart;
        return startDate;
    }

    /**Setter method for end date
     * @return String new end date
     */
    public String setEnd(String newEnd){
        endDate = newEnd;
        return endDate;
    }
}