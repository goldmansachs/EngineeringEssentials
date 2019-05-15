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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import pojo.Stock;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.SortedMap;
import java.text.ParseException;

import jdk.nashorn.internal.objects.annotations.Getter;


@Path("stock")
// TODO - add your @Path here
public class StockResource {

    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date

    private ObjectMapper mapper = new ObjectMapper();

    @GET
    public Response getByTicker(String ticker) throws IOException {
        //TODO: Return the list of all of the events in the events.json file
        List<Stock> stocks; // something Claire makes

        for (Stock temp : stocks) {
            if (temp.getName() == ticker) {
                return Response.ok().entity(temp).build();
            }
        }
        return Response.noContent().build();
    }

    @GET
    public Response getByStartDate(String dateStart) throws IOException, ParseException {
        //TODO: Return the list of all of the events in the events.json file
        List<Stock> stocks; // something Claire makes

        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date1 = simpleDateFormat.parse(dateStart);
        List<Stock> stocksByDate = new ArrayList<Stock>();

        for (Stock temp : stocks) {
            SortedMap<Date, Double> allPrices = temp.getPrices();
            int count = 0;
            for (SortedMap.Entry<Date, Double> entry : allPrices.entrySet()) {
                if (count > 0) {
                    break;
                }
                if (entry.getKey() == date1) {
                    stocksByDate.add(temp);
                }
                ++count;
            }
        }
        return Response.ok().entity(stocksByDate).build();
    }

    @GET
    public Response getByEndDate(String dateEnd) throws IOException, ParseException {
        //TODO: Return the list of all of the events in the events.json file
        List<Stock> stocks; // something Claire makes

        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date1 = simpleDateFormat.parse(dateEnd);
        List<Stock> stocksByDate = new ArrayList<Stock>();

        for (Stock temp : stocks) {
            SortedMap<Date, Double> allPrices = temp.getPrices();

            if (allPrices.lastKey() == date1) {
                stocksByDate.add(temp);
            }
        }
        return Response.ok().entity(stocksByDate).build();
    }
}
