package examples;


import model.Team;
import utility.FileHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

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
public class Example10Resource {

    /**
     * Example 10 Instructions:
     *
     * Modify the updateTeam method below to save the "team" that is passed in into a file with the pattern
     * <team-name>-team.json
     *
     * Use the appropriate method from FileHelper to write to the file. Then check to make sure it was successful with the GET
     * method provided below
     *
     * URL: http://localhost:8080/events/team/{teamName}
     */
    @PUT
    @Path("team")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTeam(Team team) {

        return Response.ok().build();
    }

    @GET
    @Path("team/{teamName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Team getTeam(@PathParam("teamName") String teamName) throws IOException {

        return FileHelper.readTeamFromFile(teamName.toLowerCase().concat("-team.json"));
    }


}
