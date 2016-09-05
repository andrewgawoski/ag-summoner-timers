package com.andrew.gawoski.summonertimers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class ResponseGame {

    @SerializedName("gameId")
    @Expose
    private long gameId;
    @SerializedName("mapId")
    @Expose
    private long mapId;
    @SerializedName("gameMode")
    @Expose
    private String gameMode;
    @SerializedName("gameType")
    @Expose
    private String gameType;
    @SerializedName("gameQueueConfigId")
    @Expose
    private long gameQueueConfigId;
    @SerializedName("participants")
    @Expose
    private List<Participant> participants = new ArrayList<Participant>();
    @SerializedName("observers")
    @Expose
    private Observers observers;
    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("bannedChampions")
    @Expose
    private List<BannedChampion> bannedChampions = new ArrayList<BannedChampion>();
    @SerializedName("gameStartTime")
    @Expose
    private long gameStartTime;
    @SerializedName("gameLength")
    @Expose
    private long gameLength;

    public ResponseGame(){}

    public ResponseGame(long gameId, long mapId, String gameMode, String gameType, long gameQueueConfigId, List<Participant> participants, Observers observers, String platformId, List<BannedChampion> bannedChampions, long gameStartTime, long gameLength) {
        this.gameId = gameId;
        this.mapId = mapId;
        this.gameMode = gameMode;
        this.gameType = gameType;
        this.gameQueueConfigId = gameQueueConfigId;
        this.participants = participants;
        this.observers = observers;
        this.platformId = platformId;
        this.bannedChampions = bannedChampions;
        this.gameStartTime = gameStartTime;
        this.gameLength = gameLength;
    }

    /**
     *
     * @return
     * The gameLength
     */
    public long getGameLength() {
        return gameLength;
    }

    /**
     *
     * @param gameLength
     * The gameLength
     */
    public void setGameLength(long gameLength) {
        this.gameLength = gameLength;
    }

    /**
     *
     * @return
     * The gameMode
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     *
     * @param gameMode
     * The gameMode
     */
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    /**
     *
     * @return
     * The mapId
     */
    public long getMapId() {
        return mapId;
    }

    /**
     *
     * @param mapId
     * The mapId
     */
    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    /**
     *
     * @return
     * The bannedChampions
     */
    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    /**
     *
     * @param bannedChampions
     * The bannedChampions
     */
    public void setBannedChampions(List<BannedChampion> bannedChampions) {
        this.bannedChampions = bannedChampions;
    }

    /**
     *
     * @return
     * The gameType
     */
    public String getGameType() {
        return gameType;
    }

    /**
     *
     * @param gameType
     * The gameType
     */
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    /**
     *
     * @return
     * The gameId
     */
    public long getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId
     * The gameId
     */
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    /**
     *
     * @return
     * The observers
     */
    public Observers getObservers() {
        return observers;
    }

    /**
     *
     * @param observers
     * The observers
     */
    public void setObservers(Observers observers) {
        this.observers = observers;
    }

    /**
     *
     * @return
     * The gameQueueConfigId
     */
    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    /**
     *
     * @param gameQueueConfigId
     * The gameQueueConfigId
     */
    public void setGameQueueConfigId(long gameQueueConfigId) {
        this.gameQueueConfigId = gameQueueConfigId;
    }

    /**
     *
     * @return
     * The gameStartTime
     */
    public long getGameStartTime() {
        return gameStartTime;
    }

    /**
     *
     * @param gameStartTime
     * The gameStartTime
     */
    public void setGameStartTime(long gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    /**
     *
     * @return
     * The participants
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     *
     * @param participants
     * The participants
     */
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    /**
     *
     * @return
     * The platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     *
     * @param platformId
     * The platformId
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

}