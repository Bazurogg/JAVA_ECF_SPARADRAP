package fr.pompey.dev.afpa.model;
import java.time.LocalDate;

public class Customer extends Person {

    private String socialSecurityNumber;

    private LocalDate birthDate;

    /**
     * Constructor for the Customer class.
     *
     * @param firstname            The first name of the customer.
     * @param lastname             The last name of the customer.
     * @param address              The address of the customer.
     * @param postalCode           The postal code of the customer's address.
     * @param city                 The city where the customer lives.
     * @param phoneNumber          The phone number of the customer.
     * @param email                The email address of the customer.
     * @param socialSecurityNumber The social security number of the customer.
     * @param birthDate            The birth date of the customer.
     */
    public Customer(String firstname, String lastname, String address, String postalCode,
                    String city, String phoneNumber, String email,
                    String socialSecurityNumber, LocalDate birthDate) {

        // Call the constructor of the superclass "Person" to initialize inherited fields
        super(firstname, lastname, address, postalCode, city, phoneNumber, email);

        // Initialize the specific fields of Customer
        setBirthDate(birthDate);
        setSocialSecurityNumber(socialSecurityNumber);

    }

    // Getters and setters for Customer-specific fields

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

