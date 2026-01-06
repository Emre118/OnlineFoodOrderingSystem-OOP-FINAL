package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer order.
 */
public class Order {

    private List<Orderable> items;
    private boolean completed;

    public Order() {
        this.items = new ArrayList<>();
        this.completed = false;
    }

    public void addItem(Orderable item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;

        for (Orderable item : items) {
            total += item.getPrice(); // polymorphism here
        }

        return total;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
