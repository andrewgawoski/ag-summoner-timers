package com.andrew.gawoski.summonertimers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 3/6/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

//This is a singleton class for data transfer between activities

public class TeamData {


        /*-- Data Members --*/


        //An array of player information
        private List<PlayerData> teamList = new ArrayList<PlayerData>(); //(5);
        private int teamSize;
        //Our instance of the object for getInstance
        //private static TeamData holder;


        /*-- Singleton stuff --*/
        private static class TeamDataHolder{
            private static final TeamData holder = new TeamData();
        }

        public static TeamData getInstance(){
            return TeamDataHolder.holder;
        }

        /*-- Getter Methods --*/

        //Get entire array or list
        public List<PlayerData> getTeamList(){
            return teamList;
        }

        //Get single player from team
        public PlayerData getTeamList(int player){
            return teamList.get(player);
        }

        public int getTeamSize(){
            return teamSize;
        }


        /*-- Setter Methods --*/


        //Sets the entire team with individual players
        public void setTeam(PlayerData p1, PlayerData p2, PlayerData p3, PlayerData p4, PlayerData p5){
            //Need to have a team of five first otherwise index out of bounds
            teamList.set(0,p1);
            teamList.set(1,p2);
            teamList.set(2,p3);
            teamList.set(3,p4);
            teamList.set(4,p5);
        }

        //Sets the entire team with an array
        public void setTeam(List<PlayerData> someList){
            teamList = someList;
        }

        //Sets a single player from an object
        public void setPlayer(int index, PlayerData thePlayer){
            //If there's actually space to add the player
            if(index <= teamSize) {
                //If we can set instead of add
                if(teamList.size() > index) {
                    teamList.set(index, thePlayer);
                }else{
                    //otherwise we add
                    teamList.add(thePlayer);
                    //Unfortunately this works improperly if the index > 1 more than current size
                    //But functionally it should work well enough
                }
            }
        }

        //Sets a single player with relevant argument fields
        public void setPlayer(int index, String summoner, ChampionInfo champion, boolean boots, boolean mastery, boolean enchant){

            PlayerData tempPlayer = new PlayerData(summoner, champion, boots, mastery, enchant);
            teamList.set(index, tempPlayer);
        }


        /*-- Constructors --*/


        //Default
        TeamData(){
            teamList = new ArrayList<PlayerData>(); //(5);
            //teamList.add(new PlayerData());
            //teamList.add(new PlayerData());
            //teamList.add(new PlayerData());
            //teamList.add(new PlayerData());
            //teamList.add(new PlayerData());
            teamSize = 5;
            //5 players for team
        }

        //Non default constructor (variable team sizes) NOT USED
        private TeamData(int size){
            teamSize = size;
        }
}