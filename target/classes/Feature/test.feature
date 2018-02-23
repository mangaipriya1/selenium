Feature: To check the Inmate public user

  Scenario Outline: To check the login functionality
    Given Open chrome and start application
    When User navigates to login page
    And I enter valid "<username>" and valid "<password>"
    Then User should login to the application

    Examples: 
      | username | password  |
      | mangai   | mangai123 |
      
  @SearchInmate
   Scenario:  Searching inmates to add contact
  And Click Find Inmates 
  | STATE   | 4    |
  | CITY    | 127  |
  |RELATION | test |
  
  
  @Replymsg
   Scenario:  Read Message from Inmate
  And Click Inbox
  | REPLY   | heiii |
  
   @Sentmsg
   Scenario:  Sent Message
   And Click Sent Items
  
   @Writemsg
   Scenario:  Write Message to Inmate
  And Click Write Message
  | SELECTINMATE  | 2605 |
  | SUBJECT  | TEST MESSAGE SUBJECT12|
  | WRITEMSG  | TEST MESSAGE CONTENT12 |
  | SELECTAMT  | 10 |
  
  @Writephotos
   Scenario:  Send Photos to Inmate
  And Click Photos
  | SELECTINMATE  | 2605 |
  | SUBJECT  | TEST MESSAGE SUBJECT12|
  | Choosefile  | C:\\Users\\Public\\Pictures\\Sample Pictures\\47230227-wallpaper-high-resolution.jpg |
  
 @MyAccount
   Scenario:  Edit My account
  And Click My account
  | fname   | mangai |
  | lname   | priya |
  
  @Purchasecredit
   Scenario:  Purchase credit
  And Click purchase credit
  | Inmate   | 1769 |
  | Amt   | 20 |
  | Full Name   | Test |
  | Card Number   | 2000 |
  | Email   | inmateinbox-buyer@sgstechie.com |
  | Pwd   | SGS@2017 |
  
  
  
  