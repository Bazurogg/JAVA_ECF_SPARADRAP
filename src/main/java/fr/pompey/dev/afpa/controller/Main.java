package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.vue.MenuHome;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        BDDConnectionManager dbManager = new BDDConnectionManager();

        try (Connection connection = dbManager.getConnection()) {
            System.out.println("Successfully connected to the database !");
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

        // Creating an MenuHome instance when the app launching
        new MenuHome(new PurchaseManager());

    }

}