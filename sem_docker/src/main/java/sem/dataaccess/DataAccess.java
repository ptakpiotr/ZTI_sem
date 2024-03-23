package sem.dataaccess;

import sem.models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    public List<Car> GetCars() {
        List<Car> cars = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            String hostname = System.getenv("DB_HOSTNAME");
            String username = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");
            String url = String.format("jdbc:postgresql://%s:5432/%s", hostname, username);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT Id, Make, Model FROM public.cars";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("Id");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                Car car = new Car(id, make, model);

                cars.add(car);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cars;
    }

    public void AddCar(Car car) {
        try {
            Class.forName("org.postgresql.Driver");
            String hostname = System.getenv("DB_HOSTNAME");
            String username = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");
            String url = String.format("jdbc:postgresql://%s:5432/%s", hostname, username);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            try {
                var prestmt = conn.prepareStatement("INSERT INTO cars (Make, Model) VALUES (?,?)");
                prestmt.setString(1, car.getMake());
                prestmt.setString(2, car.getModel());
                prestmt.execute();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return;
    }
}
