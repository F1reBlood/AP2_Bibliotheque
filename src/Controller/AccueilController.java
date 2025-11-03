package Controller;

import Model.SqlConnector;
import View.AccueilGUI;
import View.CatalogueGUI;
import View.EmprunterGUI;

import java.sql.SQLException;

public class AccueilController {
    private AccueilGUI view;
    private SqlConnector model;
    public AccueilController(AccueilGUI view, SqlConnector model) {
        this.view = view;
        this.model = model;

        view.getBtnEmprunter().addActionListener(e -> {
            new EmprunterGUI();
            view.getFrame().dispose();
        });
        view.getBtnCatalogue().addActionListener(e -> {
            try {
                new CatalogueController(new CatalogueGUI(), new SqlConnector());
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            view.getFrame().dispose();
        });
    }
}
