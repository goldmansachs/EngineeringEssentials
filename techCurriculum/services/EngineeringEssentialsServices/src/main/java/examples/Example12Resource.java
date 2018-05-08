package examples;


import model.Event;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static utility.FileHelper.DATEFORMAT;

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
@Path("events")
public class Example12Resource {

    /**
     * Example 12 Instructions:
     *
     * Fill in the function below to return a list of events that occur inbetween the start and end dates (inclusive)
     *
     * Hint: Read in the dates as Strings
     *
     * URL: http://localhost:8080/events/startDate/2018-03-07/endDate/2018-03-14
     */
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsInRange() throws ParseException {

        Date startDate = DATEFORMAT.parse("");
        Date endDate = DATEFORMAT.parse("");

        return null;
    }

}
