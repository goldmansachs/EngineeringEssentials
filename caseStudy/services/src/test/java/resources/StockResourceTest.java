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

package resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import pojo.Company;
import pojo.Stock;

import javax.ws.rs.core.Application;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Write your tests for the Stock Resource here
 */
public class StockResourceTest extends JerseyTest {

    //@Override
    protected Application configure() {
        return new ResourceConfig(
                StockResource.class

        );
    }

    // TODO - write a test for each method in the CompanyResource class

    @Test
    public void getStatsSymbol() {

        Stock response = target().path("stock/AMZN").request().get(Stock.class);

        Stock result = new Stock();
        result.setSymbol("AMZN");

        assertEquals(result.getSymbol(), response.getSymbol());
    }

    @Test
    public void getStatsSymbolDate() {

        HashMap<Date,Float> response = target().path("stock/AMZN/3-2-2018/4-25-2018").request().get(HashMap.class);

        Stock result = new Stock();
        result.setSymbol("AMZN");

        assertEquals(39, response.size());
    }

}
