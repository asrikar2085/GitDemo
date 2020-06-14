Feature: Login to QAClickAcademy site

Scenario Outline: Positive scenario for login
Given Initialize the driver
And User launches the "http://www.qaclickacademy.com/" website
And User clicks on Login Button
When User enter username <username> and password <password> and logs in
Then User should be able to login
And CLose the browser
Examples:
|username		|password		|
|asrikar		|tp123			|
|asrikar2085	|tp234			|