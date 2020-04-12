package com.aratel.androidprofessional.fragmentwithoutui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentWithoutUI extends Fragment {

    public final static String MY_FRAGMENT_TAG = "my_fragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // Get a type-safe reference to the parent context.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create ongoing threads and tasks.
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initiate worker threads and tasks.

    }
}

