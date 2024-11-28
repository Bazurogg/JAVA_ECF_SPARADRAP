package fr.pompey.dev.afpa.model;

import fr.pompey.dev.afpa.exceptions.InvalidEmailFormatException;
import fr.pompey.dev.afpa.exceptions.InvalidPhoneNumberException;

import java.util.ArrayList;

import java.util.List;

/**
 * Represents a doctor who has an agreement ID number and a list of clients.
 * This class extends the Person class to inherit common personal attributes.
 */
public class Doctor extends Person {

    /** The agreement ID number of the doctor */
    private String agreementId;

    /** The list of clients associated with the doctor */
    private List<Customer> customers;

    /** List of prescription by purchases made by this doctor */
    private List<PurchaseByPrescription> purchasesByPrescription;

    /**
     * Constructor for the Doctor class.
     *
     * @param firstname   The first name of the doctor.
     * @param lastname    The last name of the doctor.
     * @param address     The address of the doctor.
     * @param postalCode  The postal code of the doctor's address.
     * @param city        The city where the doctor resides.
     * @param phoneNumber The phone number of the doctor.
     * @param email       The email address of the doctor.
     * @param agreementId The agreement ID of the doctor.
     */
    public Doctor(Integer id, String firstname, String lastname, String address, String postalCode,
                  String city, String phoneNumber, String email, String agreementId) throws InvalidPhoneNumberException, InvalidEmailFormatException {

        // Call the constructor of the superclass (Person) to initialize inherited fields
        super(id, firstname, lastname, address, postalCode, city, phoneNumber, email);

        // Initialize the specific field of Doctor
        setAgreementId(agreementId);

        // Initialize the list of customers
        this.customers = new ArrayList<>();

        // Initialize the list of prescription of this doctor
        this.purchasesByPrescription = new ArrayList<>();

    }


    /**
     * Constructor for the Doctor class.
     * with 0 parameter
     */
    public Doctor() {

        super();

    }

    // Getters and setters for Doctor-specific fields

    /**
     * Gets the agreement ID of the doctor.
     *
     * @return the agreement ID of the doctor.
     */
    public String getAgreementId() {
        return agreementId;
    }

    /**
     * Sets the agreement ID of the doctor.
     *
     * @param agreementId the agreement ID to set.
     */
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    /**
     * Gets the list of clients associated with the doctor.
     *
     * @return the list of clients.
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Adds a customer to the doctor's list of clients.
     *
     * @param customer the customer to add.
     */
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    /**
     * Removes a customer from the doctor's list of clients.
     *
     * @param customer the customer to remove.
     */
    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    /**
     * Gets the list of prescriptions of the doctor.
     *
     * @return the list of prescriptions.
     */
    public List<PurchaseByPrescription> getPurchasesByPrescription() {
        return purchasesByPrescription;
    }

    /**
     * Adds a customer to the doctor's list of clients.
     *
     * @param purchaseByPrescription the prescription to add.
     */
    public void addPrescription(PurchaseByPrescription purchaseByPrescription) {
        this.purchasesByPrescription.add(purchaseByPrescription);
    }

    /**
     * Removes a customer from the doctor's list of clients.
     *
     * @param purchaseByPrescription the prescription to remove.
     */
    public void removePrescription(PurchaseByPrescription purchaseByPrescription) {
        this.purchasesByPrescription.remove(purchaseByPrescription);
    }

    @Override
    public String toString() {

        return "Dr. " + getLastname() + " " + getFirstname() + " - " + getAgreementId();

    }

}
