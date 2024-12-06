/*
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

public class WarGame extends Game {

    private WarPlayer player1;
    private WarPlayer player2;
    private GroupOfCards deck;
    private static final int MAX_ROUNDS = 100;

    public WarGame(String name, WarPlayer player1, WarPlayer player2) {
        super(name);
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new GroupOfCards();
    }

    @Override
    public void play() {
        // Print the start of the game
        System.out.println("Welcome to War Card Game! Created by Kamrul Hasan");
        System.out.println("Player 1: " + player1.getName());
        System.out.println("Player 2: " + player2.getName());
        System.out.println("The game begins now. Let the battle commence!");

        deck.shuffle();

        // Deal the cards
        while (deck.size() > 0) {
            player1.addCardToHand(deck.drawCard());
            player2.addCardToHand(deck.drawCard());
        }

        int round = 0;
        // Play rounds until one player runs out of cards or max rounds reached
        while (player1.handSize() > 0 && player2.handSize() > 0 && round < MAX_ROUNDS) {
            round++;
            System.out.println("\n---------- Round " + round + " Starts ----------");

            // Draw cards for each player
            PlayingCard p1Card = player1.playCard();
            PlayingCard p2Card = player2.playCard();

            System.out.println(player1.getName() + " plays " + p1Card);
            System.out.println(player2.getName() + " plays " + p2Card);

            if (p1Card.getRank() > p2Card.getRank()) {
                player1.addCardToHand(p1Card);
                player1.addCardToHand(p2Card);
                System.out.println(player1.getName() + " wins this round!");
            } else if (p1Card.getRank() < p2Card.getRank()) {
                player2.addCardToHand(p1Card);
                player2.addCardToHand(p2Card);
                System.out.println(player2.getName() + " wins this round!");
            } else {
                // Handle tie by drawing one more card each
                System.out.println("Oops!!!!    It's a tie! War starts! Both players going to draw additional cards...");
                handleSimpleTie(player1, player2, p1Card, p2Card);
            }

            // End of round message
            System.out.println("---------- Round " + round + " Ends Here ----------");
        }

        declareWinner();
    }

    private void handleSimpleTie(WarPlayer player1, WarPlayer player2, PlayingCard p1Card, PlayingCard p2Card) {
        // Each player draws one additional card to break the tie
        if (player1.handSize() > 0 && player2.handSize() > 0) {
            PlayingCard p1ExtraCard = player1.playCard();
            PlayingCard p2ExtraCard = player2.playCard();

            System.out.println(player1.getName() + " draws " + p1ExtraCard);
            System.out.println(player2.getName() + " draws " + p2ExtraCard);

            // Determine the winner of the tie
            if (p1ExtraCard.getRank() > p2ExtraCard.getRank()) {
                player1.addCardToHand(p1Card);
                player1.addCardToHand(p2Card);
                player1.addCardToHand(p1ExtraCard);
                player1.addCardToHand(p2ExtraCard);
                System.out.println(player1.getName() + " wins the war!");
            } else if (p1ExtraCard.getRank() < p2ExtraCard.getRank()) {
                player2.addCardToHand(p1Card);
                player2.addCardToHand(p2Card);
                player2.addCardToHand(p1ExtraCard);
                player2.addCardToHand(p2ExtraCard);
                System.out.println(player2.getName() + " wins the war!");
            } else {
                System.out.println("It's a double tie during the war! Both players retain their cards.");
                player1.addCardToHand(p1Card);
                player2.addCardToHand(p2Card);
                player1.addCardToHand(p1ExtraCard);
                player2.addCardToHand(p2ExtraCard);
            }
        } else {
            System.out.println("One of the players does not have enough cards for a tie-breaker. Ending game.");
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("\n---------- Game Over ----------");
        if (player1.handSize() > player2.handSize()) {
            System.out.println(player1.getName() + " is the winner!");
        } else if (player2.handSize() > player1.handSize()) {
            System.out.println(player2.getName() + " is the winner!");
        } else {
            System.out.println("It's a tie!");
        }
        System.out.println("Thanks for playing War Card Game!");
    }
}
