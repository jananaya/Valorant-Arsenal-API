package schema;

import collections.Arsenal;
import collections.interfaces.IArsenal;
import domain.entity.Weapon;
import domain.interfaces.IWeapon;

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
            ResultSet rs = stmt.executeQuery("SELECT name FROM weapon");

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM weapon WHERE name=\'"+name+"\'");

            rs.next();

            int id = rs.getInt(1);
            int categoryId = rs.getInt(3);
            String imagePath = rs.getString(4);
            float rateOfFire = rs.getFloat(5);
            int damage = rs.getInt(6);
            float rating = rs.getFloat(7);

            rs = stmt.executeQuery("SELECT categoryName from category WHERE id="+categoryId);
            rs.next();

            String category = rs.getString(1);

            rs = stmt.executeQuery("SELECT spec from spec WHERE weaponId="+id);

            ArrayList<String> specs = new ArrayList<>();

            while (rs.next())
                specs.add(rs.getString(1));

            return new Weapon(id, name, category, specs, imagePath, rateOfFire, damage, rating);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void finalize() throws Throwable {
        this.connection.close();
    }
}
