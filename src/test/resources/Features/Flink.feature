Feature: Flink Assesment for Channels 
	Description: This feature will test given scenario as part of Assesment

@test 
Scenario: As a user, I want to buy two products from weathershopper 
	Given I am on the homescreen 
	When I click on Buy option on suncreen or Moisturizers based on the temprature 
	And I add less expensive product from two product types and click on Cart
	Then I verify added products are available in cart 
	And I verify the total product cost is shown correctly 
	When I click on pay with card button 
	And I enter email and card details and Click on pay
	Then I verify whether payment is done successfully