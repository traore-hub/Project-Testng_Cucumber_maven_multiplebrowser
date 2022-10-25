Feature: login orange demo
  Scenario: authentification

    Given launch page orangeHM "browser" and "url"
    When enter the username "Admin"
    And password "admin123";
    And click button login
    Then verify title
    And close
