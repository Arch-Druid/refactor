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

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }


}
