<<<<<<< HEAD:src/view/sceneControllers/CommunicationController.java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.sceneControllers;

/**
 *
 * @author milar
 */
public final class CommunicationController {
    
    private static final CommunicationController commController = new CommunicationController();
    
    private ProductsPaneController productsPaneController = null;
    private CategoryPaneController categoryPaneController = null;
    private MenuPaneController menuPaneController = null;
    private EmployeesListController employeesListController = null;
    private UtilitiesPaneController utilitiesPaneController = null;
    
    private CommunicationController() {
    }

    public static CommunicationController getInstance(){
    return commController;
    }

    public void setCategoryPaneController(CategoryPaneController catController){
        if(this.categoryPaneController == null){
            this.categoryPaneController = catController;
        }
    }
    
    public CategoryPaneController getCategoryPaneController(){
        return this.categoryPaneController;
    }
    
    public void setProductPaneController(view.sceneControllers.ProductsPaneController productsPaneController){
        if(this.productsPaneController == null){
            this.productsPaneController = productsPaneController;
        }
    }
    
    public ProductsPaneController getProductsPaneController(){
        return this.productsPaneController;
    }
    
    public void setUtilitiesPaneController(view.sceneControllers.UtilitiesPaneController utilitiesPaneController){
        if(this.utilitiesPaneController == null){
            this.utilitiesPaneController = utilitiesPaneController;
        }
    }
    
    public UtilitiesPaneController getUtilitiesPaneController(){
        return this.utilitiesPaneController;
    }
    
    
    public void setMenuPaneController(view.sceneControllers.MenuPaneController menuPaneController){
        if(this.menuPaneController == null){
            this.menuPaneController = menuPaneController;
        }
    }
    
    public MenuPaneController getMenuPaneController(){
        return this.menuPaneController;
    }
    
    public void setEmployeePaneController(EmployeesListController employeesListController){
        if(this.employeesListController == null){
            this.employeesListController = employeesListController;
        }
    }
    
    public EmployeesListController getEmployeePaneController(){
        return this.employeesListController;
    }
}

=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author milar
 */
public final class CommunicationController {
    
    private static final CommunicationController commController = new CommunicationController();
    
    private ProductsPaneController productsPaneController = null;
    private CategoryPaneController categoryPaneController = null;
    private MenuPaneController menuPaneController = null;
    private EmployeesListController employeesListController = null;
    private UtilitiesPaneController utilitiesPaneController = null;
    
    private CommunicationController() {
    }

    public static CommunicationController getInstance(){
        return commController;
    }

    public void setCategoryPaneController(CategoryPaneController catController){
        if(this.categoryPaneController == null){
            this.categoryPaneController = catController;
        }
    }
    
    public CategoryPaneController getCategoryPaneController(){
        return this.categoryPaneController;
    }
    
    public void setProductPaneController(ProductsPaneController productsPaneController){
        if(this.productsPaneController == null){
            this.productsPaneController = productsPaneController;
        }
    }
    
    public ProductsPaneController getProductsPaneController(){
        return this.productsPaneController;
    }
    
    public void setUtilitiesPaneController(UtilitiesPaneController utilitiesPaneController){
        if(this.utilitiesPaneController == null){
            this.utilitiesPaneController = utilitiesPaneController;
        }
    }
    
    public UtilitiesPaneController getUtilitiesPaneController(){
        return this.utilitiesPaneController;
    }
    
    
    public void setMenuPaneController(MenuPaneController menuPaneController){
        if(this.menuPaneController == null){
            this.menuPaneController = menuPaneController;
        }
    }
    
    public MenuPaneController getMenuPaneController(){
        return this.menuPaneController;
    }
    
    public void setEmployeePaneController(EmployeesListController employeesListController){
        if(this.employeesListController == null){
            this.employeesListController = employeesListController;
        }
    }
    
    public EmployeesListController getEmployeePaneController(){
        return this.employeesListController;
    }
}

>>>>>>> 75c338deaea6b1b1500fb9430a85d86a0134f511:src/controller/CommunicationController.java
