package fr.pompey.dev.afpa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The type Bdd connection manager.
 */
public class BDDConnectionManager {

    private static boolean firstConnectionLog = false;
    private static final Properties prop = new Properties();
    private static Connection connection;

    /**
     * The Pathconf.
     */
    final String PATHCONF = "conf.properties";

    /**
     * Initialize connection.
     */
    public void initializeConnection() {

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

            // driver loading
            Class.forName(prop.getProperty("jdbc.driver.class"));

            // recovering parameters for the connection
            String url = prop.getProperty("jdbc.url");
            String user = prop.getProperty("jdbc.user");
            String password = prop.getProperty("jdbc.password");

            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

    /**
     * Gets instance db.
     *
     * @return the instance db
     */
    public static Connection getInstanceDB() {

        if (connection == null) {

            BDDConnectionManager dbManager = new BDDConnectionManager();

            dbManager.initializeConnection();

            System.out.println("New connection established");
        }

            // prevents spam connection log when repeated button click
        else if (!firstConnectionLog) {

                if (System.getProperty("debug.connection") != null) {

                    System.out.println("Using existing connection");

                }

            firstConnectionLog = true;

        }

        return connection;

    }

    /**
     * Close connection.
     */
    public static void closeConnection() {

        try{

            getConnection().close();

            System.out.println("Connection closed");

        }

        catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

    private static Connection getConnection(){

        return connection;

    }


}
