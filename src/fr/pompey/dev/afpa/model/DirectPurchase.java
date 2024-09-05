package fr.pompey.dev.afpa.model;

import java.util.List;
import java.time.LocalDate;

/**
 * Represents a direct purchase in the pharmacy.
 * Direct purchases inherit from the general Purchase class and do not have additional attributes.
 */
public class DirectPurchase extends Purchase {

    /**
     * Constructor for a direct purchase.
     *
     * @param purchaseDate The date the purchase was made
     * @param totalPrice The total price of the purchase
     * @param medicines The list of medicines in this purchase
     * @param customer The customer who made the purchase
     */
    public DirectPurchase(LocalDate purchaseDate, double totalPrice, List<Medicine> medicines, Customer customer) {
        super(purchaseDate, totalPrice, medicines, customer);
    }

    // Here add some futur methods implementation if needed. .

    @Override

    public String toString() {

        return "DirectPurchase{" + "purchaseDate=" + getPurchaseDate() + ", totalPrice=" + getTotalPrice() + ", medicines=" + getMedicines() + ", customer=" + getCustomer() + '}';

    }

}
