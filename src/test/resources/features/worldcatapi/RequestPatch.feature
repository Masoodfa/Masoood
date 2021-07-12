

Feature: Patch request test

@requtestPatch
   Scenario: Patch request Test
    Given The patch request API is up and running
    When I hit patch request end point url
    Then API returns the response with status code as 200