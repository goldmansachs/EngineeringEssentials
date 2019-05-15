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

package resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import pojo.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

    // Your service should return data for a given stock ticker

@Path("companies")
public class CompanyResource {

    private static final ObjectMapper mapper = new ObjectMapper();

    @GET
    public Response getCompanyForTicker(String ticker) throws IOException {

        List<Company> companies = readAllCompanies();

        // Need to get .json object
        //Company company; //get the company for ticker
        //return Response.ok().entity(company).build();

    }

    public static List<Company> readAllCompanies() throws IOException {

        InputStream inputStream = new FileInputStream(("./resources/data" + File.separatorChar + "companyInfo.json"));
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }
}
