package fr.pompey.dev.afpa.model;


import java.time.LocalDate;

/**
 * Represents a medicine in the drugstore.
 * This class includes the concept of an enum for the category of the product.
 * The class holds information about the name of the medicine, its price, the quantity purchased, and the date it went on sale.
 * Note: There is no stock management in this class.
 */
public class Medicine {


    /**
     * Enum representing the different categories of medicines.
     */
    public enum MedicineCategory {
        ANALGESIC,   // For pain relief
        ANTIBIOTIC,  // For infections
        ANTISEPTIC,  // For preventing infections
        VITAMINS,    // For supplements
        ANTIINFLAMMATORY, // For reducing inflammation
        ANTIVIRAL,   // For viral infections
    }

    /** The category of the medicine */
    private MedicineCategory category;

    /** The name of the medicine */
    private String medicineName;

    /** The date the medicine was placed on sale */
    private LocalDate dateOnSale;

    /** The price of the medicine */
    private double price;

    /** The quantity of the medicine purchased */
    private int quantity;

    /**
     * Constructor for the Medicine class.
     *
     * @param medicineName The name of the medicine.
     * @param category The category of the medicine.
     * @param price The price of the medicine.
     * @param quantity The quantity purchased.
     * @param dateOnSale The date the medicine went on sale.
     */
    public Medicine(String medicineName, MedicineCategory category, double price, int quantity, LocalDate dateOnSale) {
        this.medicineName = medicineName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.dateOnSale = dateOnSale;
    }

    // Getters and setters

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public MedicineCategory getCategory() {
        return category;
    }

    public void setCategory(MedicineCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateOnSale() {
        return dateOnSale;
    }

    public void setDateOnSale(LocalDate dateOnSale) {
        this.dateOnSale = dateOnSale;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + medicineName + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", quantity=" + quantity +
                ", dateOnSale=" + dateOnSale +
                '}';
    }

}
