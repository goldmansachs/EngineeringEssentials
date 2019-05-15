package examples;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import static utility.FileHelper.readSingleEvent;

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
public class Example4Resource {


    /**
     * Example 4 Instructions:
     *
     * Use the appropriate method from FileHelper.java (utility folder) to read in a single event from the file
     * "single-event.json" and return this event
     *
     * Hint: the method below is missing an annotation
     *
     * URL: http://localhost:8080/events/sample
     */
    @GET
    @Path("sample")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSampleEvent() throws IOException {

        Event event = FileHelper.readSingleEvent("C:/Users/Girls Who Code/Documents/Goldman Sachs Engineering Essentials Materials/EngineeringEssentials/techCurriculum/services/EngineeringEssentialsServices/data/single-event.json");
        return Response.ok().entity(event).build();
    }
}

