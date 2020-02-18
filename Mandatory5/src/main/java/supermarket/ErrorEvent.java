package supermarket;

import eventsim.Event;

public class ErrorEvent extends Event {

    private static ErrorEvent err = null;
    int time;

    public static ErrorEvent getInstance(int time)
    {
        if (err == null) {
            err = new ErrorEvent(time);
        }

        return err;
    }


    private ErrorEvent(int time) {
        super(time);
    }

    @Override
    public Event happen() {
        return null;
    }
}
