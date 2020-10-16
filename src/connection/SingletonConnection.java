/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Sopheak
 */
public final class SingletonConnection {
    
    private final String HOST = "localhost";
    private final String DB_NAME="Demo";
    private final String PORT= "5432";
    private final String USER_NAME="postgres";
    private final String PASSWORD ="Root$";

    private static SingletonConnection instance = null;
    private Connection connectionServer;

    public SingletonConnection() {
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public void connectDatabase() throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        connectionServer = java.sql.DriverManager.getConnection("jdbc:postgresql://" + HOST+ "/" + DB_NAME, USER_NAME, PASSWORD);
    }

    public Connection openConnection() {
        return connectionServer;
    }

    public void closeConnection() throws SQLException {
        if (connectionServer != null) {
            connectionServer.close();
        }
    }

}
