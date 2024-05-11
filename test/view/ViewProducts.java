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
        System.out.println("4. Update product");
        System.out.println("5. Delete product");
        System.out.println("6. Back");
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
                    updateProduct();
                    break;
                case 5 :
                    deleteProductUI();
                    break;
                case 6:
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
    public void updateProduct() {
        System.out.print("Enter product ID to update : ");
        int productId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter name :");
        String newName = sc.nextLine();
        System.out.println("Enter description: ");
        String newDescription = sc.nextLine();
        System.out.println("Enter price: ");
        double newPrice = sc.nextDouble();
        System.out.println("Enter quantity: ");
        int newQuantity = sc.nextInt();
        Products product = new Products(productId, newName, newDescription, newPrice,newQuantity);
        try {
            controllerProducts.updateProductController(product);
            System.out.println("Product name updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating product name: " + e.getMessage());
        }
    }


}
