package com.rpg.weapons;

public class Blaster extends Weapon {
    public Blaster() {
        name = "Blaster Rifle";
        id = "Blaster";
        String desc = "A Blaster Rifle available";
        canAcquire = true;
        location = "Wield";
        hp = 30;
        accuracy = 70;
    }
}
