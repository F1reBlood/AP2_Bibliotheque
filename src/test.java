import Model.Adherant;
import Model.Auteur;
import Model.Livre;
import Model.SqlConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String BDD = "bdd_bibliothèque_ap2";
        String url = "jdbc:mysql://localhost:3306/"+BDD;
        String user = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        // Affichage des livres et de leurs informations
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("Select * from livre");
        while (results.next()) {
            System.out.println(results.getString(1) + " : " +  results.getString(2) + "; Prix : " +  results.getFloat(3)
            + "; adhérantId : " + results.getString(4) + "; AuteurId : " + results.getString(5));
        }

        // Insertion d'un livre de test
        Statement stmt2 = conn.createStatement();
        int maj = stmt2.executeUpdate("Insert into livre Values('test', 'test', 0.0, 'MBR-9F1A2B3C4D5E', 'AUT-111AAA222BBB')");

        // Sélection des auteurs pour les mettre dans une arrayList
        ArrayList<Auteur> auteurs = new ArrayList<Auteur>();
        Statement stmt3 = conn.createStatement();
        ResultSet results2 = stmt3.executeQuery("Select * from auteur");
        while (results2.next()) {
            Auteur auteur = new Auteur(results2.getString(1), results2.getString(2), results2.getString(3),
                    results2.getString(4),  results2.getString(5));
            auteurs.add(auteur);
        }

        // Sélection des livres pour les mettre dans une arrayList
        ArrayList<Livre> livres = new ArrayList<Livre>();
        Statement stmt4 = conn.createStatement();
        ResultSet r3 = stmt4.executeQuery("Select * from livre");
        while (r3.next()) {
            Livre livre = new Livre(r3.getString(1), r3.getString(2), r3.getFloat(3), null, null);
            livres.add(livre);
        }

        // Sélection des adhérants pour les mettre dans une arrayList
        ArrayList<Adherant> adherants = new ArrayList<Adherant>();
        Statement stmt5 = conn.createStatement();
        ResultSet r5 = stmt5.executeQuery("Select * from adherant");
        while (r5.next()) {
            Adherant adherant = new Adherant(r5.getString(1), r5.getString(2), r5.getString(3),
                    r5.getString(4), null);
            adherants.add(adherant);
        }
    }
}
