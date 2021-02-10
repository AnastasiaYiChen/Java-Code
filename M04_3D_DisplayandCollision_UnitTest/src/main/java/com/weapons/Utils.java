package com.weapons;

import java.math.BigDecimal;

public class Utils {
    public static float add(Float v1, Float v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.add(b2).floatValue();
    }

    public static float sub(Float v1, Float v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).floatValue();
    }
}
