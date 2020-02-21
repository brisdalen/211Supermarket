package supermarket;

import eventsim.Event;

public class CheckoutEvent extends Event {

    Customer customer;

    public CheckoutEvent(int time, Checkout checkout, Customer customer) {
        super(time);
        //TODO: Når en person er i kassa allerede, må h@n få bli ferdig først, før du bytter kunde
        this.customer = customer;
        checkout.customer = customer;
        checkout.removeCustomer();
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }
}
