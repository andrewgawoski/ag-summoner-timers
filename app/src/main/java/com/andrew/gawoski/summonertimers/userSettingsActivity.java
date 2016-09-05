package com.andrew.gawoski.summonertimers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class userSettingsActivity extends AppCompatActivity {

    SharedPreferences ourPrefs;// = this.getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor ourEditor;// = ourPrefs.edit();

    //remember the box states
    CheckBox boxKey;
    CheckBox boxName;
    final static String KEY_MEMORY = "KeyIsRemembered";
    final static String NAME_MEMORY = "NameIsRemembered";

    final static String LOG_TAG = "My log tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        ourPrefs = this.getPreferences(Context.MODE_PRIVATE);
        ourEditor = ourPrefs.edit();

        boxKey = (CheckBox)findViewById(R.id.checkBox);
        boxName = (CheckBox)findViewById(R.id.checkBox2);

        Log.i(LOG_TAG, "Inside settings onCreate");
        //Remember our preferences
        if(ourPrefs.getBoolean(KEY_MEMORY, false)){
            boxKey.setChecked(true);
        }else{
            boxKey.setChecked(false);
        }

        if(ourPrefs.getBoolean(NAME_MEMORY, false)){
            boxName.setChecked(true);
        }else{
            boxName.setChecked(false);
        }


    }


    public void buttonClickReturnSetting(View v){
        Intent goBackToMainIntent = new Intent(this, MainActivity.class);
        startActivity(goBackToMainIntent);
    }

    public void buttonClickSaveSetting(View v){

        //Save our summoner names
        if(boxName.isChecked()){
            ourEditor.putBoolean(NAME_MEMORY, true);
            ourEditor.commit();
        }else{
            //don't save our names
            ourEditor.putBoolean(NAME_MEMORY, false);
            ourEditor.remove("SavedName");
            ourEditor.commit();
        }
        //Save our api keys
        if(boxKey.isChecked()){
            ourEditor.putBoolean(KEY_MEMORY, true);
            ourEditor.commit();
        }else{
            //don't save our keys
            ourEditor.putBoolean(KEY_MEMORY, false);
            ourEditor.remove("SavedKey");
            ourEditor.commit();
        }
        //provide user feedback of settings saved
        Toast settingsSaveToast = Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT);
        settingsSaveToast.show();
    }
}