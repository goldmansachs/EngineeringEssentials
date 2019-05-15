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
@Path("hello")
public class Example1Resource {


    /**
     * Example 1 Instructions:
     *
     *
     * Run your StartApp with program Arguments: server
     * Go to http://localhost:8080/hello/ok and verify your server is running.
     */

    @GET
    @Path("ok")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() throws IOException {
        return Response.status(Response.Status.OK).entity("Congratulations! You have Successfully started your Rest Server!").build();
    }
}
