/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author milar
 */

    
public class AddMenuDishController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private TextField nomeTxt;
    @FXML
    private TextField prezzoTxt;
    @FXML
    private Label nomeLbl;
    @FXML
    private Label prezzoLbl;
    @FXML
    private Button insertDishBtn;
    
    private Menu m;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
