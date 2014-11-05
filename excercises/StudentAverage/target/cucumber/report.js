$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/wendy/example/get_average.feature");
formatter.feature({
  "id": "average",
  "description": "",
  "name": "Average",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "average;get-average-score-of-grades-for-a-student",
  "description": "",
  "name": "Get average score of grades for a student",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "I have a student with a bunch of grades",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "I add score 98,99,70,64,86,78",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "the average score is 82.00",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "Stepdefs.i_have_a_student()"
});
formatter.result({
  "duration": 69857000,
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
  "duration": 1363000,
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
  "duration": 3202000,
  "status": "passed"
});
formatter.scenario({
  "id": "average;get-minimum-score",
  "description": "",
  "name": "Get minimum score",
  "keyword": "Scenario",
  "line": 8,
  "type": "scenario"
});
formatter.step({
  "name": "I have a student with a bunch of grades",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I add score 98,79,60,23,10",
  "keyword": "When ",
  "line": 10
});
formatter.step({
  "name": "the minimum score is 20",
  "keyword": "Then ",
  "line": 11
});
formatter.match({
  "location": "Stepdefs.i_have_a_student()"
});
formatter.result({
  "duration": 20000,
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
  "duration": 83000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 21
    }
  ],
  "location": "Stepdefs.get_minimum(int)"
});
formatter.result({
  "duration": 778000,
  "status": "failed",
  "error_message": "java.lang.AssertionError: expected:\u003c20\u003e but was:\u003c10\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\n\tat org.junit.Assert.assertEquals(Assert.java:118)\n\tat org.junit.Assert.assertEquals(Assert.java:555)\n\tat org.junit.Assert.assertEquals(Assert.java:542)\n\tat com.wendy.example.Stepdefs.get_minimum(Stepdefs.java:34)\n\tat ✽.Then the minimum score is 20(com/wendy/example/get_average.feature:11)\n"
});
});