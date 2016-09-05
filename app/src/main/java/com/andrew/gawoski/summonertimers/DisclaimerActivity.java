package com.andrew.gawoski.summonertimers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class DisclaimerActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

    }

    public void beginEntryChoice(View v){
        //Make it so user doesn't need to see this disclaimer again
        Intent theIntent = new Intent(this, MainActivity.class);
        startActivity(theIntent);
    }
}