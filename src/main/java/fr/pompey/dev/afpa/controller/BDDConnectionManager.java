package fr.pompey.dev.afpa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BDDConnectionManager {

    public Connection getConnection() {

        final String PATHCONF = "conf.properties";

        Properties prop = new Properties();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(PATHCONF)) {

            //statement if the conf.properties file is not found
            if (is == null) {

                throw new IOException("Config file not found : " + PATHCONF);

            }

            prop.load(is);

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

        // connection test procedure
        try {
            // Driver loading
            Class.forName(prop.getProperty("jdbc.driver.class"));


            String url = prop.getProperty("jdbc.url");
            String user = prop.getProperty("jdbc.user");
            String password = prop.getProperty("jdbc.password");

            System.out.println("Connection established");

            return DriverManager.getConnection(url, user, password);


        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}
