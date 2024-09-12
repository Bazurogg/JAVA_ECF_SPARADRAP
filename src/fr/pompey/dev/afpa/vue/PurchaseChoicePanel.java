package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.model.DirectPurchase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseChoicePanel extends JPanel {

    private JPanel panelPurchaseChoice;
    private JButton directPurchaseButton;
    private JButton byPrescriptionPurchaseButton;

    public PurchaseChoicePanel() {

        this.setVisible(true);

        add(panelPurchaseChoice);

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

        DirectPurchasePanel directPurchasePanel = new DirectPurchasePanel();

        panelPurchaseChoice.removeAll();

        panelPurchaseChoice.add(directPurchasePanel, BorderLayout.CENTER);
        panelPurchaseChoice.revalidate();
        panelPurchaseChoice.repaint();

    };


}