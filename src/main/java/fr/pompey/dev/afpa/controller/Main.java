package fr.pompey.dev.afpa.controller;

import DAO.CustomerDAO;
import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.vue.MenuHome;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BDDConnectionManager dbManager = new BDDConnectionManager();

        Connection connection = dbManager.getInstanceDB();

        System.out.println("Successfully connected to the database !");

        CustomerDAO customerDAO = new CustomerDAO();



        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ------------------------------ ( FIND ALL Customer ) ------------------------------------------------
        ArrayList<Customer> customers = customerDAO.findAll();

        if (!customers.isEmpty()) {
            System.out.println("Liste des clients :");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } else {
            System.out.println("Aucun client trouvé dans la base de données.");
        }
        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ------------------------------ ( FIND ALL Customer ) ------------------------------------------------


        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ------------------------------ ( DELETE Customer ) ------------------------------------------------
        // Recherche du client à supprimer
//        Customer customerToDelete = customerDAO.find(16);  // Remplacez 16 par l'ID que vous voulez supprimer
//
//        if (customerToDelete != null && customerToDelete.getId() != null) {
//            System.out.println("Customer ID before delete: " + customerToDelete.getId());
//
//            boolean success = customerDAO.delete(customerToDelete);
//
//            if (success) {
//                System.out.println("Client supprimé avec succès.");
//            } else {
//                System.out.println("Échec de la suppression. Le client n'existe peut-être pas.");
//            }
//        } else {
//            System.out.println("Client introuvable ou ID invalide !");
//        }
        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ------------------------------ ( DELETE Customer ) ------------------------------------------------




        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ---------------------------- ( FIND BY ID Customer ) ----------------------------------------------
//        ArrayList<Customer> customers = customerDAO.findAll();
//
//        for (Customer customer : customers) {
//
//            System.out.println(customer.getFirstname() + " " + customer.getLastname());
//
//        }
        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ---------------------------- ( FIND BY ID Customer ) ----------------------------------------------




        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ---------------------------- ( CREATE Customer ) ----------------------------------------------
//        Customer newCustomer = new Customer(
//                "Paul",
//                "Dupuis",
//                "12 Avenue de la République",
//                "75010",
//                "Paris",
//                "0601234567",
//                "paul.dupuis@mail.com",
//                "9876543210986",
//                LocalDate.of(1990, 1, 1)
//        );
//
//        // Appel à la méthode create
//        int newId = customerDAO.create(newCustomer);
//
//        // Affichage du résultat
//        if (newId > 0) {
//            System.out.println("Nouveau client créé avec succès, ID : " + newId);
//        } else {
//            System.out.println("Erreur lors de la création du client.");
//        }
        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ---------------------------- ( CREATE Customer ) ----------------------------------------------




//        try  {
//
//            Connection connection = dbManager.getInstanceDB();
//
//            System.out.println("Successfully connected to the database !");
//
//            // --------------------------------------------------- ( TEST JDBC ) ---------------------------------------------------
//            // ------------------------------------------------- ( Customer List ) -------------------------------------------------
//            //Main main = new Main();
//            //main.selectFromCustomer(connection);
//            // --------------------------------------------------- ( TEST JDBC ) ---------------------------------------------------
//            // ------------------------------------------------- ( Customer List ) -------------------------------------------------
//
//        CustomerDAO customerDAO = new CustomerDAO();
//
//        Customer customer = customerDAO.find(1); // test to found a customer with id
//
//        if (customer != null) {
//            System.out.println("Customer found.");
//            System.out.println("Firstname: " + customer.getFirstname());
//            System.out.println("Lastname: " + customer.getLastname());
//
//        } else {
//            System.out.println("Customer not found.");
//        }
//
//        } catch (Exception e) {
//
//            System.err.println("Error : " + e.getMessage());
//
//        }

        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ------------------------------ ( UPDATE Customer ) ------------------------------------------------
        // Find the customer you want to update
        Customer customerToUpdate = customerDAO.find(15); // Remplacez 16 par un ID existant

        if (customerToUpdate != null) {
            System.out.println("Customer before update: " + customerToUpdate.getFirstname() + " " + customerToUpdate.getLastname());

            // Modify some fields of the customer
            customerToUpdate.setFirstname("Matt");
            customerToUpdate.setLastname("House");
            customerToUpdate.setCity("Champigneules");

            // Attempt to update the customer
            boolean success = customerDAO.update(customerToUpdate);

            if (success) {
                System.out.println("Customer updated successfully!");
            } else {
                System.out.println("Failed to update customer.");
            }

            // Refetch to verify changes
            Customer updatedCustomer = customerDAO.find(15);
            System.out.println("Customer after update: " + updatedCustomer.getFirstname() + " " + updatedCustomer.getLastname());
        } else {
            System.out.println("Customer not found!");
        }
        // --------------------------------- ( TEST DAO  ) ---------------------------------------------------
        // ------------------------------ ( UPDATE Customer ) ------------------------------------------------


        // Creating an MenuHome instance when the app launching
        new MenuHome(new PurchaseManager());

    }

    // --------------------------------------------------- ( TEST JDBC ) ---------------------------------------------------
    // ------------------------------------------------- ( Customer List ) -------------------------------------------------

    private void selectFromCustomer(Connection connection) {

        String selectQuery = "select * from customer";

        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {

                System.out.println(resultSet.getString("cu_firstname"));
                System.out.println(resultSet.getString("cu_lastname"));
                System.out.println("---------------------------------------------");

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

    // --------------------------------------------------- ( TEST JDBC ) ---------------------------------------------------
    // ------------------------------------------------- ( Customer List ) -------------------------------------------------

}