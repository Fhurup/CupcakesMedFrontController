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
public class CupcakeButtom {

    @Override
    public String toString() {
        return "Bottom: " + name + " Price: " + price;
    }
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public CupcakeButtom(String name, int price){
        this.name = name;
        this.price = price;
    }
}
