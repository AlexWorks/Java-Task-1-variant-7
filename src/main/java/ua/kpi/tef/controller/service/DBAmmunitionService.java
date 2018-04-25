package ua.kpi.tef.controller.service;
import com.mysql.jdbc.Driver;
import ua.kpi.tef.model.entities.ammunition.Ammunition;
import ua.kpi.tef.model.entities.ammunition.Shield;
import ua.kpi.tef.model.entities.ammunition.Weapon;
import ua.kpi.tef.model.entities.ammunition.armor.Boots;
import ua.kpi.tef.model.entities.ammunition.armor.Chestplate;
import ua.kpi.tef.model.entities.ammunition.armor.Helmet;
import ua.kpi.tef.model.entities.ammunition.armor.Leggins;

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
            int type = result.getInt("type");
            switch (type) {
                case 1:
                    ammunition.add(new Helmet(name, price, weight));
                    break;
                case 2:
                    ammunition.add(new Chestplate(name, price, weight));
                    break;
                case 3:
                    ammunition.add(new Leggins(name, price, weight));
                    break;
                case 4:
                    ammunition.add(new Boots(name, price, weight));
                    break;
                case 5:
                    ammunition.add(new Weapon(name, price, weight));
                    break;
                case 6:
                    ammunition.add(new Shield(name, price, weight));
                    break;
                default:
                    throw new RuntimeException("No such ammunition type");
            }
        }
        Collections.sort(ammunition);
        return ammunition;
    }
}
