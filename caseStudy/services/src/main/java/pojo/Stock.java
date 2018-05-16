package pojo;
import java.util.HashMap;
import java.util.List;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {
    private String name;
    private List<HashMap<String, Integer>> dailyClosePrice;

    public Stock() {

    }
    public Stock(String name, List<HashMap<String, Integer>> dailyClosePrice) {
        this.name = name;
        this.dailyClosePrice = dailyClosePrice;
    }

    public String getName() {
        return name;
    }

    public List<HashMap<String, Integer>> getDailyClosePrice() {
        return dailyClosePrice;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public List<HashMap<String, Integer>> setDailyClosePrice(List<HashMap<String, Integer>>
                                                              dailyClosePrice) {
        this.dailyClosePrice = dailyClosePrice;
        return dailyClosePrice;
    }
}