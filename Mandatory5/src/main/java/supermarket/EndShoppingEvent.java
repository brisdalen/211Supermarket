/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Constants;
import eventsim.Event;
import eventsim.EventSim;


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class EndShoppingEvent extends Event {
    Customer customer;

    public EndShoppingEvent(int time, Customer customer) {
        super(time);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        System.out.println(Constants.ANSI_BRIGHT_BLUE + "customer leaving @ time: " + EventSim.getClock());
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
    }

    @Override
    public String toString() {
        return "EndShoppingEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}';
    }

}
