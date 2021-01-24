package com.rpg;

import com.rpg.monsters.DarkSoldier;
import com.rpg.monsters.DarthMaul;
import com.rpg.monsters.DarthSidious;
import com.rpg.monsters.DarthTyrannus;
import com.rpg.monsters.DarthVader;
import com.rpg.monsters.Snoke;
import com.rpg.weapons.Blaster;
import com.rpg.weapons.LightSaber;
import com.rpg.weapons.Weapon;

import java.util.ArrayList;

public class GameContainer {
    static Player player = new Player();
    static ArrayList<Star> stars = new ArrayList<>();
    static ArrayList<Object> darkArmy = new ArrayList<>();
    static ArrayList<Object> weaponColl = new ArrayList<>();

    public static void initializeDarkCharacters() {
        darkArmy.add(new DarkSoldier());
        darkArmy.add(new DarthVader());
        darkArmy.add(new DarthMaul());
        darkArmy.add(new DarthSidious());
        darkArmy.add(new DarthTyrannus());
        darkArmy.add(new Snoke());
    }

    public static void initializeWeapons() {
        weaponColl.add(new Weapon());
        weaponColl.add(new LightSaber());
        weaponColl.add(new Blaster());
    }
}
