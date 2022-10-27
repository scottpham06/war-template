
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    Deck p1;
    Deck p2;
    
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        Deck p1 = halves[1];
        Deck p2 = halves[2];
        boolean gameStatus = true;
        
        
        
        
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        while(p1.getDeckSize() > 0 && p2.getDeckSize() >0) {
            Card p1Card = p1.dealCardFromDeck();
            Card p2Card = p2.dealCardFromDeck();
            int round = 1;
            System.out.println("Round: " +round);
            System.out.println("Player 1 Cards: " + p1.getDeckSize());
            System.out.println("Player 2 Cards: " + p2.getDeckSize());
            System.out.println();
            System.out.println();
            
            if(p1Card.getRank() > p2Card.getRank()) {
               System.out.println("Player 1 Wins!");
               p1.addCardToDeck(p1Card);
               p1.addCardToDeck(p2Card);
            }
            else if(p2Card.getRank() > p1Card.getRank()) {
                System.out.println("Player 2 Wins!");
                p2.addCardToDeck(p2Card);
                p2.addCardToDeck(p1Card);
            }
            else {
                System.out.println("War!");
            }
            round++;
            System.out.println();
        }
        
        if(p1.getDeckSize() == 0) {
            System.out.println("Player 1 Wins!");
        }
        else {
            System.out.println("Player 2 Wins!");
        }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
