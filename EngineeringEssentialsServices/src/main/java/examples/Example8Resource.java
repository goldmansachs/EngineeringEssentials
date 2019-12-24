package examples;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
public class Example8Resource {

    /**
     * Example 8 Instructions:
     * Fill in the method below so that for a given country, this endpoint returns the number of wins that country has
     *
     * Hint: Don't forget the @PathParam annotation
     *
     * URL: http://localhost:8080/events/UnitedStates/wins
     * URL: http://localhost:8080/events/China/wins
     *
     */
    @GET
    @Path("replace this")
    public int getWins(String country) {
        return 0;
    }
}

