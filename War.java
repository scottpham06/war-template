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
        Deck playerOne = halves[0];
        Deck playerTwo = halves[1];

        // ...then run the event loop
        this.runEventLoop(playerOne, playerTwo);
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck playerOne, Deck playerTwo) {
        int round = 1;
        boolean notEnoughCards = false;

        while(playerOne.getDeckSize() > 0 && playerTwo.getDeckSize() > 0  ) {
            notEnoughCards = false;
            playerOneCards = "Player 1 Cards: " + playerOne.getDeckSize();
            playerTwoCards = "Player 2 Cards: " + playerTwo.getDeckSize();

            System.out.println("Round: " +round);
            System.out.println(playerOneCards);
            System.out.println(playerTwoCards);

            Card p1Card = playerOne.dealCardFromDeck();
            Card p2Card = playerTwo.dealCardFromDeck();

            System.out.println();
            System.out.println("Player 1 Card: " + p1Card.getFace() + " of " +p1Card.getSuit());
            System.out.println("Player 2 Card: " + p2Card.getFace() + " of " + p2Card.getSuit());
            System.out.println();

            try {
                if(p1Card.getRank() > p2Card.getRank()) {
                    System.out.println("Player 1 Wins This Round!");
                    playerOne.addCardToDeck(p1Card);
                    playerOne.addCardToDeck(p2Card);

                }
                else if(p2Card.getRank() > p1Card.getRank()) {
                    System.out.println("Player 2 Wins This Round!");
                    playerTwo.addCardToDeck(p2Card);
                    playerTwo.addCardToDeck(p1Card);

                }
                else {

                    List<Card> warDeckOne = new ArrayList<Card>();
                    List<Card> warDeckTwo = new ArrayList<Card>();

                    warDeckOne.add(p1Card);
                    warDeckTwo.add(p2Card);

                    while(p1Card.getRank() == p2Card.getRank()) {

                        System.out.println("War!");
                        System.out.println();

                        for(int i = 0; i < 3; i++) {
                            warDeckOne.add(playerOne.dealCardFromDeck());
                            warDeckTwo.add(playerTwo.dealCardFromDeck());
                        }

                        p1Card = playerOne.dealCardFromDeck();
                        p2Card = playerTwo.dealCardFromDeck();

                        warDeckOne.add(p1Card);
                        warDeckTwo.add(p2Card);

                        System.out.println("Player 1 Card: " + p1Card.getFace() + " of " +p1Card.getSuit());
                        System.out.println("Player 2 Card: " + p2Card.getFace() + " of " + p2Card.getSuit());
                        System.out.println();

                        if( p1Card.getRank() > p2Card.getRank() ) {
                            System.out.println("Player 1 Wins War!");

                            for(Card card : warDeckOne) {
                                playerOne.addCardToDeck(card);

                            }
                            for(Card card : warDeckTwo) {
                                playerOne.addCardToDeck(card);
                            }

                        }
                        else if (p2Card.getRank() > p1Card.getRank()) {
                            System.out.println("Player 2 Wins War!");

                            for(Card card : warDeckOne) {
                                playerTwo.addCardToDeck(card);

                            }
                            for(Card card : warDeckTwo) {
                                playerTwo.addCardToDeck(card);
                            }

                        }
                    }

                }

                round++;
                System.out.println();
            }
            catch (Exception e) {
                notEnoughCards = true;
                if(playerOne.getDeckSize() < 4) {
                    System.out.println("Player 1: Not Enough Cards");
                    System.out.println();
                }

                if(playerTwo.getDeckSize() < 4) {
                    System.out.println("Player 2: Not Enough Cards");
                    System.out.println();
                }

                break;
            }
            
            if (round >300) {
                break;

            }
        }

        if(playerOne.getDeckSize() > playerTwo.getDeckSize()) {
            if( notEnoughCards == true ) {
                printPreviousCards();
                System.out.println("Player 1 Wins The Game!");
            }
            else {
                printEndCards(playerOne, playerTwo);
                System.out.println("Player 1 Wins The Game!");
            }
        }
        else if (playerTwo.getDeckSize() > playerOne.getDeckSize()) {
            if(notEnoughCards ==true ) {
                printPreviousCards();
                System.out.println("Player 2 Wins The Game!");
            }
            else {
                printEndCards(playerOne, playerTwo);
                System.out.println("Player 2 Wins The Game!");            
            }
        }
        else {
            printEndCards(playerOne, playerTwo);
            System.out.println("Game Is A Tie!");

        }
    }

    public void printPreviousCards() {
        System.out.println("Final Cards: ");
        System.out.println(this.playerOneCards);
        System.out.println(this.playerTwoCards);
        System.out.println();
    }

    public void printEndCards(Deck playerOne, Deck playerTwo) {
        System.out.println("Final Cards: ");
        System.out.println("Player 1 Cards: " + playerOne.getDeckSize());
        System.out.println("Player 2 Cards: " + playerTwo.getDeckSize());
        System.out.println();
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
