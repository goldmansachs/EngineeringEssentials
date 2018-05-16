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

import javax.ws.rs.Path;

import pojo.Stock;
import utility.InputValidator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.List;

// TODO - add your @Path here
@Path("stock")
public class StockResource {

    // TODO - Add a @GET resource to get stock data
    @GET
    @Path("status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() throws IOException {
        return Response.status(Response.Status.OK).entity("Stock is now active").build();
    }

    @GET
    @Path("{stockName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStats(@PathParam("stockName") String stockName) throws IOException {

        List<Stock> data = InputValidator.readAllStocks("historicalStockData.json");
        Stock result = null;
        for(Stock s: data)
            if(s.getSymbol().equalsIgnoreCase(stockName))
                result = s;

        return Response.ok().entity(result).build();
    }



}
