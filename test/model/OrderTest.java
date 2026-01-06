package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderTest {

    // Test 1: Yeni siparişin başlangıç durumu
    @Test
    void newOrder_shouldBeCreatedWithZeroItems() {
        Order order = new Order();

        assertEquals(0, order.getItemCount());
        assertEquals(0.0, order.calculateTotal());
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    // Test 2: Ürün eklenince item sayısı artmalı
    @Test
    void addItem_shouldIncreaseItemCount() {
        Order order = new Order();
        MenuItem burger = new MenuItem("Burger", 100);

        order.addItem(burger);

        assertEquals(1, order.getItemCount());
    }

    // Test 3: Toplam fiyat doğru hesaplanmalı
    @Test
    void calculateTotal_shouldSumItemPrices() {
        Order order = new Order();

        order.addItem(new MenuItem("Burger", 100));
        order.addItem(new MenuItem("Cola", 30));

        assertEquals(130.0, order.calculateTotal());
    }
}
