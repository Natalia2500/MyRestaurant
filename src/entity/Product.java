/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * 
 */
public class Product implements Entity{
    
    private int codice_barre;
    private String nome;
    private int qta;
    private int prezzo;
    
    public Product(int codice_barre, String nome, int qta, int prezzo){
        this.codice_barre=codice_barre;
        this.nome=nome;
        this.qta=qta;
        this.prezzo=prezzo;
    }
    
    public int getId(){
        return this.codice_barre;
    }
    
    public String getName(){
        return this.nome;
    }
    
    public int getQty(){
        return this.qta;
    }
    
    public int getPrice(){
        return this.prezzo;
    }

    @Override
    public String getTableName() {
        return "product";
    }
    
}
