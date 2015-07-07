$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("draftingGmailFeatures/draftingMail.feature");
formatter.feature({
  "line": 1,
  "name": "This feature tests the drafts in Gmail",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "this scenario tests how user logs in gmail, navigates to drafts and verifies draft stored mail",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user \u0027\u003cuserName\u003e\u0027 loggs in using his password \u0027\u003cpassword\u003e\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "starts composing a new email providing recipient \u0027\u003crecipient\u003e\u0027 and topic \u0027\u003ctopic\u003e\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "user during mail composing navigates to drafts",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "verify email with title \u0027\u003ctopic\u003e\u0027 is stored in draft\u0027s folder",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;",
  "rows": [
    {
      "cells": [
        "userName",
        "password",
        "recipient",
        "topic"
      ],
      "line": 10,
      "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;;1"
    },
    {
      "cells": [
        "juan.epam",
        "Password123$",
        "juan.epam@gmail.com",
        "Test Drafting"
      ],
      "line": 11,
      "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3567039145,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "this scenario tests how user logs in gmail, navigates to drafts and verifies draft stored mail",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user \u0027juan.epam\u0027 loggs in using his password \u0027Password123$\u0027",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "starts composing a new email providing recipient \u0027juan.epam@gmail.com\u0027 and topic \u0027Test Drafting\u0027",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "user during mail composing navigates to drafts",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "verify email with title \u0027Test Drafting\u0027 is stored in draft\u0027s folder",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "juan.epam",
      "offset": 10
    },
    {
      "val": "Password123$",
      "offset": 50
    }
  ],
  "location": "GmailTest.theUserLoggsInUsingHisUserNameAndPassword(String,String)"
});
formatter.result({
  "duration": 8053962695,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "juan.epam@gmail.com",
      "offset": 50
    },
    {
      "val": "Test Drafting",
      "offset": 82
    }
  ],
  "location": "GmailTest.userStartsComposingNewEmailProvidesRcipientAndTopic(String,String)"
});
formatter.result({
  "duration": 4904655062,
  "status": "passed"
});
formatter.match({
  "location": "GmailTest.userDuringMailComposingNavigatesToDrafts()"
});
formatter.result({
  "duration": 118101937,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test Drafting",
      "offset": 25
    }
  ],
  "location": "GmailTest.verifySpecificEmailIsInTheBox(String)"
});
formatter.result({
  "duration": 1230410761,
  "status": "passed"
});
formatter.after({
  "duration": 712202,
  "status": "passed"
});
});