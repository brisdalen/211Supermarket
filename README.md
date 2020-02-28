# 211Supermarket

### Authors: Bjørnar Risdalen & Trym Staurheim

## In this assignment we have researched and implemented a discrete simulation model for a Supermarket.

## Our implementation
Our simulation model consists of the six events (in order): BeginShoppingEvent, LookForCheckoutEvent, WaitInQEvent, CheckoutEvent, ServeEvent and EndShoppingEvent. The BeginShoppingEvent is the origin Event for every Customer. When it is processed, either a LookForCheckoutEvent or EndShoppingEvent will be returned, depending on if the customer's "shopping list" (numProducts) is respectively greater than 0 or not. When the Customer has more than 0 number of products to buy, the BeginShoppingEvent lasts for the number of items times the constant number TIME_PER_PRODUCT, which can be found in the Constants.java file. This value (duration of BeginShoppingEvent) is stored in the filed called endShoppingTime in the Customer object. 

**The LookForCheckoutEvent** is the next event in the model. It takes the current time and the Customer with the highest priorty in the Priorty Queue. During the LookForCheckoutEvent the current customer finds the shortest queue by checking whether there is more than one checkout available, then comparing which checkout has the shortest line of customers. The customer then picks a line and additional wait-time is added to the customers shoppingtime - which is based of off the current customers ahead in the checkoutline. Lastly it adds the current customer to a queue and returns ad new WaitInQ event. 

**WaitInQEvent** takes the current time, checkout and customer then removes the first customer in the queue and returns a new Checkout Event with the current time, checkout and customer.

**CheckoutEvent** takes the current time, checkout and customer and adds a payduration constant (number of products * checkout.duration) to the current time of the customer before returning a serve event.
 
**ServeEvent** is the penultimate event. It takes current time, checkout and customer, then removes that customer from the checkout returning a new EndshoppingEvent.

**EndShoppingEvent** is the final event. The customer enters a EndShoppingEvent. This event simply displays when a customer leaves, and assigns the time to the customer's leaveTime by adding the totalcheckout time and that customers checkoutduration and returning null in the Event happen method(). 

## Known bugs
In WaitInQEvent, the value of every customers scan- and payment time is calculated, and added to the event before it starts. One problem seems to be that one's own time is calculated and added to the waittime, which should be ignored.

## Continued development
If we were to continue development of this project we would like to work on the following things:
- Statistics at the end of simulation, with options to show average queue time, longest queue time, and so on.
- Different types of customers with different shopping times, different time per product and so on. These could be children, eldery, teens and so on.
- A simple GUI instead of having to manually change values in the Constants.java file.
- Realistic and relevant random events like cleanups, crying children, or other humorous events like shoplifts, power shortage, etc.
