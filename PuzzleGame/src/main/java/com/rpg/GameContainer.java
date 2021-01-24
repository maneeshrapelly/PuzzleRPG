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

/**
 * {@link GameContainer} container for all Game objects. i.e. players, stars and monsters .. etc
 */
public class GameContainer {

    Player player = new Player();
    ArrayList<Star> stars = new ArrayList<>();
     ArrayList<DarkSoldier> darkArmy = new ArrayList<>();
    ArrayList<Weapon> weaponColl = new ArrayList<>();
    private static GameContainer instance;

    private GameContainer() {
    }

    public static GameContainer getInstance() {
        if (instance == null) {
            synchronized (GameContainer.class) {
                if (instance == null) {
                    instance = new GameContainer();
                }
            }
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Star> getStars() {
        return stars;
    }

    public void setStars(ArrayList<Star> stars) {
        this.stars = stars;
    }

    public ArrayList<DarkSoldier> getDarkArmy() {
        return darkArmy;
    }

    public void setDarkArmy(ArrayList<DarkSoldier> darkArmy) {
        this.darkArmy = darkArmy;
    }

    public ArrayList<Weapon> getWeaponColl() {
        return weaponColl;
    }

    public void setWeaponColl(ArrayList<Weapon> weaponColl) {
        this.weaponColl = weaponColl;
    }

    public void initializeDarkCharacters() {
        darkArmy.add(new DarkSoldier());
        darkArmy.add(new DarthVader());
        darkArmy.add(new DarthMaul());
        darkArmy.add(new DarthSidious());
        darkArmy.add(new DarthTyrannus());
        darkArmy.add(new Snoke());
    }

    public void initializeWeapons() {
        weaponColl.add(new Weapon());
        weaponColl.add(new LightSaber());
        weaponColl.add(new Blaster());
    }
}
