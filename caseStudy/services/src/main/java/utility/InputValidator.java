/**
 * Copyright 2019 Goldman Sachs.
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

package utility;

/**
 * Utility class to validate inputs
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InputValidator {

    private static final ObjectMapper mapper = new ObjectMapper();
    // TODO - write a method that will validate your JSON input files
    public static List<Company> readAllCompanies (String fileName) throws IOException {
       if (fileName != null ) {
           InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
           return mapper.readValue(inputStream, new TypeReference<Company>() {});
       }
       else
           return null;


    }

    // TODO - write a method that will validate the inputs to the Company Resource

    public Boolean validateCompany(String stockTicker) {
        if (stockTicker == null) return false;
        else return true;
    }

    // TODO - write a method that will validate the inputs to the Stock Resource

    public Boolean validateStock (String stockTicker, String startDate, String endDate) {
        if (stockTicker == null || startDate == null || endDate == null) {
            return false;
        }
        else
            return true;
    }

}
