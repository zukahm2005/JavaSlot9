package session14;

import session14.controller.ControllerCustomers;
import session14.entity.Customers;
import session14.model.Model;
import session14.view.ViewCustomers;

import java.io.IOException;
import java.sql.SQLException;

public class Aplication {
    public static void main(String[] args) throws IOException, SQLException {
        Model<Customers> model=new Model<>();
        ControllerCustomers<Customers> controllerCustomers=new ControllerCustomers<>(model);
        ViewCustomers viewCustomers= new ViewCustomers(controllerCustomers);
        viewCustomers.run();

    }
}
