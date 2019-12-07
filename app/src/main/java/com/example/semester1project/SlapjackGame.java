package com.example.semester1project;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class SlapjackGame {
    private List<Card> robotList;
    private List<Card> playerList;
    private List<Card> pileList;
    private boolean playerTurn; // player turn is true, robot turn is false

    public SlapjackGame(List<Card> robotList, List<Card> playerList, boolean playerTurn){
        this.robotList = robotList;
        this.playerList = playerList;
        this.playerTurn = playerTurn;
    }

    private void removeCard(boolean playerTurn){
        if (playerTurn) {
            pileList.add(playerList.get(playerList.size() - 1));
            // get the top card from player list to add to the pilelist
        }

        if (!playerTurn){
            pileList.add(robotList.get(playerList.size() - 1));
        }
    }

    private boolean getTurn(){
        return playerTurn;
    }

    private boolean checkEndGame(){
        if (playerList.size() == 0 || robotList.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean checkForCombo(){
        if ()
    }

}
