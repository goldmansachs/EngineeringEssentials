package solutions;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
@Path("response")
public class Example3SolutionResource {

    /**
     * Example 3 Instructions:
     *
     *
     */
    @GET
    @Path("test/fixed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() throws IOException {
        //TODO: Modify the Path "response" and uri of the getResponse() method to be "<localhost:port>/response/test/fixed"
        //TODO: Fix the response so that it returns a 200 OK instead of an internal server error.
        // TODO:Return the Response with the String entity
        String entity = "This site is now fixed.";
        return Response.status(Response.Status.OK).entity(entity).build();
    }
}
