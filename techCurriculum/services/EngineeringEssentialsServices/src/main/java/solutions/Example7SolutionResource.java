package solutions;


import model.Event;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
@Path("events")
public class Example7SolutionResource {

    /**
     * Example 7 Instructions:
     * <p>
     * Copy over solutions from Examples 5 and 6 into this resource to help you with this example
     * Return the Events for the country in the Response, must be a 200 OK response if available, include the teams in the response
     * If no teams were found, return a 404 Response.Status.NOT_FOUND, and a message stating the country was not found
     * If not available or exception is thrown should return a 500 Response.Status.INTERNAL_SERVER_ERROR with an explanation of what went wrong
     */

/*
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getAllEvents() throws IOException {
        List<Event> events = FileHelper.readAllEvents("events.json");
        return events;
    }


    @GET
    @Path("allParticipatingCountries")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> getAllParticipatingCountries() throws IOException {

        events = getAllEvents();
        Set<Country> countries = new HashSet<>();

        for (Event event: events) {

            countries.add(event.getAwayCountry());
            countries.add(event.getHomeCountry());
        }

        return countries;
    }

*/
    @GET
    @Path("country/{countryName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventsForCountry(@PathParam("countryName") String countryName) throws IOException {
        List<Event> eventsForCountry = new ArrayList<>();
        List<Event> events = FileHelper.readAllEvents("events.json");

        for (Event event : events) {
            if (event.getAwayCountry().name().equalsIgnoreCase(countryName) || event.getHomeCountry().name().equalsIgnoreCase(countryName)) {
                eventsForCountry.add(event);
            }
        }
        Response.ResponseBuilder response;
        try {
            if (eventsForCountry.size() > 0) {
                return Response.ok(eventsForCountry).build();
            } else {
                return Response.ok().entity("No matches found for Country with name " + countryName).build();
            }
        } catch (Exception e) {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e);
        }
        return response.build();
    }
}
