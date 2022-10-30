import java.util.ArrayList;
import java.util.Collections;  
import java.util.List;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{

    String playerOneCards;
    String playerTwoCards;
    
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        System.out.print('\u000C');
        System.out.println("After 300 Rounds, The Game Will End");
        System.out.println();
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        Deck p1 = halves[0];
        Deck p2 = halves[1];
        

        // ...then run the event loop
        this.runEventLoop(p1, p2);
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck p1, Deck p2) {
        int round = 1;
        boolean isWar =false;

        while(p1.getDeckSize() > 0 && p2.getDeckSize() > 0  ) {
            isWar = false;
            playerOneCards = "Player 1 Cards: " + p1.getDeckSize();
            playerTwoCards = "Player 2 Cards: " + p2.getDeckSize();
            
            System.out.println("Round: " +round);
            System.out.println(playerOneCards);
            System.out.println(playerTwoCards);
            Card p1Card = p1.dealCardFromDeck();
            Card p2Card = p2.dealCardFromDeck();

            System.out.println();
            System.out.println("Player 1 Card: " + p1Card.getFace() + " of " +p1Card.getSuit());
            System.out.println("Player 2 Card: " + p2Card.getFace() + " of " + p2Card.getSuit());
            System.out.println();

            try {
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

                    List<Card> warDeckOne = new ArrayList<Card>();
                    List<Card> warDeckTwo = new ArrayList<Card>();

                    warDeckOne.add(p1Card);
                    warDeckTwo.add(p2Card);

                    while(p1Card.getRank() == p2Card.getRank()) {
                        isWar = true;
                        

                        System.out.println("War!");
                        System.out.println();

                        for(int i = 0; i < 3; i++) {
                            warDeckOne.add(p1.dealCardFromDeck());
                            warDeckTwo.add(p2.dealCardFromDeck());
                        }

                        p1Card = p1.dealCardFromDeck();
                        p2Card = p2.dealCardFromDeck();

                        warDeckOne.add(p1Card);
                        warDeckTwo.add(p2Card);

                        System.out.println("Player 1 Card: " + p1Card.getFace() + " of " +p1Card.getSuit());
                        System.out.println("Player 2 Card: " + p2Card.getFace() + " of " + p2Card.getSuit());
                        System.out.println();

                        if( p1Card.getRank() > p2Card.getRank() ) {
                            System.out.println("Player 1 Wins War!");

                            for(Card card : warDeckOne) {
                                p1.addCardToDeck(card);

                            }
                            for(Card card : warDeckTwo) {
                                p1.addCardToDeck(card);
                            }

                        }
                        else if (p2Card.getRank() > p1Card.getRank()) {
                            System.out.println("Player 2 Wins War!");

                            for(Card card : warDeckOne) {
                                p2.addCardToDeck(card);

                            }
                            for(Card card : warDeckTwo) {
                                p2.addCardToDeck(card);
                            }

                        }
                    }

                }

                round++;
                System.out.println();
            }
            catch (Exception e) {
                if(p1.getDeckSize() < 4) {
                    System.out.println("Player 1: Not Enough Cards");
                    System.out.println();
                }

                if(p2.getDeckSize() < 4) {
                    System.out.println("Player 2: Not Enough Cards");
                    System.out.println();
                }

                break;
            }
            if (round >300) {
                break;

            }
        }
        if(p1.getDeckSize() > p2.getDeckSize()) {
            if( isWar == true) {
                System.out.println("Final Cards: ");
                System.out.println(this.playerOneCards);
                System.out.println(this.playerTwoCards);
                System.out.println();
                System.out.println("Player 1 Wins The Game!");
            }
            else {
                System.out.println("Final Cards: ");
                System.out.println("Player 1 Cards: " + p1.getDeckSize());
                System.out.println("Player 2 Cards: " + p2.getDeckSize());
                System.out.println();
                System.out.println("Player 1 Wins The Game!");
            }
        }
        else if (p2.getDeckSize() > p1.getDeckSize()) {
            if(isWar ==true) {
                System.out.println("Final Cards: ");
                System.out.println(this.playerOneCards);
                System.out.println(this.playerTwoCards);
                System.out.println();
                System.out.println("Player 2 Wins The Game!");
            }
            else {
                System.out.println("Final Cards: ");
                System.out.println("Player 1 Cards: " + p1.getDeckSize());
                System.out.println("Player 2 Cards: " + p2.getDeckSize());
                System.out.println();
                System.out.println("Player 1 Wins The Game!");            
            }
        }
        else {
            System.out.println("Final Cards: ");
            System.out.println(this.playerOneCards);
            System.out.println(this.playerTwoCards);
            System.out.println();
            System.out.println("Game Is A Tie!");

        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
