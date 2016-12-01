Feature: CBA Test

  Scenario: Weather API Tests Invalid Key
    Given Accessing Information Without API Key Should Fail

  Scenario: Weather API City Name Should Be Returned
    Given Weather Page Is Open
    When Weather API Information Is Called For City Sydney
    Then Weather API Should Return Current City Sydney

  Scenario: Weather API City Name Should Be Returned
    Given Weather Page Is Open
    When Weather API Information Is Called For City Adelaide
    Then Weather API Should Return Current City Adelaide

