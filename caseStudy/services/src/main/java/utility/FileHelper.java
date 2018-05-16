package utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Company;

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

    public static Company readSingleCompany(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<Company>() {});
    }

    public static List<Company> readAllCompanys(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }

    public static List<Company> readCompanysFromFile(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {});
    }

    public static Company readCompanyFromFile(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<Company>() {});
    }

    public static void writeCompanysToFile(String fileName, List<Company> Companys) throws IOException {

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), Companys);
    }

    public static void writeCompanyToFile(String fileName, Company Company) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), Company);
    }


    public static void writeCompanyToFile(String fileName, Company Company) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), Company);
    }

    public static void writeCompanysToFile(String fileName, List<Company> scheduledCompanys) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), scheduledCompanys);
    }
}
