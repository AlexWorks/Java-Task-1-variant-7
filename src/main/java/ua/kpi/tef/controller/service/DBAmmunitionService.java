package ua.kpi.tef.controller.service;
import com.mysql.jdbc.Driver;
import ua.kpi.tef.model.entities.ammunition.Ammunition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBAmmunitionService implements AmmunitionService {
    private static String URL = "jdbc:mysql://localhost:3306/ammunition";
    private static String USERNAME = "root";
    private static String PASSWORD = "lololo123";

    @Override
    public List<Ammunition> getAmmunition() {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connected to the database!");
                connection.close();
                System.out.println("Connection closed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
