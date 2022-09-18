/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.sceneControllers;

import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.delete;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 *
 * @author milar
 */
public class MenuPaneController extends BaseView implements Initializable{
    
    @FXML
    private BorderPane anchorPaneMenu;
    
    @FXML
    private Button antipastiBtn;

    @FXML
    private Button bevandeBtn;

    @FXML
    private Button contorniBtn;

    @FXML
    private Button insertDishBtn;
    @FXML
    private TextField dishSearchBar;

    @FXML
    private Button dolciBtn;

    @FXML
    private GridPane menuGridPane;

    @FXML
    private Button primiBtn;

    @FXML
    private Button secondiBtn;

    @FXML
    private Label titoloLbl;
    
     @FXML
    void antipastiBtnClicked(ActionEvent event) throws IOException {
        
        BorderPane borderPane = (BorderPane) anchorPaneMenu.getParent();
        borderPane.setCenter(FXMLLoader.load(getClass().getResource("/view/scene/menuList.fxml"))); 
        borderPane.setRight(FXMLLoader.load(getClass().getResource("/view/scene/dishInfo.fxml")));
        
        /*fxmlval.add("/view/scene/menuList.fxml");                                   
        stage = (Stage)validate.getScene().getWindow();
        stageval.add((Stage)delete.getScene().getWindow());*/
    }
    
    
    @FXML
    void insertDishBtnClicked(ActionEvent event) throws IOException {
     
      BorderPane borderPane = (BorderPane) anchorPaneMenu.getParent();
      borderPane.setRight(FXMLLoader.load(getClass().getResource("/view/scene/AddMenuDish.fxml")));  

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commController.setMenuPaneController(this);
        
        dishSearchBar.textProperty().addListener((observable, oldValue, newValue) ->{
            ObservableList<Node> dishes = menuGridPane.getChildren();
            for(Node dish : dishes){
                Button menuBtn = (Button)dish;
                String menudishName = menuBtn.getText();
                if(!menudishName.contains(newValue)){
                    dish.setVisible(false);
                    dish.setManaged(false);
                }else{
                    dish.setVisible(true);
                    dish.setManaged(true);
                }
            }
            
        });
    }

    
    
}
