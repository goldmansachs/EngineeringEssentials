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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// TODO - add your @Path here
@Path("stock")
public class StockResource {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat DATEFORMAT2 = new SimpleDateFormat("dd-MM-yyyy");
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

        if(result == null)
            return Response.ok().entity("No stock with ticker" + stockName).build();

        return Response.ok().entity(result).build();
    }

    @GET
    @Path("{stockName}/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatsDate(@PathParam("stockName") String stockName,
                                 @PathParam("startDate") String startDate,
                                 @PathParam("endDate") String endDate) throws IOException, ParseException {

        List<Stock> data = InputValidator.readAllStocks("historicalStockData.json");
        //HashMap<String, Float> pruned = new HashMap<String, Float>();
        Date start = DATEFORMAT2.parse(startDate);
        Date end = DATEFORMAT2.parse(endDate);
        Stock result = null;
        for(Stock s: data)
            if(s.getSymbol().equalsIgnoreCase(stockName)) {
                result = s;
                break;
            }

        if(result == null)
            return Response.ok().entity("No stock with ticker" + stockName).build();

        HashMap<String,Float> map = result.getDailyClosePrice()[0];
        HashMap<Date,Float> dmap = new HashMap<Date, Float>();

        Set<String> keyset = map.keySet();
        for(String date : keyset) {
            Date compare = DATEFORMAT.parse(date);
            if (compare.compareTo(start) >= 0 && compare.compareTo(end) <= 0)
                dmap.put(compare,map.get(date));
        }


        return Response.ok().entity(dmap).build();
    }



}
