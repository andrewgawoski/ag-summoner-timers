package com.andrew.gawoski.summonertimers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class BannedChampion {

    @SerializedName("pickTurn")
    @Expose
    private int pickTurn;
    @SerializedName("championId")
    @Expose
    private long championId;
    @SerializedName("teamId")
    @Expose
    private long teamId;

    public BannedChampion(){}

    public BannedChampion(long championId, long teamId, Integer pickTurn) {
        this.championId = championId;
        this.teamId = teamId;
        this.pickTurn = pickTurn;
    }

    /**
     *
     * @return
     * The pickTurn
     */
    public int getPickTurn() {
        return pickTurn;
    }

    /**
     *
     * @param pickTurn
     * The pickTurn
     */
    public void setPickTurn(int pickTurn) {
        this.pickTurn = pickTurn;
    }

    /**
     *
     * @return
     * The championId
     */
    public long getChampionId() {
        return championId;
    }

    /**
     *
     * @param championId
     * The championId
     */
    public void setChampionId(long championId) {
        this.championId = championId;
    }

    /**
     *
     * @return
     * The teamId
     */
    public long getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     * The teamId
     */
    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

}