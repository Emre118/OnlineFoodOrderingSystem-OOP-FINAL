package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    void newOrder_shouldBeCreatedWithZeroItems() {
        Order order = new Order();

        assertEquals(0, order.getItemCount());
        assertEquals(0.0, order.calculateTotal());
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }
}
