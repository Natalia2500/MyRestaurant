
package view.sceneControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;
import view.utils.BackButton;
import view.utils.LocatedImage;


/**
 * FXML Controller class
 *
 * @author Natalia
 */
public class DashboardController extends BaseView implements Initializable {


    final String BTN_SELECTED_STYLE_CLASS = "menuButton-selected";
    final String BTN_HOVER_STYLE_CLASS = "menuButton-hover";
    final String DASHBOARD_BTN_ICON_PATH = "/view/style/img/menu-icons/home.png";
    final String MENU_BTN_ICON_PATH = "/view/style/img/menu-icons/menu.png";
    final String ORDERS_BTN_ICON_PATH = "/view/style/img/menu-icons/orders.png";
    final String UTILITY_BTN_ICON_PATH = "/view/style/img/menu-icons/utility.png";
    final String STORE_BTN_ICON_PATH = "/view/style/img/menu-icons/store.png";
    final String EMPLOYEES_BTN_ICON_PATH = "/view/style/img/menu-icons/employees.png";
    final String LOGIN_BTN_ICON_PATH = "/view/style/img/menu-icons/login.png";

    @FXML
    public ImageView dashboardBtnIcon;
    @FXML
    public ImageView menuBtnIcon;
    @FXML
    public ImageView ordersBtnIcon;
    @FXML
    public ImageView utilityBtnIcon;
    @FXML
    public ImageView storeBtnIcon;
    @FXML
    public ImageView employeesBtnIcon;
    @FXML
    public Button loginBtn;
    @FXML
    public ImageView loginBtnIcon;
    @FXML
    public AnchorPane loginBtnContainer;
    public AnchorPane backButtonContainer;
    @FXML
    private Button dashboardBtn;
    @FXML
    private Button menuBtn;
    @FXML
    private Button employeesBtn;
    @FXML
    private Button storeBtn;
    @FXML
    private Button utilityBtn;
    @FXML
    private Button ordersBtn;
    @FXML
    private Pane buttonContainer;
    @FXML
    private BorderPane borderPane;

