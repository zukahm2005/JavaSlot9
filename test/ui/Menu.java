package test.ui;

import test.controller.ControllerCustomers;
import test.entity.Customers;
import test.view.ViewCustomers;
import test.view.ViewProducts;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public int menu(){
        System.out.println("===Data Management===");
        System.out.println("1. Customers");
        System.out.println("2. Products");
        System.out.println("3. Orders");
        System.out.println("4. OrderDetails");
        System.out.println("0. Exit");
        System.out.println("Your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    public boolean start() throws SQLException {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    ControllerCustomers<Customers> controllerCustomers=new ControllerCustomers<>();
                    ViewCustomers viewCustomers= new ViewCustomers(controllerCustomers);
                    viewCustomers.run();
                    break;
                case 2:
                    ViewProducts viewProducts = new ViewProducts<>();
                    viewProducts.startProduct();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }
}
