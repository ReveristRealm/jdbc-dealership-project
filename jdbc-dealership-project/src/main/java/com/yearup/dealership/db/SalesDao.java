package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.*;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract contract) {
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;

        try
        {
            connection = dataSource.getConnection();

            String query = "INSERT INTO sales_contracts (vin, sale_date, price) VALUES(?,?,?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, contract.getVin());

            statement.setDate(2, Date.valueOf(contract.getSaleDate()));

            statement.setString(3, String.valueOf(contract.getPrice()));

            statement.executeUpdate();


        }catch(Exception e){
            System.out.println("Hi!");
        }
    }
}
