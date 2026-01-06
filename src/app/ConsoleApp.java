package app;

import model.*;

public class ConsoleApp {

    public static void main(String[] args) {

        // Create restaurant and menu
        Restaurant restaurant = new Restaurant("Chatto Burger");

        MenuItem burger = new MenuItem("Burger", 120);
        MenuItem cola = new MenuItem("Cola", 30);

        restaurant.addMenuItem(burger);
        restaurant.addMenuItem(cola);

        // Create customer
        Customer customer = new Customer("emre", "1234");

        // Create order and add items
        Order order = new Order();
        order.addItem(burger);
        order.addItem(cola);

        // Print order summary
        System.out.println("Order total: " + order.calculateTotal() + " TL");

        order.markPaid();
        System.out.println("Order status: " + order.getStatus());
    }
}
