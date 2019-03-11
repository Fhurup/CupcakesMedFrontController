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
    

    public void AddCupcake(Cupcake Cupcake) {
        this.Cupcakes.add(Cupcake);
    }

    @Override
    public String toString() {
        return "LineItems{" + "Cupcakes=" + Cupcakes + '}';
    }

    public ArrayList<Cupcake> getCupcakes() {
        return Cupcakes;
    }
    
    
}
