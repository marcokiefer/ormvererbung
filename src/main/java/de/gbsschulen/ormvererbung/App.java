package de.gbsschulen.ormvererbung;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class App {
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    private static final String DB_NAME = "ormvererbung";

    private static EntityManager em;

    public static void main(String[] args) {
        Datenbank db = new Datenbank("ormvererbung", "root", "mysql");
        db.datenbankLoeschen();
        db.datenbankErstellen();
        db.createEM();

        Sparkonto sparkonto1 = new Sparkonto();
        Sparkonto sparkonto2 = new Sparkonto();
        Girokonto girokonto1 = new Girokonto();
        Girokonto girokonto2 = new Girokonto();

        db.speichern(sparkonto1);
        db.speichern(sparkonto2);
        db.speichern(girokonto1);
        db.speichern(girokonto2);

        sparkonto1.setZinssatz(0.3);
    }

}
