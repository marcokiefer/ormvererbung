package de.gbsschulen.ormvererbung;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Konto {
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
}
