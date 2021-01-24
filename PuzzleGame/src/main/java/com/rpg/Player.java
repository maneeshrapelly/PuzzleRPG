package com.rpg;

import com.rpg.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player {

    String name;
    int hp;
    int accuracy;
    int roomNum = 0;
    List<Weapon> weapons = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void explore() {
        System.out.println("Hit Points: "+ hp);
        System.out.println("Accuracy is: "+ accuracy);
        for (Weapon weapon: weapons) {
            System.out.println("Weapon: "+ weapon.getName());
        }
    }
}
