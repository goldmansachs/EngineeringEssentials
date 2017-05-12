package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Country;
import model.Event;
import model.EventType;
import org.joda.time.LocalDate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

//DO NOT MODIFY THIS CLASS
public class CreateEvents {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[]) throws IOException {

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            int eventIndex = ThreadLocalRandom.current().nextInt(0, EventType.values().length);
            int homeCountryIndex = 0;
            int awayCountryIndex = 0;
            while (homeCountryIndex == awayCountryIndex) {
                homeCountryIndex = ThreadLocalRandom.current().nextInt(0, Country.values().length);
                awayCountryIndex = ThreadLocalRandom.current().nextInt(0, Country.values().length);
            }
            events.add(createEvent(EventType.values()[eventIndex],
                    Country.values()[homeCountryIndex],
                    Country.values()[awayCountryIndex]));
        }
        //DO NOT MODIFY FILENAME
//        String filePath = CreateEvents.class.getClassLoader().getResources("resources").getPath();

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("EngineeringEssentialsServices/src/main/resources/events.json"), events);

    }

    private static Event createEvent(EventType eventType, Country homeCountry, Country awayCountry) {
        Event event = new Event();
        event.setAwayCountry(awayCountry);
        event.setHomeCountry(homeCountry);
        event.setEventType(eventType);

        int dayOfMonth = ThreadLocalRandom.current().nextInt(1, 28);
        int month = 1;
        int winner = ThreadLocalRandom.current().nextInt(0, 2);
        int winningScore = ThreadLocalRandom.current().nextInt(10, 16);
        int losingScore = ThreadLocalRandom.current().nextInt(0, 10);
        event.setWinningScore(winningScore);
        event.setLosingScore(losingScore);

        if (winner == 0) {
            event.setWinningCountry(awayCountry);
            event.setLosingCountry(homeCountry);
        } else {
            event.setWinningCountry(homeCountry);
            event.setLosingCountry(awayCountry);
        }


        Date date = new GregorianCalendar(2017, month, dayOfMonth).getTime();
        event.setDate(date);

        return event;
    }

}
