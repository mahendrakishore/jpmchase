@socialNetworking
Feature: To test social networking site functionality

  @posts
  Scenario: On social networking user is able to make posts
    Given User set the uri
    And User make a post with below data
          | userId | id | title | body |
          |   10   | 105 |  social networking   | social networking data    |
    When User make a posts

#  @comment
#  Scenario: On social networking another user is able to comment on posts
#
#  @userList
#  Scenario Outline: : On social networking get the lists of all users
#    Examples:
#    |id|



