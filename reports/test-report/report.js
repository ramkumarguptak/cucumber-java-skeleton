$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("skeleton/cba-tests.feature");
formatter.feature({
  "id": "cba-test",
  "description": "",
  "name": "CBA Test",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "cba-test;weather-api-tests-invalid-key",
  "description": "",
  "name": "Weather API Tests Invalid Key",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "Accessing Information Without API Key Should Fail",
  "keyword": "Given ",
  "line": 4
});
formatter.match({
  "location": "Stepdefs.Accessing_Information_Without_API_Key_Should_Fail()"
});
formatter.result({
  "duration": 295774280,
  "status": "passed"
});
formatter.scenario({
  "id": "cba-test;weather-api-city-name-should-be-returned",
  "description": "",
  "name": "Weather API City Name Should Be Returned",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "Weather Page Is Open",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "Weather API Information Is Called For City Sydney",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "Weather API Should Return Current City Sydney",
  "keyword": "Then ",
  "line": 9
});
formatter.match({
  "location": "Stepdefs.Weather_Page_Is_Open()"
});
formatter.result({
  "duration": 62435,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sydney",
      "offset": 43
    }
  ],
  "location": "Stepdefs.Weather_API_Information_Is_Called_For_City(String)"
});
formatter.result({
  "duration": 1166511292,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sydney",
      "offset": 39
    }
  ],
  "location": "Stepdefs.Weather_API_Should_Return_Current_City(String)"
});
formatter.result({
  "duration": 4398656,
  "status": "passed"
});
formatter.scenario({
  "id": "cba-test;weather-api-city-name-should-be-returned",
  "description": "",
  "name": "Weather API City Name Should Be Returned",
  "keyword": "Scenario",
  "line": 11,
  "type": "scenario"
});
formatter.step({
  "name": "Weather Page Is Open",
  "keyword": "Given ",
  "line": 12
});
formatter.step({
  "name": "Weather API Information Is Called For City Adelaide",
  "keyword": "When ",
  "line": 13
});
formatter.step({
  "name": "Weather API Should Return Current City Adelaide",
  "keyword": "Then ",
  "line": 14
});
formatter.match({
  "location": "Stepdefs.Weather_Page_Is_Open()"
});
formatter.result({
  "duration": 80395,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Adelaide",
      "offset": 43
    }
  ],
  "location": "Stepdefs.Weather_API_Information_Is_Called_For_City(String)"
});
formatter.result({
  "duration": 198269190,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Adelaide",
      "offset": 39
    }
  ],
  "location": "Stepdefs.Weather_API_Should_Return_Current_City(String)"
});
formatter.result({
  "duration": 341252,
  "status": "passed"
});
});