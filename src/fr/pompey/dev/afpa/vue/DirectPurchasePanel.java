package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.CustomerController;
import fr.pompey.dev.afpa.controller.MedicineController;
import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.model.DirectPurchase;
import fr.pompey.dev.afpa.model.Medicine;
import fr.pompey.dev.afpa.model.table.MedicinePurchaseTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DirectPurchasePanel extends JPanel {

    private final DirectPurchase currentPurchase;
    private JTable purchaseTable;
    private final List<Medicine> selectedMedicines = new ArrayList<>();
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
    private JScrollPane JScrollTablePurchase;
    private JComboBox<String> comboBoxCustomers;
    private JTextField TotalPriceField;
    private CustomerController customerController;
    private MedicineController.MedicineManager medicineManager;
    private List<Customer> customers;

    public DirectPurchasePanel(MedicineController.MedicineManager medicineManager, CustomerController customerController) {
        this.medicineManager = medicineManager;
        this.customerController = customerController;

        // Initialise DirectPurchase avec une liste vide de médicaments
        currentPurchase = new DirectPurchase(LocalDate.now(), 0.0, new ArrayList<>(), null);

        this.setVisible(true);
        this.add(panelDirectPurchase);

        // Initialize the UI and tables
        initializeUI();
        populateTables();
        populateComboBoxCustomer();
    }

    private void initializeUI() {
        // Create tables for each category
        tableAnalgesic = new JTable();
        tableAntibiotic = new JTable();
        tableAntiseptic = new JTable();
        tableVitamins = new JTable();
        tableAntiInflammatory = new JTable();
        tableAntiviral = new JTable();

        // Créer la table d'achat avec le modèle personnalisé
        purchaseTable = new JTable(new MedicinePurchaseTableModel(currentPurchase));
        JScrollTablePurchase.setViewportView(purchaseTable);

        TotalPriceField.setBorder(null);

        // Add tabs to tabbedPane for each category
        tabbedPane1.addTab("Analgesics", new JScrollPane(tableAnalgesic));
        tabbedPane1.addTab("Antibiotics", new JScrollPane(tableAntibiotic));
        tabbedPane1.addTab("Antiseptics", new JScrollPane(tableAntiseptic));
        tabbedPane1.addTab("Vitamins", new JScrollPane(tableVitamins));
        tabbedPane1.addTab("Anti-inflammatories", new JScrollPane(tableAntiInflammatory));
        tabbedPane1.addTab("Antivirals", new JScrollPane(tableAntiviral));

        comboBoxCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCustomer = (String) comboBoxCustomers.getSelectedItem();
                if ("Not specified".equals(selectedCustomer)) {
                    currentPurchase.setCustomer(null); // Pas de client associé
                } else {
                    // Si un client est sélectionné, récupérez ses informations
                    int selectedIndex = comboBoxCustomers.getSelectedIndex() - 1; // -1 car "Non renseigné" est en première position
                    if (selectedIndex >= 0) {
                        Customer selectedCustomerObj = customers.get(selectedIndex);
                        currentPurchase.setCustomer(selectedCustomerObj); // Associe le client à l'achat
                    }
                }
            }
        });

        // Configure the action buttons in the purchase table
        configureActionButtons();
    }

    private void configureActionButtons() {
        TableColumn removeColumn = purchaseTable.getColumn("Remove");
        removeColumn.setCellRenderer(new ButtonRenderer("Remove"));
        removeColumn.setCellEditor(new PurchaseButtonEditor(new JCheckBox(), currentPurchase.getMedicines(), purchaseTable, "Remove"));

        TableColumn increaseColumn = purchaseTable.getColumn("Increase");
        increaseColumn.setCellRenderer(new ButtonRenderer("Increase"));
        increaseColumn.setCellEditor(new PurchaseButtonEditor(new JCheckBox(), currentPurchase.getMedicines(), purchaseTable, "Increase"));

        TableColumn decreaseColumn = purchaseTable.getColumn("Decrease");
        decreaseColumn.setCellRenderer(new ButtonRenderer("Decrease"));
        decreaseColumn.setCellEditor(new PurchaseButtonEditor(new JCheckBox(), currentPurchase.getMedicines(), purchaseTable, "Decrease"));
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
        TableColumn actionColumn = table.getColumn("Action");
        actionColumn.setCellRenderer(new ButtonRenderer("Add"));
        actionColumn.setCellEditor(new MedicineButtonEditor(new JCheckBox(), medicines, table));
        actionColumn.setPreferredWidth(80); // Adjust column width to fit the button
        table.setRowHeight(30);
    }

    private void populateComboBoxCustomer() {
        comboBoxCustomers.addItem("Customer not specified");
        customers = customerController.getCustomers();
        for (Customer customer : customers) {
            comboBoxCustomers.addItem(customer.getFirstname() + " " + customer.getLastname());
        }
    }

    // Custom ButtonRenderer to render buttons in table cells
    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(String action) {
            setText(action);
            setHorizontalAlignment(CENTER);
            setPreferredSize(new Dimension(30, 80));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Custom ButtonEditor for the medicine table (Add button)
    private class MedicineButtonEditor extends DefaultCellEditor {

        private JButton button;
        private List<Medicine> medicines;
        private JTable table;

        public MedicineButtonEditor(JCheckBox checkBox, List<Medicine> medicines, JTable table) {
            super(checkBox);
            this.medicines = medicines;
            this.table = table;
            button = new JButton("Add");
            button.setPreferredSize(new Dimension(80, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAddAction();
                }
            });
        }

        private void handleAddAction() {
            int row = table.getSelectedRow();
            if (row < 0 || row >= medicines.size()) {
                return;
            }
            Medicine selectedMedicine = medicines.get(row);
            String quantityStr = JOptionPane.showInputDialog("Enter the quantity for " + selectedMedicine.getMedicineName());

            try {
                int quantity = Integer.parseInt(quantityStr);
                if (quantity > 0) {
                    selectedMedicine.setQuantity(quantity);
                    selectedMedicines.add(selectedMedicine);
                    currentPurchase.getMedicines().add(selectedMedicine);
                } else {
                    JOptionPane.showMessageDialog(null, "Quantity must be positive.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }

            // Mettre à jour la table d'achat et le prix total
            ((MedicinePurchaseTableModel) purchaseTable.getModel()).fireTableDataChanged();
            double totalPrice = calculateTotalPrice();
            TotalPriceField.setText(String.format("%.2f", totalPrice));
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

    // Custom ButtonEditor for the purchase table (Remove, Increase, Decrease buttons)
    // Custom ButtonEditor for the purchase table (Remove, Increase, Decrease buttons)
    private class PurchaseButtonEditor extends DefaultCellEditor {

        private JButton button;
        private List<Medicine> medicines;
        private JTable table;
        private String action;
        private boolean isPushed = false;

        public PurchaseButtonEditor(JCheckBox checkBox, List<Medicine> medicines, JTable table, String action) {
            super(checkBox);
            this.medicines = medicines;
            this.table = table;
            this.action = action;
            button = new JButton(action);
            button.setPreferredSize(new Dimension(80, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isPushed = true;
                    handleAction();
                    // Forcer l'arrêt de l'édition après l'action
                    fireEditingStopped();
                }
            });
        }

        private void handleAction() {
            int row = table.getSelectedRow();
            if (row < 0 || row >= medicines.size()) {
                return;
            }
            Medicine selectedMedicine = medicines.get(row);

            switch (action) {
                case "Remove":
                    currentPurchase.getMedicines().remove(selectedMedicine);
                    ((MedicinePurchaseTableModel) table.getModel()).removeMedicine(row);
                    break;
                case "Increase":
                    selectedMedicine.setQuantity(selectedMedicine.getQuantity() + 1);
                    ((MedicinePurchaseTableModel) table.getModel()).updateQuantity(row, selectedMedicine.getQuantity());
                    break;
                case "Decrease":
                    int newQuantity = selectedMedicine.getQuantity() - 1;
                    selectedMedicine.setQuantity(Math.max(newQuantity, 0));
                    ((MedicinePurchaseTableModel) table.getModel()).updateQuantity(row, selectedMedicine.getQuantity());
                    break;
            }

            // Update the table and the total price
            ((MedicinePurchaseTableModel) purchaseTable.getModel()).fireTableDataChanged();
            double totalPrice = calculateTotalPrice();
            TotalPriceField.setText(String.format("%.2f", totalPrice));
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            isPushed = false;
            button.setText(action);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }

        @Override
        public boolean stopCellEditing() {
            // Prevent stopping cell editing if the button has been pushed
            return isPushed && super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            // Ensure editing stops after the button is clicked
            super.fireEditingStopped();
        }
    }


    private double calculateTotalPrice() {
        return currentPurchase.getMedicines().stream()
                .mapToDouble(medicine -> medicine.getPrice() * medicine.getQuantity())
                .sum();
    }
}
