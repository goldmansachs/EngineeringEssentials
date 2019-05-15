package examples;


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
public class Example3Resource {

    /**
     * Example 3 Instructions:
     *
     * Modify the method below so that when you restart the Server and visit the URL,
     * you see "This site is now fixed."
     *
     * 1) You will have to change the @Path
     * 2) You will have to change the string returned
     * 3) Your will have to change the status returned to Response.Status.OK
     *
     * URL: http://localhost:8080/response/test/fixed
     */
    @GET
    @Path("test/fixed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() throws IOException {
        String properResponse = "This site is now fixed.";
        return Response.status(Response.Status.OK).entity(properResponse).build();
    }
}
