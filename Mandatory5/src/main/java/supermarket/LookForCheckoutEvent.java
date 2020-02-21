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
        Checkout checkout = customer.shop.getCheckouts()[0];
        checkout.addCustomer(customer);
        System.out.println(Constants.ANSI_BRIGHT_GREEN + "q size" + checkout.customers.size() + Constants.ANSI_RESET);
        return new WaitInQEvent(getTime(), checkout, customer);
    }

    private int getTimeAfterLooking4Q() {
        //return customer.shoppingDuration + Constants.CUSTOMER_Q_LOOKING_DURATION;
        return this.getTime() + Constants.CUSTOMER_Q_LOOKING_DURATION;
    }


}
