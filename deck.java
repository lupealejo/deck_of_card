/** ========================================
Steven's: 

	- Deck (int numPacks); 
	- void init (int numPacks);
	- void shuffle();
	- Card inspectCard(int k); 
      ====================================== */

public class deck {

	// Final constant ( 6 packs maximum ): 
	public static final int MAX_CARDS = 6*52; 

	// Private static member data: 
	private static Card [] masterPack; // Array, containing exactly 52 card references.
	
	// Private member data: 
	private Card [] cards; 
	private int topCard; 
	private int numPacks; 

	// Public Methods ===================================================

	// Constructor : Populates the arrays and assigns initial valuees to members. 
	public Deck (int numPacks) {

		allocateMasterPack (); // Lupes Method (needs to be called in constructor).  
		this.cards = masterPack; 
		init (numPacks);
	}
	
	// Overloaded Constructor : If no parameters are passed, 1 pack is assumed (default). 
	public Deck (int numPacks) {

		this(1); 
	}

	// Re-populates Card array with 52 * numPacks. ( Doesn't re-populate masterPack ). 
	void init (int numPacks) {

		this.numPacks = numPacks; 
		int a, b, c;   
		
		// Need to get top card via Brenna's accessor...
		if ((topCard) <= MAX_CARDS && numPacks != 0) {
			cards = new Card [topCard]; 
			
			for (a = 0; a < cards.length; a++) {
				cards [a] = new Card (); 		
		
				for (a = 0; a < numPacks; a++) {
				
					for (b = 52 * a; c = 0; b < 52 * a + 52; b++, c++) {
						cards [b] = masterPack [c]; 
					}
				}
			}
		else 
			return;  
		}
	} // Close init method. 

	// Mix up cards with the help of standard random num generator: 
	public void shuffle () {	
		
		Random randObj = new Random(); 
		int a; 
		
		for (a = cards.length - 1; a > 0; a--) {
			
			// nextInt() method to get a pseudorandom value from 0 to cards.length. 
			int randNum = randObj.nextInt(k +1);
				
			// Changing the cards value: 
			Card temp = cards [randNum];
			cards [randNum] = cards [a]; 
			cards [a] = temp; 
		}
	} // Close shuffle method. 

	// Accessor for an individual card. Returns a card with errorFlag = true if k is bad. 
	public Card inspectCard (int k) {

		Card card; 

		if (k < 0) {
			// Triggers errorFlag as there is no value 'R'. 
			card = new Card('R', Suit.hearts);
		}
		else {
			card = card [k]; 
		}
		
		return card;  
	}
	
} // Close deck class. 


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


//This method displays the cardInfo 
public String toString()
{
   String cardInfo;

   if (errorFlag)
      return "[ invalid ]";

   cardInfo = String.valueOf(value);
   cardInfo += " of ";
   cardInfo += String.valueOf(suit);

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

	
	
