package Controller;

import Model.SqlConnector;
import View.AccueilGUI;

import java.sql.SQLException;

public class MainController {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlConnector model = new SqlConnector();
        AccueilGUI view = new AccueilGUI();

        
    }
}
