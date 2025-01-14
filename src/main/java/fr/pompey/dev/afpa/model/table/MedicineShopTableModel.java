package fr.pompey.dev.afpa.model.table;

import javax.swing.table.AbstractTableModel;
import fr.pompey.dev.afpa.model.Medicine;
import java.util.List;

public class MedicineShopTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Name", "Price", "Quantity", "Date on Sale"};

    private final List<Medicine> medicines;

    public MedicineShopTableModel(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public int getRowCount() {
        return medicines.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medicine medicine = medicines.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return medicine.getMedicineName();  // Nom du médicament
            case 1:
                return medicine.getQuantity();  // Quantité ajoutée à l'achat
            case 2:
                return medicine.getPrice();  // Prix par unité
            case 3:
                return medicine.getPrice() * medicine.getQuantity();  // Prix total (quantité * prix unitaire)
            default:
                return null;
        }

    }

}
