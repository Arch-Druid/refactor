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


    public double getCharge() {
        double thisAmount = 0;
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (get_daysRented() > 2) {
                    thisAmount += (get_daysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (get_daysRented() > 3) {
                    thisAmount += (get_daysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }


    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if ((get_movie().get_priceCode() == Movie.NEW_RELEASE) && get_daysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;

    }


}
