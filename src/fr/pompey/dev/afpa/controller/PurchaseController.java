package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.model.Medicine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * PurchaseController is a class dedicated to managing the list of purchases.
 * Each purchase can contain multiple medicines.
 */
public class PurchaseController {

    /** The list of purchases (each purchase contains a list of medicines) */
    private List<List<Medicine>> purchases;

    /** Constructor to initialize the purchase list */
    public PurchaseController() {
        this.purchases = new ArrayList<>();
    }

    /**
     * Adds a purchase to the list of purchases.
     * Each purchase is a list of medicines.
     *
     * @param purchase the list of medicines representing a purchase.
     */
    public void addPurchase(List<Medicine> purchase) {
        this.purchases.add(purchase);
    }

    /**
     * Removes a purchase from the list of purchases.
     *
     * @param purchase the purchase (list of medicines) to remove.
     */
    public void removePurchase(List<Medicine> purchase) {
        this.purchases.remove(purchase);
    }

    /**
     * Returns the list of purchases.
     * Each purchase is a list of medicines.
     *
     * @return the list of purchases.
     */
    public List<List<Medicine>> getPurchases() {
        return purchases;
    }

    /**
     * Prints the list of purchases to the console.
     * Each purchase and its associated medicines are displayed.
     */
    public void displayPurchases() {
        if (purchases.isEmpty()) {
            System.out.println("No purchases have been made.");
        } else {
            System.out.println("List of purchases:");
            int purchaseNumber = 1;
            for (List<Medicine> purchase : purchases) {
                System.out.println("Purchase " + purchaseNumber + ":");
                for (Medicine medicine : purchase) {
                    System.out.println("- " + medicine.getMedicineName() + " (Category: " + medicine.getCategory() +
                            ", Price: €" + medicine.getPrice() + ", Quantity: " + medicine.getQuantity() + ")");
                }
                purchaseNumber++;
            }
        }
    }
}
