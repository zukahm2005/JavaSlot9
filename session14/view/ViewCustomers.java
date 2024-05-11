package session14.view;

import session14.controller.ControllerCustomers;
import session14.entity.Customers;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ViewCustomers {
    private ControllerCustomers controllerCustomers;
    private Scanner sc;
    public ViewCustomers(ControllerCustomers controllerCustomers){
        this.controllerCustomers=controllerCustomers;
        this.sc=new Scanner(System.in);
    }

    public ViewCustomers() {

    }


    public int displayMenu() {
        System.out.println("1. Add Customer");
        System.out.println("2. Find Customer by ID");
        System.out.println("3. Show All Customers");
        System.out.println("4. Update Customer");
        System.out.println("5. Delete Customer");
        System.out.println("0. Exit");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public void run() {
        while (true){
            int choice=displayMenu();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    findCustomerById();
                    break;
                case 3:
                    showAllCustomers();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    deleteCustomer();
                    break;
                default:throw new AssertionError();
            }
        }
    }


    private void addCustomer(){
        System.out.println("Enter customer details:");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Customers customer = new Customers(id, name, address, phone, email);
        controllerCustomers.addCustomer(customer);
        System.out.println("Customer added successfully!");
    }

    private void findCustomerById(){
        System.out.print("Enter customer ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Optional<Customers> optionalCustomer = controllerCustomers.findCustomerById(id);
        if (optionalCustomer.isPresent()) {
            System.out.println("Customer found:");
            displayCustomer(optionalCustomer.get());
        } else {
            System.out.println("Customer not found with ID: " + id);
        }
    }
    private void showAllCustomers(){
        List<Customers> customers = controllerCustomers.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("All customers:");
            for (Customers customer : customers) {
                displayCustomer(customer);
            }
        }
    }

    private void updateCustomer(){
        System.out.print("Enter customer ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        Optional<Customers> optionalCustomer = controllerCustomers.findCustomerById(id);
        if (optionalCustomer.isPresent()) {
            Customers existingCustomer = optionalCustomer.get();
            System.out.println("Enter new details for customer ID " + id + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Phone: ");
            String phone = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();

            existingCustomer.setName(name);
            existingCustomer.setAddress(address);
            existingCustomer.setPhone(phone);
            existingCustomer.setEmail(email);

            if (controllerCustomers.updateCustomer(existingCustomer)) {
                System.out.println("Customer updated successfully!");
            } else {
                System.out.println("Failed to update customer.");
            }
        } else {
            System.out.println("Customer not found with ID: " + id);
        }
    }

    private void deleteCustomer(){
        System.out.print("Enter customer ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        if (controllerCustomers.deleteCustomer(id)) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Failed to delete customer. Customer not found with ID: " + id);
        }
    }

    private void displayCustomer(Customers customer) {
        System.out.println("ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Email: " + customer.getEmail());
        System.out.println();
    }
}



