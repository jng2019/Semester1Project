package com.example.semester1project;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SlapjackFragment extends Fragment {

    private EditText editTextA, editTextB;
    private TextView textViewC;
    double a, b, c;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // inflate the fragment pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_pythagorean, container, false);
//        super.onCreateView(inflater, container, savedInstanceState);
        // wire widgets using that layout
        wireWidgets(rootView);

        // set any listeners for those widgets
        editTextA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            // use this one to calculate the pythag theorem
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // integer.parseInt() will convert a string to an int
                // Double.parseDouble() will convert a String to a double
                // call a calculate method that reads the values of a and b, and sets textview to the value of c
                // editTextA.getText().toString() gets the text for a
                // have some kind of error checking to make sure
                // that if you have an empty string, you don't crash
                if(a != 0 && b != 0) {
                    a = Double.parseDouble(editTextA.getText().toString());
                    b = Double.parseDouble(editTextB.getText().toString());
                    c = calculatePythag(a, b);
                }
                textViewC.setText(Double.toString(c));
            }

            @Override
            public void afterTextChanged(Editable editable) {

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
        editTextA = rootView.findViewById(R.id.editText_pythag_a);
        editTextB = rootView.findViewById(R.id.editText_pythag_b);
        textViewC = rootView.findViewById(R.id.textView_pythag_c);
    }
}
