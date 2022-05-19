package org.calma.ETC;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML private TextField identification;
    @FXML private TextField prenom;
    @FXML private TextField nom;
    @FXML private DatePicker date;
    @FXML private TextField courriel;
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
        if(e.getSource() == prenom && prenom.getText().length() >= 3){

        } else if (e.getSource() == nom && ){

        }
    }
}
