package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.controller.DoctorController;
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
    private JButton doctorButton;
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

        // Initialisation des composants

//        displayPanel = new JPanel();
//        displayPanel.setLayout(new BorderLayout());

//        // Initialise displayPanel si ce n'est pas déjà fait dans le form
//        if (displayPanel == null) {
//            displayPanel = new JPanel();
//            displayPanel.setLayout(new BorderLayout()); // Important d'avoir un layout valide
//        }

        // Ajoute le mainPanel (qui contient ton design) à la fenêtre
        this.setContentPane(mainPanel);

        // Définit la taille de la fenêtre
        this.setSize(1490, 900);

        // Permet de fermer l'application quand la fenêtre est fermée
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendre la fenêtre visible
        this.setContentPane(mainPanel);
        this.setVisible(true);

        // Ajout des écouteurs d'événements sur les boutons
        initListeners();

    }

    // Initialisation des écouteurs s'évènements sur les boutons du menu

    // Bouton détails Médecins et spécialistes
    private void initListeners() {

        doctorButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showDoctorPanel();

//                displayPanel.removeAll();
//                displayPanel.add(new DoctorPanel(doctors));
//                displayPanel.revalidate();
//                displayPanel.repaint();

            }

        });

    }

    // Méthodes pour changer le contenu du displayPanel
    private void showDoctorPanel() {

        displayPanel.removeAll();

        DoctorController doctorController = new DoctorController();
        List<Doctor> doctors = doctorController.getDoctors();

        if (doctors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No doctors available");
            return;
        }

//        System.out.println("COUCOU ! et OUI SI TU ME VOIS EH BEH çA MARCHE !");
        DoctorPanel doctorPanel = new DoctorPanel(doctors);
        displayPanel.add(doctorPanel, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();

    }


    // Methode test d'affichage au clic sur le bouton
//    private void doctorPanel() {
//
//        System.out.println("showTEST called"); // Pour vérifier si la méthode est appelée
//        displayPanel.removeAll();
//
//        TEST testPanel = new TEST();
//        displayPanel.removeAll();
//        displayPanel.setLayout(new BorderLayout());
//        displayPanel.add(testPanel, BorderLayout.CENTER);
//
//        displayPanel.revalidate();
//        displayPanel.repaint();
//
//    }

}


