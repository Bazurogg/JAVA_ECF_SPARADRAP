package fr.pompey.dev.afpa.controller;

import DAO.CustomerDAO;
import fr.pompey.dev.afpa.exceptions.EmailAlreadyExistException;
import fr.pompey.dev.afpa.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerController is a class dedicated to managing the list of customers.
 */
public class CustomerController {

    /** The list of customers */
    private List<Customer> customers;

    /** Constructor to initialize the customer list */
    public CustomerController() {
        this.customers = new ArrayList<>();

    }

    /**
     * Returns the list of customers.
     *
     * @return the list of customers.
     */
    public List<Customer> getCustomers() {

        CustomerDAO customerDAO = new CustomerDAO();

        return customerDAO.findAll();

    }

    /**
     * Adds a customer to the list.
     *
     * @param customer The customer to add.
     */
    public void addCustomer(Customer customer) {

        customers.add(customer);

    }

    /**
     * Removes a customer from the list.
     *
     * @param customer The customer to remove.
     */
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    /**
     * Prints the list of customers to the console.
     */
    public void displayCustomers() {

        if (customers.isEmpty()) {

            System.out.println("No customers registered.");

        } else {

            System.out.println("List of customers:");

            for (Customer customer : customers) {

                System.out.println(customer.getFirstname() + " " + customer.getLastname() + " - Social Security Number: " + customer.getSocialSecurityNumber());

            }

        }

    }

}
