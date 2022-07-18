/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entity.Utility;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author milar
 */
public class AddUtilityController implements Initializable {
    
    @FXML
    private Label categoriaLbl;

    @FXML
    private Label dataLbl;

    @FXML
    private TextField datautenzaTxt;

    @FXML
    private Label importoLbl;

    @FXML
    private TextField importoutenzaTxt;

    @FXML
    private Button insertUtilityBtn;

    @FXML
    private Label nfatturaLbl;

    @FXML
    private TextField nfatturaTxt;
    
    @FXML
    private Label titoloLbl;
    
    @FXML
    public AnchorPane anchorpaneAddUtility;
    
    private CommunicationController commController = CommunicationController.getInstance();

    @FXML
    private ComboBox<String> utenzeChoiceBox;
    private String[] tipo_utenza = {"Energia elettrica", "Acqua", "Gas"};
   

    @FXML
    void AddUtilityBtnClicked(ActionEvent event) {
        if(nfatturaTxt.getText().isEmpty() || importoutenzaTxt.getText().isEmpty() || datautenzaTxt.getText().isEmpty() ||utenzeChoiceBox.getValue().isEmpty() ){
            
            System.out.println("campo vuoto");
            
        }else{
		int num_utility = Integer.parseInt(nfatturaTxt.getText());
            	int  total= Integer.parseInt(importoutenzaTxt.getText());
                String type = utenzeChoiceBox.getValue();
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                String utility_date_string = datautenzaTxt.getText();
                LocalDate utility_date = LocalDate.parse(utility_date_string, formatter);
                

                Utility u = new Utility ( num_utility,total , type, utility_date); //collego con entity del db
                ControllerForView.getInstance().save(u);
                System.out.println("aggiunto");
        }

    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nfatturaTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                nfatturaTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        
        importoutenzaTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                importoutenzaTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
       
        datautenzaTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                datautenzaTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        utenzeChoiceBox.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                utenzeChoiceBox.setValue(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        utenzeChoiceBox.getItems().addAll(tipo_utenza);
        utenzeChoiceBox.setOnAction(this::getTipoUtenza);

      
    }    
    
        private void getTipoUtenza(ActionEvent event) {
        String tipologia_utenza = utenzeChoiceBox.getValue(); //return?
    }
    
}
