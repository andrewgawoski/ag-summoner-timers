package com.andrew.gawoski.summonertimers;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class MainActivity extends AppCompatActivity {


   /*
    Context context = this.getApplicationContext();
    String thePath;
    int iconID = context.getResources().getIdentifier(thePath, "drawable", context.getPackageName());
    Drawable image = context.getResources().getDrawable(iconID);
    */

    ConnectivityManager cm;
    NetworkInfo activeNetwork;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        activeNetwork = cm.getActiveNetworkInfo();

    }


    public void chooseManualEntry(View v){
        Intent theIntent = new Intent(this, ChampionActivity.class);
        startActivity(theIntent);
    }

    public void chooseAutoEntry(View v){
        if(activeNetwork != null && activeNetwork.isConnectedOrConnecting()){
            //We have a connection!
            Intent theIntent = new Intent(this, KeyEntryActivity.class);
            startActivity(theIntent);
        }else{
            //Display the toast!
            Toast connectionExists = Toast.makeText(this, "No connection detected", Toast.LENGTH_LONG);
            connectionExists.show();
        }
    }

    public void chooseAbout(View v){
        Intent theIntent = new Intent(this,DisclaimerActivity.class);
        startActivity(theIntent);
    }

    public void chooseSettings(View v){
        Intent theIntent = new Intent(this,userSettingsActivity.class);
        startActivity(theIntent);
    }
}