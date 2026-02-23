Feature: Place the Order for products

@PlaceOrder
Scenario Outline: Search Experience for Products both in home page and offers page

Given User is on GreenCart landing page
When user searched with shortname <Name> and extract the original product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom |
