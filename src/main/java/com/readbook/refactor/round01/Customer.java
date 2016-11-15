package com.readbook.refactor.round01;

import lombok.Data;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by yupeng on 14/11/2016.
 */
@Data
public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }


    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }


    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + get_name() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            double thisAmount = amountFor(each);
            frequentRenterPoints++;
            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE) && each.get_daysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }


    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.get_movie().get_priceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.get_daysRented() > 2) {
                    thisAmount += (each.get_daysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.get_daysRented() > 3) {
                    thisAmount += (each.get_daysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }


    public static void main(String[] args) {
        Customer customer = new Customer("yupeng");
        Vector rentals = new Vector();
        Movie movie = new Movie("新的影片", 1);
        Movie movie2 = new Movie("REGULAR", 2);
        Rental rental = new Rental(movie, 100);
        Rental rental2 = new Rental(movie2, 1);
        rentals.add(rental);
        rentals.add(rental2);
        customer.set_rentals(rentals);
        System.out.println(customer.statement());


    }
}
