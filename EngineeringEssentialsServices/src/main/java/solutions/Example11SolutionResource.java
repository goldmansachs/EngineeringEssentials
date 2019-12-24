package solutions;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import utility.FileHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2018 Goldman Sachs.
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
public class Example11SolutionResource {
    private ObjectMapper mapper = new ObjectMapper();


    /**
     * Example 11 Instructions:
     * <p>
     * Create a DELETE method called cancelEvent() that will update the events to remove a cancelled event based on the eventType, home country, and away country.
     * The Event Cancelled was a Baseball game where China is the Home Country and Australia is the Away Country
     * Save your changes in the test-delete-event.json
     * Return either a 200 OK or a 500 Internal Server error if it fails to delete an event
     * Return the list of cancelled events in the entity.
     */


    @DELETE
    @Path("cancel/{eventType}/home/{homeCountry}/away/{awayCountry}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelEvent(@PathParam("eventType") String eventType, @PathParam("homeCountry") String home, @PathParam("awayCountry") String away) throws IOException {
        final String filename = "remaining-events.json";
        List<Event> scheduledEvents = FileHelper.readAllEvents("events.json");
        List<Event> cancelled = new ArrayList<>();
        Response.ResponseBuilder response = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
        try {
            for (Event event : scheduledEvents) {
                if (event.getHomeCountry().name().equalsIgnoreCase(home) &&
                        event.getAwayCountry().name().equalsIgnoreCase(away) &&
                        event.getEventType().name().equalsIgnoreCase(eventType)) {
                    cancelled.add(event);
                }
            }
            scheduledEvents.removeAll(cancelled);
            FileHelper.writeEventsToFile(filename, scheduledEvents);
            return Response.ok().entity(cancelled).build();

        } catch (Exception e) {
            System.out.println("Failed to cancel an event. " + e.getLocalizedMessage());
        }
        return response.build();
    }

}
