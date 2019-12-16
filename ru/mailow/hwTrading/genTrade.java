package ru.mailow.hwTrading;

import ru.mailow.hwTrading.typesTrade.BOND;
import ru.mailow.hwTrading.typesTrade.COMMODITY_SPOT;
import ru.mailow.hwTrading.typesTrade.FX_SPOT;
import ru.mailow.hwTrading.typesTrade.IR_SWAP;

public class genTrade {
    public static Trade create(String tradeType, int price){
        switch (tradeType) {
            case "BOND":
                return new BOND(price);
            case "FX_SPOT":
                return new FX_SPOT(price);
            case "COMMODITY_SPOT":
                return new COMMODITY_SPOT(price);
            case "IR_SWAP":
                return new IR_SWAP(price);
            default:
                return null;
        }
    }

}
