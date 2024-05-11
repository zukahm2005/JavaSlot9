package test;

import test.ui.Menu;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationClient {
    public static void main(String[] args) throws IOException, SQLException {
        Menu menu = new Menu();
        menu.start();
    }
}