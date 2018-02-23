Feature: To check the Facility Staff Login

  Scenario Outline: To check the login functionality
    Given Open chrome and start application
    When User navigates to login page
    And I enter valid "<username>" and valid "<password>"
    Then User should login to the application

    Examples: 
      | username | password  |
      | facstaff0510   | mangai123 |    
 

@Grievances
 Scenario:  Respond to Request/Grievances
 And Click Request
 
 |Description | Hello |

 @InitiateMessages
 Scenario: Initiate Messages to the Inmate
 And click Initiate Message
 
 |Message Type| 54 |
 |Choose Inmate |1769|
 |Description| TestHello |
 |pdf| C:\\Users\\mangaipriya\\Desktop\\pdf.pdf |
 |SearchType|56|
 |Searchstatus|1|
 
 @Messages
 Scenario:  To check Messages
 And Click Messages
 
 |flag|0|
 |No flag|1|
 |Quarantine|2|
 
 @Photos
 Scenario:  To check Photos
 And Click Photos
 
 |pending|3|
 |Approved|1|
 |Rejected|2|
 |All|4|
 
 @Notice
 Scenario: To check Notice	
 And Click Notices
 
 |Title| Test Title |
 |Description| Test Desc|
 |Start Date| 01/22/2018 |
 |End date|01/22/2019|
 
 
 @Dashboard
 Scenario: To check Dashboard
 And Click Dashboard
 
 
 
 