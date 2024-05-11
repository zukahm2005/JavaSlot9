package session14.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import session14.dao.MySQLConnectionDB;
import session14.entity.Customers;
import session14.entity.Entity;
import session14.model.Model;

public class ControllerCustomers<T extends Entity<?>> {
    private Model<T> model;
    private Connection connection;

    public ControllerCustomers(Model<T> model) throws SQLException {
        this.model = model;
        this.connection= MySQLConnectionDB.getMySQLConnection();
    }



    public void addCustomer(Customers customer) {
        String sql = "INSERT INTO customers (customer_id,customer_name, customer_address, customer_phone, customer_email) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getEmail());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer added successfully!");
            } else {
                System.out.println("Failed to add customer.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addEntity((T) customer);
    }

    public Optional<T> findCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Tạo đối tượng khách hàng từ dữ liệu của ResultSet
                Customers customer = new Customers(
                        resultSet.getInt("customer_id"),
                        resultSet.getString("customer_name"),
                        resultSet.getString("customer_address"),
                        resultSet.getString("customer_phone"),
                        resultSet.getString("customer_email")
                );
                return Optional.of((T) customer); // Ép kiểu và trả về Optional
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty(); // Trả về Optional rỗng nếu không tìm thấy khách hàng
    }

    public List<T> getAllCustomers() {
        List<T> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Tạo đối tượng khách hàng từ dữ liệu của ResultSet
                Customers customer = new Customers(
                        resultSet.getInt("customer_id"),
                        resultSet.getString("customer_name"),
                        resultSet.getString("customer_address"),
                        resultSet.getString("customer_phone"),
                        resultSet.getString("customer_email")
                );
                customers.add((T) customer); // Thêm vào danh sách
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers; // Trả về danh sách khách hàng
    }

    public boolean updateCustomer(Customers updatedCustomer) {
        String sql = "UPDATE customers SET customer_name = ?, customer_address = ?, customer_phone = ?, customer_email = ? WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updatedCustomer.getName());
            statement.setString(2, updatedCustomer.getAddress());
            statement.setString(3, updatedCustomer.getPhone());
            statement.setString(4, updatedCustomer.getEmail());
            statement.setInt(5, updatedCustomer.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
