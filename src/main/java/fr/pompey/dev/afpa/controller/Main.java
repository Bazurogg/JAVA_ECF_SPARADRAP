package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.vue.MenuHome;

import java.net.ConnectException;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        BDDConnectionManager dbManager = new BDDConnectionManager();

        try (Connection connection = dbManager.getConnection()) {
            System.out.println("Successfully connected to the database !");

            Main main = new Main();

            main.selectFromCustomer(connection);

        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

        // Creating an MenuHome instance when the app launching
        new MenuHome(new PurchaseManager());



    }

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

}