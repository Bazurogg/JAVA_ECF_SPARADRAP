package fr.pompey.dev.afpa.vue;

import javax.swing.*;
import java.awt.*;

public class AddCustomerForm extends JFrame {
    private JPanel FormPane;
    private JPanel panelAddCustomer;
    private JTextField textFieldFirstname;
    private JTextField textFieldLastname;
    private JTextField textFieldEmail;
    private JButton saveButton;
    private JButton cancelButton;

    public AddCustomerForm() {

        setTitle("Add Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300); // Define size of the window
        setLocationRelativeTo(null); // Center the window

        // Initialize panel
//        panelAddCustomer = new JPanel();

//        // Add action listeners for buttons
//        saveButton.addActionListener(e -> {
//            // Logic to save the customer (can be expanded)
//            System.out.println("Customer saved: " + textFieldFirstname.getText());
//            dispose(); // Close the form after saving
//        });
//
//        cancelButton.addActionListener(e -> {
//            dispose(); // Close the form without saving
//        });

        // Add the panel to the frame
        add(panelAddCustomer);


    }
    
}

