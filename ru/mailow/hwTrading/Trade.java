package ru.mailow.hwTrading;

public class Trade {
    private final int price;

    public Trade(int price) {
        this.price = price;
    }

    public void printPrice() {
        System.out.println(price);
    }

}
