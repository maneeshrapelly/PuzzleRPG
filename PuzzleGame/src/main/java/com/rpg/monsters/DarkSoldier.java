package com.rpg.monsters;

public class DarkSoldier {

    String name;
    String id = "DarkSoldier";
    String desc;
    int hp;
    int accuracy;

    public void explore() {
        System.out.println("Name: "+ name);
        System.out.println("Hit Points: "+ hp);
        System.out.println("Accuracy is: "+ accuracy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
