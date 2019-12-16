package ru.mailow.hwTrading;

import java.io.Serializable;

public class Order implements Serializable {

    private final String name;

    public int getPrice() {
        return price;
    }

    public String getName(){return name;}


    private final int price;


    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }



}
