package com.andrew.gawoski.summonertimers;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Andrew on 3/8/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

//Based on code provided by Luca de Alfaro and Shobhit of CMPS121 Winter 2016 at UCSC

public class MyAdapter extends ArrayAdapter<ChampionInfo>{

    int resource;
    Context context;
    public static String LOG_TAG = "My log tag";

    public MyAdapter(Context _context, int _resource, List<ChampionInfo> theList){
        super(_context, _resource, theList);
        Log.i(LOG_TAG, "Inside MyAdapter Constructor");
        resource = _resource;
        context = _context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Log.i(LOG_TAG, "Inside MyAdapter getView");
        RelativeLayout newView;

        final ChampionInfo someChampion = getItem(position);

        //Inflate a new view if we need to
        if(convertView == null){
            Log.i(LOG_TAG, "Inside MyAdapter convertView is null!");
            newView = new RelativeLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, newView, true);
        }else{
            Log.i(LOG_TAG, "Inside MyAdapter convertView is NOT null!");
            newView = (RelativeLayout) convertView;
        }

        //Fill in the view
        Log.i(LOG_TAG, "Inside MyAdapter Filling in the view");
        TextView champTextView = (TextView) newView.findViewById(R.id.textViewName);
        Button champSelectButton = (Button) newView.findViewById(R.id.buttonChoose);
        ImageView champSelectIcon = (ImageView) newView.findViewById(R.id.imageViewIcon);

        champTextView.setText(someChampion.champName);
        //Harder to fill in the imageview
        Log.i(LOG_TAG, "Inside MyAdapter trying to get context from convertView");
        final Context ourContext = newView.getContext();
        Log.i(LOG_TAG, "Inside MyAdapter Successfully got context");
        int theID = ourContext.getResources().getIdentifier(someChampion.iconName, "drawable", context.getPackageName());
        champSelectIcon.setImageResource(theID);

        //Set a listener for the button, add a tag?
        champSelectButton.setTag(new Integer(position));
        champSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get some useful info from our singleton class
                int currentTeamSize = TeamData.getInstance().getTeamList().size();
                int maxTeamSize = TeamData.getInstance().getTeamSize();
                //Check to see if team is full
                if (maxTeamSize > currentTeamSize) {
                    //Put a new player object into the list of the singleton at the next index
                    PlayerData tempPlayer = new PlayerData(null, someChampion, false, false, false);
                    TeamData.getInstance().setPlayer(currentTeamSize, tempPlayer);
                    //Try to set the appropriate view to the right icon here
                    //Can that even be done?
                } else {
                    //Maybe display a message
                    Toast toast = Toast.makeText(ourContext, "Team Size Full: " + String.valueOf(currentTeamSize), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        return newView;
    }
}