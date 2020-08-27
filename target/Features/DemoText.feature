Feature: Demo Home Page Text Validation Feature

@DemoHomePage
Scenario Outline: Verify Input Field Text

Given User is on Demo Home Page
When title of Home Page is Valid
Then user enters Input "<Message>"
Then user clicks on Show Message button
Then user verifies input text below
	
Examples:
	|Message|
	|Hi, This is a Demo Text|	
		
@DemoHomePage
Scenario Outline: Verify Sum of Two numbers

Given User is on Demo Home Page
When title of Home Page is Valid
Then user enters numeric value in text boxes <a> and <b>
Then user clicks on Get Total button
Then user verifies Sum below
	
Examples:
	|a| |b|
	|10||20|	
	
		