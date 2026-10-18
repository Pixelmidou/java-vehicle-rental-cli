package Java_Uni.Projet.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Location {
    private LocalDate datedeb;
    private LocalDate datefin;
    private double montantTotal;
    private Client client;
    private Vehicule vehicule;
    private String vehiculeid;
    private String clientid;

    public Location(LocalDate datedeb, LocalDate datefin, Client client, Vehicule vehicule) {
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.montantTotal = calculerMontant(vehicule.getPrix());
        this.client = client;
        this.vehicule = vehicule;
    }

    public Location(LocalDate datedeb, LocalDate datefin, double montantTotal , String clientid, String vehiculeid) {
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.montantTotal = montantTotal;
        this.clientid = clientid;
        this.vehiculeid = vehiculeid;
    }

    private double calculerMontant(double prixJour) {
        long jours = ChronoUnit.DAYS.between(datedeb, datefin) + 1;
        return jours * prixJour;
    }

    public String getDatedeb() {
        return String.valueOf(datedeb);
    }

    public void setDatedeb(LocalDate datedeb) {
        this.datedeb = datedeb;
        montantTotal = calculerMontant(vehicule.getPrix());
    }

    public String getDatefin() {
        return String.valueOf(datefin);
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
        montantTotal = calculerMontant(vehicule.getPrix());
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return "Location{" +
                "datedeb=" + datedeb +
                ", datefin=" + datefin +
                ", montantTotal=" + montantTotal +
                ", client=" + client +
                ", vehicule=" + vehicule +
                '}';
    }
}
