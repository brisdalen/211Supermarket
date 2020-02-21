package supermarket;

import eventsim.Constants;
import eventsim.Event;

public class LookForCheckoutEvent extends Event {

    private Customer customer;

    public LookForCheckoutEvent(int time, Customer customer) {
        super(time);
        this.customer = customer;
    }

    @Override
    public Event happen() {

        Checkout[] checkouts = customer.shop.getCheckouts();

        int i = 0;
        int smallesQIndex = i;
        int smallesQLength = checkouts[i].customers.size();

        for(Checkout c : checkouts) {
/*
            if(c.customers.size() == 0) {
                // hvis ingen kø, gå direkte til å betale
                return new CheckoutEvent(getTimeAfterLooking4Q(), c, customer);
            }*/

            if(c.customers.size() < smallesQLength) {
                smallesQLength = c.customers.size();
                smallesQIndex = i;
            }

            i++;
        }

        System.out.println(Constants.ANSI_BRIGHT_GREEN + "checkouts = " + checkouts[smallesQIndex].customers.size() + Constants.ANSI_RESET);
        checkouts[smallesQIndex].addCustomer(customer);
        return new WaitInQEvent(getTimeAfterLooking4Q(), checkouts[smallesQIndex], customer);
    }

    private int getTimeAfterLooking4Q() {
        //return customer.shoppingDuration + Constants.CUSTOMER_Q_LOOKING_DURATION;
        return this.getTime() + Constants.CUSTOMER_Q_LOOKING_DURATION;
    }


}
