package examples;


import model.Event;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
public class Example5Resource {


    /**
     * Example 5 Instructions:
     *
     * Add the proper @Produces Annotation to the method below
     * and then use the appropriate method from FileHelper to read and return
     * the list of all of the events in the events.json file
     *
     * URL: http://localhost:8080/events/all
     */
    @GET
    @Path("all")
    public Response getAllEvents() throws IOException {

        List<Event> events = null;
        return Response.ok().entity(events).build();
    }
}
