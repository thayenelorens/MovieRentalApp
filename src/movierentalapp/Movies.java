/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movierentalapp;

import java.text.NumberFormat;

/**
 *
 * @author Thayene Lorens 
 * Student Number: 2020293.
 */
public class Movies {

    /**
     * PROPERTIES OF A MOVIE: Private.
     */
    private String title;
    private double vote_average;
    private double price;
    private int quantity;
    private double total;
    private boolean canRent;

    /**
     * CONSTRUCTOR: Public. It generates a Movie given certain parameters.
     *
     * @param title - The name of the movie.
     * @param vote_average - The rating of the movie.
     * @param price - The price of the movie.
     * @param quantity - The quantity desired.
     *
     */
    
    public Movies(String title, double vote_average, double price, int quantity) {
        this.title = title;
        this.vote_average = vote_average;
        this.price = price;
        this.quantity = quantity;

        //Working on this variable.
        this.canRent = true;

        //Setting the property total to be equals the price times the quantity selected.
        total = this.price * this.quantity;
    }

    ///////////////////////////////GETTERS/////////////////////////////////////
    /*
     * @return the String title property.
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @return double vote_average (rating).
     */
    public double getVote_average() {
        return vote_average;
    }

    /**
     * 
     * @return boolean canRent.
     */
    public boolean isCanRent() {
        return canRent;
    }

    /**
     * 
     * @return double getPrice
     */
    public double getPrice() {
        return price;
    }

    /**
     * 
     * @return int quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * 
     * @return double total.
     */
    public double getTotal() {
        return total;
    }

    ////////////////////////////////SETTERS///////////////////////////////////////////
    
    /**
     * 
     * @param title (the title property is equal to the String title parameter).
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @param vote_average (the vote_average property is equal to the vote_average parameter).
     */
    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    /**
     * 
     * @param price (the price property is equal to the price parameter).
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 
     * @param quantity (the quantity property is equal to the quantity parameter).
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * 
     * @param total (the total property is equal to the total parameter). 
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * 
     * @param canRent (the canRent property is equal to the canRent parameter).
     */
    public void setCanRent(boolean canRent) {
        this.canRent = canRent;
    }

      /**
     * A toString() is an in-built method in Java.
     *
     * @return the value given to it in string format, i.e., the established
     * properties will return as a String object. 
     * When using the method emptyCart(), this is the structure that is going to return when printing all the shopped items.
     */
    @Override
    public String toString() {
        return "               	             Eirvid's Movie Rental\n"
                + "                               Owned & Operated By:\n"
                + "                                  Thayene Lorens\n"
                + "                                  Mayara Lorens\n"
                + "                                  Marco dos Santos\n"
                + "                                  RENTAL TRANSACTION\n"
                + "-----------------------------------------------------------------------------------------------------\n"
                + "                                  Movie: " + title + "\n"
                +"\n Rating: " + vote_average +  "\n Price: " + price + "\n Quantity: " + quantity + "\n Total: " + total 
                ;
    }

}
