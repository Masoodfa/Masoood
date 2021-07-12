


Feature: Post delete MARC 21 XML

@deleteMARC21XML
   Scenario: Post delete Test
    Given The post delete XML API is up and running
    When I hit post delete XML end point url
    Then API returns the response with status code as 200