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

        System.out.println("Successfully connected to the database !");

        CustomerDAO customerDAO = new CustomerDAO();

        new MenuHome(new PurchaseManager());

    }

}