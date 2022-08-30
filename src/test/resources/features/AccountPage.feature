Feature: Account Page Feature

  Background: 
    Given user already logged in to Application
      | username | password |
      | S1003511 | SONU@25  |

  Scenario: Webpage main tab verfication
    Given user already logged in
    And get all tab details
    Then verfiy all tab working
