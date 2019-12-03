package com.example.semester1project;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SlapjackFragment extends Fragment {

    private Button buttonSlap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // inflate the fragment pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_slapjack, container, false);
//        super.onCreateView(inflater, container, savedInstanceState);
        // wire widgets using that layout
        wireWidgets(rootView);

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

    private double calculatePythag(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    private void wireWidgets(View rootView) {
        buttonSlap = rootView.findViewById(R.id.button_slapjack_slap);
    }
}
