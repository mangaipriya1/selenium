Feature: To check the Kiosk
@login
  Scenario Outline: To check the login functionality
    Given Open IE and start app
    When User navigates to login page1   
    Then User should login to the application
    
    Examples: 
      | username | password  |
     	 | mangai   | mangai123 |

    
   @Messages
   Scenario:  Send Messages to Public User
   And Click Messages
 