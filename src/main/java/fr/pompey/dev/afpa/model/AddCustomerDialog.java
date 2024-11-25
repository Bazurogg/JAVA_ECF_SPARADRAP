package fr.pompey.dev.afpa.model;

import DAO.CustomerDAO;
import fr.pompey.dev.afpa.model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AddCustomerDialog extends JDialog {

    private JTextField textFieldFirstname;
    private JTextField textFieldLastname;
    private JTextField textFieldAddress;
    private JTextField textFieldPostalCode;
    private JTextField textFieldCity;
    private JTextField textFieldPhone;
    private JTextField textFieldEmail;
    private JTextField textFieldBirthday;
    private JTextField textFieldSocialSecurityNumber;
    private JButton saveButton;
    private JButton cancelButton;

    private CustomerDAO customerDAO;

    public AddCustomerDialog(JFrame parent) {
        super(parent, "Add New Customer", true);
        customerDAO = new CustomerDAO();

        setLayout(new GridLayout(10, 2, 10, 10));

        // Create and add form components
        add(new JLabel("Firstname:"));
        textFieldFirstname = new JTextField();
        add(textFieldFirstname);

        add(new JLabel("Lastname:"));
        textFieldLastname = new JTextField();
        add(textFieldLastname);

        add(new JLabel("Address:"));
        textFieldAddress = new JTextField();
        add(textFieldAddress);

        add(new JLabel("Postal Code:"));
        textFieldPostalCode = new JTextField();
        add(textFieldPostalCode);

        add(new JLabel("City:"));
        textFieldCity = new JTextField();
        add(textFieldCity);

        add(new JLabel("Phone:"));
        textFieldPhone = new JTextField();
        add(textFieldPhone);

        add(new JLabel("Email:"));
        textFieldEmail = new JTextField();
        add(textFieldEmail);

        add(new JLabel("Birthday (YYYY-MM-DD):"));
        textFieldBirthday = new JTextField();
        add(textFieldBirthday);

        add(new JLabel("Social Security Number:"));
        textFieldSocialSecurityNumber = new JTextField();
        add(textFieldSocialSecurityNumber);

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        add(saveButton);
        add(cancelButton);

        // Add action listeners
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCustomer();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(400, 400);
        setLocationRelativeTo(parent);
    }

    private void saveCustomer() {

        try {

            Customer customer = new Customer();
            customer.setFirstname(textFieldFirstname.getText());
            customer.setLastname(textFieldLastname.getText());
            customer.setAddress(textFieldAddress.getText());
            customer.setPostalCode(textFieldPostalCode.getText());
            customer.setCity(textFieldCity.getText());
            customer.setPhoneNumber(textFieldPhone.getText());
            customer.setEmail(textFieldEmail.getText());

            try {
                String birthDateInput = textFieldBirthday.getText();
                LocalDate birthDate = LocalDate.parse(birthDateInput); // Conversion
                customer.setBirthDate(birthDate); // Setter pour LocalDate
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            customer.setSocialSecurityNumber(textFieldSocialSecurityNumber.getText());

            customerDAO.checkEmailExist(customer.getEmail());

            int newId = customerDAO.create(customer);

            if (newId > 0) {
                JOptionPane.showMessageDialog(this, "Customer added successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add customer.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

}
