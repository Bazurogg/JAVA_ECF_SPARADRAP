package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.vue.MenuHome;

public class Main {

    public static void main(String[] args) {
        // Crée une instance de MenuHome pour lancer le menu principal
        new MenuHome(new PurchaseManager());

    }

}