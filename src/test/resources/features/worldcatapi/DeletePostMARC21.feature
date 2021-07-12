

Feature: Post delete MARC 21

@deleteMARC21
   Scenario: Post request Test
    Given The post delete API is up and running
    When I hit post delete end point url
    Then API returns the response with status code as 200