package com.andrew.gawoski.summonertimers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class Participant {

    @SerializedName("masteries")
    @Expose
    private List<Mastery> masteries = new ArrayList<Mastery>();
    @SerializedName("bot")
    @Expose
    private Boolean bot;
    @SerializedName("runes")
    @Expose
    private List<Rune> runes = new ArrayList<Rune>();
    @SerializedName("spell2Id")
    @Expose
    private long spell2Id;
    @SerializedName("profileIconId")
    @Expose
    private long profileIconId;
    @SerializedName("summonerName")
    @Expose
    private String summonerName;
    @SerializedName("championId")
    @Expose
    private long championId;
    @SerializedName("teamId")
    @Expose
    private long teamId;
    @SerializedName("summonerId")
    @Expose
    private long summonerId;
    @SerializedName("spell1Id")
    @Expose
    private long spell1Id;

    public Participant(){}

    public Participant(long teamId, long spell1Id, long spell2Id, long championId, long profileIconId, String summonerName, Boolean bot, long summonerId, List<Rune> runes, List<Mastery> masteries) {
        this.teamId = teamId;
        this.spell1Id = spell1Id;
        this.spell2Id = spell2Id;
        this.championId = championId;
        this.profileIconId = profileIconId;
        this.summonerName = summonerName;
        this.bot = bot;
        this.summonerId = summonerId;
        this.runes = runes;
        this.masteries = masteries;
    }

    /**
     *
     * @return
     * The masteries
     */
    public List<Mastery> getMasteries() {
        return masteries;
    }

    /**
     *
     * @param masteries
     * The masteries
     */
    public void setMasteries(List<Mastery> masteries) {
        this.masteries = masteries;
    }

    /**
     *
     * @return
     * The bot
     */
    public Boolean getBot() {
        return bot;
    }

    /**
     *
     * @param bot
     * The bot
     */
    public void setBot(Boolean bot) {
        this.bot = bot;
    }

    /**
     *
     * @return
     * The runes
     */
    public List<Rune> getRunes() {
        return runes;
    }

    /**
     *
     * @param runes
     * The runes
     */
    public void setRunes(List<Rune> runes) {
        this.runes = runes;
    }

    /**
     *
     * @return
     * The spell2Id
     */
    public long getSpell2Id() {
        return spell2Id;
    }

    /**
     *
     * @param spell2Id
     * The spell2Id
     */
    public void setSpell2Id(long spell2Id) {
        this.spell2Id = spell2Id;
    }

    /**
     *
     * @return
     * The profileIconId
     */
    public long getProfileIconId() {
        return profileIconId;
    }

    /**
     *
     * @param profileIconId
     * The profileIconId
     */
    public void setProfileIconId(long profileIconId) {
        this.profileIconId = profileIconId;
    }

    /**
     *
     * @return
     * The summonerName
     */
    public String getSummonerName() {
        return summonerName;
    }

    /**
     *
     * @param summonerName
     * The summonerName
     */
    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
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

    /**
     *
     * @return
     * The summonerId
     */
    public long getSummonerId() {
        return summonerId;
    }

    /**
     *
     * @param summonerId
     * The summonerId
     */
    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    /**
     *
     * @return
     * The spell1Id
     */
    public long getSpell1Id() {
        return spell1Id;
    }

    /**
     *
     * @param spell1Id
     * The spell1Id
     */
    public void setSpell1Id(long spell1Id) {
        this.spell1Id = spell1Id;
    }

}