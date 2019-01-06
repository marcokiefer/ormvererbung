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
        createDB();
        createEM();
        createData();
        getData();
    }

    private static void createEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMVererbungPU");
        em = emf.createEntityManager();
    }

    private static void getData() {
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT Konto FROM Konto konto"); // JPQL
        List<Konto> list = query.getResultList();
        for (Konto konto : list) {
            if(konto.getClass().equals(Sparkonto.class))
            System.out.println(konto.getKontostand());
         }

        em.getTransaction().commit();
    }

    private static void createData() {
                Sparkonto sparkonto1 = new Sparkonto();
        Sparkonto sparkonto2 = new Sparkonto();
        Girokonto girokonto1 = new Girokonto();
        Girokonto girokonto2 = new Girokonto();

        em.getTransaction().begin();


        em.persist(sparkonto1);
        em.persist(sparkonto2);
        em.persist(girokonto1);
        em.persist(girokonto2);

        em.getTransaction().commit();
    }

    private static void createDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/", DB_USER, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DROP DATABASE IF EXISTS " + DB_NAME);
            stmt.executeUpdate("CREATE DATABASE " + DB_NAME);

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
