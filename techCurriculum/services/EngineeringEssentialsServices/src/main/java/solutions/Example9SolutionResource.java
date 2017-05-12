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
public class Example9SolutionResource {



    /**
     * Example 9 Instructions:
     *
     * Part 1: Create a Sample Event and save it to the test-create-event.json file using the POST method createEvent
     * Return either a 200 OK or a 500 Internal Server error if it fails to create the event
     * URL to Visit: <localhost:port>/events/createEvent
     * <p>
     * Part 2: Create a getNewEvent method that would read the file test-create-event.json and return the created event
     * If the event is not found, return a 404 NOT_FOUND along with an explanation
     * URL to Visit:  <localhost:port>/events/new
     */

    @POST
    @Path("createEvent")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEvent(Event newEvent) throws IOException {
        String filename = "test-create-event.json";

        List<Event> events;
        try {
            events = FileHelper.readAllEvents(filename);
            events.add(newEvent);
        } catch (IOException e) {
            // File not found
            events = new ArrayList<>();
            events.add(newEvent);
        }

        try {
            FileHelper.writeEventsToFile(filename, events);
            return Response.ok().build();
        } catch (Exception e) {
            System.out.println("Failed to create a new Event");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }


    @GET
    @Path("new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewEvent() throws IOException {
        //TODO: Make this method return an Event
        String filename = "test-create-event.json";
        List<Event> allCreatedEvents = FileHelper.readAllEvents(filename);
        return Response.ok(allCreatedEvents).build();
    }

}
