package com.readbook.refactor.round01;

/**
 * Created by yupeng on 16/11/2016.
 */
public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
