/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

public class WarGame extends Game {

    private WarPlayer player1;
    private WarPlayer player2;
    private GroupOfCards deck;
    private static final int MAX_ROUNDS = 100; // Limit the number of rounds to 100

    public WarGame(String name, WarPlayer player1, WarPlayer player2) {
        super(name);
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new GroupOfCards();
    }

    @Override
    public void play() {
        deck.shuffle();

        // Deal the cards
        while (deck.size() > 0) {
            player1.addCardToHand(deck.drawCard());
            player2.addCardToHand(deck.drawCard());
        }

        int round = 0;
        // Play rounds until one player runs out of cards or we reach max rounds
        while (player1.handSize() > 0 && player2.handSize() > 0 && round < MAX_ROUNDS) {
            round++;
            System.out.println("Round " + round);

            PlayingCard p1Card = player1.playCard();
            PlayingCard p2Card = player2.playCard();

            System.out.println(player1.getName() + " plays " + p1Card);
            System.out.println(player2.getName() + " plays " + p2Card);

            if (p1Card.getRank() > p2Card.getRank()) {
                System.out.println(player1.getName() + " wins this round!");
                player1.addCardToHand(p1Card);
                player1.addCardToHand(p2Card);
            } else if (p1Card.getRank() < p2Card.getRank()) {
                System.out.println(player2.getName() + " wins this round!");
                player2.addCardToHand(p1Card);
                player2.addCardToHand(p2Card);
            } else {
                System.out.println("It's a tie!");
                // Tie logic could be added here
            }
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        if (player1.handSize() > player2.handSize()) {
            System.out.println(player1.getName() + " is the winner!");
        } else if (player2.handSize() > player1.handSize()) {
            System.out.println(player2.getName() + " is the winner!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
