package utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import model.Team;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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
public class FileHelper {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Event readSingleEvent(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(fileName);
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<Event>() {});
    }

    public static List<Event> readAllEvents(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(fileName);
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Event>>() {
        });
    }

    public static List<Team> readTeamsFromFile(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Team>>() {});
    }

    public static Team readTeamFromFile(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<Team>() {});
    }

    public static void writeTeamsToFile(String fileName, List<Team> teams) throws IOException {

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), teams);
    }

    public static void writeTeamToFile(String fileName, Team team) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), team);
    }


    public static void writeEventToFile(String fileName, Event event) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), event);
    }

    public static void writeEventsToFile(String fileName, List<Event> scheduledEvents) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), scheduledEvents);
    }
}
