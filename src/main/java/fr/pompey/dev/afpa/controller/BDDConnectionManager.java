package fr.pompey.dev.afpa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BDDConnectionManager {

    private void getConnection() {

        final String PATHCONF = "conf.properties";

        Properties prop = new Properties();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(PATHCONF)) {

            prop.load(is);

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

        try {
            // Charger le driver
            Class.forName(prop.getProperty("jdbc.driver.class"));

            String url = prop.getProperty("jdbc.url");
            String user = prop.getProperty("jdbc.user");
            String password = prop.getProperty("jdbc.password");

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection established");

            connection.close();

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}
