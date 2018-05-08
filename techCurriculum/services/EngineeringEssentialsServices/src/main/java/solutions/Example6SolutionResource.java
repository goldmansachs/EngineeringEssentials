package solutions;

import model.Country;
import model.Event;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class Example6SolutionResource {

    @GET
    @Path("allParticipatingCountries")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> getAllParticipatingCountries() throws IOException {

        List<Event> events = FileHelper.readAllEvents("allParticipatingCountries.json");
        Set<Country> countries = new HashSet<>();

        for (Event event: events) {

            countries.add(event.getAwayCountry());
            countries.add(event.getHomeCountry());
        }

        return countries;
    }
}
