import java.util.*;

public class Tabuls {
    static ArrayList<Order> orders = new ArrayList<Order>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {

        }
    }

    public static boolean ordersContain(String n) {
        for (Order order : orders) {
            if (n.indexOf(order.name) >= 0)
                return true;
        }
        return false;
    }
}

class Order {
    String name = "";
    ArrayList<String> dishes = new ArrayList<String>();

    Order(String line) {
        Scanner lineScan = new Scanner(line);
        name = lineScan.next().toLowerCase();
        dishes.add(lineScan.next().toLowerCase());
    }

    void addFood(String line) {
        Scanner lineScan = new Scanner(line);
        lineScan.next();
        dishes.add(lineScan.next().toLowerCase());
    }
}