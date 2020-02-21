package supermarket;

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
        assert checkout.customers.peekFirst() != null;
        int temp = checkout.customers.peekFirst().queueWaitDuration;
        customer.checkoutDuration +=temp;
        checkout.removeCustomer();
        return new ServeEvent(getTime(),this.checkout, this.customer);
    }
}
