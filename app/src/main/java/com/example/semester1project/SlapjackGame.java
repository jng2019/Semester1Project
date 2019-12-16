package com.example.semester1project;

import java.util.List;

public class SlapjackGame {

    private List<Card> robotList;
    private List<Card> playerList;
    private List<Card> pileList;
    private boolean playerTurn; // true = player's turn, false = robot's turn
    private boolean combo = false;

    public SlapjackGame(List<Card> robotList, List<Card> playerList){
        this.robotList = robotList;
        this.playerList = playerList; }

    public void playCard(List<Card> deck) {
        // basically burnCard method but the card goes to the top (last index)
            pileList.add(deck.get(deck.size() - 1));
    }

    public void burnCard(List<Card> deck) {
        // basically playCard method but the card goes to the bottom (first index)
            pileList.add(0, deck.get(deck.size() - 1));
    }

    public void moveCardsToWinner(List<Card> winnerList){
        for (int i = pileList.size() - 1; i >= 0; i--){
            winnerList.add(0, pileList.get(i));
        }
    }

    public boolean getTurn(){
        return playerTurn;
    }

    public boolean checkEndGame(){
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
        if (pileList.size() > 2){
            if (pileList.get(pileList.size()- 3).getNumber() == pileList.get(pileList.size() - 1).getNumber()){
                combo = true;
            }
        }
        // checking for doubles
        else if ((pileList.size() > 1)) {
            if ((pileList.get(pileList.size() - 2)).getNumber() == pileList.get(pileList.size() - 1).getNumber()) {
                combo = true;
            }
        }
        // checking for jacks
        else {
            combo = pileList.get(pileList.size() - 1).getNumber() == 11;
        }
        return combo;
    }
}
