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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Comparator;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    /** Private variables */
    private Calendar date;
    private double price;

    /**Default constructor */
    public Stock(){
        date = GregorianCalendar.getInstance();
        date.clear();
        price = 0;
    }

    /**Constructor 
     * @param d date string to be parsed
     * @param p price to be stored
    */
    public Stock(String d, double p){
        //splits date string into month, date, and year
        String dateAttributes[] = d.split("\\");
        //Iniatialize Calendar object and clear it
        date = GregorianCalendar.getInstance();
        date.clear();
        //Parse string into integers
        int year = Integer.parseInt(dateAttributes[2]);
        int month = Integer.parseInt(dateAttributes[0]);
        int day = Integer.parseInt(dateAttributes[1]);
        //Put attributes into Calendar object
        //Using month-1 because months in Calendar are 0-based
        date.set(year, month-1, day);

        price = p;

    }

    /** Getter method for price
     * @return String price variable
     */
    public Double getPrice(){
        return price;
    }

    /** Getter method for start date
     * @return String start date variable in String form
     */
    public Calendar getDate(){
        return date;
    }

//    /**Setter method for name
//     * @return String new name
//     */
//    public String setName(String newName){
//        name = newName;
//        return name;
//    }

    /**Setter method for date
     * @return String new date
     */
    public Calendar setEnd(Calendar newDate){
        date = newDate;
        return date;
    }

    /**
     * Comparator method
     */
    @Override
    public int compare(Stock s) {
        return date.compareTo(s.getDate());
      }
}