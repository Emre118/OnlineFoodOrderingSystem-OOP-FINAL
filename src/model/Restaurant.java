package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a restaurant with a menu.
 */
public class Restaurant {

    private String name;
    private List<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }
}
