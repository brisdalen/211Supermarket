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
 * A customer enters the shop
 *
 * @author evenal
 */
public class BeginShoppingEvent extends Event {
    Customer customer;

    public BeginShoppingEvent(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        System.out.println(Constants.ANSI_BRIGHT_BLUE + "begin shopping time: " + EventSim.getClock());
        if(customer.numProducts > 0) {
            return new LookForCheckoutEvent(customer);
        } else {
            return new EndShoppingEvent(customer);
        }
    }
}
