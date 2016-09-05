package com.andrew.gawoski.summonertimers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew on 3/13/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class SummonerWrapper {

    @SerializedName("SummonerDTO")
    @Expose
    private com.andrew.gawoski.summonertimers.SummonerDTO ourSummoner;

    public SummonerWrapper(){}

    public SummonerDTO getOurSummoner() {
        return ourSummoner;
    }

    public void setOurSummoner(SummonerDTO ourSummoner){
        this.ourSummoner = ourSummoner;
    }
}