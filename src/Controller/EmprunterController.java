package Controller;

import Model.SqlConnector;
import View.EmprunterGUI;

public class EmprunterController {
    private EmprunterGUI view;
    private SqlConnector model;

    public EmprunterController(EmprunterGUI view, SqlConnector model) {
        this.view = view;
        this.model = model;


    }
}
