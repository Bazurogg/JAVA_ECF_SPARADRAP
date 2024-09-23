package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.PurchaseManager;
import fr.pompey.dev.afpa.model.Purchase;
import fr.pompey.dev.afpa.model.table.PurchaseTableModel;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PurchaseHistoryPanel extends JPanel {

    private JScrollPane JScrollTableAllPurchases;
    private JPanel panelPurchaseHistory;
    private PurchaseManager purchaseManager;
    private JTable purchaseTable;

    public PurchaseHistoryPanel(PurchaseManager purchaseManager) {

        this.purchaseManager = purchaseManager;

        // Initialiser le panel d'historique des achats

        this.setVisible(true);

        this.add(panelPurchaseHistory); // Ajouter le panel au centre

        // Créer la table des achats
        initializeTable();
    }

    private void initializeTable() {

        List<Purchase> purchases = purchaseManager.getAllPurchases();

        // Créer la table avec le modèle
        purchaseTable = new JTable(new PurchaseTableModel(purchases));

        JScrollTableAllPurchases.setViewportView(purchaseTable);

    }

}