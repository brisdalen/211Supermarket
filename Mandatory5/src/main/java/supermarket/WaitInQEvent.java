package supermarket;

import eventsim.Constants;
import eventsim.Event;

public class WaitInQEvent extends Event {

    Checkout checkout;
    Customer customer;
    int waitDuration;

    public WaitInQEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        //System.out.println(Constants.ANSI_BRIGHT_CYAN + "Waiting.." + Constants.ANSI_RESET);
        this.checkout = checkout;
        this.customer = customer;

    }

    @Override
    public Event happen() {
        // Fjern kunden som går fra køen til kassa
        checkout.removeCustomer();
        /*assert checkout.customers.peekFirst() != null;
        waitDuration = 0;
        for(Customer c : checkout.customers) {
            waitDuration += checkout.payDuration + (c.numProducts * checkout.prodDuration);
        }*/
        return new CheckoutEvent(getTime(), checkout, customer);
    }
}
