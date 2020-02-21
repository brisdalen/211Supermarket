package supermarket;

import eventsim.Event;

public class ServeEvent extends Event {
    Checkout checkout;
    Customer customer;
    public ServeEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        this.checkout = checkout;
        this.customer = customer;
        checkout.customer = this.customer;
    }

    @Override
    public Event happen() {

        return new EndShoppingEvent(customer);
    }
}
