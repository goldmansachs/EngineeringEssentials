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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import pojo.Company;
import utility.InputValidator;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Write your tests for the Company Resource here
 */
public class CompanyResourceTest extends JerseyTest {

    // TODO - write a test for each method in the CompanyResource class
    // Think about both positive and negative test cases:
    // What happens if no inputs are passed?
    // What happens if the input is null?

    //@Override
    protected Application configure() {
        return new ResourceConfig(
                CompanyResource.class

        );
    }

    @Test
    public void getStatus() {
        String response = target().path("company/status").request().get(String.class);

        assertEquals("Server is now active", response);
    }

    @Test
    public void getStatsName() {

        Company response = target().path("company/name/Amazon.com Inc.").request().get(Company.class);

        Company result = new Company();
        result.setSymbol("AMZN");
        result.setName("Amazon.com Inc.");
        result.setHeadquartersCity("Seattle");
        result.setHeadquartersStateOrCountry("WA");
        result.setNumberOfEmployees(341000);
        result.setSector("Cyclical Consumer Goods & Services");
        result.setIndustry("Internet & Mail Order Department Stores");

        assertEquals(result.getName(), response.getName());
        assertEquals(result.getNumberOfEmployees(),response.getNumberOfEmployees());
    }
    @Test
    public void getStatsSymbol() {

        Company response = target().path("company/symbol/AMZN").request().get(Company.class);

        Company result = new Company();
        result.setSymbol("AMZN");
        result.setName("Amazon.com Inc.");
        result.setHeadquartersCity("Seattle");
        result.setHeadquartersStateOrCountry("WA");
        result.setNumberOfEmployees(341000);
        result.setSector("Cyclical Consumer Goods & Services");
        result.setIndustry("Internet & Mail Order Department Stores");

        assertEquals(result.getName(), response.getName());
        assertEquals(result.getNumberOfEmployees(),response.getNumberOfEmployees());
    }

}
