package test.model;

import test.dao.DBConnection;
import test.entity.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO <T extends Products>{
    public final Connection connection = DBConnection.getDBConnection();
    private final String SQL_CREATE_PRODUCT = "INSERT INTO products (product_id, product_name, product_description, product_price, product_quantity) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_GET_ALL_PRODUCTS = "SELECT * FROM products";;
    private final String SQL_GET_PRODUCT_BY_ID = "SELECT * FROM products WHERE product_id = ?";
    private final String SQL_UPDATE_NAME_PRODUCT = "update products set product_name = ? where product_id = ?";
    private final String SQL_UPDATE_DESCRIPTION_PRODUCT = "update products set product_description = ? where product_id = ?";
    private final String SQL_UPDATE_PRICE_PRODUCT = "update products set product_price = ? where product_id = ?";
    private final String SQL_UPDATE_QUANTITY_PRODUCT = "update products set product_quantity = ? where product_id = ?";
    private final String SQL_DELETE_PRODUCT = "delete from products where product_id = ?";
    public ProductDAO() throws SQLException {
    }
    public void createProduct(T product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_CREATE_PRODUCT);
        pstm.setInt(1, product.getId());
        pstm.setString(2,product.getName());
        pstm.setString(3,product.getDescription());
        pstm.setDouble(4,product.getPrice());
        pstm.setInt(5,product.getQuantity());
        pstm.executeUpdate();
        System.out.println("Create succesfully");
    }
    public List<T> getAllProducts() throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_GET_ALL_PRODUCTS);
        List<T> allProduct = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            int product_id = rs.getInt("product_id");
            String product_name = rs.getString("product_name");
            String product_description = rs.getString("product_description");
            double product_price = rs.getDouble("product_price");
            int product_quantity = rs.getInt("product_quantity");

            System.out.println("\nID: " + product_id);
            System.out.println("Name: " + product_name);
            System.out.println("Description: " + product_description);
            System.out.println("Price: " + product_price);
            System.out.println("Quantity: " + product_quantity);
            System.out.println("--------------------");
        }
        return allProduct;
    }

    public Products getProductById(int productId) throws SQLException {

        PreparedStatement pstm = connection.prepareStatement(SQL_GET_PRODUCT_BY_ID);
        pstm.setInt(1, Integer.valueOf(productId)); // Assuming productId is a String
        try (ResultSet rs = pstm.executeQuery()) {
            boolean found = false;
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String product_description = rs.getString("product_description");
                double product_price = rs.getDouble("product_price");
                int product_quantity = rs.getInt("product_quantity");

                System.out.println("\nID: " + product_id);
                System.out.println("Name: " + product_name);
                System.out.println("Description: " + product_description);
                System.out.println("Price: " + product_price);
                System.out.println("Quantity: " + product_quantity);
            }
            if (!found) {
                System.out.println("Product with ID " + productId + " was not found");
            }
        }
        return null;
    }
    public void updateNameProduct(T product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_UPDATE_NAME_PRODUCT);
        pstm.setInt(1, product.getId());
        pstm.setString(2, product.getName());
        pstm.executeUpdate();
    }

    public void updateDescriptionProduct(T product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_UPDATE_DESCRIPTION_PRODUCT);
        pstm.setInt(1, product.getId());
        pstm.setString(2, product.getDescription());
        pstm.executeUpdate();
    }

    public void updatePriceProduct(T product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_UPDATE_PRICE_PRODUCT);
        pstm.setInt(1, product.getId());
        pstm.setDouble(2, product.getPrice());
        pstm.executeUpdate();
    }

    public void updateQuantityProduct(T product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_UPDATE_QUANTITY_PRODUCT);
        pstm.setInt(1, product.getId());
        pstm.setInt(2, product.getQuantity());
        pstm.executeUpdate();
    }
    public boolean deleteProduct(int productId){
        try {
            PreparedStatement pstm = connection.prepareStatement(SQL_DELETE_PRODUCT);
            pstm.setInt(1, productId);
            int deleted = pstm.executeUpdate();
            if (deleted == 0) {
                System.out.println("No rows deleted. Person with ID " + productId + " not found.");
            } else {
                System.out.println("Person with ID " + productId + " deleted successfully.");
            }
            pstm.close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return false;
    }
}
