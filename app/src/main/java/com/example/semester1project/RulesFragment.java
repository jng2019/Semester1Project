package com.example.semester1project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RulesFragment extends Fragment {

    private TextView description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_rules, container, false);
        wireWidgets(rootview);
        description.setText("Beginning on the dealer’s left, each player lifts one card at a time from their pile and places it face up in the center of the table.\n" +
                "When the card played to the center is a jack, the fun begins! The first player to slap their hand down on the jack takes it, as well as all the cards " +
                "beneath it. The player winning these cards turns them face down, places them under their pile of cards, and shuffles them to form a new, larger pile.");
        return rootview;
    }

    private void wireWidgets(View rootview) {
        description = rootview.findViewById(R.id.textView_rules_description);
    }
}