    @FXML
    private Node employeesPane = null;
    @FXML
    private Node menuPane = null;
    @FXML
    private Node utilitiesPane = null;
    @FXML
    private Node categoryPane = null;
    private Node ordersPane = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dashboardBtnIcon.setImage(new LocatedImage(this.DASHBOARD_BTN_ICON_PATH));
        employeesBtnIcon.setImage(new LocatedImage(this.EMPLOYEES_BTN_ICON_PATH));
        menuBtnIcon.setImage(new LocatedImage(this.MENU_BTN_ICON_PATH));
        ordersBtnIcon.setImage(new LocatedImage(this.ORDERS_BTN_ICON_PATH));
        storeBtnIcon.setImage(new LocatedImage(this.STORE_BTN_ICON_PATH));
        utilityBtnIcon.setImage(new LocatedImage(this.UTILITY_BTN_ICON_PATH));
        loginBtnIcon.setImage(new LocatedImage(this.LOGIN_BTN_ICON_PATH));
        dashboardBtn.fire();
        this.commController.setDashboardController(this);
    } 

    public void addBackButton(BackButton btn){
        this.backButtonContainer.getChildren().clear();
        this.backButtonContainer.getChildren().add(btn);
    }

    public void removeBackButton(){
        this.backButtonContainer.getChildren().clear();
    }
    private void resetAllExcept(Button btn){
        for(Node node: buttonContainer.getChildren() ){
            if(node.getId() != btn.getId() && node.getStyleClass().contains(this.BTN_SELECTED_STYLE_CLASS)){
                node.getStyleClass().remove(this.BTN_SELECTED_STYLE_CLASS);
            }
        }
        this.setCenterPane(null);
        this.setRightPane(null);
    }
    
    private void select(Button btn){
        btn.getStyleClass().add(this.BTN_SELECTED_STYLE_CLASS);
    }
    

    @FXML
    private void dashboardBtnClicked(ActionEvent event) throws IOException {
        select(dashboardBtn);
        resetAllExcept(dashboardBtn);
        borderPane.setCenter(FXMLLoader.load(getClass().getResource("/view/scene/chartsPane.fxml")));
    }

    @FXML
    private void menuBtnClicked(ActionEvent event) throws IOException {
        select(menuBtn);
        resetAllExcept(menuBtn);
        
        if(this.menuPane == null){
           this.menuPane = FXMLLoader.load(getClass().getResource("/view/scene/MenuPanel.fxml"));
        }
        borderPane.setCenter(this.menuPane);
        borderPane.setRight(null);

    }

    @FXML
    private void employeesBtnClicked(ActionEvent event) throws IOException {
        select(employeesBtn);
        resetAllExcept(employeesBtn);
        
        if(this.employeesPane == null){
            this.employeesPane = FXMLLoader.load(getClass().getResource("/view/scene/EmployeesList.fxml"));
        }
        borderPane.setCenter(this.employeesPane);
        borderPane.setRight(null);
    }

    @FXML
    private void storeBtnClicked(ActionEvent event) throws IOException {
        select(storeBtn);
        resetAllExcept(storeBtn);

        if(this.categoryPane == null){
            this.categoryPane = FXMLLoader.load(getClass().getResource("/view/scene/categoryPane.fxml"));
        }
        borderPane.setCenter(this.categoryPane);

        CategoryPaneController categoryPaneController = commController.getCategoryPaneController();
        categoryPaneController.animate();
        borderPane.setRight(null);
    }

    @FXML
    private void utilityBtnClicked(ActionEvent event) throws IOException {
        select(utilityBtn);
        resetAllExcept(utilityBtn);
        
        if(this.utilitiesPane == null){
            this.utilitiesPane = FXMLLoader.load(getClass().getResource("/view/scene/UtilitiesPanel.fxml"));
        }
        borderPane.setCenter(this.utilitiesPane);
        borderPane.setRight(null);
    }

    @FXML
    private void ordersBtnClicked(ActionEvent event) throws IOException {
        select(ordersBtn);
        resetAllExcept(ordersBtn);

        if(this.ordersPane == null){
            this.ordersPane =  FXMLLoader.load(getClass().getResource("/view/scene/orderPane.fxml"));
        }
        borderPane.setCenter(this.ordersPane);
        borderPane.setRight(null);
        OrderPaneController orderPaneController = commController.getOrderPaneController();
        orderPaneController.setMode(orderPaneController.ORDERS_ON_DELIVERY_MODE);
    }
    
    public void setCenterPane(Node node){
        borderPane.setCenter(node);
    }
    public Node getCenterPane(){ return borderPane.getCenter();}
    public void setRightPane(Node node){ borderPane.setRight(node);}
    public Node getRightPane(){ return borderPane.getRight();}
    public void menuBtnHovered(MouseEvent mouseEvent) {
        Button btn = (Button)mouseEvent.getSource();
        if(!btn.getStyleClass().contains(this.BTN_SELECTED_STYLE_CLASS)){
            btn.getStyleClass().add("menuButton-hover");
            ImageView iconContainer = (ImageView) btn.getGraphic();
            String staticIconUrl = ((LocatedImage)iconContainer.getImage()).getUrl();
            String gifIconUrl = staticIconUrl.replace("png","gif");
            ImageView btnIcon = (ImageView) buttonContainer.lookup("#"+iconContainer.getId());
            if(btnIcon == null){
                btnIcon = (ImageView) loginBtnContainer.lookup("#"+iconContainer.getId());
            }
            btnIcon.setImage(new LocatedImage(gifIconUrl));
        }
    }


    public void menuBtnNotHovered(MouseEvent mouseEvent) {
        Button btn = (Button)mouseEvent.getSource();
        if(btn.getStyleClass().contains(this.BTN_HOVER_STYLE_CLASS)){
            btn.getStyleClass().remove(this.BTN_HOVER_STYLE_CLASS);
            ImageView iconContainer = (ImageView) btn.getGraphic();
            String gifIconUrl = ((LocatedImage)iconContainer.getImage()).getUrl();
            String staticIconUrl = gifIconUrl.replace("gif","png");
            ImageView btnIcon = (ImageView) buttonContainer.lookup("#"+iconContainer.getId());
            if(btnIcon == null){
                btnIcon = (ImageView) loginBtnContainer.lookup("#"+iconContainer.getId());
            }
            btnIcon.setImage(new LocatedImage(staticIconUrl));
        }
    }

    public void loginBtnClicked(ActionEvent actionEvent) {
    }

}
