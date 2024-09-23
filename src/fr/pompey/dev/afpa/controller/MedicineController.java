package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.model.Medicine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MedicineController is a class dedicated to managing the list of medicines available in the drugstore.
 */
public class MedicineController {

    /** The list of medicines */
    private List<Medicine> medicines;

    /** Instance of MedicineManager */
    private MedicineManager medicineManager;

    /**
     * Constructor to initialize the medicine list and MedicineManager
     */
    public MedicineController() {
        this.medicines = new ArrayList<>();
        initializeMedicines();
        this.medicineManager = new MedicineManager(this.medicines);
    }

    // Automatically generated list of medicines
    private void initializeMedicines() {
        medicines.add(new Medicine("Doliprane", Medicine.MedicineCategory.ANALGESIC, 2.50, 10, LocalDate.of(2023, 1, 12)));
        medicines.add(new Medicine("Amoxicilline", Medicine.MedicineCategory.ANTIBIOTIC, 8.99, 5, LocalDate.of(2023, 2, 5)));
        medicines.add(new Medicine("Betadine", Medicine.MedicineCategory.ANTISEPTIC, 4.75, 12, LocalDate.of(2022, 11, 20)));
        medicines.add(new Medicine("Berocca", Medicine.MedicineCategory.VITAMINS, 6.20, 20, LocalDate.of(2023, 3, 15)));
        medicines.add(new Medicine("Ibuprofène", Medicine.MedicineCategory.ANTIINFLAMMATORY, 3.50, 15, LocalDate.of(2023, 4, 10)));
        medicines.add(new Medicine("Zovirax", Medicine.MedicineCategory.ANTIVIRAL, 9.30, 8, LocalDate.of(2023, 5, 7)));
        medicines.add(new Medicine("Paracétamol", Medicine.MedicineCategory.ANALGESIC, 1.99, 25, LocalDate.of(2022, 12, 1)));
        medicines.add(new Medicine("Augmentin", Medicine.MedicineCategory.ANTIBIOTIC, 12.50, 4, LocalDate.of(2023, 6, 18)));
        medicines.add(new Medicine("Mercurochrome", Medicine.MedicineCategory.ANTISEPTIC, 3.80, 7, LocalDate.of(2023, 7, 21)));
        medicines.add(new Medicine("Supradyn", Medicine.MedicineCategory.VITAMINS, 10.00, 18, LocalDate.of(2023, 8, 9)));
    }

    /**
     * Adds a medicine to the list of medicines.
     *
     * @param medicine the medicine to add.
     */
    public void addMedicine(Medicine medicine) {
        this.medicines.add(medicine);
    }

    /**
     * Removes a medicine from the list of medicines.
     *
     * @param medicine the medicine to remove.
     */
    public void removeMedicine(Medicine medicine) {
        this.medicines.remove(medicine);
    }

    /**
     * Returns the list of medicines.
     *
     * @return the list of medicines.
     */
    public List<Medicine> getMedicines() {
        return medicines;
    }

    /**
     * Returns the MedicineManager instance.
     *
     * @return the MedicineManager
     */
    public MedicineManager getMedicineManager() {
        return this.medicineManager;
    }

    /**
     * Prints the list of medicines to the console.
     */
    public void displayMedicines() {

        if (medicines.isEmpty()) {

            System.out.println("No medicines available.");

        } else {

            System.out.println("List of medicines:");

            for (Medicine medicine : medicines) {

                System.out.println(medicine.getMedicineName() + " - Category: " + medicine.getCategory() +
                        " - Price: €" + medicine.getPrice() + " - Quantity: " + medicine.getQuantity());

            }

        }

    }



    /**
     * The type Medicine manager.
     */
    public static class MedicineManager {
        private List<Medicine> allMedicines;

        /**
         * Instantiates a new Medicine manager.
         *
         * @param allMedicines the all medicines
         */
        public MedicineManager(List<Medicine> allMedicines) {
            this.allMedicines = allMedicines;
        }

        /**
         * Gets medicines by category.
         *
         * @param category the category
         * @return the medicines by category
         */
        public List<Medicine> getMedicinesByCategory(Medicine.MedicineCategory category) {
            return allMedicines.stream()
                    .filter(medicine -> medicine.getCategory() == category)
                    .collect(Collectors.toList());
        }
    }

}
