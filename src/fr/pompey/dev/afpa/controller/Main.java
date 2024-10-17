package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.vue.MenuHome;

public class Main {

    public static void main(String[] args) {

        // Creating an MenuHome instance when the app launching
        new MenuHome(new PurchaseManager());

    }

}