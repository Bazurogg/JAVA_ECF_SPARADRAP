package test;

import fr.pompey.dev.afpa.exceptions.InvalidEmailFormatException;
import fr.pompey.dev.afpa.exceptions.InvalidPhoneNumberException;
import fr.pompey.dev.afpa.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit tests for the {@link Person} class.
 * <p>
 * This class contains various test methods to validate the behavior of the
 * {@link Person} class, including testing the setters for first name, last name,
 * postal code, phone number, and email. Each method ensures the proper functioning
 * of validation and value setting in the {@link Person} class.
 * </p>
 */
class PersonTest {

    private Person personUnderTest;

    /**
     * Set up the test environment.
     * <p>
     * This method is called before each test to create a new instance of the
     * {@link Person} class to be tested.
     * </p>
     */
    @BeforeEach
    void setUp() {
        personUnderTest = new Person();
    }

    /**
     * Clean up after each test.
     * <p>
     * This method is called after each test to reset the test instance.
     * </p>
     */
    @AfterEach
    void tearDown() {
        personUnderTest = null;
    }

    /**
     * Test the setter for the first name.
     * <p>
     * This test ensures that the {@link Person#setFirstname(String)} method correctly
     * sets the first name and that it throws an {@link IllegalArgumentException}
     * when an invalid value (null) is provided.
     * </p>
     */
    @Test
    void setFirstname() {

        // Test setting a valid first name
        personUnderTest.setFirstname("Matt");
        Assertions.assertEquals("Matt", personUnderTest.getFirstname(), "Firstname is set correctly");

        // Test setting an invalid first name (null)
        Assertions.assertThrows(IllegalArgumentException.class, () -> personUnderTest.setFirstname(null),
                "Setting an empty firstname should throw an IllegalArgumentException");
    }

    /**
     * Test the setter for the last name.
     * <p>
     * This test ensures that the {@link Person#setLastname(String)} method correctly
     * sets the last name, converting it to uppercase, and throws an
     * {@link IllegalArgumentException} when an invalid value (null) is provided.
     * </p>
     */
    @Test
    void setLastname() {

        // Test setting a valid last name
        personUnderTest.setLastname("House");
        Assertions.assertEquals("HOUSE", personUnderTest.getLastname(), "Lastname is set and converted to uppercase correctly");

        // Test setting an invalid last name (null)
        Assertions.assertThrows(IllegalArgumentException.class, () -> personUnderTest.setLastname(null),
                "Setting an empty lastname should throw an IllegalArgumentException");
    }

    /**
     * Test the setter for the postal code.
     * <p>
     * This test ensures that the {@link Person#setPostalCode(String)} method correctly
     * sets a valid postal code and throws an {@link IllegalArgumentException} when
     * an invalid postal code (less than 5 digits) is provided.
     * </p>
     */
    @Test
    void setPostalCode() {

        // Test setting a valid postal code
        personUnderTest.setPostalCode("54100");
        Assertions.assertEquals("54100", personUnderTest.getPostalCode(), "Postal code is set correctly.");

        // Test setting an invalid postal code (less than 5 digits)
        Assertions.assertThrows(IllegalArgumentException.class, () -> personUnderTest.setPostalCode("1234"),
                "Setting a postal code with less than 5 digits should throw an exception.");
    }

    /**
     * Test the setter for the phone number.
     * <p>
     * This test ensures that the {@link Person#setPhoneNumber(String)} method correctly
     * sets a valid phone number and throws an {@link InvalidPhoneNumberException}
     * when an invalid phone number is provided (less than 10 digits).
     * </p>
     */
    @Test
    void setPhoneNumber() {

        // Test setting a valid phone number
        Assertions.assertDoesNotThrow(() -> personUnderTest.setPhoneNumber("0123456789"),
                "Setting a valid phone number should not throw an exception.");
        Assertions.assertEquals("0123456789", personUnderTest.getPhoneNumber(), "Phone number should be set correctly.");

        // Test setting an invalid phone number (less than 10 digits)
        Assertions.assertThrows(InvalidPhoneNumberException.class, () -> personUnderTest.setPhoneNumber("1234"),
                "Setting an invalid phone number should throw an InvalidPhoneNumberException.");
    }

    /**
     * Test the setter for the email address.
     * <p>
     * This test ensures that the {@link Person#setEmail(String)} method correctly
     * sets a valid email and throws an {@link InvalidEmailFormatException} when
     * an invalid email format is provided.
     * </p>
     */
    @Test
    void setEmail() {

        // Test setting a valid email
        Assertions.assertDoesNotThrow(() -> personUnderTest.setEmail("example@example.com"),
                "Setting a valid email should not throw an exception.");
        Assertions.assertEquals("example@example.com", personUnderTest.getEmail(), "Email should be set correctly.");

        // Test setting an invalid email format
        Assertions.assertThrows(InvalidEmailFormatException.class, () -> personUnderTest.setEmail("invalid-email"),
                "Setting an invalid email should throw an InvalidEmailFormatException.");
    }
}
