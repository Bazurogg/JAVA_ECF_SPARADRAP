package fr.pompey.dev.afpa.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Represents a direct purchase in the pharmacy.
 * Direct purchases inherit from the general Purchase class and do not have additional attributes.
 */
public class DirectPurchase extends Purchase {

    private LocalDate purchaseDate;
    private double totalPrice;
    private List<Medicine> medicines;
    private Customer customer;

    /**
     * Constructor for a direct purchase with a customer.
     *
     * @param purchaseDate The date the purchase was made
     * @param totalPrice The total price of the purchase
     * @param medicines The list of medicines in this purchase
     * @param customer The customer who made the purchase
     */
    public DirectPurchase(LocalDate purchaseDate, double totalPrice, List<Medicine> medicines, Customer customer) {
        super(purchaseDate, totalPrice, medicines, customer);
    }

    /**
     * Constructor for a direct purchase without a customer.
     *
     * @param purchaseDate The date the purchase was made
     * @param totalPrice The total price of the purchase
     * @param medicines The list of medicines in this purchase
     */
    public DirectPurchase(LocalDate purchaseDate, double totalPrice, List<Medicine> medicines) {
        super(purchaseDate, totalPrice, medicines); // Calls the parent constructor without customer
    }

    // Here add some future methods implementation if needed.
    public void calculateTotalPrice() {
        totalPrice = 0.0;
        for (Medicine medicine : medicines) {
            totalPrice += medicine.getPrice() * medicine.getQuantity(); // Assurez-vous que Medicine a une méthode getQuantity
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Medicine> getMedicines() {
        return medicines != null ? medicines : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DirectPurchase{" +
                "purchaseDate=" + getPurchaseDate() +
                ", totalPrice=" + getTotalPrice() +
                ", medicines=" + getMedicines() +
                ", customer=" + (getCustomer() != null ? getCustomer() : "No customer") +
                '}';
    }

}
