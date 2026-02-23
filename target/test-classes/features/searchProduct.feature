Feature: Search and Place Order for products

@OffersPage
Scenario Outline: Search Experience for Products both in home page and offers page

Given User is on GreenCart landing page
When user searched with shortname <Name> and extract the original product
Then user searched for <Name> shortname in offers page 
And validate Product name in offers page matches with Landing Page

Examples:
| Name |
| Tom |
| Beet |