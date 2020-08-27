Feature: Demo Home Page Checkbox Validation Feature 

@DemoHomePage
Scenario: Verify Checkbox functionality 

Given User is on Demo Home Page
When title of Home Page is Valid
And User clicks on Input Forms Text
And user clicks on Checkbox Demo
And User checks the checkbox
Then user verifies success message below	
		