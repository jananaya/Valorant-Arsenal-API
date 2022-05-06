package schema;

import collections.Arsenal;
import domain.entity.Weapon;
import domain.interfaces.IWeapon;
import domain.interfaces.IArsenal;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private static Database instance;

    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/valorant_arsenal",
                    "root",
                    ""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            return new Database();
        }

        return instance;
    }

    public IArsenal read() {
        try {
            IArsenal arsenal = new Arsenal();

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM weapons");

            while (rs.next()) {
                String name = rs.getString(1);
                arsenal.insert(readByName(name));
            }
            return arsenal;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public IWeapon readByName(String name) {
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM weapons WHERE name=\'"+name+"\'");

            rs.next();

            int categoryId = rs.getInt(2);
            String imagePath = rs.getString(3);

            rs = stmt.executeQuery("SELECT categoryName from category WHERE id="+categoryId);
            rs.next();

            String category = rs.getString(1);

            rs = stmt.executeQuery("SELECT characteristic from specs WHERE weaponName=\'"+name+"\'");

            ArrayList<String> specs = new ArrayList<>();

            while (rs.next())
                specs.add(rs.getString(1));

            return new Weapon(name, category, specs, imagePath, 0, 0, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void finalize() throws Throwable {
        this.connection.close();
    }
}
