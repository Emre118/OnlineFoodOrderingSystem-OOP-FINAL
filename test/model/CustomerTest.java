package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for Customer authentication logic.
 */
public class CustomerTest {

    @Test
    void checkLogin_shouldReturnTrue_whenUsernameAndPasswordAreCorrect() {
        // Arrange
        Customer customer = new Customer("emre", "1234");

        // Act
        boolean result = customer.checkLogin("emre", "1234");

        // Assert
        assertTrue(result);
    }

    @Test
    void checkLogin_shouldReturnFalse_whenPasswordIsWrong() {
        // Arrange
        Customer customer = new Customer("emre", "1234");

        // Act
        boolean result = customer.checkLogin("emre", "wrongpass");

        // Assert
        assertFalse(result);
    }

    @Test
    void checkLogin_shouldReturnFalse_whenUsernameIsWrong() {
        // Arrange
        Customer customer = new Customer("emre", "1234");

        // Act
        boolean result = customer.checkLogin("wronguser", "1234");

        // Assert
        assertFalse(result);
    }
}
