package com.andrew.gawoski.summonertimers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew on 3/12/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class SummonerDTO {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profileIconId")
    @Expose
    private int profileIconId;
    @SerializedName("summonerLevel")
    @Expose
    private long summonerLevel;
    @SerializedName("revisionDate")
    @Expose
    private long revisionDate;

    public SummonerDTO(){}


    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId){
        this.profileIconId = profileIconId;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(long summonerLevel){
        this.summonerLevel = summonerLevel;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(long revisionDate){
        this.revisionDate = revisionDate;
    }
}