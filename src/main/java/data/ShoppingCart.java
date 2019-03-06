package data;


import data.Cupcake;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frederik
 */
public class ShoppingCart {

    public ShoppingCart(int invoiceID) {
        this.invoiceID = invoiceID;
    }
    private ArrayList<LineItems> items = new ArrayList();
    private int invoiceID;

    public ArrayList<LineItems> getItems() {
        return items;
    }

    public int getInvoiceID() {
        return invoiceID;
    }
    
}
