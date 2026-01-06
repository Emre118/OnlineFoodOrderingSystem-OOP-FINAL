package app;

import java.util.ArrayList;
import java.util.List;

import model.MenuItem;
import model.Restaurant;

public class ConsoleApp {

    public static void main(String[] args) {

        List<Restaurant> restaurants = seedRestaurants();

        System.out.println("=== Restaurants ===");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ") " + restaurants.get(i).getName());
        }
    }

    private static List<Restaurant> seedRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant r1 = new Restaurant("Chatto Burger");
        r1.addMenuItem(new MenuItem("Burger", 120));
        r1.addMenuItem(new MenuItem("Cola", 30));

        Restaurant r2 = new Restaurant("Pizza Lab");
        r2.addMenuItem(new MenuItem("Margherita", 140));
        r2.addMenuItem(new MenuItem("Ayran", 20));

        Restaurant r3 = new Restaurant("Sushi Go");
        r3.addMenuItem(new MenuItem("Sushi Roll", 220));
        r3.addMenuItem(new MenuItem("Green Tea", 35));

        Restaurant r4 = new Restaurant("Kebab House");
        r4.addMenuItem(new MenuItem("Adana", 180));
        r4.addMenuItem(new MenuItem("Salgam", 25));

        Restaurant r5 = new Restaurant("Pasta Corner");
        r5.addMenuItem(new MenuItem("Spaghetti", 160));
        r5.addMenuItem(new MenuItem("Water", 10));

        Restaurant r6 = new Restaurant("Coffee & More");
        r6.addMenuItem(new MenuItem("Latte", 80));
        r6.addMenuItem(new MenuItem("Cheesecake", 110));

        Restaurant r7 = new Restaurant("Healthy Bowl");
        r7.addMenuItem(new MenuItem("Chicken Bowl", 170));
        r7.addMenuItem(new MenuItem("Smoothie", 90));

        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
        restaurants.add(r4);
        restaurants.add(r5);
        restaurants.add(r6);
        restaurants.add(r7);

        return restaurants;
    }
}
