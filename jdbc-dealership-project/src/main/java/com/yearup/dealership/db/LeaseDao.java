package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract contract) {
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;

        try
        {
            connection = dataSource.getConnection();

            String query ="INSERT INTO lease_contracts (vin , lease_start, lease_end, monthly_payment) VALUES (?,?,?,?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, contract.getVin());

            statement.setString(2, String.valueOf(contract.getLeaseStart()));

            statement.setString(3, String.valueOf(contract.getLeaseEnd()));

            statement.setString(4, String.valueOf(contract.getMonthlyPayment()));

            statement.executeUpdate();


        }catch(Exception e){
            System.out.println("Hi");
        }
    }
}
