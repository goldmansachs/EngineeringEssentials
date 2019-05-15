package utility;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pojo.Company;

public class Test {
	public static void main(String[] args) {
		JSONArray obj = null;
		try {
			obj = (JSONArray) new JSONParser().parse(new FileReader("companyInfo.json"));
		} catch (IOException e) {
			System.out.println("Error 1");
			return;
		} catch (ParseException e) {
			System.out.println("Error 2");
			return;
		}
		boolean valid = true;
		
		for (int i = 0; i < obj.size(); i++) {
			JSONObject jobj = (JSONObject) obj.get(i);
			
			boolean symbolValid = jobj.get("symbol") instanceof String || jobj.get("symbol") == null;
			boolean nameValid = jobj.get("name") instanceof String || jobj.get("name") == null;
			boolean hqCityValid = jobj.get("headquartersCity") instanceof String || jobj.get("headquartersCity") == null;
			boolean hqStateValid = jobj.get("headquartersStateOrCountry") instanceof String || jobj.get("headquartersStateOrCountry") == null;
			boolean numEmployeesValid = jobj.get("numberOfEmployees") instanceof Integer && (int) jobj.get("numberOfEmployees") >= 0 || jobj.get("numberOfEmployees") == null;
			boolean sectorValid = jobj.get("sector") instanceof String || jobj.get("sector") == null;
			boolean industryValid = jobj.get("industry") instanceof String || jobj.get("industry") == null;
			
			if (symbolValid && nameValid && hqCityValid && hqStateValid && numEmployeesValid && sectorValid && industryValid)
				valid = false;
			else {
				String symbol = symbolValid ? (String) jobj.get("symbol") : null;
				String name = nameValid ? (String) jobj.get("name") : null;
				String hqCity = hqCityValid ? (String) jobj.get("headquartersCity") : null;
				String hqState = hqStateValid ? (String) jobj.get("headquartersStateOrCountry") : null;
				int numEmployees = numEmployeesValid ? (int) jobj.get("numberOfEmployees") : -1;
				String sector = sectorValid ? (String) jobj.get("sector") : null;
				String industry = industryValid ? (String) jobj.get("industry") : null;
				
				System.out.println("Symbol: " + symbol);
				System.out.println("Name: " + name);
				System.out.println("HQ City: " + hqCity);
				System.out.println("HQ State: " + hqState);
				System.out.println("Employees: " + numEmployees);
				System.out.println("Sector: " + sector);
				System.out.println("Industry: " + industry);
				System.out.println();
				
				
//				Company comp = new Company(symbol, name, hqCity, hqState, numEmployees, sector, industry);
			}
		}
	}
}
