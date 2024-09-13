package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.MedicineController;
import fr.pompey.dev.afpa.model.Medicine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        model.addColumn("Action"); // Add Action column for buttons

        // Populate the table with data
        for (Medicine medicine : medicines) {
            model.addRow(new Object[]{
                    medicine.getMedicineName(),
                    medicine.getPrice(),
                    medicine.getQuantity(),
                    medicine.getDateOnSale(),
                    "Add" // Text for the button
            });
        }

        // Set the model to the table
        table.setModel(model);

        // Set custom renderer and editor for the Action column
//        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
//        table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), medicines, table));

        TableColumn actionColumn = table.getColumn("Action");
        actionColumn.setCellRenderer(new ButtonRenderer());
        actionColumn.setCellEditor(new ButtonEditor(new JCheckBox(), medicines, table));
        actionColumn.setPreferredWidth(80); // Adjust column width to fit the button
        table.setRowHeight(30);


    }

    // Custom ButtonRenderer to render buttons in table cells
    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setText("Add");
            setHorizontalAlignment(CENTER);
            setPreferredSize(new Dimension(30, 80));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }

    }

    // Custom ButtonEditor to handle button clicks
    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private List<Medicine> medicines;
        private JTable table;

        public ButtonEditor(JCheckBox checkBox, List<Medicine> medicines, JTable table) {
            super(checkBox);
            this.medicines = medicines;
            this.table = table;
            button = new JButton("Add");
            button.setPreferredSize(new Dimension(30, 80));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    Medicine selectedMedicine = medicines.get(row);

                    String quantityStr = JOptionPane.showInputDialog("Enter the quantity for " + selectedMedicine.getMedicineName());
                    try {
                        int quantity = Integer.parseInt(quantityStr);
                        if (quantity > 0) {
                            // Handle adding the medicine here
                            JOptionPane.showMessageDialog(null, "Added " + quantity + " of " + selectedMedicine.getMedicineName());
                        } else {
                            JOptionPane.showMessageDialog(null, "Quantity must be positive.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }

    }

}

