/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * 
 * @param <T>
 */
public interface Table<T> {
    
    List<T> getAll();
    Object catch_input = "mario"; //getText
    
    //se servisse di restituire un oggetto nella lista
    //T get(int id);
    
    void save(T t);
    //query 
    
    void update(T t);
    
    void delete(T t);
    
    List<T>  search(Object catch_input);
  
}
