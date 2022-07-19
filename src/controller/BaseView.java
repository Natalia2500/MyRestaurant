/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author milar
 */
public class BaseView {
    
    protected IControllerForView controllerForView = ControllerForView.getInstance();
    protected CommunicationController commController = CommunicationController.getInstance();
    
}
