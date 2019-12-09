package com.example.semester1project;

import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlapjackFragment extends Fragment {

    private Button buttonSlap;
    private ImageView imageViewPlayerDeck;
    private ImageView imageViewComputerDeck;
    private ImageView imageViewFirstCard;
    private ImageView imageViewSecondCard;
    private ImageView imageViewThirdCard;

    private List<Card> completeDeckFromJson;
    private List<Card> robotCardListDeck;
    private List<Card> playerCardListDeck;
    private List<Card> pileList;
    private SlapjackGame game;
    private boolean playerTurn; // player turn is true, robot turn is false
    private boolean isCombo = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.deckofcards); //getting xml
        String jsonString = readTextFile(XmlFileInputStream);
        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Card[] cards = gson.fromJson(jsonString, Card[].class);
        // convert your array to a list using the Arrays utility class
        completeDeckFromJson = Arrays.asList(cards);
        robotCardListDeck = new ArrayList<>();
        playerCardListDeck = new ArrayList<>();
        int a;
        for (a = completeDeckFromJson.size() - 26; a >= 0; a--)
        {
            robotCardListDeck.add(completeDeckFromJson.get(a));
        }
        int b;
        for (b = completeDeckFromJson.size() - 1; b > 26; b--)
        {
            playerCardListDeck.add(completeDeckFromJson.get(b));
        }
        game = new SlapjackGame(robotCardListDeck, playerCardListDeck);
        // verify that it read everything properly
        // pls work
        // inflate the fragment pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_slapjack, container, false);
//        super.onCreateView(inflater, container, savedInstanceState);
        // wire widgets using that layout
        wireWidgets(rootView);
        setOnClickListeners();
        // set any listeners for those widgets
        buttonSlap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // return the inflated view
        return rootView;


//         return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setOnClickListeners() {
        buttonSlap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn){

                }
            }
        });
    }

    private void wireWidgets(View rootView) {
        buttonSlap = rootView.findViewById(R.id.button_slapjack_slap);
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
