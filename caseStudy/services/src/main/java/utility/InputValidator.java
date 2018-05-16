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

public class InputValidator {

    private static final ObjectMapper mapper = new ObjectMapper();
    // TODO - write a method that will validate your JSON input files

    // TODO - write a method that will validate the inputs to the Company Resource
    public static List<Company> readAllCompanies(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream("resources/"+ fileName);

        //        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }
    // TODO - write a method that will validate the inputs to the Stock Resource

}
