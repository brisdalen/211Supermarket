package supermarket;

import eventsim.Event;

public class JoinQEvent extends Event {

    public JoinQEvent(int time, Checkout checkout, Customer customer) {
        super(time);
    }

    @Override
    public Event happen() {
        return null;
    }
}
