# 211Supermarket

## Authors: Bjørnar Risdalen & Trym Staurheim

## In this assignment we have researched and implemented a discrete simulation model for a Supermarket.

## Our implementation
Our simulation model consists of the six events (in order): BeginShoppingEvent, LookForCheckoutEvent, WaitInQEvent, CheckoutEvent, ServeEvent and EndShoppingEvent. The BeginShoppingEvent is the origin Event for every Customer. When it is processed, either a LookForCheckoutEvent or EndShoppingEvent will be returned, depending on if the customer's "shopping list" (numProducts) is respectively greater than 0 or not. When the Customer has more than 0 number of products to buy, the BeginShoppingEvent lasts for the number of items times the constant number TIME_PER_PRODUCT, which can be found in the Constants.java file. This value (duration of BeginShoppingEvent) is stored in the filed called endShoppingTime in the Customer object. 

The LookForCheckoutEvent is the next event in the model. 

Afterwards we start with the WaitInQEvent.

WaitInQ returns the CheckoutEvent, and

The penultimate event is the ServeEvent, which

Finally the customer enters a EndShoppingEvent. This event simply displays when a customer leaves, and assigns the time to the customer's leaveTime. 

## Continued development
If we were to continue development of this project we would like to work on the following things:

## Known bugs
In WaitInQEvent, the value of every customers scan- and payment time is calculated, and added to the event before it starts. One problem seems to be that one's own time is calculated and added to the waittime, which should be ignored.
