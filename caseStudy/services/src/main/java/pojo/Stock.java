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
import java.lang.String;
import java.lang.Double;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    // TODO - Think back to your modelling session
    // Define the attributes of a stock price based on the
    // provided data in resources/data

    String name;
    HashMap<String, Double> prices = new HashMap();

    public Stock(String name, HashMap prices) {
        this.name = name;
        // need to normalize the prices; sort by date
        this.prices = prices;
    }

    // TODO - add getter and setter methods for your attributes

    void setName(String newName) {
        name = newName;
    }

    String getName() {
        return name;
    }

    void setPriceByDate(String date, Double newPrice) {
        prices.put(date, newPrice);
        // if want to return NULL if the date doesn't exist, use REPLACE
        // prices.replace(date, newPrice);
    }

    Double getPriceByDate(String date) {
        return prices.get(date);
    }
}
