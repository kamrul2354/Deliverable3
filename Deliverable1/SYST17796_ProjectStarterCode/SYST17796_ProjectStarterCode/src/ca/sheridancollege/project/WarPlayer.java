/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 *
 * @author rivan
 */
public class WarPlayer extends Player{
    private final ArrayList<PlayingCard> hand = new ArrayList<>();

    public WarPlayer(String name) {
        super(name);
    }

    public void addCardToHand(PlayingCard card) {
        hand.add(card);
    }

    public PlayingCard playCard() {
        return hand.remove(0); // Play the top card from the hand
    }

    public int handSize() {
        return hand.size();
    }

    @Override
    public void play() {
        // Logic for playing a turn (handled in Game logic)
    }
}
