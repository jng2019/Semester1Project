package com.example.semester1project;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlapjackGame {

    private List<Card> robotList;
    private List<Card> playerList;
    private List<Card> pileList;
    private boolean playerTurn; // player turn is true, robot turn is false
    private boolean combo = false;

    public SlapjackGame(List<Card> robotList, List<Card> playerList){
        this.robotList = robotList;
        this.playerList = playerList; }

    public void removeCard(boolean playerTurn){
        if (playerTurn) {
            pileList.add(playerList.get(playerList.size() - 1));
            // get the top card from player list to add to the pileList
        }

        if (!playerTurn){
            pileList.add(robotList.get(playerList.size() - 1));
        }
    }

    public boolean getTurn(){
        return playerTurn;
    }

    public boolean checkEndGame(){
        if (playerList.size() == 0 || robotList.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void checkForCombo() {
        // delete the previous combo is there are no matches
        if ((pileList.size() > 1)) {
            if ((pileList.get(pileList.size() - 2)).getNumber() == pileList.get(pileList.size() - 1).getNumber()) {
                combo = true;
            }
        }
        if (pileList.size() > 2){
            if (pileList.get(pileList.size()- 3).getNumber() == pileList.get(pileList.size() - 1).getNumber()){
                combo = true;
            }
        }

    }

    public void moveCards(List<Card> winnerList){
        for (int i = pileList.size() - 1; i >= 0; i--){
            winnerList.add(0, pileList.get(i));
        }
    }

}
