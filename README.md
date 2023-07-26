# Card Game

This is a simple implementation of a Poker game in Java, consisting of three classes: `Card`, `Hand`, and `Poker`.

## Card Class

The `Card` class represents a playing card with a rank and a suit. It provides methods to get the rank and suit of the card. The ranks and suits are represented as enums to ensure type safety. Additionally, the class includes static methods to convert abbreviated card representations (e.g., "TD" for Ten of Diamonds) into corresponding `Rank` and `Suit` enum values.

### Usage Example:
```java
// Creating a card using rank and suit enums
Card card = new Card(Card.Rank.ACE, Card.Suit.HEARTS);

// Creating a card using a shorthand representation
Card card2 = new Card("TD"); // Ten of Diamonds
```

## Hand Class

The `Hand` class represents a poker hand, which is a collection of 5 cards. It provides methods to check the kind of the hand (e.g., flush, straight, pair, etc.), using methods like `isFlush()`, `isStraight()`, and `kind()`. The class also implements the `Comparable` interface to enable hand comparison based on their kind. The `compareTo()` method returns a negative integer if the current hand is worse, 0 if both hands are equal, and a positive integer if the current hand is better.

### Usage Example:
```java
// Creating a hand using a string containing all the cards
Hand hand = new Hand("5C TD AH QS 2D");

// Checking the kind of the hand
Hand.Kind kind = hand.kind();
```

## Poker Class

The `Poker` class represents the poker game. It allows you to add hands and determine the best hand among them. The `bestHand()` method returns the hand with the highest kind based on the implemented comparison logic in the `Hand` class.

### Usage Example:
```java
// Creating a Poker game
Poker pokerGame = new Poker();

// Adding hands to the game
Hand hand1 = new Hand("5C TD AH QS 2D");
Hand hand2 = new Hand("2H 2D 3S 3H 3C");
pokerGame.addHand(hand1);
pokerGame.addHand(hand2);

// Getting the best hand among the added hands
Hand bestHand = pokerGame.bestHand();
```

**Note:** The code provided above is a basic implementation of a Poker game with limited features. Additional functionality and error handling can be added as per specific requirements.
