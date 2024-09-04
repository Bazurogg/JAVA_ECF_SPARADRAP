package fr.pompey.dev.afpa.model;


/**
 * Represents the category of each medicine.
 * This super class serves to build the medicine child class.
 */
public class MedCat {

    private String categoryName;

    /**
     * Constructor for the MedCat class.
     *
     * @param categoryName the category name
     */
    public  MedCat(String categoryName) {

        // Initialize the specific fields of Customer
        setCategoryName(categoryName);

    }

    /**
     * Gets category name of the medicine.
     *
     * @return the category name
     */
    public String getCategoryName() {
        
        return categoryName;

    }

    /**
     * Sets category name of the medicine.
     *
     * @param categoryName the category name
     */
    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;

    }

}


