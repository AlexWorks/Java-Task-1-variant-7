package ua.kpi.tef.controller.service;
import com.mysql.jdbc.Driver;
import ua.kpi.tef.controller.AmmunitionFactory;
import ua.kpi.tef.controller.enums.AmmunitionType;
import ua.kpi.tef.model.entities.ammunition.Ammunition;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class DBAmmunitionService implements AmmunitionService {
    private static String URL = "jdbc:mysql://localhost:3306/ammunition";
    private static String USERNAME = "root";
    private static String PASSWORD = "lololo123";

    private Connection connection;
    private String getAllStatement = "SELECT name, weight, price, type FROM ammunition WHERE 1";
    private PreparedStatement getAll;

    public DBAmmunitionService() throws Exception {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if (connection.isClosed()) {
            throw new RuntimeException("Can't connect to the Database");
        }
        getAll = connection.prepareStatement(getAllStatement);
    }

    @Override
    public ArrayList<Ammunition> getAllAmmunition() throws Exception {
        ResultSet result = getAll.executeQuery();
        ArrayList<Ammunition> ammunition = new ArrayList<>();
        while ( result.next()) {
            String name = result.getString("name");
            double weight = result.getDouble("weight");
            int price = result.getInt("price");
            String type = result.getString("type");
            AmmunitionType ammunitionType = AmmunitionType.getType(type);
            AmmunitionFactory factory = new AmmunitionFactory();
            ammunition.add(factory.createAmmunition(ammunitionType, name, price, weight));
        }
        Collections.sort(ammunition);
        return ammunition;
    }
}
