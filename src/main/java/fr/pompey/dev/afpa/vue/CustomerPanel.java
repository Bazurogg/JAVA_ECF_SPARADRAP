package fr.pompey.dev.afpa.vue;

import DAO.CustomerDAO;
import fr.pompey.dev.afpa.model.Customer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Panel for managing customers.
 * Allows listing, adding, updating, and deleting customer records.
 */
public class CustomerPanel extends JPanel {

    private JPanel panelCustomer;
    private JTextField textField_CustomerAddress;
    private JTextField textField_CustomerSocialSecurityNumber;
    private JTextField textField_CustomerLastname;
    private JTextField textField_CustomerFirstname;
    private JTextField textField_CustomerPhone;
    private JTextField textField_CustomerPostalCode;
    private JTextField textField_CustomerCity;
    private JTextField textField_CustomerEmail;
    private JLabel panelCustomerInfo;
    private JComboBox<Customer> comboBox_customerList;
    private JButton addNewCustomerButton;
    private JButton updateCustomerButton;
    private JButton deleteCustomerButton;
    private CustomerDAO customerDAO; // DAO instance

    /**
     * Constructor for CustomerPanel.
     * Initializes the panel components and sets up event listeners.
     */
    public CustomerPanel() {

        // initialising customerDAO instance
        customerDAO = new CustomerDAO();

        initializeComponents();

        List<Customer> customers = customerDAO.findAll();

        Collections.sort(customers, Comparator.comparing(Customer::getLastname));

        this.setVisible(true);

        add(panelCustomer);


        // adding customers to the JComboBox
        for (Customer customer : customers) {

            comboBox_customerList.addItem(customer);

        }

        comboBox_customerList.setSelectedIndex(-1);

        // adding a listener to show selected customer's details
        comboBox_customerList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Customer selectedCustomer = (Customer) comboBox_customerList.getSelectedItem();

                if (selectedCustomer != null) {

                    updateCustomerDetails(selectedCustomer);

                }

            }

        });

        addNewCustomerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Create and display the AddCustomerForm
                AddCustomerForm addCustomerForm = new AddCustomerForm(CustomerPanel.this);
                addCustomerForm.setVisible(true);

                // Reload customers list after adding a new customer
                reloadCustomers();

                clearCustomerDetails();

            }

        });

        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Retrieve the selected client from the JComboBox
                Customer selectedCustomer = (Customer) comboBox_customerList.getSelectedItem();

                if (selectedCustomer != null) {
                    int confirm = JOptionPane.showConfirmDialog(
                            CustomerPanel.this,
                            "Are you sure you want to delete this customer?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {

                        // delete customer by DAO
                        boolean isDeleted = customerDAO.delete(selectedCustomer);

                        if (isDeleted) {

                            JOptionPane.showMessageDialog(CustomerPanel.this, "Customer deleted successfully!");

                            // updating user UI
                            comboBox_customerList.removeItem(selectedCustomer);
                            reloadCustomers();
                            clearCustomerDetails();

                        } else {

                            JOptionPane.showMessageDialog(CustomerPanel.this, "Failed to delete customer.", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(CustomerPanel.this, "Please select a customer to delete.", "Warning", JOptionPane.WARNING_MESSAGE);

                }

            }

        });

        updateCustomerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Recovering data of the customer selected in the combobox
                Customer selectedCustomer = (Customer) comboBox_customerList.getSelectedItem();

                if (selectedCustomer != null) {

                    // updating entries of the customer with the new values of the input text fields
                    selectedCustomer.setFirstname(textField_CustomerFirstname.getText());
                    selectedCustomer.setLastname(textField_CustomerLastname.getText());
                    selectedCustomer.setAddress(textField_CustomerAddress.getText());
                    selectedCustomer.setEmail(textField_CustomerEmail.getText());
                    selectedCustomer.setCity(textField_CustomerCity.getText());
                    selectedCustomer.setPhoneNumber(textField_CustomerPhone.getText());
                    selectedCustomer.setPostalCode(textField_CustomerPostalCode.getText());
                    selectedCustomer.setSocialSecurityNumber(textField_CustomerSocialSecurityNumber.getText());

                    // calling the DAO update method
                    boolean isUpdated = customerDAO.update(selectedCustomer);

                    if (isUpdated) {

                        JOptionPane.showMessageDialog(CustomerPanel.this, "Customer updated successfully!");

                    } else {

                        JOptionPane.showMessageDialog(CustomerPanel.this, "Failed to update customer.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } else {

                    JOptionPane.showMessageDialog(CustomerPanel.this, "Please select a customer to update.", "Warning", JOptionPane.WARNING_MESSAGE);

                }

            }

        });

    }

    /**
     * Initializes UI components and performs any required setup.
     */
    private void initializeComponents() {

        // Erase borders for the JTextFields
        textField_CustomerSocialSecurityNumber.setBorder(null);

    }

    /**
     * Updates the customer details displayed in the text fields.
     *
     * @param customer The customer whose details are to be displayed.
     */
    private void updateCustomerDetails(Customer customer) {

        textField_CustomerFirstname.setText(customer.getFirstname());
        textField_CustomerLastname.setText(customer.getLastname());
        textField_CustomerAddress.setText(customer.getAddress());
        textField_CustomerEmail.setText(customer.getEmail());
        textField_CustomerCity.setText(customer.getCity());
        textField_CustomerPhone.setText(customer.getPhoneNumber());
        textField_CustomerPostalCode.setText(customer.getPostalCode());
        textField_CustomerSocialSecurityNumber.setText(customer.getSocialSecurityNumber());

    }

    /**
     * Clears the customer details from the text fields.
     */
    void clearCustomerDetails() {
        textField_CustomerFirstname.setText("");
        textField_CustomerLastname.setText("");
        textField_CustomerAddress.setText("");
        textField_CustomerEmail.setText("");
        textField_CustomerCity.setText("");
        textField_CustomerPhone.setText("");
        textField_CustomerPostalCode.setText("");
        textField_CustomerSocialSecurityNumber.setText("");
    }

    /**
     * Reloads the customer list in the JComboBox by fetching updated data from the database.
     */
    void reloadCustomers() {

        comboBox_customerList.removeAllItems();

        List<Customer> customers = customerDAO.findAll();

        Collections.sort(customers, Comparator.comparing(Customer::getLastname));

        for (Customer customer : customers) {

            comboBox_customerList.addItem(customer);

        }

        comboBox_customerList.setSelectedIndex(-1);

    }

}
