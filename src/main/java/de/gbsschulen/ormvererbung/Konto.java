package de.gbsschulen.ormvererbung;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // default: 1 Tabelle
//@Inheritance(strategy = InheritanceType.JOINED) // 3 Tabellen
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 2 Tabellen
public abstract class Konto {
    @Id
    private String id;
    private double kontostand;

    public Konto(String id, double kontostand) {
        this.id = id;
        this.kontostand = kontostand;
    }

    public Konto() {
        this(UUID.randomUUID().toString(), 0.0);
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }
}
