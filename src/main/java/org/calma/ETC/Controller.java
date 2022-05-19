package org.calma.ETC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML private TextField identification;

    @FXML private TextField prenom;
    private String prenomValue;

    @FXML private TextField nom;
    private String nomValue;

    @FXML private DatePicker date;
    private String naissance;

    @FXML private TextField courriel;
    private String valueCourriel;

    @FXML private ImageView image;
    @FXML private TextArea inclus;
    @FXML private TextArea exclus;
    @FXML private Button include;
    @FXML private Button exclude;
    @FXML private Button validation;

    public void initialize(){
        validation.setDisable(true);
    }

    @FXML
    public void fullName(KeyEvent e) {
        if (e.getSource() == prenom) {
            if (prenom.getText().length() >= 3) {
                if (prenomValue.isEmpty()) prenomValue = prenom.getText().substring(0, 3);
                setIdentification();
            } else prenomValue = "";
        }
        if (e.getSource() == nom) {
            if (nom.getText().length() >= 3) {
                if (nomValue.isEmpty()) {
                    nomValue = nom.getText().substring(0, 3);
                    setIdentification();
                } else nomValue = "";
            }
        }
    }
    @FXML
    public void date(ActionEvent e) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yy");
        naissance = date.getValue().format(formatter);
    }

    private void setIdentification(){
        identification.setText(nomValue + "-" + prenomValue + "-" + naissance);
    }


}
