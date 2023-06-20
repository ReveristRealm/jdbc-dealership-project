package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try {
            String query3 = "INSERT INTO vehicles(VIN, make, model, year, SOLD, color, vehicleType, odometer, price) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?);";
            statement = connection.prepareStatement(query3,statement.RETURN_GENERATED_KEYS);

            statement.setString(1,vehicle.getVin());
            statement.setString(3,vehicle.getMake());
            statement.setString(4,vehicle.getModel());
            statement.setInt(2, vehicle.getYear());
            statement.setBoolean(2, vehicle.isSold());
            statement.setString(5,vehicle.getColor());
            statement.setString(2, vehicle.getVehicleType());
            statement.setInt(6, vehicle.getOdometer());
            statement.setDouble(7, vehicle.getPrice());

            statement.executeUpdate();

            ResultSet generatedKeys =statement.getGeneratedKeys();
            if(generatedKeys.next()){
                int key = generatedKeys.getInt(1);
                System.out.println("Generated ID: " + key );
            }

        }catch(Exception e){
            System.out.println("No");
        }
    }

    public void removeVehicle(String VIN) {
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try
        {
            String query = "DELETE FROM inventory WHERE vin LIKE ?;";

            statement = connection.prepareStatement(query);

            statement.setString(1,VIN);

            statement.executeUpdate();


            String query2 = "DELETE FROM vehicles WHERE vin LIKE '?'";

            statement = connection.prepareStatement(query2);

            statement.setString(1,VIN);

            statement.executeUpdate();
        }catch(Exception e){
            System.out.println("Hi");
        }
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> returnthis = new ArrayList<>();
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();

            String query = "SELECT * FROM vehicles WHERE price > ? AND price < ?;";

            statement = connection.prepareStatement(query);
            statement.setDouble(1,minPrice);
            statement.setDouble(2,maxPrice);

            results = statement.executeQuery();

            while(results.next()){
                String vin = results.getString("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");
                boolean sold = results.getBoolean("SOLD");
                String vehicleType = results.getString("vehicleType");

                Vehicle car = new Vehicle(vin,make,model,year,sold,color,vehicleType,odometer,price);
                returnthis.add(car);
            }

        }catch(Exception e){
            System.out.println("Hi");
        }
        return  returnthis;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> returnthis = new ArrayList<>();
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();

            String query = "SELECT * FROM vehicles WHERE make LIKE 'make' AND model LIKE 'model';";

            statement = connection.prepareStatement(query);
            statement.setString(1,make);
            statement.setString(2,model);

            results = statement.executeQuery();

            while(results.next()){
                String vin = results.getString("vin");
                int year = results.getInt("year");
                String makee = results.getString("make");
                String modell = results.getString("model");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");
                boolean sold = results.getBoolean("SOLD");
                String vehicleType = results.getString("vehicleType");

                Vehicle car = new Vehicle(vin,makee,modell,year,sold,color,vehicleType,odometer,price);
                returnthis.add(car);
            }

        }catch(Exception e){
            System.out.println("Hi");
        }
        return  returnthis;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        List<Vehicle> returnthis = new ArrayList<>();
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();

            String query = "SELECT * FROM vehicles WHERE year > ? AND year < ? ;";

            statement = connection.prepareStatement(query);
            statement.setInt(1,minYear);
            statement.setInt(2,maxYear);

            results = statement.executeQuery();

            while(results.next()){
                String vin = results.getString("vin");
                int year = results.getInt("yearr");
                String make = results.getString("make");
                String model = results.getString("model");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");
                boolean sold = results.getBoolean("SOLD");
                String vehicleType = results.getString("vehicleType");

                Vehicle car = new Vehicle(vin,make,model,year,sold,color,vehicleType,odometer,price);
                returnthis.add(car);
            }

        }catch(Exception e){
            System.out.println("Hi");
        }
        return  returnthis;
    }

    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> returnthis = new ArrayList<>();
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();

            String query = "SELECT * FROM vehicles WHERE color LIKE ?;";

            statement = connection.prepareStatement(query);
            statement.setString(1,color);

            results = statement.executeQuery();

            while(results.next()){
                String vin = results.getString("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String colorr = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");
                boolean sold = results.getBoolean("SOLD");
                String vehicleType = results.getString("vehicleType");

                Vehicle car = new Vehicle(vin,make,model,year,sold,colorr,vehicleType,odometer,price);
                returnthis.add(car);
            }

        }catch(Exception e){
            System.out.println("Hi");
        }
        return  returnthis;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        List<Vehicle> returnthis = new ArrayList<>();
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();

            String query = "SELECT * FROM vehicles WHERE odometer > ? AND odometer < ?;";

            statement = connection.prepareStatement(query);
            statement.setInt(1,minMileage);
            statement.setInt(2,maxMileage);

            results = statement.executeQuery();

            while(results.next()){
                String vin = results.getString("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");
                boolean sold = results.getBoolean("SOLD");
                String vehicleType = results.getString("vehicleType");

                Vehicle car = new Vehicle(vin,make,model,year,sold,color,vehicleType,odometer,price);
                returnthis.add(car);
            }

        }catch(Exception e){
            System.out.println("Hi");
        }
        return  returnthis;
    }

    public List<Vehicle> searchByType(String type) {
        List<Vehicle> returnthis = new ArrayList<>();
        Connection connection = null;
        ResultSet results = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();

            String query = "SELECT * FROM vehicles WHERE vehicleType LIKE ?;";

            statement = connection.prepareStatement(query);
            statement.setString(1,type);

            results = statement.executeQuery();

            while(results.next()){
                String vin = results.getString("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");
                boolean sold = results.getBoolean("SOLD");
                String vehicleType = results.getString("vehicleType");

                Vehicle car = new Vehicle(vin,make,model,year,sold,color,vehicleType,odometer,price);
                returnthis.add(car);
            }

        }catch(Exception e){
            System.out.println("Hi");
        }
        return  returnthis;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
