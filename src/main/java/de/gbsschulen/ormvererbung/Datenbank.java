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

public class Datenbank {
    private String datenbank;
    private String user;
    private String password;
    private EntityManager em;

    public Datenbank(String datenbank, String user, String password) {
        this.datenbank = datenbank;
        this.user = user;
        this.password = password;
    }


    public void datenbankLoeschen() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/", user, password);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DROP DATABASE IF EXISTS " + datenbank);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void datenbankErstellen() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/", user, password);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE DATABASE " + datenbank);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMVererbungPU");
        em = emf.createEntityManager();
    }

    public void speichern(Konto konto) {
        em.getTransaction().begin();
        em.persist(konto);
        em.getTransaction().commit();
    }

    public List<Konto> getDaten() {
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT Konto FROM Konto konto"); // JPQL
        List<Konto> list = query.getResultList();  
        em.getTransaction().commit();
        return list;
    }
}
