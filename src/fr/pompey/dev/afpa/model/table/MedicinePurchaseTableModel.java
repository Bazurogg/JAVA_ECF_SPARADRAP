package fr.pompey.dev.afpa.model.table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import fr.pompey.dev.afpa.model.Medicine;
import fr.pompey.dev.afpa.model.DirectPurchase;

public class MedicinePurchaseTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Medicine", "Quantity", "Price per unit", "Total price"};
    
    private List<Medicine> purchaseMedicines;  // Liste de médicaments de l'achat

    // Le constructeur prend une instance de DirectPurchase
    public MedicinePurchaseTableModel(DirectPurchase purchase) {

        this.purchaseMedicines = purchase.getMedicines();  // Appelle getMedicines() sur l'instance

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
            case 0:
                return medicine.getMedicineName();
            case 1:
                return medicine.getQuantity();
            case 2:
                return medicine.getPrice();
            case 3:
                return medicine.getQuantity() * medicine.getPrice();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}