package com.readbook.refactor.round01;

import lombok.Data;

/**
 * Rental 表示某个顾客租了一部影片
 */
@Data
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }


}
