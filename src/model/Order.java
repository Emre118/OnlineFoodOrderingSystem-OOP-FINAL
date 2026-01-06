package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's order.
 */
public class Order {

    private final List<Orderable> items;
    private OrderStatus status;

    public Order() {
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    public void addItem(Orderable item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (Orderable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void markPaid() {
        this.status = OrderStatus.PAID;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public List<Orderable> getItems() {
        return items;
    }

    public int getItemCount() {
        return items.size();
    }

}
