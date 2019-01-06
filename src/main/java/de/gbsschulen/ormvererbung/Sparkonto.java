package de.gbsschulen.ormvererbung;

import javax.persistence.*;

@Entity
public class Sparkonto extends  Konto{
    private double zinssatz;

    public Sparkonto(String id, double kontostand, double zinssatz) {
        super(id, kontostand);
        this.zinssatz = zinssatz;
    }

    public Sparkonto() {
        super();
        this.zinssatz = 0.0;
    }

    public double getZinssatz() {
        return zinssatz;
    }

    public void setZinssatz(double zinssatz) {
        this.zinssatz = zinssatz;
    }
}
