package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.CustomerController;
import fr.pompey.dev.afpa.controller.MedicineController;
import fr.pompey.dev.afpa.controller.PurchaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseChoicePanel extends JPanel {

    private JPanel panelPurchaseChoice;
    private MedicineController medicineController;
    private CustomerController customerController;
    private PurchaseManager purchaseManager;
    private JButton directPurchaseButton;
    private JButton byPrescriptionPurchaseButton;

    public PurchaseChoicePanel(MedicineController medicineController) {

        this.medicineController = medicineController; // Initialise medicineController dans le constructeur
        this.customerController = customerController; // Initialisation dans le constructeur
        this.purchaseManager = purchaseManager;

        this.setVisible(true);
        this.add(panelPurchaseChoice);

        // Ajout des écouteurs d'événements sur les boutons
        initListeners();

    }

    private void initListeners() {

        directPurchaseButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                showDirectPurchasePanel();

            }

        });

    }

    private void showDirectPurchasePanel() {

        if (customerController == null) {
            customerController = new CustomerController();
        }

        PurchaseManager purchaseManager = new PurchaseManager();

        DirectPurchasePanel directPurchasePanel = new DirectPurchasePanel(medicineController.getMedicineManager(),
                customerController, purchaseManager);

        panelPurchaseChoice.removeAll();
        panelPurchaseChoice.add(directPurchasePanel, BorderLayout.CENTER);
        panelPurchaseChoice.revalidate();
        panelPurchaseChoice.repaint();

    }

}
