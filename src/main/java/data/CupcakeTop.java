/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author frederik
 */
public class CupcakeTop {

    @Override
    public String toString() {
        return "Topping: " + name + " Price: " + price;
    }
    private int price;
    private String name;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
    public CupcakeTop(String name, int price){
        this.price = price;
        this.name = name;
    }
}
