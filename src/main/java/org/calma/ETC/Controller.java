package org.calma.ETC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Departement> departement;
    @FXML private TextField identification;
    private String valueIdent;

    @FXML private TextField prenom;
    private String prenomValue = "";

    @FXML private TextField nom;
    private String nomValue = "";

    @FXML private DatePicker date;
    private String naissance = "";

    @FXML private TextField courriel;
    private String valueCourriel;
    private boolean verifCourriel;

    @FXML private ImageView image;
    @FXML private ListView inclus;
    private String valInclus = "";
    @FXML private ListView exclus;
    @FXML private Button include;
    @FXML private Button exclude;
    @FXML private Button validation;

    public void initialize(){
        validation.setDisable(true);
        departement = new ArrayList<>();
        departement.add(new Departement(0, "Administration"));
        departement.add(new Departement(1, "Ressources humaine"));
        departement.add(new Departement(2, "Marketing"));
        departement.add(new Departement(3, "Logistique"));
        inclus.getItems().addAll(departement);
    }

    @FXML
    public void fullName(KeyEvent e) {
        if (e.getSource() == prenom) {
            if (prenom.getText().length() >= 3) prenomValue = prenom.getText().substring(0, 3).toLowerCase();
            else prenomValue = "";
        }
        if (e.getSource() == nom) {
            if (nom.getText().length() >= 3) nomValue = nom.getText().substring(0, 3).toLowerCase();
            else nomValue = "";
        }
        setIdentification();
    }
    @FXML
    public void date(ActionEvent e) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yy");
        naissance = date.getValue().format(formatter);
        setIdentification();
    }
    @FXML
    public void verifCourriel(KeyEvent e) {
        if(courriel.getText().contains("@") && courriel.getText().contains(".")){
            Image newImage = new Image(getClass().getResourceAsStream("images/email_valid.png"));
            image.setImage(newImage);
            verifCourriel = true;
            activacteButton();
        } else verifCourriel = false;

    }
    @FXML
    public void switchSide(ActionEvent e) {
        if(e.getSource() == include){
            if(exclus.getSelectionModel().getSelectedItem() != null){
                inclus.getItems().add(exclus.getSelectionModel().getSelectedItem());
                exclus.getItems().remove(exclus.getSelectionModel().getSelectedIndex());
            }

        }
        if(e.getSource() == exclude){
            if(inclus.getSelectionModel().getSelectedItem() != null) {
                exclus.getItems().add(inclus.getSelectionModel().getSelectedItem());
                inclus.getItems().remove(inclus.getSelectionModel().getSelectedIndex());
            }
        }
    }

    private void setIdentification(){
        valueIdent = nomValue + "-" + prenomValue + "-" + naissance;
        identification.setText(valueIdent);
    }

    private void activacteButton(){

    }

}
