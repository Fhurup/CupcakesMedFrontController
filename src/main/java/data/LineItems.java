/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author frederik
 */
public class LineItems {
    private ArrayList<Cupcake> Cupcakes = new ArrayList();
    private int amount;

    public void AddCupcake(Cupcake Cupcake, int amount) {
        this.Cupcakes.add(Cupcake);
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "LineItems{" + "Cupcakes=" + Cupcakes + '}';
    }

    public ArrayList<Cupcake> getCupcakes() {
        return Cupcakes;
    }
    
    
}
