import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        List<Stock> stocks = new ArrayList<Stock>();
        Portfolio portfolio = new Portfolio(stocks);

        do {
            if (choice >= 0 & choice <= 5) {
            System.out.println("Hello, this is your portfolio.");
            System.out.println("Choose your action:");
            System.out.println("1.Browse");
            System.out.println("2. Add");
            System.out.println("3. Remove");
            System.out.println("4. Balance");
            System.out.println("5. Exit");
            System.out.println("I choose: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1.Browse");
                    break;
                case 2:
                    System.out.println("2. Add");
                    //dummy data
//                    Stock stock = new Stock(1000,"Stock name",345, BigDecimal.TEN);
                    System.out.println("2. Add");
                    System.out.println("Add stock ID");
                    int stockId = scanner.nextInt();
                    System.out.println("Add stock name");
                    String stockName = scanner.nextLine();
                    System.out.println("Add quantity");
                    int quantity = scanner.nextInt();
                    System.out.println("Add price");
                    BigDecimal pricePerShare = scanner.nextBigDecimal();
                    Stock stock = new Stock(stockId, stockName, quantity, pricePerShare);
                    portfolio.addStock(stock);
                    break;
                case 3:
                    System.out.println("3. Remove");
                    break;
                case 4:
                    System.out.println("4. Balance");
                    break;
                case 5:
                    System.out.println("5. Exit");
                    break;
            }
            }else{
                System.out.println("Provide correct number one again");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            }

        } while (choice != 5);
    }
}