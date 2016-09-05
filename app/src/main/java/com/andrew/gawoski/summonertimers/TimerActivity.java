package com.andrew.gawoski.summonertimers;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class TimerActivity extends AppCompatActivity {

    //Bunch of view variables (Basically every view to be modified)

    //P1
    ImageView ChampP1;
    ImageButton BootsP1;
    ImageButton EnchantP1;
    ImageButton S1P1;
    ImageButton S2P1;

    //P2
    ImageView ChampP2;
    ImageButton BootsP2;
    ImageButton EnchantP2;
    ImageButton S1P2;
    ImageButton S2P2;

    //P3
    ImageView ChampP3;
    ImageButton BootsP3;
    ImageButton EnchantP3;
    ImageButton S1P3;
    ImageButton S2P3;

    //P4
    ImageView ChampP4;
    ImageButton BootsP4;
    ImageButton EnchantP4;
    ImageButton S1P4;
    ImageButton S2P4;

    //P5
    ImageView ChampP5;
    ImageButton BootsP5;
    ImageButton EnchantP5;
    ImageButton S1P5;
    ImageButton S2P5;

    //A copy of our team instance & list
    List<PlayerData> ourTimerTeam = TeamData.getInstance().getTeamList();

    //A copy of our spell list for reference
    List<SSInfo> ourSpellList = SpellList.getInstance().getListOfSpells();

    public static String LOG_TAG = "My log tag";

    public static final int RED_COLOR = Color.parseColor("#d20000");
    public static final int GREEN_COLOR = Color.parseColor("#13a509");

    //For current cooldowns
    int[] currentCooldownArray;

    //For base cooldowns
    int[] baseCooldownArray;

    final Runnable setSpellRunnable = new Runnable() {
        @Override
        public void run() {
            timerHelperMethod();
        }
    };

    TimerTask ourSpellTimerTask = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(setSpellRunnable);
        }
    };

    Timer ourSpellTimer;// = new Timer(true);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        currentCooldownArray = new int[]{0,0,0,0,0,0,0,0,0,0};
        baseCooldownArray = new int[]{0,0,0,0,0,0,0,0,0,0};

        initializeViews();
        //We don't change the views themselves after setting them intially, so we just call this
        populateTimerViews();

        //Get our cooldowns set
        spellBaseCooldownUpdate();

        ourSpellTimer = new Timer(true);

        ourSpellTimer.scheduleAtFixedRate(ourSpellTimerTask,1000L, 1000L);
    }

    protected void onPause(){
        ourSpellTimer.cancel();
        super.onPause();
    }

    public void timerHelperMethod(){
        Log.i(LOG_TAG, "Inside our timer helper method call)");
        Log.i(LOG_TAG, "Set to happen every second (1000ms)");
        //Decrement all active cooldowns if they're > 0
        for(int i = 0; i < currentCooldownArray.length; i++){
           // Log.i(LOG_TAG, "Current spell slot is" + i);
            //Log.i(LOG_TAG, "The current cooldown remaining is " + currentCooldownArray[i]);
            if(currentCooldownArray[i] > 0) {
                currentCooldownArray[i] = currentCooldownArray[i] -1;
            }
        }
        //Now that all relevant spell cooldowns have been decremented,
        //Update our draw for them
        spellDrawUpdate();
    }

    //All this does is set our current cooldown array to the corresponding basecooldownarray value
    public void genericSpellTimerClick(View v){
        //So it can start ticking down to 0
        Log.i(LOG_TAG, "Inside our spell timer click");
        int ourTag = Integer.parseInt((String)v.getTag());
        Log.i(LOG_TAG, "Current cooldown array " + currentCooldownArray[ourTag] + " set to " + baseCooldownArray[ourTag]);
        currentCooldownArray[ourTag] = baseCooldownArray[ourTag];
        Log.i(LOG_TAG, "current cooldown is now " + currentCooldownArray[ourTag]);
        //We could also immediately modify the draw for this view as well
        //improves user feedback/smoothness
        //No need to call our spellDrawUpdate function here
        v.setAlpha(0);
        v.setBackgroundColor(RED_COLOR);
    }

    public double modifierCalculator (PlayerData ourPlayer, SSInfo ourSpell){
        double ourModifier = 1;
        //The modifiers are additive
        if(ourPlayer.hasBoots){
            //Player has boots or 10% reduction
            ourModifier = ourModifier - .1;
        }
        if(ourPlayer.hasMastery){
            ourModifier = ourModifier - .15;
        }
        if(ourPlayer.hasEnchant){
            if(ourSpell.spellName.equals("Flash") || ourSpell.spellName.equals("Ghost") || ourSpell.spellName.equals("Teleport")){
                ourModifier = ourModifier - .15;
            }
        }
        return ourModifier;
    }

    public void spellBaseCooldownUpdate(){

        PlayerData tempPlayer;

        //P1 spells
        tempPlayer = ourTimerTeam.get(0);
        baseCooldownArray[0] = (int)((tempPlayer.spell1.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell1));
        baseCooldownArray[1] = (int)((tempPlayer.spell2.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell2));

        //P2 spells
        tempPlayer = ourTimerTeam.get(1);
        baseCooldownArray[2]  = (int)((tempPlayer.spell1.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell1));
        baseCooldownArray[3]  = (int)((tempPlayer.spell2.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell2));

        //P3 spells
        tempPlayer = ourTimerTeam.get(2);
        baseCooldownArray[4]  = (int)((tempPlayer.spell1.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell1));
        baseCooldownArray[5]  = (int)((tempPlayer.spell2.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell2));

        //P4 spells
        tempPlayer = ourTimerTeam.get(3);
        baseCooldownArray[6]  = (int)((tempPlayer.spell1.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell1));
        baseCooldownArray[7]  = (int)((tempPlayer.spell2.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell2));

        //P5 spells
        tempPlayer = ourTimerTeam.get(4);
        baseCooldownArray[8]  = (int)((tempPlayer.spell1.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell1));
        baseCooldownArray[9]  = (int)((tempPlayer.spell2.cooldown) * modifierCalculator(tempPlayer, tempPlayer.spell2));
    }

    public void spellDrawUpdate(){

        //Player 1 ------------------------------------

        //S1P1
        //on cooldown
        S1P1.setAlpha(1-((float)currentCooldownArray[0]/(float)baseCooldownArray[0]));
        if(currentCooldownArray[0] > 0) {
            S1P1.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S1P1.setBackgroundColor(GREEN_COLOR);
        }

        //S2P1
        //on cooldown
        S2P1.setAlpha(1-((float)currentCooldownArray[1]/(float)baseCooldownArray[1]));
        if(currentCooldownArray[1] > 0) {
            S2P1.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S2P1.setBackgroundColor(GREEN_COLOR);
        }

        //Player 2 ------------------------------------

        //S1P2
        //on cooldown
        S1P2.setAlpha(1-((float)currentCooldownArray[2]/(float)baseCooldownArray[2]));
        if(currentCooldownArray[2] > 0) {
            S1P2.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S1P2.setBackgroundColor(GREEN_COLOR);
        }

        //S2P2
        //on cooldown
        S2P2.setAlpha(1-((float)currentCooldownArray[3]/(float)baseCooldownArray[3]));
        if(currentCooldownArray[3] > 0) {
            S2P2.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S2P2.setBackgroundColor(GREEN_COLOR);
        }

        //Player 3 ------------------------------------

        //S1P3
        //on cooldown
        S1P3.setAlpha(1-((float)currentCooldownArray[4]/(float)baseCooldownArray[4]));
        if(currentCooldownArray[4] > 0) {
            S1P3.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S1P3.setBackgroundColor(GREEN_COLOR);
        }

        //S2P3
        //on cooldown
        S2P3.setAlpha(1-((float)currentCooldownArray[5]/(float)baseCooldownArray[5]));
        if(currentCooldownArray[5] > 0) {
            S2P3.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S2P3.setBackgroundColor(GREEN_COLOR);
        }

        //Player 4 ------------------------------------

        //S1P4
        //on cooldown
        S1P4.setAlpha(1-((float)currentCooldownArray[6]/(float)baseCooldownArray[6]));
        if(currentCooldownArray[6] > 0) {
            S1P4.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S1P4.setBackgroundColor(GREEN_COLOR);
        }

        //S2P4
        //on cooldown
        S2P4.setAlpha(1-((float)currentCooldownArray[7]/(float)baseCooldownArray[7]));
        if(currentCooldownArray[7] > 0) {
            S2P4.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S2P4.setBackgroundColor(GREEN_COLOR);
        }

        //Player 5 ------------------------------------

        //S1P5
        //on cooldown
        S1P5.setAlpha(1-((float)currentCooldownArray[8]/(float)baseCooldownArray[8]));
        if(currentCooldownArray[8] > 0) {
            S1P5.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S1P5.setBackgroundColor(GREEN_COLOR);
        }

        //S2P5
        //on cooldown
        S2P5.setAlpha(1-((float)currentCooldownArray[9]/(float)baseCooldownArray[9]));
        if(currentCooldownArray[9] > 0) {
            S2P5.setBackgroundColor(RED_COLOR);
        }else{
            //Not on cooldown
            S2P5.setBackgroundColor(GREEN_COLOR);
        }
    }

    public void genericBootClick(View v){
        int ourTag = Integer.parseInt((String)v.getTag());

        //Are we currently enabled or disabled?
        if(ourTimerTeam.get(ourTag).hasBoots){
            //We have boots!
            //Make it so we don't
            ourTimerTeam.get(ourTag).hasBoots = false;
            v.setAlpha(.5f);
        }else{
            //We don't have boots!
            //Make it so we do
            ourTimerTeam.get(ourTag).hasBoots = true;
            v.setAlpha(1f);
        }
        //Whichever we choose, we want to update our base cooldowns
        spellBaseCooldownUpdate();
    }

    public void genericEnchantClick(View v){
        //Basically the same as the boot click function
        int ourTag = Integer.parseInt((String)v.getTag());

        //Are we currently enabled or disabled?
        if(ourTimerTeam.get(ourTag).hasEnchant){
            //We have enchant!
            //Make it so we don't
            ourTimerTeam.get(ourTag).hasEnchant = false;
            v.setAlpha(.5f);
        }else{
            //We don't have enchant!
            //Make it so we do
            ourTimerTeam.get(ourTag).hasEnchant = true;
            v.setAlpha(1f);
        }
        //Update the base cooldowns regardless
        spellBaseCooldownUpdate();
    }

    //Helper function for readability
    public void initializeViews(){
        //P1
        ChampP1 = (ImageView)findViewById(R.id.imageViewChampP1);
        BootsP1 = (ImageButton)findViewById(R.id.imageButtonBootsP1);
        EnchantP1 = (ImageButton)findViewById(R.id.imageButtonEnchantP1);
        S1P1 = (ImageButton)findViewById(R.id.imageButtonS1P1);
        S2P1 = (ImageButton)findViewById(R.id.imageButtonS2P1);

        //P2
        ChampP2 = (ImageView)findViewById(R.id.imageViewChampP2);
        BootsP2 = (ImageButton)findViewById(R.id.imageButtonBootsP2);
        EnchantP2 = (ImageButton)findViewById(R.id.imageButtonEnchantP2);
        S1P2 = (ImageButton)findViewById(R.id.imageButtonS1P2);
        S2P2 = (ImageButton)findViewById(R.id.imageButtonS2P2);

        //P3
        ChampP3 = (ImageView)findViewById(R.id.imageViewChampP3);
        BootsP3 = (ImageButton)findViewById(R.id.imageButtonBootsP3);
        EnchantP3 = (ImageButton)findViewById(R.id.imageButtonEnchantP3);
        S1P3 = (ImageButton)findViewById(R.id.imageButtonS1P3);
        S2P3 = (ImageButton)findViewById(R.id.imageButtonS2P3);

        //P4
        ChampP4 = (ImageView)findViewById(R.id.imageViewChampP4);
        BootsP4 = (ImageButton)findViewById(R.id.imageButtonBootsP4);
        EnchantP4 = (ImageButton)findViewById(R.id.imageButtonEnchantP4);
        S1P4 = (ImageButton)findViewById(R.id.imageButtonS1P4);
        S2P4 = (ImageButton)findViewById(R.id.imageButtonS2P4);

        //P5
        ChampP5 = (ImageView)findViewById(R.id.imageViewChampP5);
        BootsP5 = (ImageButton)findViewById(R.id.imageButtonBootsP5);
        EnchantP5 = (ImageButton)findViewById(R.id.imageButtonEnchantP5);
        S1P5 = (ImageButton)findViewById(R.id.imageButtonS1P5);
        S2P5 = (ImageButton)findViewById(R.id.imageButtonS2P5);
    }

    //Helper function for readability and initial dynamic view population/drawing
    public void populateTimerViews(){

        PlayerData tempPlayer;
        int tempIconID;

        //Populate Player 1
        tempPlayer = ourTimerTeam.get(0);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.theChampion.iconName);
        AndrewUtilities.customDrawIcon(ChampP1, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell1.iconName);
        AndrewUtilities.customDrawIcon(S1P1, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell2.iconName);
        AndrewUtilities.customDrawIcon(S2P1, tempIconID);

        //Populate Player 2
        tempPlayer = ourTimerTeam.get(1);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.theChampion.iconName);
        AndrewUtilities.customDrawIcon(ChampP2, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell1.iconName);
        AndrewUtilities.customDrawIcon(S1P2, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell2.iconName);
        AndrewUtilities.customDrawIcon(S2P2, tempIconID);

        //Populate Player 3
        tempPlayer = ourTimerTeam.get(2);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.theChampion.iconName);
        AndrewUtilities.customDrawIcon(ChampP3, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell1.iconName);
        AndrewUtilities.customDrawIcon(S1P3, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell2.iconName);
        AndrewUtilities.customDrawIcon(S2P3, tempIconID);

        //Populate Player 4
        tempPlayer = ourTimerTeam.get(3);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.theChampion.iconName);
        AndrewUtilities.customDrawIcon(ChampP4, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell1.iconName);
        AndrewUtilities.customDrawIcon(S1P4, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell2.iconName);
        AndrewUtilities.customDrawIcon(S2P4, tempIconID);

        //Populate Player 5
        tempPlayer = ourTimerTeam.get(4);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.theChampion.iconName);
        AndrewUtilities.customDrawIcon(ChampP5, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell1.iconName);
        AndrewUtilities.customDrawIcon(S1P5, tempIconID);
        tempIconID = AndrewUtilities.getIconID(this, tempPlayer.spell2.iconName);
        AndrewUtilities.customDrawIcon(S2P5, tempIconID);

    }
}