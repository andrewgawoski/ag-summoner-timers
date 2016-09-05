package com.andrew.gawoski.summonertimers;

import android.content.Context;

/**
 * Created by Andrew on 3/6/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class ChampionInfo {
    public String champName;
    public String iconName;

    public String getIconName(){
        if (!iconName.equals("")){
            return iconName;
        }else{
            return "icon_default";
        }
    }

    ChampionInfo(){
        champName = "";
        iconName = "";
    }

    ChampionInfo(String cn, String in){
        champName = cn;
        iconName = in;
    }
}