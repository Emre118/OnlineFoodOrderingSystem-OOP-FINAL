package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RestaurantTest {

    @Test
    void newRestaurant_shouldHaveEmptyMenu() {
        Restaurant restaurant = new Restaurant("Test Restaurant");

        assertNotNull(restaurant.getMenu());
        assertEquals(0, restaurant.getMenu().size());
    }

    @Test
    void addMenuItem_shouldIncreaseMenuSize() {
        Restaurant restaurant = new Restaurant("Test Restaurant");
        MenuItem item = new MenuItem("Burger", 100);

        restaurant.addMenuItem(item);

        assertEquals(1, restaurant.getMenu().size());
        assertEquals("Burger", restaurant.getMenu().get(0).getName());
    }
}
