package com.andrew.gawoski.summonertimers;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Andrew on 3/8/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public final class AndrewUtilities {

    private AndrewUtilities(){}

    public static final String LOG_TAG = "My log tag ";

    //Returns the resource ID based on the context and string of drawable
    public static int getIconID(Context theContext, String iconName){
        String thePath;
        if(iconName != null){
            thePath = "drawable/" + iconName;
        }else{
            thePath = "drawable/icon_default";
        }
        int iconID = theContext.getResources().getIdentifier(thePath, "drawable", theContext.getPackageName());
        return iconID;
    }

    //Custom draw for imageView
    public static void customDrawIcon(ImageView ourView, int theID){
        ImageView theView = ourView;
        //If the icon actually exists
        if(theID != 0){
            //Change our view to that icon
            theView.setImageResource(theID);
        }else{
            //otherwise make it our unknown icon
            theView.setImageResource(R.drawable.icon_default);
        }

    }

    //Custom draw for imageButton
    public static void customDrawIcon(ImageButton ourView, int theID){
        ImageButton ourButton = ourView;
        //the icon exists
        if(theID != 0){
            //Change our button's resource to the icon
            ourButton.setImageResource(theID);
        }else{
            //doesn't exist, set to default
            ourButton.setImageResource(R.drawable.icon_default);
        }
    }

    //Custom get string from json-returning url
    public static String jsonToString(String url, final Context ourContext) throws IOException{

        Log.i(LOG_TAG, "Inside jsonToString");
        final SharedPreferences ourPrefs = ourContext.getSharedPreferences("AGST_PREF", Context.MODE_PRIVATE);
        final SharedPreferences.Editor ourEditor = ourPrefs.edit();

        ourEditor.putString("requestString", url);
        ourEditor.commit();

        Log.i(LOG_TAG, "Creating new thread to run on");
        new Thread(){

            public void run(){
                Log.i(LOG_TAG, "Inside our void run");
                try {
                    Log.i(LOG_TAG, "Inside our try");
                    //Instantiate the client
                    OkHttpClient ourHttpClient = new OkHttpClient();
                    //Prepare the request with our url for api call
                    String urlFromPrefs = ourPrefs.getString("requestString", "nothing");
                    Request ourRequest = new Request.Builder().url(urlFromPrefs).build();
                    //Execute the response
                    Response ourResponse = ourHttpClient.newCall(ourRequest).execute();

                    String tempString = ourResponse.body().string();

                    Log.i(LOG_TAG, "Inserting the following to preferences: ");
                    Log.i(LOG_TAG, tempString);
                    ourEditor.putString("jsonString", tempString);
                    ourEditor.commit();
                }catch(Exception e){
                    Log.i(LOG_TAG, "Inside our exception catch");
                    e.printStackTrace();
                }
                Log.i(LOG_TAG, "leaving our void run");
            }
        }.start();
        Log.i(LOG_TAG, "We just left the thread, doing return");

        if(ourPrefs.getBoolean("networkThreadFinished", false)){
            //do nothing
        }else{
            try {
                Thread.sleep(3000L);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }

        ourEditor.putBoolean("networkThreadFinished", false);
        return ourPrefs.getString("jsonString", "preferences error");
    }

    public static String summonerNameClear(String theBaseName){
        //Clear all of the characters out here. Surely there is a better way to do this.
        theBaseName = theBaseName.toLowerCase();
        theBaseName = theBaseName.replace(" ","");
        theBaseName = theBaseName.replace(",","");
        theBaseName = theBaseName.replace(".","");
        theBaseName = theBaseName.replace("/","");
        theBaseName = theBaseName.replace(";","");
        theBaseName = theBaseName.replace("'","");
        theBaseName = theBaseName.replace("[","");
        theBaseName = theBaseName.replace("]","");
        theBaseName = theBaseName.replace("\\","");
        theBaseName = theBaseName.replace("-","");
        theBaseName = theBaseName.replace("=","");
        theBaseName = theBaseName.replace("`","");
        theBaseName = theBaseName.replace("<","");
        theBaseName = theBaseName.replace(">","");
        theBaseName = theBaseName.replace("?","");
        theBaseName = theBaseName.replace(":","");
        theBaseName = theBaseName.replace("\"","");
        theBaseName = theBaseName.replace("{","");
        theBaseName = theBaseName.replace("}","");
        theBaseName = theBaseName.replace("|","");
        theBaseName = theBaseName.replace("_","");
        theBaseName = theBaseName.replace("+","");
        theBaseName = theBaseName.replace("~","");
        theBaseName = theBaseName.replace("!","");
        theBaseName = theBaseName.replace("@","");
        theBaseName = theBaseName.replace("#","");
        theBaseName = theBaseName.replace("$","");
        theBaseName = theBaseName.replace("%","");
        theBaseName = theBaseName.replace("^","");
        theBaseName = theBaseName.replace("&","");
        theBaseName = theBaseName.replace("*","");
        theBaseName = theBaseName.replace("(","");
        theBaseName = theBaseName.replace(")","");
        return theBaseName;
    }

    public static String regionConverter(String originalRegion){
        //I should have used a map for this, but map creation probably takes longer
        Log.i(LOG_TAG, "Converting region tag from " + originalRegion);
        String ourString = "";
        if(originalRegion.equals("na")){
            ourString = "NA1";
        }else if(originalRegion.equals("br")){
            ourString = "BR1";
        }else if(originalRegion.equals("eune")){
            ourString = "EUN1";
        }else if(originalRegion.equals("euw")){
            ourString = "EUW1";
        }else if(originalRegion.equals("kr")){
            ourString = "KR";
        }else if(originalRegion.equals("lan")){
            ourString = "LA1";
        }else if(originalRegion.equals("las")){
            ourString = "LA2";
        }else if(originalRegion.equals("oce")){
            ourString = "OC1";
        }else if(originalRegion.equals("tr")){
            ourString = "TR1";
        }else if(originalRegion.equals("ru")){
            ourString = "RU";
        }else if(originalRegion.equals("pbe")){
            ourString = "PBE1";
        }else{
            //Something weird happened
            Log.i(LOG_TAG, "No regions matched error, returning NA1");
            ourString = "NA1";
        }
        return ourString;
    }

    public static PlayerData createPlayerFromAPI(Participant theParticipant){
        //Set this to the index of the champion in our special list
        int indexOfChampion = -1;
        //Set to index of summoner spells in our special list
        int indexOfSp1 = SpellList.getInstance().getSpellIDtoIndex().get(theParticipant.getSpell1Id());
        int indexOfSp2 = SpellList.getInstance().getSpellIDtoIndex().get(theParticipant.getSpell2Id());

        String summonerName = "";
        summonerName = theParticipant.getSummonerName();

        indexOfChampion = ChampionList.getInstance().getIdToOurIndex().get(theParticipant.getChampionId());
        //Index of champion gotten
        ChampionInfo playerChampion = ChampionList.getInstance().getListOfChampions().get(indexOfChampion);


        //Don't set this
        boolean hasBoots = false;

        //check for mastery
        boolean hasMastery = false;
        Long masteryInsightID = 6241L;
        for(int i = 0; i < theParticipant.getMasteries().size(); i++){
            if(masteryInsightID.equals(theParticipant.getMasteries().get(i).getMasteryId())){
                hasMastery = true;
            }
        }



        SSInfo summonerSp1 = SpellList.getInstance().getListOfSpells().get(indexOfSp1);
        SSInfo summonerSp2 = SpellList.getInstance().getListOfSpells().get(indexOfSp2);

        PlayerData ourPlayer = new PlayerData(summonerName, playerChampion, hasBoots, hasMastery, summonerSp1, summonerSp2);
        return ourPlayer;
    }
}