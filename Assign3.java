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
	
   public boolean getFlag()
   {
	   return errorFlag;
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
	
   public boolean equals(Card card)
   {
	   if (getValue() == card.getValue() && getFlag() == card.getFlag() && getSuit() == card.getSuit())
	   {
		   return true;
	   }
	   else
		   return false;
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





/*========================================
Lupe's Part:

//This method will remove and return the top card in the array
public Card playCard()
{      
   Card topCard =  myCards[numCards - 1];
   myCards[numCards - 1] = null; 
   numCards-- ;
   return topCard;
}

//Returns the string built up by the Stringizer
 public String toString()
   {
      int i;
      String cardInfo = "Hand = ( ";

      for (i = 0; i < numCards; i++)
      {
         cardInfo += myCards[i].toString();
         if (i < numCards - 1)
            cardInfo += ", ";
      }
      cardInfo +=" )";
      return cardInfo;
   }

static private void allocateMasterPack()
{
   int x, y;
   Card.Suit cardSuit;
   char cardValue;

   // allocate 
   masterPack = new Card[52];
   for (y = 0; y < 52; y++)
      masterPack[y] = new Card();

   //loop for the suits 
   //set values for suit
   for (y = 0; y < 4; y++)
   {
      cardSuit = Card.Suit.values()[y];
      masterPack[13*y].set('A', cardSuit);

      for (cardValue='2', x = 1; cardValue<='9'; cardValue++, x++)

         masterPack[13*y + x].set(cardValue, cardSuit);
      masterPack[13*y+9].set('T', cardSuit);
      masterPack[13*y+10].set('J', cardSuit);
      masterPack[13*y+11].set('Q', cardSuit);
      masterPack[13*y+12].set('K', cardSuit);
   }
}



====================================== */

