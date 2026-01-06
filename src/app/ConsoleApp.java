package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.MenuItem;
import model.Order;
import model.Restaurant;

public class ConsoleApp {

    public static void main(String[] args) {

        List<Restaurant> restaurants = seedRestaurants();
        Scanner sc = new Scanner(System.in);

        // Restaurant list
        System.out.println("=== Restaurants ===");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ") " + restaurants.get(i).getName());
        }

        // User selects restaurant
        int choice = readInt(sc, "Select restaurant (1-7): ", 1, restaurants.size());
        Restaurant selectedRestaurant = restaurants.get(choice - 1);

        // Print selected restaurant menu
        System.out.println("\n--- " + selectedRestaurant.getName() + " Menu ---");
        for (int i = 0; i < selectedRestaurant.getMenu().size(); i++) {
            MenuItem item = selectedRestaurant.getMenu().get(i);
            System.out.println((i + 1) + ") " + item.getName() + " - " + item.getPrice() + " TL");
        }
        System.out.println("0) Finish and go to checkout");

        // Cart / Order
        Order order = new Order();

        // User adds items to cart
        while (true) {
            int itemChoice = readInt(sc, "Select item (0-" + selectedRestaurant.getMenu().size() + "): ",
                    0, selectedRestaurant.getMenu().size());

            if (itemChoice == 0) {
                break;
            }

            MenuItem selectedItem = selectedRestaurant.getMenu().get(itemChoice - 1);
            order.addItem(selectedItem);
            System.out.println("Added: " + selectedItem.getName());
        }

        // Checkout summary (simple)
        System.out.println("\n--- Cart Summary ---");
        System.out.println("Items count: " + order.getItemCount());
        System.out.println("Total: " + order.calculateTotal() + " TL");

       // Payment selection
        System.out.println("\nSelect payment method:");
        System.out.println("1) Cash");
        System.out.println("2) Credit Card");

        int payChoice = readInt(sc, "Your choice (1-2): ", 1, 2);
        String paymentMethod = (payChoice == 1) ? "CASH" : "CREDIT_CARD";

        order.markPaid(paymentMethod);

        // Final order summary
        System.out.println("\n--- Final Order Summary ---");
        System.out.println("Restaurant: " + selectedRestaurant.getName());
        System.out.println("Items count: " + order.getItemCount());
        System.out.println("Total: " + order.calculateTotal() + " TL");
        System.out.println("Payment: " + order.getPaymentMethod());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Payment completed.");

        // Rating
        int rating = readInt(sc, "Rate the restaurant (1-10): ", 1, 10);
        System.out.println("Thanks! You rated " + selectedRestaurant.getName() + " as " + rating + "/10.");

    }

    // Creates sample restaurants and menus
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

    // Reads integer input safely
    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(sc.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
            }
        }
    }
}
