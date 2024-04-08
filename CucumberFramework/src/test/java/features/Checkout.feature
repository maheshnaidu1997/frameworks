Feature: Place the order for Products
@PlaceOrder
Scenario Outline: Search Experiance for product search in both home and offers page

Given User is on GreenCart Landing page
When user searched with a shortname <Names> and extracted the actual name of product
And Added "10" items of selected product to cart
Then User proceeds to checkout and validate the <Names> items in checkout page
And Varify user has ability to enter promo code and place the order

Examples:
|	Names	|
| Tom		|