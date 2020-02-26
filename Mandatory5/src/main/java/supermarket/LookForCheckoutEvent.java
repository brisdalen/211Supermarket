package supermarket;

import com.sun.tools.internal.jxc.ap.Const;
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
        Checkout checkout = findShortestCheckoutQ(customer.shop.getCheckouts());
        System.out.println(Constants.ANSI_BRIGHT_GREEN + "q size before = " + checkout.customers.size() + Constants.ANSI_RESET);
        int waitTime = 0;
        for(Customer c : checkout.customers) {
            // Calculate total wait time in the qeueu
            waitTime += getCustomerCheckoutDuration(c);
        }
        if(checkout.customer != null) {
            waitTime += getCustomerCheckoutDuration(checkout.customer);
        }
        System.out.println(Constants.ANSI_BRIGHT_MAGENTA + " total waitTime = " + waitTime + Constants.ANSI_RESET);
        checkout.addCustomer(customer);
        System.out.println(Constants.ANSI_BRIGHT_GREEN + "q size after = " + checkout.customers.size() + Constants.ANSI_RESET);
        return new WaitInQEvent(getTime() + waitTime, checkout, customer);
    }

    private Checkout findShortestCheckoutQ(Checkout[] checkouts) {
        if(checkouts.length == 1) {
            System.out.println(Constants.ANSI_CYAN_BACKGROUND + Constants.ANSI_BRIGHT_RED + "Checkout 0 returned" + Constants.ANSI_RESET);
            return checkouts[0];
        }

        int smallestQ = 255;
        int smallestQIndex = 0;

        for(int i = 0; i < checkouts.length; i++) {
            int size = checkouts[i].customers.size();
            if(size < smallestQ) {
                smallestQ = size;
                smallestQIndex = i;
            }
        }
        System.out.println(Constants.ANSI_CYAN_BACKGROUND + Constants.ANSI_BRIGHT_RED + "Checkout " + smallestQIndex + " returned" + Constants.ANSI_RESET);
        return checkouts[smallestQIndex];
    }

    private int getCustomerCheckoutDuration(Customer customer) {
        int waitTime = Constants.CHECKOUT_PAY_DURATION + (Constants.CHECKOUT_PROD_DURATION * customer.numProducts);
        System.out.println(Constants.ANSI_BRIGHT_MAGENTA + "waitTime = " + waitTime + Constants.ANSI_RESET);
        return waitTime;
    }

    private int getTimeAfterLooking4Q() {
        //return customer.shoppingDuration + Constants.CUSTOMER_Q_LOOKING_DURATION;
        return this.getTime() + Constants.CUSTOMER_Q_LOOKING_DURATION;
    }

}
