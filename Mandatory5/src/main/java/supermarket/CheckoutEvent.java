package supermarket;

import eventsim.Event;

public class CheckoutEvent extends Event {

    Customer customer;

    public CheckoutEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        this.customer = customer;
        checkout.customer = customer;
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }
}
