package fr.pompey.dev.afpa.vue;

import DAO.CustomerDAO;
import fr.pompey.dev.afpa.model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class AddCustomerForm extends JFrame {
    private JPanel FormPane;
    private JPanel panelAddCustomer;
    private JTextField textFieldFirstname;
    private JTextField textFieldLastname;
    private JTextField textFieldAddress;
    private JTextField textFieldPostalCode;
    private JTextField textFieldCity;
    private JTextField textFieldPhone;
    private JTextField textFieldEmail;
    private JTextField textFieldSocialSecurityNumber;
    private JButton cancelButton;
    private JButton addButton;
    private JComboBox<Integer> BD_comboBox_day;
    private JComboBox<String> BD_comboBox_month;
    private JComboBox<Integer> BD_comboBox_year;
    private CustomerDAO customerDAO;
    private CustomerPanel customerPanel;

    public AddCustomerForm(CustomerPanel customerPanel) {

        this.customerPanel = customerPanel;

        customerDAO = new CustomerDAO();

        setTitle("Add Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 1000); // Define size of the window
        setLocationRelativeTo(null); // Center the window

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

        // Initialize combobox values
        populateDateComboboxes();

        // delete the input text field borders
        removeBordersRecursively(panelAddCustomer);

        add(panelAddCustomer);

        BD_comboBox_day.setSelectedIndex(0);
        BD_comboBox_month.setSelectedIndex(0);
        BD_comboBox_year.setSelectedIndex(0);

        // Create new customer
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                addNewCustomer();

            }

        });

        // cancel and close the addCustomerForm panel
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }

        });

    }

    private void addNewCustomer() {

        try {

            Customer customer = new Customer();

            customer.setFirstname(textFieldFirstname.getText());
            customer.setLastname(textFieldLastname.getText());
            customer.setAddress(textFieldAddress.getText());
            customer.setPostalCode(textFieldPostalCode.getText());
            customer.setCity(textFieldCity.getText());
            customer.setPhoneNumber(textFieldPhone.getText());
            customer.setEmail(textFieldEmail.getText());
            customer.setSocialSecurityNumber(textFieldSocialSecurityNumber.getText());

            // recovering values from combobox
            int day = (int) BD_comboBox_day.getSelectedItem();
            String month = (String) BD_comboBox_month.getSelectedItem();
            int year = (int) BD_comboBox_year.getSelectedItem();

            // mapping month to a number (1-12)
            String[] months = {"1-January", "2-February", "3-March", "4-April", "5-May", "6-June",
                    "7-July", "8-August", "9-September", "10-October", "11-November", "12-December"};
            int monthNumber = -1;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equalsIgnoreCase(month)) {
                    monthNumber = i + 1; // Les indices commencent à 0, donc on ajoute 1
                    break;
                }
            }

            if (monthNumber == -1) {
                throw new IllegalArgumentException("Invalid month selected.");
            }

            // formating the date value to match the DB format (YYYY-MM-DD)
            String formattedDate = String.format("%04d-%02d-%02d", year, monthNumber, day);

            // Afficher ou utiliser la date
//            System.out.println("Date d'anniversaire formatée : " + formattedDate);

            // add the formated date to the DB
             customer.setBirthDate(LocalDate.parse(formattedDate));

            customerDAO.checkEmailExist(customer.getEmail());

            int newId = customerDAO.create(customer);

            if (newId > 0) {

                JOptionPane.showMessageDialog(this, "Customer added successfully!");

                customerPanel.reloadCustomers();

                customerPanel.clearCustomerDetails();

                dispose();

            } else {

                JOptionPane.showMessageDialog(this, "Failed to add customer.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Errro : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Removes borders of all JTextFields in a given container.
     *
     * @param container The main container (e.g., panelAddCustomer)
     */
    private void removeBordersRecursively(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setBorder(null); // remove borders
            } else if (comp instanceof Container) {
                // If the component is another container, recursively call
                removeBordersRecursively((Container) comp);
            }
        }
    }

    /**
     * Populate the day, month, and year comboboxes with appropriate values.
     */
    private void populateDateComboboxes() {
        // Populate day combobox (1-31)

        IntStream.rangeClosed(1, 31).forEach(BD_comboBox_day::addItem);

        // Populate month combobox (1-Jan to 12-Dec)

        String[] months = {"1-January", "2-February", "3-March", "4-April", "5-May", "6-June",
                "7-July", "8-August", "9-September", "10-October", "11-November", "12-December"};
        for (String month : months) {
            BD_comboBox_month.addItem(month);
        }

        // Populate year combobox (e.g., 1900 to current year)

        int currentYear = java.time.Year.now().getValue();
        IntStream.rangeClosed(1900, currentYear).forEach(BD_comboBox_year::addItem);
    }


}


