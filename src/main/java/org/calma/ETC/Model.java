package org.calma.ETC;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Departement> departement;
    private String valueIdent;
    private String prenom;
    private boolean verifPrenom;
    private String nom;
    private boolean verifNom;
    private String naissance;
    private boolean verifCourriel;

    public Model() {
        this.departement = new ArrayList<>();
        this.prenom = "";
        this.verifPrenom = false;
        this.nom = "";
        this.verifNom = false;
        this.naissance = "";
        this.verifCourriel = false;
    }
    //departement
    public List<Departement> getDepartement() {
        return departement;
    }
    public void addDepartement(Departement departement){
        this.departement.add(departement);
    }
    //Identification
    public String getValueIdent() {
        return valueIdent;
    }
    public void setValueIdent() {
        this.valueIdent = nom + "-" + prenom + "-" + naissance;
    }
    //prenom
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public boolean isVerifPrenom() {
        return verifPrenom;
    }
    public void setVerifPrenom(boolean verifPrenom) {
        this.verifPrenom = verifPrenom;
    }
    //nom
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public boolean isVerifNom() {
        return verifNom;
    }
    public void setVerifNom(boolean verifNom) {
        this.verifNom = verifNom;
    }
    //naissance
    public String getNaissance() {
        return naissance;
    }
    public void setNaissance(DatePicker naissance) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yy");
        this.naissance = naissance.getValue().format(formatter);
    }
    //courriel
    public boolean isVerifCourriel() {
        return verifCourriel;
    }
    public void setVerifCourriel(boolean verifCourriel) {
        this.verifCourriel = verifCourriel;
    }
}