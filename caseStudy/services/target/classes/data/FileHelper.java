public class FileHelper {
    public static void main(String[] args) {
        Object obj = parser.parse(new FileReader("./companyInfo.json"));
        JSONObject jsonObject = (JSONObject) jsonObject;

        for (Object o : a) {
            JSONObject company = (JSONObject) o;
            String name = (String) company.get("symbol");
            System.out.println(name);
        }
    }
}