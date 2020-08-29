Feature: Landing
@smoke
Scenario: first automation test
  Given I open chrome page
  When is my search field visible
  And I type in search Hello World And Hit Enter
  Then Scroll down
  Then I click to github link to link
  When is GitHub page open







