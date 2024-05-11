package test.view;

import test.controller.ControllerProducts;
import test.entity.Products;
import test.ui.Menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewProducts<T extends Products> {
    Scanner sc = new Scanner(System.in);
    ControllerProducts controllerProducts = new ControllerProducts();

    public ViewProducts() throws SQLException {
    }

    public int menuProducts(){
        System.out.println("===Products Management===");
        System.out.println("1. Create product");
        System.out.println("2. Show all products");
        System.out.println("3. Find product by id");
        System.out.println("4. Update name product");
        System.out.println("5. Update description product");
        System.out.println("6. Update price product");
        System.out.println("7. Update quantity product");
        System.out.println("8. Delete product");
        System.out.println("9. Back");
        System.out.println("Your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    public boolean startProduct() throws SQLException {
        while (true){
            int choice = menuProducts();
            switch (choice){
                case 1:
                    createProductUi();
                    break;
                case 2:
                    getAllProducts();
                    break;
                case 3:
                    getProductByIdUI();
                    break;
                case 4:
                    updateNameProduct();
                    break;
                case 5 :
                    updateDescriptionProduct();
                    break;
                case 6:
                    updatePriceProduct();
                    break;
                case 7:
                    updateQuantityProduct();
                    break;
                case 8:
                    deleteProductUI();
                    break;
                case 9:
                    Menu menu = new Menu();
                    menu.start();
                    break;
            }
        }
    }
    public void createProductUi() throws SQLException {
        System.out.println("Enter id: ");
        int product_id = Integer.parseInt(sc.nextLine());

        System.out.println("Enter name: ");
        String product_name = sc.nextLine();

        System.out.println("Descripton: ");
        String product_desc = sc.nextLine();

        System.out.println("Price: ");
        double product_price = Double.parseDouble(sc.nextLine());

        System.out.println("Quantity: ");
        int product_quantity = Integer.parseInt(sc.nextLine());

        Products products = new Products(product_id,product_name,product_desc,product_price,product_quantity);
        controllerProducts.createProductController(products);
    }

    public void getAllProducts() throws SQLException {
        List<T> allProducts = controllerProducts.getAllProductsController();
        allProducts.forEach(product -> {
            System.out.println("===Product Information===");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
            System.out.println(product.getQuantity());
        });
    }
    public void getProductByIdUI() throws SQLException {
        ControllerProducts productbyid = new ControllerProducts();
        System.out.println("=== Product Contact by Id ===");
        System.out.print("Enter id to search: ");
        int productId = Integer.parseInt(sc.nextLine());

        try {
            productbyid.getProductByIdController(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProductUI() throws SQLException {
        System.out.println("Enter ID to delete: ");
        int prodId = Integer.parseInt(sc.nextLine());
        System.out.println("Are you sure? (y/n)");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            boolean delete = controllerProducts.deleteProductController(prodId);
            if (delete) {
                System.out.println("Person with ID " + prodId +" deleted successfully");
            } else {
                System.out.println("No rows deleted. Person with ID " + prodId + " not found");
            }
        } else if (confirm.equalsIgnoreCase("n")) {
            System.out.println("Deletion operation cancelled");
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'");
        }
    }
    public void updateNameProduct() {
        System.out.print("Enter product ID to update name: ");
        int productId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        Products product = new Products(productId, newName, null, 0.0,0);
        try {
            controllerProducts.updateNameProductController(product);
            System.out.println("Product name updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating product name: " + e.getMessage());
        }
    }

    public void updateDescriptionProduct() {
        System.out.print("Enter product ID to update description: ");
        int productId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new description: ");
        String newDescription = sc.nextLine();

        Products product = new Products(productId, null, newDescription, 0.0,0);
        try {
            controllerProducts.updateDescriptionProductController(product);
            System.out.println("Product description updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating product description: " + e.getMessage());
        }
    }

    public void updatePriceProduct() {
        System.out.print("Enter product ID to update price: ");
        int productId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new price: ");
        double newPrice = Double.parseDouble(sc.nextLine());

        Products product = new Products(productId, null, null, newPrice,0);
        try {
            controllerProducts.updatePriceProductController(product);
            System.out.println("Product price updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating product price: " + e.getMessage());
        }
    }
    public void updateQuantityProduct() {
        System.out.print("Enter product ID to update quantity: ");
        int productId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new quantity: ");
        int newQuantity = Integer.parseInt(sc.nextLine());

        Products product = new Products(productId, null, null, 0.0,newQuantity);
        try {
            controllerProducts.updateQuantityProductController(product);
            System.out.println("Product quantity updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating product quantity: " + e.getMessage());
        }
    }
}
