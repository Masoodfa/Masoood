
Feature: Post requests MARC21 XML

@requestPostMARC21XML
   Scenario: Post request Test
    Given The post XML API is up and running
    When I hit post XML end point url
    Then API returns the response with status code as 200
    
    
    
    
    
   