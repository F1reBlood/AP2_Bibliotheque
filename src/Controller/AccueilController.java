package Controller;

import Model.SqlConnector;
import View.*;

import java.sql.SQLException;

public class AccueilController {
    private AccueilGUI view;
    private SqlConnector model;
    public AccueilController(AccueilGUI view, SqlConnector model){
        this.view = view;
        this.model = model;

        view.getBtnEmprunter().addActionListener(e -> {
            new EmprunterController(new EmprunterGUI(), model);
            view.getFrame().dispose();
        });
        view.getBtnCatalogue().addActionListener(e -> {
            new CatalogueController(new CatalogueGUI(), model);
            view.getFrame().dispose();
        });
        view.getBtnRestituer().addActionListener(e -> {
           new RestituerController(new RestituerGUI(), model);
           view.getFrame().dispose();
        });
        view.getBtnInformations().addActionListener(e -> {
            new InformationsController(new InformationsGUI(), model);
            view.getFrame().dispose();
        });
    }
}
