package com.example.semester1project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PadoruFragment extends Fragment {
    private ImageView padoru;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_padoru, container, false);
        wireWidgets(rootview);
        return rootview;
    }

    private void wireWidgets(View rootview) {
        padoru = rootview.findViewById(R.id.imageView_padoru_padoru);
    }
}
