package model;

/**
 * Customer is a specialized User who can place orders.
 */
public class Customer extends User {

    public Customer(String username, String password) {
        super(username, password);
    }
}
