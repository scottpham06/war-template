import java.util.ArrayList;
import java.util.Collections;  
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
        Deck p1 = halves[0];
        Deck p2 = halves[1];
        boolean gameStatus = true;
        
        
        
        
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        while(p1.getDeckSize() > 0 && p2.getDeckSize() > 0) {
            Card p1Card = p1.dealCardFromDeck();
            Card p2Card = p2.dealCardFromDeck();
            int round = 1;
            System.out.println("Round: " +round);
            System.out.println("Player 1 Cards: " + p1.getDeckSize());
            System.out.println("Player 2 Cards: " + p2.getDeckSize());
            System.out.println();
            System.out.println("Player 1 Card: " + p1Card.getFace() + " of " +p1Card.getSuit());
            System.out.println("Player 2 Card: " + p2Card.getFace() + " of " + p2Card.getSuit());
            
            if(p1Card.getRank() > p2Card.getRank()) {
               System.out.println("Player 1 Wins This Round!");
               p1.addCardToDeck(p1Card);
               p1.addCardToDeck(p2Card);
            }
            else if(p2Card.getRank() > p1Card.getRank()) {
                System.out.println("Player 2 Wins This Round!");
                p2.addCardToDeck(p2Card);
                p2.addCardToDeck(p1Card);
            }
            else {
                System.out.println("War!");
                Deck warDeckOne = new Deck();
                Deck warDeckTwo = new Deck();
                
                warDeckOne.addCardToDeck(p1Card);
                warDeckTwo.addCardToDeck(p2Card);
                
                for(int i = 0; i == 2; i++) {
                    warDeckOne.addCardToDeck(p1.dealCardFromDeck());
                    warDeckTwo.addCardToDeck(p2.dealCardFromDeck());
                }
                
                if(p1.dealCardFromDeck().getRank() > p2.dealCardFromDeck().getRank()) {
                    p1.addAll();
                    
                    
                }
                
                
                
            }
            round++;
            System.out.println();
        }
        
        if(p1.getDeckSize() == 0) {
            System.out.println("Player 1 Wins The Game!");
        }
        else {
            System.out.println("Player 2 Wins The Game!");
        }
    }
    
 
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
