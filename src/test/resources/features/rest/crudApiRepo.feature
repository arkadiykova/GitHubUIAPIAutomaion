@regression @wip_arkady
Feature: User interacts with a repository API

  Background:
    Given the user is authenticated for API

  Scenario: User creates a new repository via API
    When the user sends a POST request to create a new repository
    Then the repository should be successfully created

  Scenario: User gets information about a repository via API
    Given there is an existing repository
    When the user sends a GET request to retrieve repository information
    Then the repository information  retrieved successfully

  Scenario: User updates a repository via API
    Given there is an existing repository
    When the user sends a PUT request to update the repository
    Then the repository should be successfully updated

  Scenario: User deletes a repository via API
    Given there is an existing repository
    When the user sends a DELETE request to delete the repository
    Then the repository should be successfully deleted