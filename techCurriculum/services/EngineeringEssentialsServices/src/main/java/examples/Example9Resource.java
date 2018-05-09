package examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

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
public class Example9Resource {


    /**
     * Example 9 Instructions:
     *
     * Part 1:
     * Create a Sample Event and save it to the test-create-event.json file using the POST method createEvent
     * Return a response with Status.OK after creating the event
     *
     * Part 2: Add a getNewEvent method that would reads the file test-create-event.json and returns the created event
     *
     * URL (after part 2): http://localhost:8080/events/newEvent
     */
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEvent(Event newEvent) throws IOException{
        final String filename = "test-create-event.json";
        return null;
    }

}
