package ru.mailow.hwTrading;


import ru.mailow.hwTrading.typesTrade.BOND;
import ru.mailow.hwTrading.typesTrade.COMMODITY_SPOT;
import ru.mailow.hwTrading.typesTrade.FX_SPOT;
import ru.mailow.hwTrading.typesTrade.IR_SWAP;

public enum createTradeEnum {
    BOND{
        @Override
        public Trade createTrade(int price){
            System.out.println("BOND");
            return new BOND(price);
        }
    },
    COMMODITY_SPOT{
        @Override
        public Trade createTrade(int price){
            System.out.println("COMMODITY_SPOT");
            return new COMMODITY_SPOT(price);
        }
    },
    FX_SPOT{
        @Override
        public Trade createTrade(int price){
            System.out.println("FX_SPOT");
            return new FX_SPOT(price);
        }
    },
    IR_SWAP{
        @Override
        public Trade createTrade(int price){
            System.out.println("IR_SWAP");
            return new IR_SWAP(price);
        }
    };
    public abstract Trade createTrade(int price);
}

