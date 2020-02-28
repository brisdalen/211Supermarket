package supermarket;

import eventsim.Constants;
import eventsim.Event;

public class CheckoutEvent extends Event {

    Customer customer;
    Checkout checkout;

    public CheckoutEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        //TODO: Når en person er i kassa allerede, må h@n få bli ferdig først, før du bytter kunde
        this.customer = customer;
        this.checkout = checkout;
        checkout.customer = customer;
    }

    @Override
    public Event happen() {
        return new ServeEvent(getTime() + getServeTime(), this.checkout, this.customer);
    }

    private int getServeTime() {
        // Regn ut hvor lang tid det tar før man kan betale
        return checkout.payDuration + (customer.numProducts * checkout.prodDuration);
    }
}
