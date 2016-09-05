package com.andrew.gawoski.summonertimers;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Time;
import java.util.List;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class SummonerActivity extends AppCompatActivity {

    int currentTeamMember;
    List<SSInfo> ourSpellList;
    public static String LOG_TAG = "My Log tag: ";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);
        Log.i(LOG_TAG, "Inside onCreate SummonerActivity");
        currentTeamMember = 0;
        Log.i(LOG_TAG, "Current team member is " + currentTeamMember);
        ourSpellList = SpellList.getInstance().getListOfSpells();
        //Lets disable our continue button unless the champion has two spells
        Button theContinueButton = (Button)findViewById(R.id.buttonSpellConfirm);
        theContinueButton.setEnabled(false);
        //We actually check to enable it in updateSpellSelect
        updateSpellSelect(currentTeamMember);
    }

    //Updates the icons based on which team member it is currently
    public void updateSpellSelect(int currentMemberIndex){
        Log.i(LOG_TAG, "Inside updateSpellSelect");
        //Find the views we're updating
        ImageView selectedChampion = (ImageView)findViewById(R.id.imageViewSpellChampion);
        ImageView selectedFirstSpell = (ImageView)findViewById(R.id.imageViewSpellS1);
        ImageView selectedSecondSpell = (ImageView)findViewById(R.id.imageViewSpellS2);
        Button someContinueButton = (Button)findViewById(R.id.buttonSpellConfirm);

        //Cut down on number of getInstance calls, we make a temporary team member object to update from
        //same with getApplicationContext
        PlayerData tempPlayer = TeamData.getInstance().getTeamList(currentMemberIndex);
        Log.i(LOG_TAG, "Just made tempPlayer");
        Log.i(LOG_TAG, "its champ name is " + tempPlayer.theChampion.champName);
        Context tempContext = getApplicationContext();
        String tempChampIcon = tempPlayer.theChampion.getIconName();
        String tempChampS1 = tempPlayer.spell1.getIconName();
        String tempChampS2 = tempPlayer.spell2.getIconName();
        int imageFirstID = AndrewUtilities.getIconID(tempContext, tempChampIcon);
        int imageSecondID = AndrewUtilities.getIconID(tempContext, tempChampS1);
        int imageThirdID = AndrewUtilities.getIconID(tempContext, tempChampS2);

        //Now we update our views with our helper function
        AndrewUtilities.customDrawIcon(selectedChampion, imageFirstID);
        AndrewUtilities.customDrawIcon(selectedFirstSpell, imageSecondID);
        AndrewUtilities.customDrawIcon(selectedSecondSpell, imageThirdID);
        if(!tempPlayer.spell2.spellName.equals("")){
            //We have two spells in the box!
            someContinueButton.setEnabled(true);
        }else{
            //Not enough spells
            someContinueButton.setEnabled(false);
        }
    }

    public void genericSpellClick (View v){
        //First make sure they don't have two spells
        PlayerData tempPlayer = TeamData.getInstance().getTeamList(currentTeamMember);
        if(tempPlayer.spell2.spellName.equals("")){
            //No spell, we can add one

            //Do we add it to the first slot or the second slot?
            if(tempPlayer.spell1.spellName.equals("")){
                //We're adding it to the first slot
                TeamData.getInstance().getTeamList(currentTeamMember).spell1 = ourSpellList.get(Integer.parseInt((String) v.getTag()));
                updateSpellSelect(currentTeamMember);
            }else{
                //we're adding it to the second slot
                if(!tempPlayer.spell1.spellName.equals(ourSpellList.get(Integer.parseInt((String)v.getTag())).spellName)) {
                    //if we don't already have that spell
                    TeamData.getInstance().getTeamList(currentTeamMember).spell2 = ourSpellList.get(Integer.parseInt((String) v.getTag()));
                    updateSpellSelect(currentTeamMember);
                }else{
                    //We already have that spell
                    Toast spellExists = Toast.makeText(this, "You've already selected that spell", Toast.LENGTH_SHORT);
                    spellExists.show();
                }

            }

        }else{
            //Spell full, display a message
            Toast ourToast = Toast.makeText(this, "Two spells already chosen", Toast.LENGTH_SHORT);
            ourToast.show();
        }
        //Do a check to make sure spell hasn't already been selected
        //Is it easier to use an external list of strings for the names we can clear and .contains()?
        //We already have fields where the data is stored in our team data or player data
    }
    public void spellContinueClick (View v){
        //How many spells do we have?

        //Do we have a second spell?
        if(!TeamData.getInstance().getTeamList(currentTeamMember).spell2.spellName.equals("")){
            //We have a second spell

            //We should only advance here
            //What team member are we on?
            if(currentTeamMember >= TeamData.getInstance().getTeamSize() - 1){
                //We are a maximum sized team with full spells (>= 5-1)
                //We advance to the next activity
                Intent nextIntent = new Intent(this, TimerActivity.class);
                startActivity(nextIntent);
            }else{
                //We are not a full sized team
                //We advance to the next player
                currentTeamMember++;
                //We should update the icons too
                updateSpellSelect(currentTeamMember);
            }
        }else{
            //We have either 1 or 0 spells.
            //Do we have 1?
            if(!TeamData.getInstance().getTeamList(currentTeamMember).spell1.spellName.equals("")){
                //We have 1 spell
                //-----CODE HERE
            }else{
                //We have 0 spells
                //-----CODE HERE
            }
        }




    }

    public void spellBackClick (View v){
        //Need to decrement the currentTeamMember variable if we have no spells selected
        //make a temp current member item
        PlayerData tempPlayer = TeamData.getInstance().getTeamList(currentTeamMember);

        //Player does not have a spell in spell slot 1, need to go to previous team member
        if(tempPlayer.spell1.spellName.equals("")){

            //We don't have any previous team members (this is the first team member) (and they have no spells)
            if(currentTeamMember <= 0){

                //Switch intents back to Champion Activity
                Intent ourIntent = new Intent(this, ChampionActivity.class);
                startActivity(ourIntent);
            }else{
                //We're able to go back a team member

                //No need to remove abilities because there are none
                currentTeamMember = currentTeamMember - 1;
                updateSpellSelect(currentTeamMember);
            }
            //They have a spell in spell slot 1
        }else{

            //What about spell 2?
            if(tempPlayer.spell2.spellName.equals("")){

                //They have a spell in slot 1 but not 2, need to remove it
                TeamData.getInstance().getTeamList(currentTeamMember).spell1 = new SSInfo();
                updateSpellSelect(currentTeamMember);

                //They have a spell in slot 2, need to remove
            }else{

                //Remove it
                TeamData.getInstance().getTeamList(currentTeamMember).spell2 = new SSInfo();
                updateSpellSelect(currentTeamMember);
            }
        }
    }
}