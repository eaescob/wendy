$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/wendy/example/get_average.feature");
formatter.feature({
  "id": "average",
  "description": "",
  "name": "Average",
  "keyword": "Feature",
  "line": 1
});
formatter.background({
  "description": "",
  "name": "This is just an example application",
  "keyword": "Background",
  "line": 3,
  "type": "background"
});
formatter.scenario({
  "id": "average;get-average-score-of-grades-for-a-student",
  "description": "",
  "name": "Get average score of grades for a student",
  "keyword": "Scenario",
  "line": 5,
  "type": "scenario"
});
formatter.step({
  "name": "I have a student with a bunch of grades",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "I add score 98,99,70,64,86,78",
  "keyword": "When ",
  "line": 7
});
formatter.step({
  "name": "the average score is 82.00",
  "keyword": "Then ",
  "line": 8
});
formatter.match({
  "location": "Stepdefs.i_have_a_student()"
});
formatter.result({
  "duration": 99036000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "98,99,70,64,86,78",
      "offset": 12
    }
  ],
  "location": "Stepdefs.add_score(String)"
});
formatter.result({
  "duration": 1296000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "82.00",
      "offset": 21
    }
  ],
  "location": "Stepdefs.get_average(String)"
});
formatter.result({
  "duration": 3087000,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "This is just an example application",
  "keyword": "Background",
  "line": 3,
  "type": "background"
});
formatter.scenario({
  "id": "average;get-minimum-score",
  "description": "",
  "name": "Get minimum score",
  "keyword": "Scenario",
  "line": 10,
  "type": "scenario"
});
formatter.step({
  "name": "I have a student with a bunch of grades",
  "keyword": "Given ",
  "line": 11
});
formatter.step({
  "name": "I add score 98,79,60,23,10",
  "keyword": "When ",
  "line": 12
});
formatter.step({
  "name": "the minimum score is 10",
  "keyword": "Then ",
  "line": 13
});
formatter.match({
  "location": "Stepdefs.i_have_a_student()"
});
formatter.result({
  "duration": 22000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "98,79,60,23,10",
      "offset": 12
    }
  ],
  "location": "Stepdefs.add_score(String)"
});
formatter.result({
  "duration": 87000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 21
    }
  ],
  "location": "Stepdefs.get_minimum(int)"
});
formatter.result({
  "duration": 775000,
  "status": "passed"
});
});