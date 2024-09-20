package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.model.Medicine;
import fr.pompey.dev.afpa.model.Purchase;

import java.time.LocalDate;
import java.util.*;

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

        // Initialiser quelques achats fictifs pour tester l'affichage
        initializeDummyPurchases();

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

    /**
     * Initialize the manager with some dummy purchases for testing purposes
     */
    private void initializeDummyPurchases() {
        // Création de clients fictifs
        Customer customer1 = new Customer("Olivier", "Renaud", "25 Rue des Pyrénées", "64000", "Pau", "0600000015",
                "olivier.renaud@mail.com", "9998887776666",  LocalDate.of(1987, 6, 25));
        Customer customer2 = new Customer("Nicolas", "Fabre", "15 Boulevard des Anglais", "06300", "Nice", "0600000014", "nicolas.fabre@mail.com", "2221110009995", LocalDate.of(1992, 5, 30));

        // Création de médicaments fictifs
        Medicine med1 = new Medicine("Paracétamol", Medicine.MedicineCategory.ANALGESIC, 1.99, 25, LocalDate.of(2022, 12, 1));
        Medicine med2 = new Medicine("Ibuprofène", Medicine.MedicineCategory.ANTIINFLAMMATORY, 3.50, 15, LocalDate.of(2023, 4, 10));

        // Création d'achats fictifs
        Purchase purchase1 = new Purchase(LocalDate.now(), 6.25, Arrays.asList(med1), customer1);
        Purchase purchase2 = new Purchase(LocalDate.now(), 2.50, Arrays.asList(med2), customer2);

        // Ajout des achats à la liste
        addPurchase(purchase1);
        addPurchase(purchase2);

    }

}
