package examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Copyright 2017 Goldman Sachs.
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
public class Example11Resource {

    /**
     * Example 11 Instructions:
     *
     * Create a DELETE method called cancelEvent() that will update the events to cancel all events with a given
     * eventType, home country, and away country.
     *
     * The Event Cancelled was a Baseball game where China is the Home Country and Australia is the Away Country
     *
     * Save the remaining events in remaining-events.json
     * Return either a 200 OK or a 500 Internal Server error if it fails to delete an event
     * Return the list of cancelled events in the entity.
     *
     * Compare the remaining-events.json file to events.json file to check that the proper events were deleted
     *
     */
    @DELETE
    @Path("cancel/{eventType}/home/{homeCountry}/away/{awayCountry}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cancelEvent() throws IOException{
        final String filename = "remaining-events.json";

        return null;
    }

}
