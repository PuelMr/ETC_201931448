package org.calma.ETC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    //model
    private Model model;
    @FXML private TextField identification;
    @FXML private TextField prenom;
    @FXML private TextField nom;
    @FXML private DatePicker date;
    @FXML private TextField courriel;
    @FXML private ImageView image;
    @FXML private ListView inclus;
    @FXML private ListView exclus;
    @FXML private Button include;
    @FXML private Button exclude;
    @FXML private Button validation;

    public void initialize(){
        model = new Model();
        validation.setDisable(true);
        model.addDepartement(new Departement(0, "Administration"));
        model.addDepartement(new Departement(1, "Ressources humaine"));
        model.addDepartement(new Departement(2, "Marketing"));
        model.addDepartement(new Departement(3, "Logistique"));
        inclus.getItems().addAll(model.getDepartement());
    }

    @FXML
    public void fullName(KeyEvent e) {
        if (e.getSource() == prenom) {
            if (prenom.getText().length() >= 3) {
                model.setPrenom(prenom.getText().substring(0, 3).toLowerCase());
                model.setVerifPrenom(true);
            } else {
                model.setPrenom("");
                model.setVerifPrenom(false);
            }
        }
        if (e.getSource() == nom) {
            if (nom.getText().length() >= 3) {
                model.setNom(nom.getText().substring(0, 3).toLowerCase());
                model.setVerifNom(true);
            } else {
                model.setNom("");
                model.setVerifNom(false);
            }
        }
        activateButton();
        setIdentification();
    }
    @FXML
    public void date(ActionEvent e) {
        model.setNaissance(date);
        setIdentification();
    }
    @FXML
    public void verifCourriel(KeyEvent e) {
        if(courriel.getText().contains("@") && courriel.getText().contains(".")){
            model.setVerifCourriel(true);
            activateButton();
        } else model.setVerifCourriel(false);
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
    @FXML
    public void validation(MouseEvent e) {
        System.out.println("Identification : " + identification.getText() +
                "\n Prenom : " + prenom.getText() +
                "\n Nom : " + nom.getText() +
                "\n Date de naissance : " + date.getValue() +
                "\n Courriel : " + courriel.getText());
    }

    private void setIdentification(){
        model.setValueIdent();
        identification.setText(model.getValueIdent());
    }

    private void activateButton(){
        if(model.isVerifPrenom() && model.isVerifNom() && model.isVerifCourriel()){
            validation.setDisable(false);
        } else validation.setDisable(true);
    }

}
