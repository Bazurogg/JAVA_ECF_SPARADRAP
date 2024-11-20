package fr.pompey.dev.afpa.controller;

import DAO.CustomerDAO;
import fr.pompey.dev.afpa.model.Customer;
import fr.pompey.dev.afpa.vue.MenuHome;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        BDDConnectionManager dbManager = new BDDConnectionManager();

        try  {

            Connection connection = dbManager.getInstanceDB();

            System.out.println("Successfully connected to the database !");

            // --------------------------------------------------- ( TEST JDBC ) ---------------------------------------------------
            // ------------------------------------------------- ( Customer List ) -------------------------------------------------
            //Main main = new Main();
            //main.selectFromCustomer(connection);
            // --------------------------------------------------- ( TEST JDBC ) ---------------------------------------------------
            // ------------------------------------------------- ( Customer List ) -------------------------------------------------

        CustomerDAO customerDAO = new CustomerDAO();

        Customer customer = customerDAO.find(1); // Trouver le client avec l'ID 1

        if (customer != null) {
            System.out.println("Customer found:");
            System.out.println("Firstname: " + customer.getFirstname());
            System.out.println("Lastname: " + customer.getLastname());
            // Afficher d'autres informations si nécessaire
        } else {
            System.out.println("Customer not found.");
        }

        } catch (Exception e) {

            System.err.println("Error : " + e.getMessage());

        }

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