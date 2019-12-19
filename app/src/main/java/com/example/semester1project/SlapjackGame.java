package com.example.semester1project;

import java.util.ArrayList;
import java.util.List;

public class SlapjackGame {

    private List<Card> robotList;
    private List<Card> playerList;
    private List<Card> pileList;
    private boolean playerTurn; // true = player's turn, false = robot's turn
    private boolean combo = false;

    public SlapjackGame(List<Card> robotList, List<Card> playerList, List<Card> pileList) {
        this.robotList = robotList;
        this.playerList = playerList;
        this.pileList = pileList;
    }

    public void playCardPlayer() {
        // basically burnCard method but the card goes to the top (last index)
        pileList.add(playerList.get(playerList.size() - 1));
        playerList.remove(playerList.get(playerList.size() - 1));
    }

    public void playCardRobot() {
        pileList.add(robotList.get(robotList.size() - 1));
        robotList.remove(robotList.get(robotList.size() - 1));
    }

    public void burnCard(List<Card> deck) {
        // basically playCard method but the card goes to the bottom (first index)
        pileList.add(0, deck.get(deck.size() - 1));
        deck.remove(deck.get(deck.size() - 1));
    }

    public void moveCardsToWinner(List<Card> winnerList){
        for (int i = pileList.size() - 1; i >= 0; i--){
            winnerList.add(0, pileList.get(i));
            pileList.remove(0);
        }
    }

    public boolean getTurn(){
        return playerTurn;
    }

    public boolean checkEndGame() {
        if (playerList.size() == 0 || robotList.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    // changed this method to return boolean combo after changing the value of combo
    public boolean checkForCombo() {
        // delete the previous combo if there are no matches
        // checking for sandwiches
        combo = false;
        if (pileList.size() > 2) {
            if (pileList.get(pileList.size()- 3).getNumber() == pileList.get(pileList.size() - 1).getNumber()){
                combo = true;
            }
        }
        // checking for doubles
        if (pileList.size() > 1) {
            if ((pileList.get(pileList.size() - 2)).getNumber() == pileList.get(pileList.size() - 1).getNumber()) {
                combo = true;
            }

        }
        // checking for jacks
        if (pileList.size() > 0) {
            if (pileList.get(pileList.size() - 1).getNumber() == 11) {
                combo = true;
            }
        }
        return combo;
    }
}
