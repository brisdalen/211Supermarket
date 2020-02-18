package supermarket;

import eventsim.Constants;
import eventsim.Event;

public class LookForCheckoutEvent extends Event {

    private Customer customer;

    public LookForCheckoutEvent(Customer customer) {
        super(customer.shoppingDuration);
        this.customer = customer;
    }

    @Override
    public Event happen() {

        // Hvis det skjer noe galt returneres en error event
        Event event = ErrorEvent.getInstance(getTimeAfterLooking4Q());

        for(Checkout c : customer.shop.getCheckouts()) {
            if(c.customers.size() > 0) {
                event = new JoinQEvent(getTimeAfterLooking4Q(), c, customer);
            } else {
                // hvis ingen kø, gå direkte til å betale
                event = new CheckoutEvent(getTimeAfterLooking4Q(), c, customer);
            }
        }

        return event;
    }

    private int getTimeAfterLooking4Q() {
        return customer.shoppingDuration + Constants.CUSTOMER_Q_LOOKING_DURATION;
    }


}
