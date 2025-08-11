import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Stock> stocks = new ArrayList<>();
    static Portfolio portfolio = new Portfolio(stocks);
    static TerminalText text = new TerminalText();
    static Scanner scanner = new Scanner(System.in);

    public static void buyStock() {
        System.out.print("Please input stock ID: ");
        int stockId = scanner.nextInt();
        System.out.print("Please input stock name: ");
        String stockName = scanner.next();

        Stock currentStock = new Stock(stockId, stockName, 0, new BigDecimal("100"));
        boolean found = false;
        for (Stock stock : stocks) {
            if (stock.equals(currentStock)) {
                found = true;
                System.out.println("Your current holdings:\n" + stock);
                break;
            }
        }
        if (found) {
            System.out.print("Update price: ");
            BigDecimal pricePerShare = scanner.nextBigDecimal();
            currentStock.updatePricePerShare(pricePerShare);
            System.out.println("How many more shares would you like to buy?");
        } else {
            System.out.println("You do not own any shares of this stock.");
            System.out.print("Set the current price: ");
            BigDecimal pricePerShare = scanner.nextBigDecimal();
            currentStock.updatePricePerShare(pricePerShare);
            System.out.println("How many shares would you like to buy?");
        }
        System.out.print("Input: ");
        int quantity = scanner.nextInt();
        currentStock.buyStock(quantity);
        portfolio.addStock(currentStock);
    }

    public static void sellStock() {
        System.out.print("Please input stock ID: ");
        int stockId = scanner.nextInt();
        System.out.print("Please input stock name: ");
        String stockName = scanner.next();

        Stock currentStock = new Stock(stockId, stockName, 0, new BigDecimal("100"));
        boolean found = false;
        for (Stock stock : stocks) {
            if (stock.equals(currentStock)) {
                found = true;
                System.out.println("Your current holdings:\n" + stock);
                break;
            }
        }
        if (found) {
            System.out.print("Update price: ");
            BigDecimal pricePerShare = scanner.nextBigDecimal();
            currentStock.updatePricePerShare(pricePerShare);
            System.out.println("How many shares would you like to sell?");
            System.out.print("Input: ");
            int quantity = scanner.nextInt();
            currentStock.sellStock(quantity);
            portfolio.removeStock(currentStock);
        } else {
            System.out.println("You do not own any shares of this stock.");
        }
    }

    public static void main(String[] args) {

        text.intro();

        int choice;
        do {
            text.action();
            choice = scanner.nextInt();
            if (choice < 0 || choice > 5) {
                text.error();
                break;
            }

            switch (choice) {
                case 1:     // Browse portfolio
                    if (portfolio.getStocks().isEmpty()) {
                        System.out.println("Your Portfolio is currently empty.");
                    } else {
                        System.out.println(portfolio.toString());
                    }
                    break;
                case 2:     // Check balance
                    System.out.println("Total value of your stocks: " + portfolio.getTotalValue());
                    break;
                case 3:     // Buy stock
                    buyStock();
                    break;
                case 4:     // Sell stock
                    sellStock();
                    break;
                case 5:     // Exit
                    break;
            }
            int cont;
            do {
                System.out.print("Leave? (0: No, 1: Yes): ");
                cont = scanner.nextInt();
            } while (cont != 0 && cont != 1);
            if (cont == 1) choice = 5;
        } while (choice != 5);
        text.outro();
    }
}