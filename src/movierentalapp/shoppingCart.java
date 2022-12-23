/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalapp;


import java.util.ArrayList;

/**
 * A ShoppingCart that stores items in an ArrayList
 *
 * Possible to add items.
 * Can also "empty" the cart.
 * This code is based on a code taught by Ken in previous semesters.
 * 
 * @author Thayene Lorens
 * Student Number: 2020293
 */
public class shoppingCart {

    private ArrayList<Movies> items;

    /**
     * Create a shopping cart by initializing the items to an empty arrayList that stores Movies as Objects.
     */
    public shoppingCart() {

        items = new ArrayList<Movies>();

    }

    /**
     * This method should add someItem to the shopping cart.
     *
     * @param someItem the item that has been bought by the user.
     */
    public void buyItem(Movies someItem) {

        this.items.add(someItem);
    }

    /**
     * Create a formatted String (using toString() method.
     * It contains all the items in the ShoppingCart.
     *
     * @return the formatted String and it also clears the items list.
     */
    public String emptyCart() {

        String itemList = "";

        for (Movies item : this.items) {

            itemList = itemList + item.toString() + "\n";

        }

        this.items.clear();

        return itemList;
    }
//    
    }


