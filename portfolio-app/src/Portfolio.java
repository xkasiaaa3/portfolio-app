import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Portfolio {

    List<Stock> stocks = Collections.emptyList();

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

    public void addStock(Stock stock){
        if (stocks.contains(stock)){
            stocks.stream().forEach(s -> {
                if (s.equals(stock)) {
                    s.updatePricePerShare(stock.getPricePerShare());
                    s.buyStock(stock.getQuantity());
                }});
        }
        else{
            System.out.println(stocks.add(stock));
        }

        System.out.println("Portfolio update stocks, current stocks: \n" + stocks);
    }
}
