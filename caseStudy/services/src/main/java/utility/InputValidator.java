package utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Company;
import pojo.Stock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

public class InputValidator {

    private static final ObjectMapper mapper = new ObjectMapper();
    // TODO - write a method that will validate your JSON input files

    public static List<Company> readAllCompanies(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream("resources/data/"+ fileName);

        //        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }
    public static List<Stock> readAllStocks(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream("resources/data/"+ fileName);

        //        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Stock>>() {
        });
    }

}
