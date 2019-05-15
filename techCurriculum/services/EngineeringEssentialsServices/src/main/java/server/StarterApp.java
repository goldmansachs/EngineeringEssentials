package server;

import examples.*;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solutions.Example10SolutionResource;
import solutions.Example11SolutionResource;
import solutions.Example2SolutionResource;
import solutions.Example3SolutionResource;
import solutions.Example4SolutionResource;
import solutions.Example5SolutionResource;
import solutions.Example6SolutionResource;
import solutions.Example7SolutionResource;
import solutions.Example8SolutionResource;
import solutions.Example9SolutionResource;

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
public class StarterApp extends Application<Configuration> {

    /**
     *
     * General Instructions:
     *
     * This is a rough guide of how each exercise will go:
     * 1) Read the prompt
     * 2) Go to ResourcesTest.java and run the example test case, make sure that it fails
     *      - In some cases the test may not already be filled in for you, then you will have to write the test,
     *      - and see it fail
     * 3) Implement the solution in Example<#>Resource.java
     * 4) Go to ResourcesTest.java and run the test, make sure it passes
     * 5) Uncomment the example resource in the 'run' method below
     * 5) Restart the Server (if you get a "address-in-use bind" error, then you did not properly stop the server
     * 6) Visit the URL to confirm it is working (for GET requests)
     * 7) Check appropriate JSON file in "data" folder to make sure data was updated properly (for POST, PUT, DELETE)
     *
     *
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(StarterApp.class);

    private static Example11SolutionResource restService = new Example11SolutionResource();

    public StarterApp() {
    }

    @Override
    public void initialize(Bootstrap<Configuration> b) {
        
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new Example1Resource());
        e.jersey().register(new Example2Resource());
        e.jersey().register(new Example3Resource());
        e.jersey().register(new Example4Resource());
//        e.jersey().register(new Example5Resource());
//        e.jersey().register(new Example6Resource());
//        e.jersey().register(new Example7Resource());
//        e.jersey().register(new Example8Resource());
//        e.jersey().register(new Example9Resource());
//        e.jersey().register(new Example10Resource());
//        e.jersey().register(new Example11Resource());
//        e.jersey().register(new Example12Resource());
        LOGGER.info("Successfully started REST Service.");
    }

    /**
     *
     * StarterApp Intellij Run Configuration:
     *
     * Program args: 'server'
     * Working Directory: path to EngineeringEssentialsTraining
     *  - '...\EngineeringEssentials\EngineeringEssentialsTraining"
     */
    public static void main(String[] args) throws Exception {

        StarterApp restServer = new StarterApp();
        restServer.run(args);

        System.out.println("Go to localhost:8080/hello/ok in your browser.");
    }

}