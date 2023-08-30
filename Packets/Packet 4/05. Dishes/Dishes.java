//Christopher Petty

import java.util.*;
import java.io.*;

public class Dishes {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("dishes.dat"));
        int ll = input.nextInt();
        input.nextLine();

        for (int i = 0; i < ll; i++) {
            String[] data = input.nextLine().split(" ");
            int numOfDishes = Integer.parseInt(data[0]);
            String order = data[1];
            ArrayList<Dish> dishIndicies = new ArrayList<Dish>();

            for (int j = 0; j < numOfDishes; j++) {
                String[] dishData = input.nextLine().split(" ");
                dishIndicies.add(new Dish(dishData[0], Integer.parseInt(dishData[1]), Integer.parseInt(dishData[2])));
            }

            int bussers = Integer.parseInt(input.nextLine());

            Table table = new Table(order, dishIndicies, bussers);
            table.calculateBussers();
            System.out.println(table);
        }
    }
}

class Table {
    char[] order;
    ArrayList<Dish> dishes;
    int bussers, clearers, cleaners;
    double time;

    Table(String order_, ArrayList<Dish> dishIndicies, int bussers_) {
        order = order_.toCharArray();
        bussers = bussers_;
        dishes = new ArrayList<Dish>();

        for (char name : order) {
            for (Dish dish : dishIndicies) {
                if (dish.name == name)
                    dishes.add(dish);
            }
        }
    }

    void calculateBussers() {
        double bestTime = Integer.MAX_VALUE;
        int bestCombo = -1;

        for (int i = 0; i <= bussers; i++) {
            clearers = i;
            cleaners = bussers - i;
            for (Dish dish : dishes) {
                time += dish.calculateTime(clearers, cleaners);
            }
            if (time < bestTime) {
                bestTime = time;
                bestCombo = i;
            }
            time = 0;
        }

        clearers = bestCombo;
        cleaners = bussers - bestCombo;
        time = bestTime;
        time = Math.round(time * 100) / 100.0;
    }

    public String toString() {
        return clearers + " clearers " + cleaners + " cleaners: " + time;
    }

}

class Dish {
    int clear, clean;
    char name;

    Dish(String name_, int clear_, int clean_) {
        name = name_.charAt(0);
        clear = clear_;
        clean = clean_;
    }

    double calculateTime(double clearers, double cleaners) {
        return clear / clearers + clean / cleaners;
    }
}