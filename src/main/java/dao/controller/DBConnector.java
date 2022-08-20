package dao.controller;

import dao.env.Environment;

import javax.swing.*;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DBConnector {
    static private Connection connection;
    private static final Properties prop = new Properties();

    final static Logger logger = Logger.getLogger(FileReader.class);

    static {
        prop.setProperty("user", Environment.USERNAME.getEnvironmentValue());
        prop.setProperty("password", Environment.PASSWORD.getEnvironmentValue());
        prop.setProperty("create", "true");
    }

    public static Connection getConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(Environment.DB_URL.getEnvironmentValue(),
                    prop
            );
            logger.info("Connect to database was successful!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Connect to database not successful!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            logger.error(e);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        return connection;
    }
}