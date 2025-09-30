package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class SqlConnector {
    private ArrayList<Auteur> listAuteurs;
    private ArrayList<Livre> listLivres;
    private ArrayList<Adherant> listAdherants;
    private Connection conn;
    private String BDD;
    private String url;
    private String user;
    private String password;

    public SqlConnector() throws ClassNotFoundException, SQLException {
        /*
        Pour se connecter à la BDD Hostinger :
        String BDD = "u937355202_gravouil";
        String url = "jdbc:mysql://193.203.168.138:3306/"+BDD+"?characterEncoding=utf8";
        String user = "u937355202_gravouil";
        String password = "E6Ensitech2024";
        */

        BDD = "bdd_bibliothèque_ap2";
        url = "jdbc:mysql://localhost:3306/"+BDD;
        user = "root";
        password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);

        // Sélection des auteurs pour les mettres dans une arrayList
        listAuteurs = new ArrayList<Auteur>();
        Statement stmt1 = conn.createStatement();
        ResultSet r1 = stmt1.executeQuery("Select * from auteur");
        while (r1.next()) {
            listAuteurs.add(new Auteur(r1.getString(1), r1.getString(2), r1.getString(3),
                    r1.getString(4),  r1.getString(5)));
        }

        // Sélection des adhérants pour les mettres dans une arrayList
        listAdherants = new ArrayList<Adherant>();
        Statement stmt2 = conn.createStatement();
        ResultSet r2 = stmt2.executeQuery("Select * from adherant");
        while (r2.next()) {
            listAdherants.add(new Adherant(r2.getString(1), r2.getString(2), r2.getString(3),
                    r2.getString(4)));
        }

        // Sélection des livres pour les mettre dans une arrayList
        listLivres = new ArrayList<Livre>();
        Statement stmt3 = conn.createStatement();
        ResultSet r3 = stmt3.executeQuery("Select livre.*,adherant.identifiant,auteur.id from livre " +
                "join adherant on livre.adherant=adherant.identifiant join auteur on livre.auteur=auteur.id");
        while (r3.next()) {
            listLivres.add(new Livre(r3.getString(1), r3.getString(2), r3.getFloat(3),
                    r3.getString(4), r3.getString(5)));
        }

        // Ajoute les livres empruntés par l'adhérant dans adherant.listLivres
        for (Adherant adherant : listAdherants) {
            for  (Livre livre : listLivres) {
                if (Objects.equals(livre.getAdherantId(), adherant.getIdentifiant())){
                    ArrayList<Livre> tempList = adherant.getListLivres();
                    tempList.add(livre);
                    adherant.setListLivres(tempList);
                }
            }
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public ArrayList<Auteur> getListAuteurs() {
        return listAuteurs;
    }
    public void setListAuteurs(ArrayList<Auteur> listAuteurs) {
        this.listAuteurs = listAuteurs;
    }

    public ArrayList<Livre> getListLivres() {
        return listLivres;
    }
    public void setListLivres(ArrayList<Livre> listLivres) {
        this.listLivres = listLivres;
    }

    public ArrayList<Adherant> getListAdherants() {
        return listAdherants;
    }
    public void setListAdherants(ArrayList<Adherant> listAdherants) {
        this.listAdherants = listAdherants;
    }
}
