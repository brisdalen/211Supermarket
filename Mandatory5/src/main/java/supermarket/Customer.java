/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Constants;
import eventsim.EventSim;


/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values

    private int maxNumOfProducts = Constants.CUSTOMER_MAX_PRODUCTS;
    private int minNumOfProducts = Constants.CUSTOMER_MIN_PRODUCTS;

    // customer will spend ranom amount of time between these values before
    // going to check out


    SuperMarket shop;
    String name;

    int beginShoppingTime;
    int shoppingDuration;
    int numProducts;
    int endShoppingTime;
    int queueWaitDuration;
    int checkoutTime;
    int checkoutDuration;
    int leaveTime;


    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = "Cust" + i;
        beginShoppingTime = i;

        //System.out.println("name = " + name);

        numProducts = EventSim.nextInt(minNumOfProducts, maxNumOfProducts);
        //System.out.println("[Customer]number of products: " + numProducts);

        recalculateTimes();
    }

    public void changeNumOfProdcuts(int n) {
        //System.out.println("[Customer]changeNumOfProdcuts");
        numProducts = n;
        recalculateTimes();
    }

    private void recalculateTimes() {
        shoppingDuration = numProducts * Constants.TIME_PER_PRODUCT;
        endShoppingTime = beginShoppingTime + shoppingDuration;
        //System.out.println("[Customer]shopping duration: " + shoppingDuration);
        //System.out.println("[Customer]end shopping time: " + endShoppingTime);
    }

}
