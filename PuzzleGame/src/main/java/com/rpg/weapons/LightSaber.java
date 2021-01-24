package com.rpg.weapons;

public class LightSaber extends Weapon {
    public LightSaber() {
        name = "Light Sword";
        id = "LightSaber";
        String desc = "A Light Sword available";
        canAcquire = true;
        location = "Hand";
        hp = 10;
        accuracy = 50;
    }
}
