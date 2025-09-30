package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnector {
    public SqlConnector() throws ClassNotFoundException, SQLException {
        /*
        Pour se connecter à la BDD Hostinger :
        String BDD = "u937355202_gravouil";
        String url = "jdbc:mysql://193.203.168.138:3306/"+BDD+"?characterEncoding=utf8";
        String user = "u937355202_gravouil";
        String password = "E6Ensitech2024";
        */

        String BDD = "bdd_bibliothèque_ap2";
        String url = "jdbc:mysql://localhost:3306/"+BDD;
        String user = "root";
        String password = "";

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
    }
}
