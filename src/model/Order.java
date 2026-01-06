package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's order.
 */
public class Order {

    private final List<Orderable> items;
    private OrderStatus status;
    private String paymentMethod;

    public Order() {
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
        this.paymentMethod = "NOT_SELECTED";
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
    public void markPaid(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.status = OrderStatus.PAID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
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
