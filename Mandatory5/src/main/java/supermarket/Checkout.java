/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;


import eventsim.Constants;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author evenal
 */
public class Checkout {
    // amount of time per prouct (to scan barcode)
    int prodDuration = Constants.CHECKOUT_PROD_DURATION;
    // amount of time to pay
    int payDuration = Constants.CHECKOUT_PAY_DURATION;
    //todo: blir nullpoint i constructor pga customer finnes ikke når checkout opprettes. -> fiks??
    Customer customer;
    //private int totalDuration = payDuration + prodDuration * customer.numProducts;
    int totalDuration;
    LinkedList<Customer> customers;

    SuperMarket shop;
    String name;

    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;

        customers = new LinkedList<Customer>();
    }

    public void addCustomer(Customer c) {
        customers.addLast(c);
    }

    public void removeCustomer() {
        customers.removeFirst();
    }

    public Customer poll() {
        return customers.pollFirst();
    }

    public void calculateDuration() {
        if(customer != null) {
            totalDuration = payDuration + (prodDuration * customer.numProducts);
        } else {
            System.err.println("[Checkout]customer is null.");
        }
    }
}
