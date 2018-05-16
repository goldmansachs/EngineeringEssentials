package server;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.CompanyResource;

public class StarterApp extends Application<Configuration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarterApp.class);

    public StarterApp() {
    }

    @Override
    public void initialize(Bootstrap<Configuration> b) {

    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new CompanyResource());
//        e.jersey().register(new Example2Resource());
//        e.jersey().register(new Example3Resource());
//        e.jersey().register(new Example4Resource());
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

        System.out.println("Go to localhost:8080/company/status in your browser.");
    }

}