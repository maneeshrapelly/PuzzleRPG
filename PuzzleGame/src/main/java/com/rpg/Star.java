package com.rpg;

import com.rpg.monsters.DarkSoldier;
import com.rpg.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Star} class has information about one planet in galaxy
 */
public class Star {

    int roomNum;
    String name;
    List<String> features = new ArrayList<>();
    List<String> exits = new ArrayList<>();
    List<DarkSoldier> soldiers = new ArrayList<>();
    List<Weapon> weapons = new ArrayList<>();

    public Star(int num) {
        this.roomNum = num;
    }


    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getExits() {
        return exits;
    }

    public void setExits(List<String> exits) {
        this.exits = exits;
    }

    public List<DarkSoldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<DarkSoldier> soldiers) {
        this.soldiers = soldiers;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }
}
