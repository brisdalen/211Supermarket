/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;


import eventsim.Constants;

import java.util.PriorityQueue;

/**
 *
 * @author evenal
 */
public class Checkout {
    // amount of time per prouct (to scan barcode)
    private int prodDuration = Constants.PROD_DURATION;
    // amount of time to pay
    private int payDuration = Constants.PAY_DURATION;
    //todo: blir nullpoint i constructor pga customer finnes ikke når checkout opprettes. -> fiks??
    Customer customer;
    //private int totalDuration = payDuration + prodDuration * customer.numProducts;
    PriorityQueue<Customer> customers;

    SuperMarket shop;
    String name;

    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;

        customers = new PriorityQueue<>();
    }
}
