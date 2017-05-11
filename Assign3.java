import java.util.*;

public class Assign3
{
	public static void main(String [] args)
	{
		Card first = new Card('A', Card.Suit.spades);
		Card second = new Card('2', Card.Suit.hearts);
		Card third = new Card('D', Card.Suit.clubs);
		
		System.out.println(first.toString());
		System.out.println(second.toString());
		System.out.println(third.toString());
		
		third.set('A', Card.Suit.hearts);
		first.set('G', Card.Suit.clubs);
		
		System.out.println(first.toString());
		System.out.println(second.toString());
		System.out.println(third.toString());
	}
}

class Card
{
   public enum Suit { clubs, diamonds, hearts, spades }
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   //Default Constructor
   Card()
   {
	   set('A', Suit.spades);
   }
   
   //Constructor
   Card(char value, Suit suit)
   {
      set(value, suit);
   }
   
   //Mutators
   public void setValue(char newValue)
   {
      value = newValue;
   }
   
   public void setSuit(Suit newSuit)
   {
      suit = newSuit;
   }
   
   //Accessors
   public char getValue()
   {
	   return value;
   }
   
   public Suit getSuit()
   {
	   return suit;
   }
   
   //Public Methods
   public String toString()
   {
	   if (errorFlag == true)
	   {
		   return "[ invalid ]";
	   }
	   else 
	   {
		   return "(" + value + ", " + suit +")";
	   }
   }
   
   public boolean set(char value, Suit suit)
   {
	   setValue(value);
	   setSuit(suit);
	   errorFlag = isValid(value, suit);
	   
	   return true;
   }
   
   //Private Methods
   private boolean isValid(char value, Suit suit)
   {
	   if (value == 'A' || value == '2' || value == '3' || value == '4' || value == '5' || value == '6' || value == '7' || value == '8' || value == '9' || value == 'T' || value == 'J' || value == 'Q' || value == 'K')
	   {
		   return false;
	   }
	   else
		   return true;
   }
}

class Hand
{
   public int MAX_CARDS = 50;
   private Card[] myCards;
   int numCards;
   
   //Default Constructor
   Hand()
   {
	   myCards = new Card[MAX_CARDS];
	   numCards = 0;
   }
   
   public void resetHand()
   {
	   myCards = new Card[MAX_CARDS];
	   numCards = 0;
   }
   
   public boolean takeCard(Card card)
   {
	   myCards[numCards].set(card.getValue(), card.getSuit());
	   ++numCards;
	   
	   return true;
   }
   
   public Card playCard()
   {
	   
   }
}

class Deck
{
   
}