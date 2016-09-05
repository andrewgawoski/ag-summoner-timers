package com.andrew.gawoski.summonertimers;

/**
 * Created by Andrew on 3/6/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

//Class that is inside the team array and used for data transfer, not populated directly from API
public class PlayerData {

    public String summonerName;
    public ChampionInfo theChampion;
    public boolean hasBoots;
    public boolean hasMastery;
    public SSInfo spell1;
    public SSInfo spell2;
    public boolean hasEnchant;

    //Constructor (Default)
    PlayerData(){
        summonerName = null;
        theChampion = new ChampionInfo();
        hasBoots = false;
        hasMastery = false;
        spell1 = new SSInfo();
        spell2 = new SSInfo();
        hasEnchant = false;
    }

    //Non default constructor
    PlayerData(String summoner, ChampionInfo champion, boolean boots, boolean mastery, boolean enchant){
        summonerName = summoner;
        theChampion = champion;
        hasBoots = boots;
        hasMastery = mastery;
        spell1 = new SSInfo();
        spell2 = new SSInfo();
        hasEnchant = enchant;
    }

    //Second non default constructor
    PlayerData(String summoner, ChampionInfo champion, boolean boots, boolean mastery, SSInfo s1, SSInfo s2){
        summonerName = summoner;
        theChampion = champion;
        hasBoots = boots;
        hasMastery = mastery;
        spell1 = s1;
        spell2 = s2;
        hasEnchant = false;
    }
}