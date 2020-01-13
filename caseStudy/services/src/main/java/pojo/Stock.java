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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {
    // Define the attributes of a stock price based on the
    // provided data in resources/data
    String ticker;
    ArrayList<Price> prices;
    Date startDate;
    Date endDate;

    public Stock(String ticker, ArrayList<Price> prices){
        this.ticker = ticker;
        this.prices = prices;
        sortPrices();
        this.startDate = prices.get(0).getDate();
        this.endDate = prices.get(prices.size()-1).getDate();
    }

    private void sortPrices(){
        Comparator<Price> compare = Comparator.comparing(Price::getDate);
        Collections.sort(prices, compare);
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setPrices(ArrayList<Price> prices) {
        this.prices = prices;
        sortPrices();
    }

    public String getTicker() {
        return ticker;
    }

    public ArrayList<Price> getPrices() {
        return prices;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
