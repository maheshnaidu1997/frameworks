Feature: Search and place the order for products
@OffersPage
Scenario Outline: Search experiance for product search in both home and offers page

Given User is on GreenCart Landing page
When user searched with a shortname <Names> and extracted the actual name of product
Then user searched for <Names> shortname in offerspage
And validate product name in offers page matches with landing page

Examples:
|	Names	|
|	Tom		|
| Beet	|