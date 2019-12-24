package solutions;

import model.Event;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
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
public class Example8SolutionResource {

    @GET
    @Path("{country}/wins")
    public int getWins(@PathParam("country") String country) throws IOException {

        List<Event> events = FileHelper.readAllEvents("events.json");

        int numWins = 0;
        for (Event event: events) {
            if (event.getWinningCountry().name().equalsIgnoreCase(country)) {
                ++numWins;
            }

        }
        return numWins;
    }
}
