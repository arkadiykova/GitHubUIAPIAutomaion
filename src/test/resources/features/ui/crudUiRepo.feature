@regression @ui
Feature: User is able to create, get, update/put, and delete the repo

  Background:
    Given the user logged in

  Scenario: User interacts with a repository
    When the user creates a new repository
    Then the repository should be created successfully

    When the user gets information about the repository
    Then the repository information should be retrieved successfully

    When the user updates the repository
    Then the repository should be updated successfully

    When the user deletes the repository
    Then the repository should be deleted successfully
