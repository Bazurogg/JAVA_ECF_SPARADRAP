package fr.pompey.dev.afpa.model.table;

import fr.pompey.dev.afpa.model.Purchase;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PurchaseTableModel extends AbstractTableModel {

    // Noms des colonnes pour les achats
    private final String[] columnNames = {"Date", "Customer", "Medicines", "Total Price"};

    // Liste des achats
    private final List<Purchase> purchases;

    public PurchaseTableModel(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public int getRowCount() {
        return purchases.size();  // Le nombre de lignes est le nombre d'achats
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;  // Nombre de colonnes défini par le tableau columnNames
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];  // Retourner le nom des colonnes
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Récupérer l'achat correspondant à la ligne (rowIndex)
        Purchase purchase = purchases.get(rowIndex);

        // Renvoyer les données en fonction de la colonne (columnIndex)
        switch (columnIndex) {
            case 0:
                return purchase.getPurchaseDate().toString();  // Date d'achat
            case 1:
                return purchase.getCustomer().getFirstname() + " " + purchase.getCustomer().getLastname();  // Nom du client
            case 2:
                return purchase.getMedicines().toString();  // Liste des médicaments sous forme de chaîne
            case 3:
                return String.format("%.2f", purchase.getTotalPrice());  // Prix total de l'achat, formaté avec 2 décimales
            default:
                return null;
        }
    }
}