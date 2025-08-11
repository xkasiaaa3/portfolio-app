import java.math.BigDecimal;
import java.util.Objects;

public class Stock {

    private final int stockId;
    private final String stockName;
    private int quantity;
    private BigDecimal pricePerShare;

    public Stock(int stockId, String stockName, int quantity, BigDecimal pricePerShare) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
    }

    public int getStockId() {
        return stockId;
    }
    public String getStockName() {
        return stockName;
    }
    public BigDecimal getPricePerShare() {
        return pricePerShare;
    }
    public void updatePricePerShare(BigDecimal newPrice) {
        if (newPrice.compareTo(new BigDecimal("0")) > 0) {
            this.pricePerShare = newPrice;
        } else {
            System.out.println("Invalid input, try again.");
        }
    }
    public int getQuantity() {
        return quantity;
    }
    public void buyStock(int buyQuantity) {
        this.quantity += buyQuantity;
    }
    public void sellStock(int sellQuantity) {
        this.quantity -= sellQuantity;
    }

    @Override
    public String toString() {
        return "Stock ID: " + stockId + "\n" +
                "Stock Name: " + stockName + "\n" +
                "Stock Price per share: " + pricePerShare + "\n" +
                "Stock Quantity: " + quantity + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return stockId == stock.stockId && Objects.equals(stockName, stock.stockName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, stockName, quantity, pricePerShare);
    }
}

