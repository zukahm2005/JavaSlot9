package test.controller;

import test.entity.Customers;
import test.entity.Entity;
import test.model.CustomerDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ControllerCustomers <T extends Entity<?>>{
    CustomerDAO customerDAO = new CustomerDAO();

    public ControllerCustomers() throws SQLException {
    }

    public void addCustomer(T customer) throws SQLException {
        customerDAO.addCustomer((Customers) customer);
    }
    public List<T> getAllCustomers() throws SQLException {
        return customerDAO.getAllCustomers();
    }
    public Optional findCustomerById(int id) throws SQLException {
        return customerDAO.findCustomerById(id);

    }
    public boolean updateCustomer(T customer) throws SQLException {
        customerDAO.updateCustomer((Customers) customer);
        return false;
    }
    public boolean deleteCustomer(int productId){
        return customerDAO.deleteCustomer(productId);
    }
}
