package fr.pompey.dev.afpa.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Initialise displayPanel si ce n'est pas déjà fait dans le form
        if (displayPanel == null) {
            displayPanel = new JPanel();
            displayPanel.setLayout(new BorderLayout()); // Important d'avoir un layout valide
        }

        // Ajoute le mainPanel (qui contient ton design) à la fenêtre
        this.setContentPane(mainPanel);

        // Définit la taille de la fenêtre
        this.setSize(1480, 900);

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

                showMedicProPanel();

            }

        });

    }

    // Méthodes pour changer le contenu du displayPanel

    private void showMedicProPanel() {

        displayPanel.removeAll();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(new JLabel("Doctors and Specialists Management Panel"));
        displayPanel.revalidate();
        displayPanel.repaint();

    }

    // Main pour lancer l'application et afficher le menu d'accueil
    public static void main(String[] args) {
        // Crée une instance de MenuHome, ce qui affichera la fenêtre
        new MenuHome();
    }

}

