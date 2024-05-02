Feature: Subscribe

  @Subs
  Scenario Outline: Subscribe with valid email from sign-up bloc
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country> and <currency>
    And the user has accessed the sign-up bloc
    When the user inserts a valid email <email> and attempts to subscribe
    And the user selects the country where they live <country>
    And the user selects the most exciting topic from the world of Fortnums <fortnumTopic>
    And the user selects the Fortnums product <product> they would take to a desert island
    And the user attemps to subscribe
    Then the user is successfully subscribed
    Examples:
      | country        | fortnumTopic | product                   | currency | email                           |
      | United Kingdom | Restaurants  | Fortnum’s Tabletop Trivia | € EUR    | kiffoubreucrigra-7916@yopmail.com |
