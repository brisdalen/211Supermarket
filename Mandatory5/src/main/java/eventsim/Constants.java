package eventsim;

public class Constants {
    public static final int SM_NUM_CHECKOUTS = 1;
    public static final int SM_NUM_CUSTOMERS = 4;

    public static final int CUSTOMER_MAX_PRODUCTS = 500;
    public static final int CUSTOMER_MIN_PRODUCTS = 1;

    // TODO: trekke fra nok varer til å være innenfor max shopping time hvis antall varer * time per product blir for høyt
    public static final int CUSTOMER_MAX_SHOPPING_TIME = 10800;
    public static final int TIME_PER_PRODUCT = 90;

    /**
     * ANSI strings for formating print statements with color
     */
    // --------- Forgrunnsfarger ---------
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // --------- Bakgrunnsfarger ---------
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
}
