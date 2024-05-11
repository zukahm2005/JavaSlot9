package test.controller;

import test.entity.Products;
import test.model.ProductDAO;

import java.sql.SQLException;
import java.util.List;

public class ControllerProducts <T extends Products>{
    ProductDAO productDAO = new ProductDAO<>();

    public ControllerProducts() throws SQLException {
    }

    public void createProductController(T product) throws SQLException {
        productDAO.createProduct(product);
    }
    public List<T> getAllProductsController() throws SQLException {
        return productDAO.getAllProducts();
    }
    public List<T> getProductByIdController(int productId) throws SQLException {
        return (List<T>) productDAO.getProductById(productId);

    }
    public void updateNameProductController(T product) throws SQLException {
        productDAO.updateNameProduct(product);
    }
    public void updateDescriptionProductController(T product) throws SQLException {
        productDAO.updateDescriptionProduct(product);
    }
    public void updatePriceProductController(T product) throws SQLException {
        productDAO.updatePriceProduct(product);
    }
    public void updateQuantityProductController(T product) throws SQLException {
        productDAO.updateQuantityProduct(product);
    }
    public boolean deleteProductController(int productId){
        return productDAO.deleteProduct(productId);
    }
}
