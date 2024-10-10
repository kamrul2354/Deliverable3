/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author rivan
 */
public class StartWarGame {
        public static void main(String[] args) {
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");

        WarGame game = new WarGame("War Card Game", player1, player2);
        game.play();
    }
}
