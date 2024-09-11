package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.CustomerController;
import fr.pompey.dev.afpa.controller.DoctorController;
import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuHome extends JFrame {

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

    // Constructeur pour initialiser la fenêtre
    public MenuHome() {
        // Appelle le constructeur de JFrame pour définir le titre de la fenêtre
        super("Pharmacy Management - Home");

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

    // Initialisation des écouteurs s'évènements sur les boutons du menu
    // Bouton détails Médecins
    private void initListeners() {

        doctorsButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showDoctorPanel();

            }

        });

        customersButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showCustomerPanel();

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




}


