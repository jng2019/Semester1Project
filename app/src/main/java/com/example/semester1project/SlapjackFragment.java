package com.example.semester1project;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Random;

public class SlapjackFragment extends Fragment{

    private Button buttonSlap;
    private ImageView imageViewPlayerDeck;
    private ImageView imageViewComputerDeck;
    private ImageView imageViewFirstCard;
    private ImageView imageViewSecondCard;
    private ImageView imageViewThirdCard;

    private List<Card> completeDeckFromJson;
    private List<Card> playerDeck;
    private List<Card> robotDeck;
    private SlapjackGame game;
    private boolean playerTurn = true; // player turn is true, robot turn is false
    private boolean isCombo = false;
    private ArrayList<Card> pileList;
    private Random generator = new Random();

    private CountDownTimer timer;
    private boolean isRunning;
    private boolean playerClickedDuringDelay;
//    private int cpuEasy;
//    private int cpuMedium;
//    private int cpuHard;

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
        // shuffle the cards
        for (int i = 0; i < completeDeckFromJson.size(); i++)
        {
            int randomIndex = generator.nextInt(completeDeckFromJson.size() - 1);
            completeDeckFromJson.set(i, completeDeckFromJson.get(randomIndex));
        }
        // split the cards into two piles; one for the player, one for the cpu
        robotDeck = new ArrayList<>();
        playerDeck = new ArrayList<>();
        pileList = new ArrayList<>();
        int a;
        for (a = completeDeckFromJson.size() - 26; a >= 0; a--)
        {
            robotDeck.add(completeDeckFromJson.get(a));
        }
        int b;
        for (b = completeDeckFromJson.size() - 1; b > 26; b--)
        {
            playerDeck.add(completeDeckFromJson.get(b));
        }
        game = new SlapjackGame(robotDeck, playerDeck);
        // verify that it read everything properly
        // pls work
        // inflate the fragment pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_slapjack, container, false);
//        super.onCreateView(inflater, container, savedInstanceState);
        // wire widgets using that layout
        wireWidgets(rootView);
        // set any listeners for those widgets
        setOnClickListeners();
        // return the inflated view
        return rootView;

//         return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void updateDisplay() {
        if (pileList != null) {
            for (int i = pileList.size() - 1; i >= 0; i--) {
                int resourceImage = getResources().getIdentifier(pileList.get(i).getImage(), "drawable", getActivity().getPackageName());
                imageViewPlayerDeck.setImageDrawable(getResources().getDrawable(resourceImage));
//                imageViewComputerDeck.setImageDrawable();
//                imageViewFirstCard.setImageDrawable();
//                imageViewSecondCard.setImageDrawable();
//                imageViewThirdCard.setImageDrawable();
            }
        }
    }

    private void setOnClickListeners() {
        buttonSlap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCombo = game.checkForCombo(); // check for combo
                // first click
                if (pileList == null) {
                    game.playCard(playerDeck);
                    updateDisplay();
                    playerTurn = false;
                }
                // all following clicks
                else {
                    if (isRunning) {
                        if (isCombo) {
                            game.moveCardsToWinner(playerDeck);
                            playerTurn = true;
                        }
                        else {
                            game.burnCard(playerDeck);
                        }
                        timer.cancel();
                    }
                    else if (playerTurn) {
                        game.playCard(playerDeck);
                        playerTurn = false;
                    }
                    updateDisplay();
                }
                // pause before cpu's turn
                // the time between the turns (there might be a combo)
                timer = new CountDownTimer(2000, 1) {
                    @Override
                    public void onTick(long l) {
                        // boolean flag to indicate that the timer is running
                        isRunning = true;
                    }
                    // only get to onFinish() if the player did not slap after a turn
                    @Override
                    public void onFinish() {
                        if (isCombo) {
                            isRunning = false;
                            game.moveCardsToWinner(robotDeck);
                            playerTurn = false;
                        }
                    }
                }.start();
                updateDisplay();
            }
        });
    }

    private void wireWidgets(View rootView) {
        buttonSlap = rootView.findViewById(R.id.button_slapjack_slap);
        imageViewPlayerDeck = rootView.findViewById(R.id.imageView);
        imageViewComputerDeck = rootView.findViewById(R.id.imageView_robotDeck_slapjack);
        imageViewFirstCard = rootView.findViewById(R.id.imageView_rightCard_slapjack);
        imageViewSecondCard = rootView.findViewById(R.id.imageView_middleCard_slapjack);
        imageViewThirdCard = rootView.findViewById(R.id.imageView_leftCard_slapjack );
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
