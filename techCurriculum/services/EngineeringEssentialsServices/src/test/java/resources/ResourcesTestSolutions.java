package resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import solutions.*;
import utility.FileHelper;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import static model.Country.*;
import static org.junit.Assert.*;
import static utility.FileHelper.DATEFORMAT;

/**
 * Copyright 2017 Goldman Sachs.
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
public class ResourcesTestSolutions extends JerseyTest {
        private static ObjectMapper mapper = new ObjectMapper();


    @Override
    protected Application configure() {
        return new ResourceConfig(
                Example2SolutionResource.class,
                Example3SolutionResource.class,
                Example4SolutionResource.class,
                Example5SolutionResource.class,
                Example6SolutionResource.class,
                Example7SolutionResource.class,
                Example8SolutionResource.class,
                Example9SolutionResource.class,
                Example10SolutionResource.class,
                Example11SolutionResource.class,
                Example12SolutionResource.class
                );
    }

    @Test
    public void testExample2() {
        String response = target().path("events/test").request().get(String.class);
        assertEquals("Welcome to Engineering Essentials Services Training!", response);
    }

    @Test
    public void testExample3() {
        String entity = "This site is now fixed.";
        Response expected = Response.ok().entity(entity).build();

        Response response = target().path("response/test/fixed").request().get();
        String stringResponse = target().path("response/test/fixed").request().get(String.class);
        assertEquals(expected.getStatus(), response.getStatus());
        assertEquals(expected.getEntity(), stringResponse);
    }

    @Test
    public void testExample4() throws ParseException {
        Event event = new Event();
        event.setAwayCountry(Country.Australia);
        event.setHomeCountry(Portugal);
        event.setWinningCountry(Portugal);
        event.setLosingCountry(Country.Australia);
        event.setWinningScore(22);
        event.setLosingScore(4);
        event.setEventType(EventType.WaterPolo);

        Date date = DATEFORMAT.parse("2017-02-27");
        event.setDate(date);

        Event response = target().path("events/sample").request().get(Event.class);
        assertEquals(event, response);
    }

    @Test
    public void testExample5() throws IOException {
        List<Event> events = FileHelper.readAllEvents("events.json");

        Response response = target().path("events/all").request().get();
        List<Event> responseEvents = mapper.convertValue(response.readEntity(List.class), new TypeReference<List<Event>>() {
        });

        assertEquals(events.size(), responseEvents.size());
        assertEquals(events, responseEvents);
    }

    @Test
    public void testExample6() {

        Set<Country> checkParticipatingCountries = EnumSet.complementOf(EnumSet.of(Country.Portugal));
        Set<Country> getParticipatingCountries = target().path("events/allParticipatingCountries").request().get(Set.class);

        assertEquals(checkParticipatingCountries.size(), getParticipatingCountries.size());
        assertFalse(getParticipatingCountries.contains(Portugal));

    }

    @Test
    public void testExample7() {

        List<Event> china = target().path("/events/country/China").request().get(List.class);
        List<Event> brazil = target().path("events/country/brazil").request().get(List.class);
        List<Event> brazilUppercase = target().path("events/country/BraZil").request().get(List.class);
        List<Event> us = target().path("events/country/UnitedStates").request().get(List.class);
        String response = target().path("events/country/Canada").request().get(String.class);

        assertEquals(23, china.size());
        assertEquals(28, brazil.size());
        assertEquals(28, brazilUppercase.size());
        assertEquals(25, us.size());
        assertEquals(response, "No matches found for Country with name Canada");
    }

    @Test
    public void testExample8() {

        int expNumWinsEngland = 15;
        int expNumWinsUnitedStates = 8;
        int expNumWinsChina = 15;

        int actualNumWinsEngland = target().path("events/England/wins").request().get(int.class);
        int actualNumWinsUnitedStates = target().path("events/UnitedStates/wins").request().get(int.class);
        int actualNumWinsChina = target().path("events/China/wins").request().get(int.class);

        assertEquals(expNumWinsEngland, actualNumWinsEngland);
        assertEquals(expNumWinsUnitedStates, actualNumWinsUnitedStates);
        assertEquals(expNumWinsChina, actualNumWinsChina);
    }

    @Test
    public void testExample9() throws ParseException, IOException {

        Event event = new Event();
        event.setAwayCountry(Country.Japan);
        event.setHomeCountry(UnitedStates);
        event.setWinningCountry(UnitedStates);
        event.setLosingCountry(Country.Japan);
        event.setWinningScore(10);
        event.setLosingScore(4);
        event.setEventType(EventType.Baseball);

        Date date = DATEFORMAT.parse("2017-02-22");
        event.setDate(date);

        Response postEvent = target().path("events/createEvent").request().post(Entity.json(event));
        List<Event> getNewEvents = target().path("events/new").request().get(List.class);

        // To make sure that the event was created
        assertEquals(1, getNewEvents.size());

        target().path("events/createEvent").request().post(Entity.json(event));
        List<Event> getNewEvents2 = target().path("events/new").request().get(List.class);

        // To make sure that a new event was added, rather than overwriting the existing one
        assertEquals(2, getNewEvents2.size());
        assertEquals(postEvent.getStatus(), 200);

    }

    @Test
    public void testExample10() {

        Set<Player> players = new HashSet<>();
        players.add(new Player("Anna Conda", India));
        players.add(new Player("Linda Book", India));

        Team ballers = new Team();
        ballers.setName("Smallers");
        ballers.setPlayers(players);

        Response putTeam = target().path("events/team").request().put(Entity.json(ballers));
        assertEquals(200, putTeam.getStatus());

        Team getBallers = target().path("events/team/Smallers").request().get(Team.class);

        target().path("events/team").request().put(Entity.json(ballers));
        Team getBallers2 = target().path("events/team/Smallers").request().get(Team.class);

        assertEquals(ballers, getBallers);
        assertEquals(getBallers, getBallers2);
    }

    @Test
    public void testExample11() throws ParseException, IOException {
        List<Event> allEvents = FileHelper.readAllEvents("events.json");

        List<Event> cancelledEvents = target().path("events/cancel/Baseball/home/China/away/Australia").request().delete(List.class);

        assertTrue(cancelledEvents.size() < allEvents.size());
        assertEquals(1, cancelledEvents.size());

    }

    @Test
    public void testExample12() {

        // Check that the number of events between Feb 09 2017 and Feb 12 2017 (inclusive) is 14

        List<Event> eventsInRange = target().path("/events/startDate/2017-02-09/endDate/2017-02-12").request().get(List.class);
        assertEquals(14, eventsInRange.size());
    }

}