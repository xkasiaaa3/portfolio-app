import java.math.BigDecimal;
import java.util.List;

public class Portfolio {

    List<Stock> stocks;

    public Portfolio(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public BigDecimal getTotalValue(){
        BigDecimal sum = BigDecimal.valueOf(0);
        stocks.stream().forEach(stock ->{sum.add(stock.getPricePerShare().multiply(BigDecimal.valueOf(stock.getQuantity())));});
        return sum;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
