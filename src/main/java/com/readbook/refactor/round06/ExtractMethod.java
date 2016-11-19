package com.readbook.refactor.round06;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by yupeng on 2016/11/19.
 */
public class ExtractMethod {

    private String _name;


    Vector _orders;

    void printOwing(double amount) {
        printBanner();
        printDetails(amount);
    }

    void printOwingWithLocalField() {
        Enumeration e = _orders.elements();
        double outstanding = 0.0;

        printBanner();

        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            outstanding = each.getAmount();
        }

        printLocal(outstanding);
    }

    private void printLocal(double outstanding) {
        System.out.println("name:"+_name);
        System.out.println("amount"+ outstanding);
    }


    private void printDetails(double amount) {
        printLocal(amount);
    }

    private void printBanner() {
        System.out.println("this is printBanner Func");
    }


}
