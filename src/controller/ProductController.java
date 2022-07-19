/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Natalia
 */
public class ProductController extends BaseView implements Initializable {

    @FXML
    private Button product;

    private HashMap<String, Object> productInfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setProductInfo(HashMap<String, Object> productInfo){
        this.productInfo=productInfo;
        this.product.setText((String)productInfo.get("name"));
    }

    @FXML
    private void productSelected(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/productInfoPane.fxml"));
        Node productInfoPane = loader.load();
        ProductInfoPaneController productInfoPaneContr = loader.getController();
        productInfoPaneContr.setProductInfo(this.productInfo);
        commController.getProductsPaneController().showProductInfoPane(productInfoPane);
    }
    
}
