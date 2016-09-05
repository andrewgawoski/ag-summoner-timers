package com.andrew.gawoski.summonertimers;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class Rune {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("runeId")
    @Expose
    private long runeId;

    public Rune(){}

    public Rune(int count, long runeId) {
        this.count = count;
        this.runeId = runeId;
    }

    /**
     *
     * @return
     * The count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The runeId
     */
    public long getRuneId() {
        return runeId;
    }

    /**
     *
     * @param runeId
     * The runeId
     */
    public void setRuneId(long runeId) {
        this.runeId = runeId;
    }

}