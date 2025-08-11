import java.math.BigDecimal;

public class Stock {

    int stockId;
    String stockName;
    int quantity;
    BigDecimal pricePerShare;

    public BigDecimal getPricePerShare() {
        return pricePerShare;
    }
    public void updatePricePerShare(BigDecimal newPrice) {
        this.pricePerShare = newPrice;
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
}
