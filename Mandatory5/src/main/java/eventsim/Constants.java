package eventsim;

public class Constants {
    public static final int SM_NUM_CHECKOUTS = 1;
    public static final int SM_NUM_CUSTOMERS = 4;

    public static final int CUSTOMER_MAX_PRODUCTS = 500;
    public static final int CUSTOMER_MIN_PRODUCTS = 1;

    // TODO: trekke fra nok varer til å være innenfor max shopping time hvis antall varer * time per product blir for høyt
    public static final int CUSTOMER_MAX_SHOPPING_TIME = 10800;
    public static final int TIME_PER_PRODUCT = 90;

    //Checkout
    public static final int PROD_DURATION = 2;
    public static final int PAY_DURATION = 10;

    /**
     * ANSI strings for formating print statements with color
     */
    public static final String ANSI_RESET = "\u001B[0m";
    // --------- Forgrunnsfarger ---------
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // --------- Forgrunnsfarger ekstra lys ---------
    public static final String ANSI_BRIGHT_BLACK = "\u001b[30;1m";
    public static final String ANSI_BRIGHT_RED = "\u001b[31;1m";
    public static final String ANSI_BRIGHT_GREEN = "\u001b[32;1m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001b[33;1m";
    public static final String ANSI_BRIGHT_BLUE = "\u001b[34;1m";
    public static final String ANSI_BRIGHT_MAGENTA = "\u001b[35;1m";
    public static final String ANSI_BRIGHT_CYAN = "\u001b[36;1m";
    public static final String ANSI_BRIGHT_WHITE = "\u001b[37;1m";
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
