package fr.pompey.dev.afpa.model.table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import fr.pompey.dev.afpa.model.Medicine;
import fr.pompey.dev.afpa.model.DirectPurchase;

public class MedicinePurchaseTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Medicine", "Quantity", "Price per unit", "Total price", "Increase", "Decrease", "Remove"};
    private List<Medicine> purchaseMedicines;  // Liste de médicaments de l'achat

    public MedicinePurchaseTableModel(DirectPurchase purchase) {
        this.purchaseMedicines = purchase.getMedicines();
    }

    @Override
    public int getRowCount() {
        return purchaseMedicines.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medicine medicine = purchaseMedicines.get(rowIndex);
        switch (columnIndex) {
            case 0: return medicine.getMedicineName();
            case 1: return medicine.getQuantity();
            case 2: return medicine.getPrice();
            case 3: return medicine.getQuantity() * medicine.getPrice(); // Total price
            case 4: return "Increase";  // Text for the Increase button
            case 5: return "Decrease";  // Text for the Decrease button
            case 6: return "Remove";    // Text for the Remove button
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Indicate that columns 4, 5, and 6 are buttons and should be editable
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 4;  // Only buttons are editable
    }

    // Handle actions on "Remove", "Increase", and "Decrease" buttons
    public void removeMedicine(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < purchaseMedicines.size()) {
            purchaseMedicines.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public void updateQuantity(int rowIndex, int quantity) {
        if (rowIndex >= 0 && rowIndex < purchaseMedicines.size()) {
            Medicine medicine = purchaseMedicines.get(rowIndex);
            medicine.setQuantity(quantity);
            fireTableCellUpdated(rowIndex, 1); // Update quantity cell
            fireTableCellUpdated(rowIndex, 3); // Update total price cell
        }
    }
}
