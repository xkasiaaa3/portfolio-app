public class TerminalText {
    public void intro() {
        System.out.println("Welcome to your portfolio manager!");
    }
    public void action() {
        System.out.println("""
                -----------------------------------------------
                Please choose one of the following actions:
                1. Browse your portfolio
                2. Check the current value of your portfolio
                3. Purchase a stock
                4. Sell a stock
                5. Exit
                -----------------------------------------------
                """);
        System.out.print("Input: ");
    }
    public void bar() {
        System.out.println("-----------------------------------------------");
    }
    public void error() {
        System.out.println("Invalid input, please try again.");
    }
    public void outro() {
        System.out.println("""
            Farewell and see you soon!
                  |\\      _,,,---,,_
            ZZZzz /,`.-'`'    -.  ;-;;,_
                 |,4-  ) )-,_. ,\\ (  `'-'
                '---''(_/--'  `-'\\_)
            """);
    }
}
