
Feature: Post requests

@post
   Scenario: Post request Test
    Given The post API is up and running
    When I hit post end point url
    Then API returns the response with status code as 200
    
    
    
    
   