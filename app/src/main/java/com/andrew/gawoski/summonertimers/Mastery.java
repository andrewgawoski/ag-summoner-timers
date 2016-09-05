package com.andrew.gawoski.summonertimers;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class Mastery {

    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("masteryId")
    @Expose
    private long masteryId;

    public Mastery(){}

    public Mastery(int rank, long masteryId) {
        this.rank = rank;
        this.masteryId = masteryId;
    }

    /**
     *
     * @return
     * The rank
     */
    public int getRank() {
        return rank;
    }

    /**
     *
     * @param rank
     * The rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     *
     * @return
     * The masteryId
     */
    public long getMasteryId() {
        return masteryId;
    }

    /**
     *
     * @param masteryId
     * The masteryId
     */
    public void setMasteryId(long masteryId) {
        this.masteryId = masteryId;
    }

}