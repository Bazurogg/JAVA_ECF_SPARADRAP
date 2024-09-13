package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.MedicineController;
import fr.pompey.dev.afpa.model.Medicine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DirectPurchasePanel extends JPanel {

    private JPanel panelDirectPurchase;
    private JTabbedPane tabbedPane1;
    private JTable tableAnalgesic;
    private JTable tableAntibiotic;
    private JTable tableAntiseptic;
    private JTable tableVitamins;
    private JTable tableAntiInflammatory;
    private JTable tableAntiviral;
    private JButton createNewDirectPurchaseButton;
    private JButton cancelButton;

    private MedicineController.MedicineManager medicineManager;

    public DirectPurchasePanel(MedicineController.MedicineManager medicineManager) {
        this.medicineManager = medicineManager;

        this.setVisible(true);
        this.add(panelDirectPurchase);

        // Initialize the UI and tables
        initializeUI();
        populateTables();
    }

    private void initializeUI() {

        // Create tables for each category
        tableAnalgesic = new JTable();
        tableAntibiotic = new JTable();
        tableAntiseptic = new JTable();
        tableVitamins = new JTable();
        tableAntiInflammatory = new JTable();
        tableAntiviral = new JTable();

        // Add tabs to tabbedPane for each category
        tabbedPane1.addTab("Analgesics", new JScrollPane(tableAnalgesic));
        tabbedPane1.addTab("Antibiotics", new JScrollPane(tableAntibiotic));
        tabbedPane1.addTab("Antiseptics", new JScrollPane(tableAntiseptic));
        tabbedPane1.addTab("Vitamins", new JScrollPane(tableVitamins));
        tabbedPane1.addTab("Anti-inflammatories", new JScrollPane(tableAntiInflammatory));
        tabbedPane1.addTab("Antivirals", new JScrollPane(tableAntiviral));

    }

    private void populateTables() {
        populateTable(Medicine.MedicineCategory.ANALGESIC, tableAnalgesic);
        populateTable(Medicine.MedicineCategory.ANTIBIOTIC, tableAntibiotic);
        populateTable(Medicine.MedicineCategory.ANTISEPTIC, tableAntiseptic);
        populateTable(Medicine.MedicineCategory.VITAMINS, tableVitamins);
        populateTable(Medicine.MedicineCategory.ANTIINFLAMMATORY, tableAntiInflammatory);
        populateTable(Medicine.MedicineCategory.ANTIVIRAL, tableAntiviral);
    }

    private void populateTable(Medicine.MedicineCategory category, JTable table) {
        if (table == null) {
            System.err.println("Error: Table for category " + category + " is null.");
            return;
        }

        // Get the list of medicines by category
        List<Medicine> medicines = medicineManager.getMedicinesByCategory(category);

        // Create table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Date on Sale");

        // Populate the table with data
        for (Medicine medicine : medicines) {
            model.addRow(new Object[]{
                    medicine.getMedicineName(),
                    medicine.getPrice(),
                    medicine.getQuantity(),
                    medicine.getDateOnSale()
            });
        }

        // Set the model to the table
        table.setModel(model);

    }

}
