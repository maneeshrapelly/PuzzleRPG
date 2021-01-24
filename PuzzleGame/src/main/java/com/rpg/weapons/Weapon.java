package com.rpg.weapons;

public class Weapon {
    String name;
    String id = "Weapon";
    String desc;
    boolean canAcquire = false;
    String location;
    int hp;
    int accuracy;

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

    public boolean isCanAcquire() {
        return canAcquire;
    }

    public void setCanAcquire(boolean canAcquire) {
        this.canAcquire = canAcquire;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
