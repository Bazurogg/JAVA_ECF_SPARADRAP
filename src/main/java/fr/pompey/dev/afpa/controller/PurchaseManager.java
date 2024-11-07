package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.model.Medicine;
import fr.pompey.dev.afpa.model.Purchase;
import fr.pompey.dev.afpa.model.Medicine.MedicineCategory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PurchaseManager {

    private List<Purchase> allPurchases = new ArrayList();

    public PurchaseManager() {

//        this.initializeDummyPurchases();

    }

    public void addPurchase(Purchase purchase) {

        if (purchase != null) {

            this.allPurchases.add(purchase);

        }

    }

    public void removePurchase(Purchase purchase) {

        this.allPurchases.remove(purchase);

    }

    public List<Purchase> getAllPurchases() {
        return this.allPurchases;
    }

    public void displayAllPurchases() {
        if (this.allPurchases.isEmpty()) {
            System.out.println("No purchases have been made.");
        } else {
            System.out.println("List of all purchases:");
            Iterator var1 = this.allPurchases.iterator();

            while(var1.hasNext()) {
                Purchase purchase = (Purchase)var1.next();
                System.out.println(purchase);
            }
        }

    }

    public int getPurchaseCount() {

        return this.allPurchases.size();

    }

    private void initializeDummyPurchases() {
        Customer customer1 = new Customer("Olivier", "Renaud", "25 Rue des Pyrénées", "64000", "Pau", "0600000015", "olivier.renaud@mail.com", "9998887776666", LocalDate.of(1987, 6, 25));
        Customer customer2 = new Customer("Nicolas", "Fabre", "15 Boulevard des Anglais", "06300", "Nice", "0600000014", "nicolas.fabre@mail.com", "2221110009995", LocalDate.of(1992, 5, 30));
        Medicine med1 = new Medicine("Paracétamol", MedicineCategory.ANALGESIC, 1.99, 25, LocalDate.of(2022, 12, 1));
        Medicine med2 = new Medicine("Ibuprofène", MedicineCategory.ANTIINFLAMMATORY, 3.5, 15, LocalDate.of(2023, 4, 10));
        Purchase purchase1 = new Purchase(LocalDate.now(), 6.25, Arrays.asList(med1), customer1);
        Purchase purchase2 = new Purchase(LocalDate.now(), 2.5, Arrays.asList(med2), customer2);

        this.addPurchase(purchase1);

        this.addPurchase(purchase2);

    }

}
