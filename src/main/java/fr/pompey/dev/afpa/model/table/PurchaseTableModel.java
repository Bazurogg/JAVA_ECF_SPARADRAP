//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fr.pompey.dev.afpa.model.table;

import fr.pompey.dev.afpa.model.Purchase;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PurchaseTableModel extends AbstractTableModel {

    private final String[] columnNames = new String[]{"Date", "Customer", "Medicines", "Total Price"};

    private final List<Purchase> purchases;

    public PurchaseTableModel(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public int getRowCount() {
        return this.purchases.size();
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        Purchase purchase = this.purchases.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return purchase.getPurchaseDate().toString();
            case 1:
                String var10000 = purchase.getCustomer().getFirstname();
                return var10000 + " " + purchase.getCustomer().getLastname();
            case 2:
                return purchase.getMedicines().toString();
            case 3:
                return String.format("%.2f", purchase.getTotalPrice());
            default:
                return null;

        }

    }

}