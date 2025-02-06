 Feature: Cart Feature
   Scenario: Verify that a product can be added to the shopping cart
     Given  Click on a lighting category on the home page And go to lamp
     When Click on “Add to Bag” button on a random product
     And Click on the same product and add it to the bag
     Then Ensure the quantity displayed in the bag