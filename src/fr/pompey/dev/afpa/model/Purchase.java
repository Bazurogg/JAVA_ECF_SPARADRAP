package fr.pompey.dev.afpa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a general purchase (either direct or by prescription) in the pharmacy.
 * Each purchase has a date, a total price, a list of medicines involved, and the customer who made the purchase.
 * The total price will later consider the customer's health insurance coverage.
 */
public class Purchase {

    /** The date the purchase was made */
    private LocalDate purchaseDate;

    /** The total price of the purchase, which may be adjusted by health insurance later */
    private double totalPrice;

    /** List of medicines involved in this purchase */
    private List<Medicine> medicines;

    /** The customer who made the purchase */
    private Customer customer;

    /**
     * Constructor for a general purchase.
     *
     * @param purchaseDate The date the purchase was made
     * @param totalPrice The total price of the purchase
     * @param medicines The list of medicines in this purchase
     * @param customer The customer who made the purchase
     */
    public Purchase(LocalDate purchaseDate, double totalPrice, List<Medicine> medicines, Customer customer) {
        setPurchaseDate(purchaseDate);
        setTotalPrice(totalPrice);
        this.medicines = medicines != null ? new ArrayList<>(medicines) : new ArrayList<>(); // Prevent null pointer
        setCustomer(customer);
    }

    /**
     * Constructor for a general purchase without a customer.
     *
     * @param purchaseDate The date the purchase was made
     * @param totalPrice The total price of the purchase
     * @param medicines The list of medicines in this purchase
     */
    public Purchase(LocalDate purchaseDate, double totalPrice, List<Medicine> medicines) {
        setPurchaseDate(purchaseDate);
        setTotalPrice(totalPrice);
        this.medicines = medicines != null ? new ArrayList<>(medicines) : new ArrayList<>(); // Prevent null pointer
        this.customer = null; // No customer for this constructor
    }

    /**
     * Gets the date the purchase was made.
     *
     * @return the date of the purchase
     */
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Sets the date the purchase was made.
     *
     * @param purchaseDate The date of the purchase
     */
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Gets the total price of the purchase.
     *
     * @return the total price of the purchase
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of the purchase.
     *
     * @param totalPrice The total price of the purchase
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets the list of medicines involved in this purchase.
     *
     * @return the list of medicines
     */
    public List<Medicine> getMedicines() {
        return medicines;
    }

    /**
     * Sets the list of medicines involved in this purchase.
     *
     * @param medicines The list of medicines
     */
    public void setMedicines(List<Medicine> medicines) {
        this.medicines = new ArrayList<>(medicines); // Prevent external modifications
    }

    /**
     * Adds a medicine to the list of medicines for this purchase.
     *
     * @param medicine The medicine to add
     */
    public void addMedicine(Medicine medicine) {
        if (medicine != null) {
            this.medicines.add(medicine);
            updateTotalPrice();
        }
    }

    /**
     * Removes a medicine from the list of medicines for this purchase.
     *
     * @param medicine The medicine to remove
     */
    public void removeMedicine(Medicine medicine) {
        if (medicine != null && this.medicines.contains(medicine)) {
            this.medicines.remove(medicine);
            updateTotalPrice();
        }
    }

    /**
     * Clears all medicines from the purchase.
     */
    public void clearMedicines() {
        this.medicines.clear();
        updateTotalPrice();
    }

    /**
     * Updates the total price of the purchase based on the medicines in the list.
     * The total price is calculated as the sum of the prices of all medicines.
     */
    private void updateTotalPrice() {
        this.totalPrice = medicines.stream().mapToDouble(Medicine::getPrice).sum();
    }

    /**
     * Gets the customer who made the purchase.
     *
     * @return the customer who made the purchase
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer who made the purchase.
     *
     * @param customer The customer who made the purchase
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseDate=" + purchaseDate +
                ", totalPrice=" + totalPrice +
                ", medicines=" + medicines +
                ", customer=" + (customer != null ? customer : "No customer") +
                '}';
    }

}
