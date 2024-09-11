package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerPanel extends JPanel {

    private JPanel panelCustomer;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField5;
    private JTextField textField8;
    private JLabel panelCustomerInfo;
    private JComboBox<Customer> comboBox1;
    private JButton addNewCustomerButton;

    public CustomerPanel(List<Customer> customers) {

        initializeComponents();

        Collections.sort(customers, Comparator.comparing(Customer::getLastname));

        this.setVisible(true);

        add(panelCustomer);

        for (Customer customer : customers) {

            comboBox1.addItem(customer);

        }

        comboBox1.setSelectedIndex(-1);

        comboBox1.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                Customer selectedCustomer = (Customer) comboBox1.getSelectedItem();

                if (selectedCustomer != null) {

                    updateCustomerDetails(selectedCustomer);

                }

            }

        });

    }

    private void initializeComponents() {

        // Suppression des bordures pour les JTextFields
        textField8.setBorder(null);

    }

    // Method to update the JTextFields with customer information
    private void updateCustomerDetails(Customer customer) {
        textField1.setText(customer.getFirstname());
        textField2.setText(customer.getLastname());
        textField3.setText(customer.getAddress());
        textField4.setText(customer.getEmail());
        textField5.setText(customer.getCity());
        textField6.setText(customer.getPhoneNumber());
        textField7.setText(customer.getPostalCode());
        textField8.setText(customer.getSocialSecurityNumber());
    }

}
