package fr.pompey.dev.afpa.controller;

import DAO.CustomerDAO;
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
//        initializeCustomers();
    }

    /**
     * Initializes a list of customers with pre-defined values.
     */
//    private void initializeCustomers() {
//        customers.add(new Customer("Alice", "Dupont", "123 Rue de Paris", "75001", "Paris", "0600000001", "alice.dupont@mail.com", "1234567890123", LocalDate.of(1985, 3, 12)));
//        customers.add(new Customer("Bob", "Martin", "456 Rue de Lyon", "69001", "Lyon", "0600000002", "bob.martin@mail.com", "9876543210987", LocalDate.of(1978, 7, 4)));
//        customers.add(new Customer("Clara", "Durand", "789 Avenue de Nice", "06000", "Nice", "0600000003", "clara.durand@mail.com", "1234598765432", LocalDate.of(1990, 11, 24)));
//        customers.add(new Customer("David", "Moreau", "101 Boulevard Saint-Germain", "75005", "Paris", "0600000004", "david.moreau@mail.com", "9988776655443", LocalDate.of(1969, 6, 1)));
//        customers.add(new Customer("Eva", "Lopez", "202 Rue de Bordeaux", "33000", "Bordeaux", "0600000005", "eva.lopez@mail.com", "1122334455667", LocalDate.of(1995, 1, 15)));
//        customers.add(new Customer("Fabrice", "Garnier", "10 Rue des Fleurs", "75012", "Paris", "0600000006", "fabrice.garnier@mail.com", "9988771122334", LocalDate.of(1982, 8, 19)));
//        customers.add(new Customer("Géraldine", "Roche", "35 Rue Victor Hugo", "13001", "Marseille", "0600000007", "geraldine.roche@mail.com", "1112223334445", LocalDate.of(1988, 10, 7)));
//        customers.add(new Customer("Henri", "Lemoine", "50 Boulevard des Capucines", "34000", "Montpellier", "0600000008", "henri.lemoine@mail.com", "3334445556667", LocalDate.of(1970, 12, 29)));
//        customers.add(new Customer("Isabelle", "Morin", "12 Rue de la Liberté", "44000", "Nantes", "0600000009", "isabelle.morin@mail.com", "7778889991112", LocalDate.of(1993, 9, 5)));
//        customers.add(new Customer("Julien", "Bernard", "28 Rue Saint-Michel", "31000", "Toulouse", "0600000010", "julien.bernard@mail.com", "6665554443332", LocalDate.of(1984, 4, 22)));
//        customers.add(new Customer("Karine", "Perrin", "78 Avenue Jean Jaurès", "67000", "Strasbourg", "0600000011", "karine.perrin@mail.com", "5556667778889", LocalDate.of(1976, 11, 18)));
//        customers.add(new Customer("Louis", "Girard", "5 Rue Pasteur", "59000", "Lille", "0600000012", "louis.girard@mail.com", "4445556667773", LocalDate.of(1968, 7, 10)));
//        customers.add(new Customer("Marie", "Leclerc", "90 Rue des Acacias", "76000", "Rouen", "0600000013", "marie.leclerc@mail.com", "3332221110004", LocalDate.of(1980, 2, 16)));
//        customers.add(new Customer("Nicolas", "Fabre", "15 Boulevard des Anglais", "06300", "Nice", "0600000014", "nicolas.fabre@mail.com", "2221110009995", LocalDate.of(1992, 5, 30)));
//        customers.add(new Customer("Olivier", "Renaud", "25 Rue des Pyrénées", "64000", "Pau", "0600000015", "olivier.renaud@mail.com", "9998887776666", LocalDate.of(1987, 6, 25)));
//    }

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
