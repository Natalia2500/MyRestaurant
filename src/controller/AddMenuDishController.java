/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entity.Menu;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 *
 */

public class AddMenuDishController implements Initializable {
    
    @FXML
    private Label categoriaLbl;

    @FXML
    private ChoiceBox<String> categorieChoicebox;
    private String[] categorie = {"Antipasti", "Primi", "Secondi", "Contorni", "Dolci", "Bevande"};

    @FXML
    private Button insertdishBtn;

    @FXML
    private Label nomeLbl;

    @FXML
    private TextField nomeTxt;

    @FXML
    private Label prezzoLbl;

    @FXML
    private TextField prezzoTxt;

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomeTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                nomeTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        
        prezzoTxt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                prezzoTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        categorieChoicebox.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                categorieChoicebox.setValue(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        categorieChoicebox.getItems().addAll(categorie);
        categorieChoicebox.setOnAction(this::getCategoriaScelta);

        
    }    

    @FXML
    private void addMenuDishBtnClicked(ActionEvent event) {
        
        //controllo che siano stati inseriti tutti i campi
        if(nomeTxt.getText().isEmpty() || prezzoTxt.getText().isEmpty() || categorieChoicebox.getValue().isEmpty() ){
            
            System.out.println("campo vuoto");
            
        }else{
		String nameDish = nomeTxt.getText();
            	int price = Integer.parseInt(prezzoTxt.getText());
                String categoria_scelta = categorieChoicebox.getValue(); //param fisso per categoria selezionata
                

                Menu m = new Menu (nameDish, price, categoria_scelta); //collego con entity del db
                ControllerForView.getInstance().save(m);
                System.out.println("aggiunto");
        }
        
    }

    private void getCategoriaScelta(ActionEvent event) {
        String categoria_scelta = categorieChoicebox.getValue();
    }

}
