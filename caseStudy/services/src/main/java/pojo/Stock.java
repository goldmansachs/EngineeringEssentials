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
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.lang.String;
import java.lang.Double;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    private String name;
    private Map<Date, Double> prices = new HashMap();

    public Stock(String name, HashMap<String, Double> temp) throws ParseException{
        this.name = name;

        HashMap<Date, Double> modTemp = new HashMap();
        for (HashMap.Entry<String, Double> entry : temp.entrySet()) {
            String pattern = "MM/dd/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = simpleDateFormat.parse(entry.getKey());
            modTemp.put(date, entry.getValue());
        }

        // Sort MOD TEMP by date (key).
        Map<Date, Double> map = new TreeMap(modTemp);
        this.prices = map;
    }

    public boolean equals(Stock obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null || obj.getClass()!= this.getClass()) {
            return false;
        }
        // type casting of the argument.
        Stock obj1 = (Stock) obj;


        return (obj1.name == this.name && obj1.prices == this.prices);
    }
    // Getter and setter methods

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setPriceByDate(String date, Double newPrice) throws ParseException{
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date1 = simpleDateFormat.parse(date);
        prices.put(date1, newPrice);

        // if want to return NULL if the date doesn't exist, use REPLACE
    }

    public Double getPriceByDate(String date) throws ParseException{
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date1 = simpleDateFormat.parse(date);
        return prices.get(date1);
    }
}
