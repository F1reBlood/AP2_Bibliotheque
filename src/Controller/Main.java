package Controller;

import Model.SqlConnector;
import View.AccueilGUI;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new AccueilController(new AccueilGUI(), new SqlConnector());
    }
}
