package com.andrew.gawoski.summonertimers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class KeyEntryActivity extends AppCompatActivity {

    //These are the request parameters
    private static final String baseReq1 = "https://na.api.pvp.net/api/lol/";
    //region ID
    private static final String baseReq2 = "/v1.4/summoner/by-name/";
    //summoner name
    private static final String baseReq3 = "?api_key=";
    //api key


    ConnectivityManager cm;
    NetworkInfo activeNetwork;
    String userName;
    String userKey;
    String userRegion;
    EditText nameField;
    EditText keyField;

    public static final String LOG_TAG = "My log tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_entry);

        //Our network detecting instantiated objects
        cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        activeNetwork = cm.getActiveNetworkInfo();

        //Some views for our text fields
        nameField = (EditText)findViewById(R.id.editTextName);
        keyField = (EditText)findViewById(R.id.editTextKey);


        SharedPreferences ourPrefs = this.getPreferences(Context.MODE_PRIVATE);

        //Remember the users previously entered values if they have that setting chosen
        if(ourPrefs.getBoolean("KeyIsRemembered", false)){
            keyField.setText(ourPrefs.getString("SavedKey", ""));
        }else{
            keyField.setText("");
        }
        if(ourPrefs.getBoolean("NameIsRemembered", false)){
            nameField.setText(ourPrefs.getString("SavedName", ""));
        }else{
            nameField.setText("");
        }


    }

    public void genericRegionClick(final View v) {
        Toast encouragementToast = Toast.makeText(this, "Processing Request", Toast.LENGTH_LONG);
        encouragementToast.show();

        SharedPreferences ourPrefs = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor ourEditor = ourPrefs.edit();

        if(ourPrefs.getBoolean("KeyIsRemembered", false)){
            ourEditor.putString("SavedKey", userKey);
            ourEditor.commit();
        }
        if(ourPrefs.getBoolean("NameIsRemembered", false)){
            ourEditor.putString("SavedName", userName);
            ourEditor.commit();
        }

        //When we click a button, first we check for the connection
        if(activeNetwork != null && activeNetwork.isConnectedOrConnecting()){
            //We have a connection!

            //We grab the summoner name, key and region from the v.tag converted to a String
            userName = nameField.getText().toString();
            userName = AndrewUtilities.summonerNameClear(userName);

            userKey = keyField.getText().toString();
            userRegion = (String)v.getTag();

            //What is our completed get url?
            String fullRequestString = "https://" + userRegion +".api.pvp.net/api/lol/"
                    + userRegion +"/v1.4/summoner/by-name/" + userName + "?api_key="
                    + userKey;


            //Then we do retrofit (NOT USING RETROFIT)
            String ourResultFromRiot = "";

            try {
                ourResultFromRiot = AndrewUtilities.jsonToString(fullRequestString, this);
            }catch (IOException ie){
                ie.printStackTrace();
            }

            Log.i(LOG_TAG, "Our result is " + ourResultFromRiot);

            /*
            Log.i(LOG_TAG, "Our result from preferences is ");
            SharedPreferences ourPrefs = this.getSharedPreferences("ASGT_PREFS", Context.MODE_PRIVATE);
            Log.i(LOG_TAG, ourPrefs.getString("jsonString", "error outside our helper"));
            */

            if(ourResultFromRiot.contains("\"status_code\": 400")){
                //Error 400!
                Toast ourToast = Toast.makeText(this, "Error 400, Bad Request", Toast.LENGTH_LONG);
                ourToast.show();
            }else if(ourResultFromRiot.contains("\"status_code\": 401")){
                //Error 401!
                Toast ourToast = Toast.makeText(this, "Error 401, Invalid API Key", Toast.LENGTH_LONG);
                ourToast.show();
            }else if(ourResultFromRiot.contains("\"status_code\": 404")){
                //Error 404!
                Toast ourToast = Toast.makeText(this, "Error 404, Summoner Not Found", Toast.LENGTH_LONG);
                ourToast.show();
            }else if(ourResultFromRiot.contains("\"status_code\": 429")){
                //Error 429!
                Toast ourToast = Toast.makeText(this, "Error 429, Rate Limit Exceeded", Toast.LENGTH_LONG);
                ourToast.show();
                //Maybe do something to prevent the next network call here
                //something about a retry-after header to halt calls for a duration

            }else if(ourResultFromRiot.contains("\"status_code\": 500")){
                //Error 500!
                Toast ourToast = Toast.makeText(this, "Error 500, Internal Server Error", Toast.LENGTH_LONG);
                ourToast.show();
            }else if(ourResultFromRiot.contains("\"status_code\": 503")){
                //Error 503!
                Toast ourToast = Toast.makeText(this, "Error 503, Server Unavailable", Toast.LENGTH_LONG);
                ourToast.show();
            }else if(ourResultFromRiot.contains(userName)){
                //Success?
                //Modify the response turn it into json and fill our SummonerDTO with it
                String newString = ourResultFromRiot.replaceFirst(userName, "SummonerDTO");
                Log.i(LOG_TAG, "Our new modified response is:");
                Log.i(LOG_TAG, newString);
                //String confirmed to work with appropriate response
                JsonObject obj = new JsonParser().parse(newString).getAsJsonObject();
                Log.i(LOG_TAG, "Our json object is:");
                Log.i(LOG_TAG, obj.toString());
                //Now we have our modified json object, deserialize
                //SummonerWrapper ourUser;
                Gson gson = new Gson();
                SummonerWrapper ourUser = new Gson().fromJson(obj, SummonerWrapper.class);

                Log.i(LOG_TAG, "Lets test things");
                Log.i(LOG_TAG, "Name: " + ourUser.getOurSummoner().getName());
                Log.i(LOG_TAG, "ID: " + ourUser.getOurSummoner().getId());
                Log.i(LOG_TAG, "Summoner Level: " + ourUser.getOurSummoner().getSummonerLevel());

                //Successful deserialization.

                //We can now pass our ID as an intent to the next activity
                //Which we'll probably do rather than right here for the sake of keeping things easy to read
                Intent intentFormation = new Intent(this, TeamFormationActivity.class);
                intentFormation.putExtra("ORIGINAL_ID", ourUser.getOurSummoner().getId());
                intentFormation.putExtra("ORIGINAL_REGION", v.getTag().toString());
                intentFormation.putExtra("ORIGINAL_KEY", userKey);
                startActivity(intentFormation);

            }else{
                //I have no idea what went wrong.
                Toast ourToast = Toast.makeText(this, "Something unusual happened.\nMaybe let the developer know?", Toast.LENGTH_LONG);
                ourToast.show();
            }

        }else{
            //Display the toast!
            Toast connectionExists = Toast.makeText(this, "No connection detected", Toast.LENGTH_LONG);
            connectionExists.show();
        }

    }

}