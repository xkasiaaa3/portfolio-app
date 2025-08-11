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
        BigDecimal total = BigDecimal.ZERO;

        for (Stock stock : stocks) {
            BigDecimal value = stock.getPricePerShare().multiply(new BigDecimal(stock.getQuantity()));
            total = total.add(value);
        }

        return total;
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
