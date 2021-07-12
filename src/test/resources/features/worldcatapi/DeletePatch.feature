

Feature: Patch delete test

@deletePatch
   Scenario: Patch delete Test
    Given The patch delete API is up and running
    When I hit patch delete end point url
    Then API returns the response with status code as 200