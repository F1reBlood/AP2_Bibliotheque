package Controller;

import Model.SqlConnector;
import View.AccueilGUI;
import View.CatalogueGUI;

import java.sql.SQLException;

public class MainController {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlConnector model = new SqlConnector();
        CatalogueGUI view = new CatalogueGUI();

        
    }
}
