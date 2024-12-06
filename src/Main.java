import logic.Product;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static final String VERSION = "v1.1 Dev";
    public static final String AUTHOR = "Pawelusz";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserWallet wallet = new UserWallet(1.0);

        /*
                        PRODUCTS
        to add product just type:
        "products.put("code", new Product("Product_Name", price like 1.23));"
        and add it in START_MESSAGE section
         */

        HashMap<String, Product> products = new HashMap();
        products.put("53O5", new Product("Banan", 5.63));
        products.put("E0P3", new Product("Kiwi", 8.40));
        products.put("S5RS", new Product("Gruszka", 3.12));
        products.put("ES351", new Product("Truskawka", 8.00));

        /*              START_MESSAGE
        in this section you must add your product and modify message
         */
        out.println(">        PENGUIN SHOP        <");
        out.println(" ");
        out.println("* - Developer: " + AUTHOR);
        out.println("* - Version: " + VERSION);
        out.println("* - Ilość produktów na stanie: " + products.size());
        out.println("-------------->");
        out.println(" ");
        out.println("*\t Lista dostępnych produktów \t*");
        out.println(" ");
        out.println(products.get("53O5"));
        out.println(products.get("E0P3"));
        out.println(products.get("S5RS"));
        out.println(products.get("ES351"));
        out.println(" ");

        /*
                    CODE
         In this section you can set your code and modify
         message, ect.
         */
        out.println(">     KOD    <");
        out.println(" ");
        out.println("* - Wpisz kod aby uzyskać kupon na 10zł, jednak");
        out.println("* - jak nie chcesz wpisywać kodu wpisz BRAK");
        out.println(" ");

        String discountCode = scanner.nextLine();

        if (discountCode.equalsIgnoreCase("FS4X")) {
            wallet.addMoney(10);
            out.println("$ - Sukces! Twoje aktualne saldo to " + wallet.getMoney());
        }

        /*
                    BUY_SYSTEM
        Int this section you can modify the
         */
        out.println("* - Co chcesz zakupić?");

        String product = scanner.nextLine();

        if (products.containsKey(product)) {
            out.println("? - Sprawdzanie czy produkt jest dostępny...");
            out.println("$ - Sukces! Produkt jest dostępny na magazynie");
            out.println(" ");
        } else {
            out.println("! - W magazynie aktualnie niema produktu na ktory oczekujesz");
        }

        if (wallet.getMoney() < products.get(product).getPrice()) {
            out.println("Nie masz wystarczająco pieniędzy na zakup tego produktu");

        } else {
            wallet.setMoney(wallet.getMoney() - products.get(product).getPrice());
            out.println("Zakupiłeś produkt: " + products.get(product).getProductName());
            out.println("Pozostało w portfelu: " + wallet.getMoney());
        }
    }
}
