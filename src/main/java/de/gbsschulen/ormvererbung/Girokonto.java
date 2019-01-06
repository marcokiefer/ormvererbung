package de.gbsschulen.ormvererbung;

import javax.persistence.Entity;

@Entity
public class Girokonto extends Konto{
    private double dispo;

    public double getDispo() {
        return dispo;
    }

    public void setDispo(double dispo) {
        this.dispo = dispo;
    }
}
