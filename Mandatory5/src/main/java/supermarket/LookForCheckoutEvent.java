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

        Checkout[] checkouts = customer.shop.getCheckouts();

        // Hvis det skjer noe galt returneres en error event
        Event event = ErrorEvent.getInstance(getTimeAfterLooking4Q());

        int i = 0;
        int smallesQIndex = i;
        int smallesQLength = checkouts[i].customers.size();

        for(Checkout c : checkouts) {

            if(c.customers.size() == 0) {
                // hvis ingen kø, gå direkte til å betale
                event = new CheckoutEvent(getTimeAfterLooking4Q(), c, customer);
                break;
            }

            if(c.customers.size() < smallesQLength) {
                smallesQLength = c.customers.size();
                smallesQIndex = i;
            }

            i++;
        }

        return event;
    }

    private int getTimeAfterLooking4Q() {
        return customer.shoppingDuration + Constants.CUSTOMER_Q_LOOKING_DURATION;
    }


}
