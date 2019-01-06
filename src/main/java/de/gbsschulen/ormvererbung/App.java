package de.gbsschulen.ormvererbung;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    private static final String DB_NAME = "ormvererbung";

    public static void main(String[] args) {
        createDB();
        createData();
    }

    private static void createData() {
        Konto konto1 = new Konto();
        Konto konto2 = new Konto();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMVererbungPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(konto1);
        em.persist(konto2);

        em.getTransaction().commit();
        em.close();
        emf.close();
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
