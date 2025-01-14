package fr.pompey.dev.afpa.model;

import fr.pompey.dev.afpa.exceptions.InvalidEmailFormatException;
import fr.pompey.dev.afpa.exceptions.InvalidPhoneNumberException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents a customer of the drugstore.
 * This class extends the Person class to inherit common personal attributes.
 */
public class Customer extends Person {

    private String socialSecurityNumber;

    private LocalDate birthDate;

    /** The list of specialists a customers can have */
    private List<Specialist> specialists;

    /**
     * Constructor for the Customer class.
     *
     * @param id                   the id
     * @param firstname            The first name of the customer.
     * @param lastname             The last name of the customer.
     * @param address              The address of the customer.
     * @param postalCode           The postal code of the customer's address.
     * @param city                 The city where the customer lives.
     * @param phoneNumber          The phone number of the customer.
     * @param email                The email address of the customer.
     * @param socialSecurityNumber The social security number of the customer.
     * @param birthDate            The birthdate of the customer.
     */
    public Customer(Integer id, String firstname, String lastname, String address, String postalCode,
                    String city, String phoneNumber, String email,
                    String socialSecurityNumber, LocalDate birthDate) throws InvalidPhoneNumberException, InvalidEmailFormatException {

        // Call the constructor of the superclass "Person" to initialize inherited fields
        super(id, firstname, lastname, address, postalCode, city, phoneNumber, email);

        // Initialize the specific fields of Customer
        setBirthDate(birthDate);

        setSocialSecurityNumber(socialSecurityNumber);

        // Initialize the list of specialists
        this.specialists = new ArrayList<>();

    }

    /**
     * Constructor for the Customer class.
     * with 0 parameter
     */
    public Customer() {

        super();

    }

    /**
     * Gets social security number.
     *
     * @return the social security number
     */
// Getters and setters for Customer-specific fields
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets social security number.
     *
     * @param socialSecurityNumber the social security number
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        logger.info("Setting SS id to {}", socialSecurityNumber);
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Gets birthdate.
     *
     * @return the birthdate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birth ate.
     *
     * @param birthDate the birthdate
     */
    public void setBirthDate(LocalDate birthDate) {
        logger.info("Setting Birthdate to {}", birthDate);
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return getLastname() + " " + getFirstname() + " / " + socialSecurityNumber;
    }

    /**
     * Gets the list of specialists associated with the customer.
     *
     * @return the list of specialists.
     */
    public List<Specialist> getSpecialists() {
        return specialists;
    }

    /**
     * Adds a specialist to the customer's list of specialists.
     *
     * @param specialist the specialist to add.
     */
    public void addSpecialist(Specialist specialist) {
        this.specialists.add(specialist);
    }

    /**
     * Removes a specialist from the customer's list of specialists.
     *
     * @param specialist the specialist to remove.
     */
    public void removeCustomer(Specialist specialist) {
        this.specialists.remove(specialists);
    }

}

