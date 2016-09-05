package com.andrew.gawoski.summonertimers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrew on 3/6/2016.
 */

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

//Initializes the map of champions and their icon paths here.

//Hopefully shared between classes
public class ChampionList {

    List<ChampionInfo> listOfChampions = new ArrayList<ChampionInfo>();


    private static class ChampionListHolder{
        private static final ChampionList theList = new ChampionList();
    }

    public static ChampionList getInstance(){
        return ChampionListHolder.theList;
    }

    public Map<Long, Integer> getIdToOurIndex(){return idToOurIndex;}

    public List<ChampionInfo> getListOfChampions() {
        return listOfChampions;
    }

    public Map<Long, Integer> idToOurIndex = new HashMap<Long, Integer>();
    private ChampionList(){

        //listOfChampions = new ArrayList<ChampionInfo>();

        //ChampionInfo(champion name, icon name)
        listOfChampions.add(new ChampionInfo("Aatrox", "icon_aatrox"));
        idToOurIndex.put(266L, 0);
        listOfChampions.add(new ChampionInfo("Ahri", "icon_ahri"));
        idToOurIndex.put(103L, 1);
        listOfChampions.add(new ChampionInfo("Akali", "icon_akali"));
        idToOurIndex.put(84L, 2);
        listOfChampions.add(new ChampionInfo("Alistar", "icon_alistar"));
        idToOurIndex.put(12L, 3);
        listOfChampions.add(new ChampionInfo("Amumu", "icon_amumu"));
        idToOurIndex.put(32L, 4);
        listOfChampions.add(new ChampionInfo("Anivia", "icon_anivia"));
        idToOurIndex.put(34L, 5);
        listOfChampions.add(new ChampionInfo("Annie", "icon_annie"));
        idToOurIndex.put(1L, 6);
        listOfChampions.add(new ChampionInfo("Ashe", "icon_ashe"));
        idToOurIndex.put(22L, 7);
        listOfChampions.add(new ChampionInfo("Aurelion Sol", "icon_aurelion_sol"));
        idToOurIndex.put(0L, 8);
        listOfChampions.add(new ChampionInfo("Azir", "icon_azir"));
        idToOurIndex.put(268L, 9);
        listOfChampions.add(new ChampionInfo("Bard", "icon_bard"));
        idToOurIndex.put(432L, 10);
        listOfChampions.add(new ChampionInfo("Blitzcrank", "icon_blitzcrank"));
        idToOurIndex.put(53L, 11);
        listOfChampions.add(new ChampionInfo("Brand", "icon_brand"));
        idToOurIndex.put(63L, 12);
        listOfChampions.add(new ChampionInfo("Braum", "icon_braum"));
        idToOurIndex.put(201L, 13);
        listOfChampions.add(new ChampionInfo("Caitlyn", "icon_caitlyn"));
        idToOurIndex.put(51L, 14);
        listOfChampions.add(new ChampionInfo("Cassiopeia", "icon_cassiopeia"));
        idToOurIndex.put(69L, 15);
        listOfChampions.add(new ChampionInfo("Cho'Gath", "icon_chogath"));
        idToOurIndex.put(31L, 16);
        listOfChampions.add(new ChampionInfo("Corki", "icon_corki"));
        idToOurIndex.put(42L, 17);
        listOfChampions.add(new ChampionInfo("Darius", "icon_darius"));
        idToOurIndex.put(122L, 18);
        listOfChampions.add(new ChampionInfo("Diana", "icon_diana"));
        idToOurIndex.put(131L, 19);
        listOfChampions.add(new ChampionInfo("Dr. Mundo", "icon_dr_mundo"));
        idToOurIndex.put(36L, 20);
        listOfChampions.add(new ChampionInfo("Draven", "icon_draven"));
        idToOurIndex.put(119L, 21);
        listOfChampions.add(new ChampionInfo("Ekko", "icon_ekko"));
        idToOurIndex.put(245L, 22);
        listOfChampions.add(new ChampionInfo("Elise", "icon_elise"));
        idToOurIndex.put(60L, 23);
        listOfChampions.add(new ChampionInfo("Evelynn", "icon_evelynn"));
        idToOurIndex.put(28L, 24);
        listOfChampions.add(new ChampionInfo("Ezreal", "icon_ezreal"));
        idToOurIndex.put(81L, 25);
        listOfChampions.add(new ChampionInfo("Fiddlesticks", "icon_fiddlesticks"));
        idToOurIndex.put(9L, 26);
        listOfChampions.add(new ChampionInfo("Fiora", "icon_fiora"));
        idToOurIndex.put(114L, 27);
        listOfChampions.add(new ChampionInfo("Fizz", "icon_fizz"));
        idToOurIndex.put(105L, 28);
        listOfChampions.add(new ChampionInfo("Galio", "icon_galio"));
        idToOurIndex.put(3L, 29);
        listOfChampions.add(new ChampionInfo("Gangplank", "icon_gangplank"));
        idToOurIndex.put(41L, 30);
        listOfChampions.add(new ChampionInfo("Garen", "icon_garen"));
        idToOurIndex.put(86L, 31);
        listOfChampions.add(new ChampionInfo("Gnar", "icon_gnar"));
        idToOurIndex.put(150L, 32);
        listOfChampions.add(new ChampionInfo("Gragas", "icon_gragas"));
        idToOurIndex.put(79L, 33);
        listOfChampions.add(new ChampionInfo("Graves", "icon_graves"));
        idToOurIndex.put(104L, 34);
        listOfChampions.add(new ChampionInfo("Hecarim", "icon_hecarim"));
        idToOurIndex.put(120L, 35);
        listOfChampions.add(new ChampionInfo("Heimerdinger", "icon_heimerdinger"));
        idToOurIndex.put(74L, 36);
        listOfChampions.add(new ChampionInfo("Illaoi", "icon_illaoi"));
        idToOurIndex.put(420L, 37);
        listOfChampions.add(new ChampionInfo("Irelia", "icon_irelia"));
        idToOurIndex.put(39L, 38);
        listOfChampions.add(new ChampionInfo("Janna", "icon_janna"));
        idToOurIndex.put(40L, 39);
        listOfChampions.add(new ChampionInfo("Jarvan IV", "icon_jarvan_iv"));
        idToOurIndex.put(59L, 40);
        listOfChampions.add(new ChampionInfo("Jax", "icon_jax"));
        idToOurIndex.put(24L, 41);
        listOfChampions.add(new ChampionInfo("Jayce", "icon_jayce"));
        idToOurIndex.put(126L, 42);
        listOfChampions.add(new ChampionInfo("Jhin", "icon_jhin"));
        idToOurIndex.put(202L, 43);
        listOfChampions.add(new ChampionInfo("Jinx", "icon_jinx"));
        idToOurIndex.put(222L, 44);
        listOfChampions.add(new ChampionInfo("Kalista", "icon_kalista"));
        idToOurIndex.put(429L, 45);
        listOfChampions.add(new ChampionInfo("Karma", "icon_karma"));
        idToOurIndex.put(43L, 46);
        listOfChampions.add(new ChampionInfo("Karthus", "icon_karthus"));
        idToOurIndex.put(30L, 47);
        listOfChampions.add(new ChampionInfo("Kassadin", "icon_kassadin"));
        idToOurIndex.put(38L, 48);
        listOfChampions.add(new ChampionInfo("Katarina", "icon_katarina"));
        idToOurIndex.put(55L, 49);
        listOfChampions.add(new ChampionInfo("Kayle", "icon_kayle"));
        idToOurIndex.put(10L, 50);
        listOfChampions.add(new ChampionInfo("Kennen", "icon_kennen"));
        idToOurIndex.put(85L, 51);
        listOfChampions.add(new ChampionInfo("Kha'Zix", "icon_khazix"));
        idToOurIndex.put(121L, 52);
        listOfChampions.add(new ChampionInfo("Kindred", "icon_kindred"));
        idToOurIndex.put(203L, 53);
        listOfChampions.add(new ChampionInfo("Kog'Maw", "icon_kogmaw"));
        idToOurIndex.put(96L, 54);
        listOfChampions.add(new ChampionInfo("LeBlanc", "icon_leblanc"));
        idToOurIndex.put(7L, 55);
        listOfChampions.add(new ChampionInfo("Lee Sin", "icon_lee_sin"));
        idToOurIndex.put(64L, 56);
        listOfChampions.add(new ChampionInfo("Leona", "icon_leona"));
        idToOurIndex.put(89L, 57);
        listOfChampions.add(new ChampionInfo("Lissandra", "icon_lissandra"));
        idToOurIndex.put(127L, 58);
        listOfChampions.add(new ChampionInfo("Lucian", "icon_lucian"));
        idToOurIndex.put(236L, 59);
        listOfChampions.add(new ChampionInfo("Lulu", "icon_lulu"));
        idToOurIndex.put(117L, 60);
        listOfChampions.add(new ChampionInfo("Lux", "icon_lux"));
        idToOurIndex.put(99L, 61);
        listOfChampions.add(new ChampionInfo("Malphite", "icon_malphite"));
        idToOurIndex.put(54L, 62);
        listOfChampions.add(new ChampionInfo("Malzahar", "icon_malzahar"));
        idToOurIndex.put(90L, 63);
        listOfChampions.add(new ChampionInfo("Maokai", "icon_maokai"));
        idToOurIndex.put(57L, 64);
        listOfChampions.add(new ChampionInfo("Master Yi", "icon_master_yi"));
        idToOurIndex.put(11L, 65);
        listOfChampions.add(new ChampionInfo("Miss Fortune", "icon_miss_fortune"));
        idToOurIndex.put(21L, 66);
        listOfChampions.add(new ChampionInfo("Mordekaiser", "icon_mordekaiser"));
        idToOurIndex.put(82L, 67);
        listOfChampions.add(new ChampionInfo("Morgana", "icon_morgana"));
        idToOurIndex.put(25L, 68);
        listOfChampions.add(new ChampionInfo("Nami", "icon_nami"));
        idToOurIndex.put(267L, 69);
        listOfChampions.add(new ChampionInfo("Nasus", "icon_nasus"));
        idToOurIndex.put(75L, 70);
        listOfChampions.add(new ChampionInfo("Nautilus", "icon_nautilus"));
        idToOurIndex.put(111L, 71);
        listOfChampions.add(new ChampionInfo("Nidalee", "icon_nidalee"));
        idToOurIndex.put(76L, 72);
        listOfChampions.add(new ChampionInfo("Nocturne", "icon_nocturne"));
        idToOurIndex.put(56L, 73);
        listOfChampions.add(new ChampionInfo("Nunu", "icon_nunu"));
        idToOurIndex.put(20L, 74);
        listOfChampions.add(new ChampionInfo("Olaf", "icon_olaf"));
        idToOurIndex.put(2L, 75);
        listOfChampions.add(new ChampionInfo("Orianna", "icon_orianna"));
        idToOurIndex.put(61L, 76);
        listOfChampions.add(new ChampionInfo("Pantheon", "icon_pantheon"));
        idToOurIndex.put(80L, 77);
        listOfChampions.add(new ChampionInfo("Poppy", "icon_poppy"));
        idToOurIndex.put(78L, 78);
        listOfChampions.add(new ChampionInfo("Quinn", "icon_quinn"));
        idToOurIndex.put(133L, 79);
        listOfChampions.add(new ChampionInfo("Rammus", "icon_rammus"));
        idToOurIndex.put(33L, 80);
        listOfChampions.add(new ChampionInfo("Rek'Sai", "icon_reksai"));
        idToOurIndex.put(421L, 81);
        listOfChampions.add(new ChampionInfo("Renekton", "icon_renekton"));
        idToOurIndex.put(58L, 82);
        listOfChampions.add(new ChampionInfo("Rengar", "icon_rengar"));
        idToOurIndex.put(107L, 83);
        listOfChampions.add(new ChampionInfo("Riven", "icon_riven"));
        idToOurIndex.put(92L, 84);
        listOfChampions.add(new ChampionInfo("Rumble", "icon_rumble"));
        idToOurIndex.put(68L, 85);
        listOfChampions.add(new ChampionInfo("Ryze", "icon_ryze"));
        idToOurIndex.put(13L, 86);
        listOfChampions.add(new ChampionInfo("Sejuani", "icon_sejuani"));
        idToOurIndex.put(113L, 87);
        listOfChampions.add(new ChampionInfo("Shaco", "icon_shaco"));
        idToOurIndex.put(35L, 88);
        listOfChampions.add(new ChampionInfo("Shen", "icon_shen"));
        idToOurIndex.put(98L, 89);
        listOfChampions.add(new ChampionInfo("Shyvana", "icon_shyvana"));
        idToOurIndex.put(102L, 90);
        listOfChampions.add(new ChampionInfo("Singed", "icon_singed"));
        idToOurIndex.put(27L, 91);
        listOfChampions.add(new ChampionInfo("Sion", "icon_sion"));
        idToOurIndex.put(14L, 92);
        listOfChampions.add(new ChampionInfo("Sivir", "icon_sivir"));
        idToOurIndex.put(15L, 93);
        listOfChampions.add(new ChampionInfo("Skarner", "icon_skarner"));
        idToOurIndex.put(72L, 94);
        listOfChampions.add(new ChampionInfo("Sona", "icon_sona"));
        idToOurIndex.put(37L, 95);
        listOfChampions.add(new ChampionInfo("Soraka", "icon_soraka"));
        idToOurIndex.put(16L, 96);
        listOfChampions.add(new ChampionInfo("Swain", "icon_swain"));
        idToOurIndex.put(50L, 97);
        listOfChampions.add(new ChampionInfo("Syndra", "icon_syndra"));
        idToOurIndex.put(134L, 98);
        listOfChampions.add(new ChampionInfo("Tahm Kench", "icon_tahm_kench"));
        idToOurIndex.put(223L, 99);
        listOfChampions.add(new ChampionInfo("Talon", "icon_talon"));
        idToOurIndex.put(91L, 100);
        listOfChampions.add(new ChampionInfo("Taric", "icon_taric"));
        idToOurIndex.put(44L, 101);
        listOfChampions.add(new ChampionInfo("Teemo", "icon_teemo"));
        idToOurIndex.put(17L, 102);
        listOfChampions.add(new ChampionInfo("Thresh", "icon_thresh"));
        idToOurIndex.put(412L, 103);
        listOfChampions.add(new ChampionInfo("Tristana", "icon_tristana"));
        idToOurIndex.put(18L, 104);
        listOfChampions.add(new ChampionInfo("Trundle", "icon_trundle"));
        idToOurIndex.put(48L, 105);
        listOfChampions.add(new ChampionInfo("Tryndamere", "icon_tryndamere"));
        idToOurIndex.put(23L, 106);
        listOfChampions.add(new ChampionInfo("Twisted Fate", "icon_twisted_fate"));
        idToOurIndex.put(4L, 107);
        listOfChampions.add(new ChampionInfo("Twitch", "icon_twitch"));
        idToOurIndex.put(29L, 108);
        listOfChampions.add(new ChampionInfo("Udyr", "icon_udyr"));
        idToOurIndex.put(77L, 109);
        listOfChampions.add(new ChampionInfo("Urgot", "icon_urgot"));
        idToOurIndex.put(6L, 110);
        listOfChampions.add(new ChampionInfo("Varus", "icon_varus"));
        idToOurIndex.put(110L, 111);
        listOfChampions.add(new ChampionInfo("Vayne", "icon_vayne"));
        idToOurIndex.put(67L, 112);
        listOfChampions.add(new ChampionInfo("Veigar", "icon_veigar"));
        idToOurIndex.put(45L, 113);
        listOfChampions.add(new ChampionInfo("Vel'Koz", "icon_velkoz"));
        idToOurIndex.put(161L, 114);
        listOfChampions.add(new ChampionInfo("Vi", "icon_vi"));
        idToOurIndex.put(254L, 115);
        listOfChampions.add(new ChampionInfo("Viktor", "icon_viktor"));
        idToOurIndex.put(112L, 116);
        listOfChampions.add(new ChampionInfo("Vladimir", "icon_vladimir"));
        idToOurIndex.put(8L, 117);
        listOfChampions.add(new ChampionInfo("Volibear", "icon_volibear"));
        idToOurIndex.put(106L, 118);
        listOfChampions.add(new ChampionInfo("Warwick", "icon_warwick"));
        idToOurIndex.put(19L, 119);
        listOfChampions.add(new ChampionInfo("Wukong", "icon_wukong"));
        idToOurIndex.put(62L, 120);
        listOfChampions.add(new ChampionInfo("Xerath", "icon_xerath"));
        idToOurIndex.put(101L, 121);
        listOfChampions.add(new ChampionInfo("Xin Zhao", "icon_xin_zhao"));
        idToOurIndex.put(5L, 122);
        listOfChampions.add(new ChampionInfo("Yasuo", "icon_yasuo"));
        idToOurIndex.put(157L, 123);
        listOfChampions.add(new ChampionInfo("Yorick", "icon_yorick"));
        idToOurIndex.put(83L, 124);
        listOfChampions.add(new ChampionInfo("Zac", "icon_zac"));
        idToOurIndex.put(154L, 125);
        listOfChampions.add(new ChampionInfo("Zed", "icon_zed"));
        idToOurIndex.put(238L, 126);
        listOfChampions.add(new ChampionInfo("Ziggs", "icon_ziggs"));
        idToOurIndex.put(115L, 127);
        listOfChampions.add(new ChampionInfo("Zilean", "icon_zilean"));
        idToOurIndex.put(26L, 128);
        listOfChampions.add(new ChampionInfo("Zyra", "icon_zyra"));
        idToOurIndex.put(143L, 129);
    }
}