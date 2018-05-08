package examples;


import model.Country;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
public class Example6Resource {

    /**
     * Example 6 Instructions:
     * Add the functionality to return a list of Countries that participated in at least 1 event
     *
     * URL: http://localhost:8080/events/allParticipatingCountries
     *
     */
    @GET
    @Path("replace")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllParticipatingCountries() {

        List<Country> participatingCountries = null;
        return null;
    }
}
