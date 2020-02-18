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

        int i = 0;
        int smallesQIndex = i;
        int smallesQLength = checkouts[i].customers.size();

        for(Checkout c : checkouts) {

            if(c.customers.size() == 0) {
                // hvis ingen kø, gå direkte til å betale
                return new CheckoutEvent(getTimeAfterLooking4Q(), c, customer);
            }

            if(c.customers.size() < smallesQLength) {
                smallesQLength = c.customers.size();
                smallesQIndex = i;
            }

            i++;
        }

        return new JoinQEvent(getTimeAfterLooking4Q(), checkouts[smallesQIndex], customer);
    }

    private int getTimeAfterLooking4Q() {
        return customer.shoppingDuration + Constants.CUSTOMER_Q_LOOKING_DURATION;
    }


}
