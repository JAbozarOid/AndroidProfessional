package com.aratel.androidprofessional.fragmentwithoutui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class UseFragmentWithoutUiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentWithoutUI fragmentWithoutUI = (FragmentWithoutUI) fragmentManager.findFragmentByTag(FragmentWithoutUI.MY_FRAGMENT_TAG);
        if (fragmentWithoutUI == null) {
            if (savedInstanceState == null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(new FragmentWithoutUI(), FragmentWithoutUI.MY_FRAGMENT_TAG);
                fragmentTransaction.commitNow();
            }
        }

    }
}
