package com.andrew.gawoski.summonertimers;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class Observers {

    @SerializedName("encryptionKey")
    @Expose
    private String encryptionKey;

    public Observers(){}

    public Observers(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    /**
     *
     * @return
     * The encryptionKey
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

    /**
     *
     * @param encryptionKey
     * The encryptionKey
     */
    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

}