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



public class ClosePrice {
    String date;
    double price;

    public void ClosePrice(String date, double price) {
        this.date = date;
        this.price = price;
    }

    public void setDate(String d) {
        this.date = d;
    }
    
    public void setPrice(double p) {
        this.price = p;
    }

    public String getDate() {
        return this.date;
    }

    public double getPrice() {
        return this.price;
    }
}

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    String name;
    ArrayList<ClosePrice> daily = new ArrayList<ClosePrice>();

    public void Stock(String name, ArrayList daily) {
        this.name = name;
        this.daily = daily;
    }

    public void setName(String n) {
        this.name = n;
    }
    
    public void setDaily(ArrayList daily) {
        this.daily = daily;
    }

    public String getName() {
        return this.name;
    }

    public double getDaily() {
        return this.daily;
    }

}

