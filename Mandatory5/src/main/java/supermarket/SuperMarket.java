/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;
import eventsim.Constants;
import eventsim.Event;
import eventsim.EventSim;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author evenal
 */
public class SuperMarket {

    public static void main(String[] arts) {
        SuperMarket supern = new SuperMarket();
        supern.startSim();
    }


    private int numOfCheckouts = Constants.SM_NUM_CHECKOUTS;
    private int numOfCustomers = Constants.SM_NUM_CUSTOMERS;


    Checkout[] checkouts;
    List<Customer> customers;
    List<Event> init;


    public SuperMarket() {

        checkouts = new Checkout[numOfCheckouts];
        for (int i = 0; i < numOfCheckouts; i++)
            checkouts[i] = new Checkout(this, i);
        customers = new ArrayList<>();
        init = new ArrayList<Event>();
        for (int i = 0; i < numOfCustomers; i++) {

            Customer c = new Customer(this, i);
            init.add(new BeginShoppingEvent(c));
            customers.add(c);
        }
    }


    public void startSim() {
        EventSim sim = EventSim.getInstance();
        sim.setup(init);
        sim.run();
    }
}
