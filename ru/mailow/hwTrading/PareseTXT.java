package ru.mailow.hwTrading;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PareseTXT {

    private static String tradeType;
    private static int price;

    public static Trade parse(File file, Boolean byEnum) {
        try {
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int equalIndex = line.indexOf('=');
                if (equalIndex != -1) {
                    String value = line.substring(equalIndex + 1);
                    try {
                        price = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        tradeType = value;
                    }
                }
            }
            fr.close();
            if (byEnum) {
                return createTradeEnum.valueOf(tradeType).createTrade(price);
            } else {
                return createTradeSwitch.createTrade(tradeType, price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
