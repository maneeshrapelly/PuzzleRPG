package com.rpg;

/**
 * Entry point to game, where it continue asking for player next action.
 * Exits after player collects 1000 Hit points.
 */
public class GameEntry {

    static MoveStep move = new MoveStep();
    public static void main(String[] args) {
        GameContainer.initializeDarkCharacters();
        GameContainer.initializeWeapons();
        MonsterResurrection res = new MonsterResurrection();
        res.startThread();

        while (true) {
            continuationloop();
            if (GameContainer.player.getHp() >= 1000) {
                System.out.println("You Won, Galaxy is yours");
                res.stopThread();
                break;
            }
        }
    }

    public static void continuationloop() {
        move.parseNextCommand();
    }
}
