package com.readbook.refactor.round01;

/**
 * Created by yupeng on 30/10/2016.
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    public int getFrequentRenterPoints() {
        if ((get_movie().getPriceCode() == Movie.NEW_RELEASE) && get_daysRented() > 1)
            return 2;
        return 1;
    }

    public double getCharge() {
        double thisAmount = 0;
        switch (get_movie().getPriceCode()) {
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


}
