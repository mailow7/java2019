package ru.mailow.hwTrading;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("./src/ru/mailow/hwTrading/trade.txt");
        Trade trade = PareseTXT.parse(file, true);
        if (trade != null) {
            trade.printPrice();
        }

    }
}
