/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * SYST 17796 Project Base code.
 * @author KamrulHasan
 * @studentID 991769795
 * @date 2024
 */
public class PlayingCard extends Card {
    private final String suit;
    private final int rank;

    public PlayingCard(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
