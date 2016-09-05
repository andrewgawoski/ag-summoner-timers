package com.andrew.gawoski.summonertimers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew on 3/13/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class GameResponseWrapper {
    @SerializedName("response")
    @Expose
    private ResponseGame theResponse;

    public ResponseGame getTheResponse(){
        return theResponse;
    }

    public void setTheResponse(ResponseGame response){
        this.theResponse = response;
    }
}