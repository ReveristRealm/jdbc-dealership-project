package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.*;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;

        try
        {
            connection = dataSource.getConnection();

            String query4 = "INSERT INTO inventory(dealership_id, VIN) VALUES(?,?);";

            statement = connection.prepareStatement(query4);

            statement.setInt(1,dealershipId);

            statement.setString(2, vin);

            statement.executeUpdate();


        }catch(Exception e){
            System.out.println("Hi!");
        }
    }

    public void removeVehicleFromInventory(String vin) {
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;

        try
        {
            connection = dataSource.getConnection();

            String query2 = "DELETE FROM inventory WHERE vin LIKE '?'";

            statement = connection.prepareStatement(query2);

            statement.setString(1,vin);

            statement.executeUpdate();

        }catch(Exception e){
            System.out.println("Hi!");
        }
    }
}
