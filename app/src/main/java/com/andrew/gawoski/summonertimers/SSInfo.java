package com.andrew.gawoski.summonertimers;

/**
 * Created by Andrew on 3/8/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class SSInfo {
    public String spellName;
    public String iconName;
    //In whole seconds, base cooldown
    public int cooldown;

    public String getIconName(){
        if (!iconName.equals("")){
            return iconName;
        }else{
            return "icon_default";
        }
    }

    SSInfo(){
        spellName = "";
        iconName = "";
        cooldown = -1;
    }

    SSInfo(String sn, String in, int cd){
        spellName = sn;
        iconName = in;
        cooldown = cd;
    }
}