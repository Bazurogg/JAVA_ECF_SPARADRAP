package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.CustomerController;
import fr.pompey.dev.afpa.controller.DoctorController;
import fr.pompey.dev.afpa.controller.MedicineController;
import fr.pompey.dev.afpa.controller.PurchaseManager;
import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.model.Doctor;
import fr.pompey.dev.afpa.model.Purchase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuHome extends JFrame {
    private PurchaseManager purchaseManager;
    private JPanel sideBar;
    private JButton customersButton;
    private JButton medicinesButton;
    private JButton doctorsButton;
    private JButton purchasesButton;
    private JButton homeButton;
    private JButton exitButton;
    private JPanel mainPanel;
    private JPanel displayPanel;
    private JButton specialistButton;
    private JButton allPurchasesButton;

    // Constructeur pour initialiser la fenêtre
    public MenuHome(PurchaseManager purchaseManager) {

        // Appelle le constructeur de JFrame pour définir le titre de la fenêtre
        super("Pharmacy Management - Home");

        this.purchaseManager = purchaseManager;

        // Ajoute le mainPanel (qui contient ton design) à la fenêtre
        this.setContentPane(mainPanel);

        // Définit la taille de la fenêtre
        this.setSize(1490, 960);

        // Permet de fermer l'application quand la fenêtre est fermée
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendre la fenêtre visible
        this.setContentPane(mainPanel);
        this.setVisible(true);

        // Ajout des écouteurs d'événements sur les boutons
        initListeners();


    }



    // Initializing Event Listeners on Menu Buttons

    private void initListeners() {

        // Button to doctor's details
        doctorsButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showDoctorPanel();

            }

        });

        // Button to customer's details
        customersButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showCustomerPanel();

            }

        });

        // button to the purchase choice window
        purchasesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showPurchaseChoicePanel();

            }

        });// button to show the list of purchases
        allPurchasesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showPurchaseHistoryPanel();

            }

        });

    }

    // Méthods to swipe the displayPanel with another  swing GUI panel class
    // Doctor Panel
    private void showDoctorPanel() {

        displayPanel.removeAll();

        DoctorController doctorController = new DoctorController();
        List<Doctor> doctors = doctorController.getDoctors();

        if (doctors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No doctors available");
            return;
        }

        DoctorPanel doctorPanel = new DoctorPanel(doctors);
        displayPanel.add(doctorPanel, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();

    }

    // Customer Panel
    private void showCustomerPanel() {

        displayPanel.removeAll();

        CustomerController customerController = new CustomerController();
        List<Customer> customers = customerController.getCustomers();

        if (customers.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No customers available");
            return;
        }

        CustomerPanel customerPanel = new CustomerPanel(customers);
        displayPanel.add(customerPanel, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();

    }

    // Purchase choice panel
    private void showPurchaseChoicePanel() {

        displayPanel.removeAll();
        MedicineController medicineController = new MedicineController();
        PurchaseChoicePanel purchaseChoicePanel = new PurchaseChoicePanel(medicineController);
        displayPanel.add(purchaseChoicePanel, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();

    }

    private void showPurchaseHistoryPanel() {

        PurchaseHistoryPanel purchaseHistoryPanel = new PurchaseHistoryPanel(purchaseManager);
        displayPanel.removeAll();
        displayPanel.add(purchaseHistoryPanel, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();

    }


}


