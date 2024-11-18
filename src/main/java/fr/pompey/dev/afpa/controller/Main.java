package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.vue.MenuHome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

//        BDDConnectionManager dbManager = new BDDConnectionManager();
//
//        try (Connection connection = dbManager.getConnection()) {
//            System.out.println("Connexion réussie !");
//        } catch (Exception e) {
//            System.err.println("Erreur : " + e.getMessage());
//        }

        // Creating an MenuHome instance when the app launching
        new MenuHome(new PurchaseManager());

    }

}