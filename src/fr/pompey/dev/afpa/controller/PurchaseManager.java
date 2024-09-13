package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.model.Purchase;
import java.util.ArrayList;
import java.util.List;

/**
 * PurchaseManager is responsible for managing all purchases in the store.
 * It maintains a list of all purchases made and provides methods to add, remove, and retrieve purchases.
 */
public class PurchaseManager {

    /** The list of all purchases made in the store */
    private List<Purchase> allPurchases;

    /** Constructor to initialize the purchase manager */
    public PurchaseManager() {
        this.allPurchases = new ArrayList<>();
    }

    /**
     * Adds a purchase to the list of all purchases.
     *
     * @param purchase the purchase to add
     */
    public void addPurchase(Purchase purchase) {
        if (purchase != null) {
            this.allPurchases.add(purchase);
        }
    }

    /**
     * Removes a purchase from the list of all purchases.
     *
     * @param purchase the purchase to remove
     */
    public void removePurchase(Purchase purchase) {
        this.allPurchases.remove(purchase);
    }

    /**
     * Returns the list of all purchases.
     *
     * @return the list of all purchases
     */
    public List<Purchase> getAllPurchases() {
        return allPurchases;
    }

    /**
     * Prints the details of all purchases to the console.
     * Each purchase and its associated details are displayed.
     */
    public void displayAllPurchases() {
        if (allPurchases.isEmpty()) {
            System.out.println("No purchases have been made.");
        } else {
            System.out.println("List of all purchases:");
            for (Purchase purchase : allPurchases) {
                System.out.println(purchase);
            }
        }
    }

    /**
     * Returns the total number of purchases.
     *
     * @return the total number of purchases
     */
    public int getPurchaseCount() {
        return allPurchases.size();
    }
}
