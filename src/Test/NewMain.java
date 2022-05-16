
package test;

import controller.ControllerForView;
import entity.Employee;
import entity.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Employee emp = new Employee(CF123, "mario", "rossi", "cameriere", 10-04-2022, 12-05-2022,1200);
        ControllerForView.getInstance().save(emp);
        
    }
    
}
