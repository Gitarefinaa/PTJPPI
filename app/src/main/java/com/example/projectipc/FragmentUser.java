package com.example.projectipc;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.prefs.Preferences;


public class FragmentUser extends Fragment {
    Button logout;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View frame=inflater.inflate(R.layout.activity_fragment_user, container, false);

    return frame;
    }



}
