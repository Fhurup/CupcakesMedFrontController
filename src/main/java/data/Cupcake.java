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
public class Cupcake {

    private int price;
    private String cupcakeTop;
    private String cupcakeButtom;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return cupcakeTop + " " + cupcakeButtom;
    }

    public String getCupcakeTop() {
        return cupcakeTop;
    }

    public String getCupcakeButtom() {
        return cupcakeButtom;
    }

    public int getPrice() {
        return price;
    }

    public Cupcake(CupcakeTop cupcakeTop, CupcakeButtom cupcakeButtom, int amount) {
        this.cupcakeButtom = cupcakeButtom.getName();
        this.cupcakeTop = cupcakeTop.getName();
        this.price = cupcakeTop.getPrice() + cupcakeButtom.getPrice();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cupcake{" + "cupcakeTop=" + cupcakeTop + ", cupcakeButtom=" + cupcakeButtom + ", price=" + price + '}';
    }
}
