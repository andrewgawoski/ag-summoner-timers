package com.andrew.gawoski.summonertimers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class ChampionActivity extends AppCompatActivity{
    public static String LOG_TAG = "My log tag";

    Timer ourTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);


        final Runnable setImageRunnable = new Runnable(){
            public void run(){
                updateTeamIcons();
            }
    };

        TimerTask ourTask = new TimerTask(){
            public void run(){
                runOnUiThread(setImageRunnable);
            }
        };

        //New timer to run as a daemon just in case
        ourTimer = new Timer(true);
        ourTimer.schedule(ourTask, 5L, 5L);
        //timer.cancel();
    }

    protected void onPause(){
        ourTimer.cancel();
        super.onPause();
    }


    private MyAdapter ourAdapter;

    public List<ChampionInfo> ourList; // = ChampionList.getInstance().getListOfChampions();

    @Override
    protected void onResume(){
        ourList = ChampionList.getInstance().getListOfChampions();
        ListView myListView = (ListView)findViewById(R.id.listViewChampions);
        ourAdapter = new MyAdapter(this, R.layout.element_champion, ourList);
        myListView.setAdapter(ourAdapter);
        ourAdapter.notifyDataSetChanged();
        updateTeamIcons();

        super.onResume();
    }

    //Updates and draws team icons based on our TeamData singleton
    public void updateTeamIcons(){

        //Get our current team
        List theCurrentTeam =TeamData.getInstance().getTeamList();
        int tempID;

        //get and set our views
        int id1;
        ImageView member1 = (ImageView) findViewById(R.id.imageViewC1);
        int id2;
        ImageView member2 = (ImageView) findViewById(R.id.imageViewC2);
        int id3;
        ImageView member3 = (ImageView) findViewById(R.id.imageViewC3);
        int id4;
        ImageView member4 = (ImageView) findViewById(R.id.imageViewC4);
        int id5;
        ImageView member5 = (ImageView) findViewById(R.id.imageViewC5);
        //Our default ID
        int defaultID = AndrewUtilities.getIconID(this.getApplicationContext(), "icon_default");

        //View Player 1
        if(theCurrentTeam.size() >= 1) {

            id1 = AndrewUtilities.getIconID(member1.getContext(), TeamData.getInstance().getTeamList(0).theChampion.getIconName());
        }else{
            id1 = defaultID;
        }

        //View Player 2
        if(theCurrentTeam.size() >= 2) {

            id2 = AndrewUtilities.getIconID(member2.getContext(), TeamData.getInstance().getTeamList(1).theChampion.getIconName());
        }else{
            id2 = defaultID;
        }

        //View Player 3
        if(theCurrentTeam.size() >= 3) {

            id3 = AndrewUtilities.getIconID(member3.getContext(), TeamData.getInstance().getTeamList(2).theChampion.getIconName());
        }else{
            id3 = defaultID;
        }

        //View Player 4
        if(theCurrentTeam.size() >= 4) {

            id4 = AndrewUtilities.getIconID(member4.getContext(), TeamData.getInstance().getTeamList(3).theChampion.getIconName());
        }else{
            id4 = defaultID;
        }

        //View Player 5
        if(theCurrentTeam.size() >= 5) {
            id5 = AndrewUtilities.getIconID(member5.getContext(), TeamData.getInstance().getTeamList(4).theChampion.getIconName());
        }else{
            id5 = defaultID;
        }
        //Actually draw the icons
        AndrewUtilities.customDrawIcon(member1, id1);
        AndrewUtilities.customDrawIcon(member2, id2);
        AndrewUtilities.customDrawIcon(member3, id3);
        AndrewUtilities.customDrawIcon(member4, id4);
        AndrewUtilities.customDrawIcon(member5, id5);
    }

    //Presumably part of when it runs
    //int numberOfChampions = ChampionList.getInstance().getListOfChampions().size();

    public void championBackClick(View v){
        int numberOfPlayers = TeamData.getInstance().getTeamList().size();
        //If we have champions to remove,
        if(numberOfPlayers > 0){
            TeamData.getInstance().getTeamList().remove(numberOfPlayers-1);
        }else{
            //Maybe they want to go back to the old activity?
            Intent theIntent = new Intent(this, MainActivity.class);
            startActivity(theIntent);
        }

    }

    public void championConfirmClick(View v){
        int numberOfPlayers = TeamData.getInstance().getTeamList().size();
        //If we have a full team (does not support team sizes other than 5)
        if (numberOfPlayers > 4){
            Intent theIntent = new Intent(this, SummonerActivity.class);
            startActivity(theIntent);
        }else{
            Toast toast = Toast.makeText(this, "The team isn't full!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}