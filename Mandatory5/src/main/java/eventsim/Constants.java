package eventsim;

public class Constants {
    public static final int SM_NUM_CHECKOUTS = 1;
    public static final int SM_NUM_CUSTOMERS = 4;

    public static final int CUSTOMER_MAX_PRODUCTS = 500;
    public static final int CUSTOMER_MIN_PRODUCTS = 1;

    // TODO: trekke fra nok varer til å være innenfor max shopping time hvis antall varer * time per product blir for høyt
    public static final int CUSTOMER_MAX_SHOPPING_TIME = 10800;
    public static final int TIME_PER_PRODUCT = 90;
}
