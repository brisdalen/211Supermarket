package supermarket;

import eventsim.Event;

public class ServeEvent extends Event {
    Checkout checkout;
    Customer customer;
    public ServeEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        this.checkout = checkout;
        this.customer = customer;
    }

    @Override
    public Event happen() {
        checkout.customer = null;
        return new EndShoppingEvent(getTime(), customer);
    }
}
