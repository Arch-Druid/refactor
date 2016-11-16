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
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + get_name() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;

    }

    public int getTotalFrequentRenterPoints() {
        Enumeration rentals = _rentals.elements();
        int frequentRenterPoints = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;

    }


    public double getTotalCharge() {
        double totalAmount = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }


    public static void main(String[] args) {
        Customer customer = new Customer("yupeng");
        Vector rentals = new Vector();
        Movie movie = new Movie("新的影片", 2);
        Movie movie2 = new Movie("REGULAR", 2);
        Rental rental = new Rental(movie, 100);
        Rental rental2 = new Rental(movie2, 3333);
        rentals.add(rental);
        rentals.add(rental2);
        customer.set_rentals(rentals);
        System.out.println(customer.statement());


    }
}
