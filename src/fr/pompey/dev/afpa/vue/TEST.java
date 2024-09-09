package fr.pompey.dev.afpa.vue;

import javax.swing.*;
import java.awt.*;

public class TEST extends JPanel {

    private JButton JEButton;
    private JButton SUISButton;
    private JButton SPIDERMANButton;

    public TEST() {
        // Appelle le constructeur généré automatiquement par IntelliJ pour le designer
        initComponents();
    }

    private void initComponents() {
        // Code généré automatiquement par IntelliJ IDEA pour le designer
        // Assurez-vous que le code ici est complet et correct
        setLayout(new GridLayout(1, 3)); // Exemple de mise en page

        JEButton = new JButton("JE");
        SUISButton = new JButton("SUIS");
        SPIDERMANButton = new JButton("SPIDERMAN");

        add(JEButton);
        add(SUISButton);
        add(SPIDERMANButton);

    }

}