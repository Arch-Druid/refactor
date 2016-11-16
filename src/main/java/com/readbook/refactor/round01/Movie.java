package com.readbook.refactor.round01;

import lombok.Data;

/**
 * Movie 只是一个简单的纯数据类
 */
@Data
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    private String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        set_priceCode(priceCode);
    }


    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public void set_priceCode(int _priceCode) {
        switch (_priceCode) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
