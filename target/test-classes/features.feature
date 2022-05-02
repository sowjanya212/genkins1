Feature: Gmail mail compose

  Scenario: 
    Given open "edge" browser
    And launch site using "https://www.gmail.com"
    When do login using "sowji10q71a0212" and "chitti1992" credentials
    Then compose is displayed
    When click on compose and fill feilds and send mail and check response
      | to                       | subject    | body            | attachment                                                     |
      | jagan.cssi@gmail.com     | wishes     | congratulations | C:\\Users\\jagan\\OneDrive\\Pictures\\Nihaan.jpg               |
      | chittisowji212@gmail.com | sample pic | gud mrng        | C:\\Users\\jagan\\OneDrive\\Documents\\What is BUS Schema.docx |
    When do logout
    Then login page should be redisplayed
    When close site
