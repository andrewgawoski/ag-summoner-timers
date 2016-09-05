package com.andrew.gawoski.summonertimers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrew on 3/8/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class SpellList {

    List<SSInfo> listOfSpells = new ArrayList<SSInfo>();

    public Map<Long, Integer> spellIDtoIndex = new HashMap<Long, Integer>();

    private static class SpellListHolder{
        private static final SpellList theList = new SpellList();
    }

    public static SpellList getInstance(){
        return SpellListHolder.theList;
    }


    public List<SSInfo> getListOfSpells() {
        return listOfSpells;
    }

    public Map<Long, Integer> getSpellIDtoIndex(){return  spellIDtoIndex;}


    private SpellList() {
        listOfSpells.add(new SSInfo("Barrier", "icon_barrier", 210));
        spellIDtoIndex.put(21L, 0);
        listOfSpells.add(new SSInfo("Cleanse", "icon_cleanse", 210));
        spellIDtoIndex.put(1L, 1);
        listOfSpells.add(new SSInfo("Exhaust", "icon_exhaust", 210));
        spellIDtoIndex.put(3L, 2);
        listOfSpells.add(new SSInfo("Flash", "icon_flash", 300));
        spellIDtoIndex.put(4L, 3);
        listOfSpells.add(new SSInfo("Ghost", "icon_ghost", 210));
        spellIDtoIndex.put(6L, 4);
        listOfSpells.add(new SSInfo("Heal", "icon_heal", 240));
        spellIDtoIndex.put(7L, 5);
        listOfSpells.add(new SSInfo("Ignite", "icon_ignite", 210));
        spellIDtoIndex.put(14L, 6);
        listOfSpells.add(new SSInfo("Smite", "icon_smite", 15));
        spellIDtoIndex.put(11L, 7);
        listOfSpells.add(new SSInfo("Teleport", "icon_teleport", 300));
        spellIDtoIndex.put(12L, 8);
    }

}