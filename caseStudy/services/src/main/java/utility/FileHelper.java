package utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    public static List<Company> readAllCompanies(String fileName) throws
            IOException {
        InputStream inputStream = new FileInputStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }

    public static void main(String[] args) {
        try {
            List<Company> companies = readAllCompanies
                    ("/Users/shreyakeshive/Desktop/EngineeringEssentials/caseStudy/services/src/main/resources/data/companyInfo.json");
        } catch (IOException e) {
            System.out.println("error in parsing company.java");
        }
    }
}
