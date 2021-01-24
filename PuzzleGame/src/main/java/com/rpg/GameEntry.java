package com.rpg;

/**
 * {@link GameEntry} Entry point to game, where it continue asking for player next action.
 * Exits after player collects 1000 Hit points.
 */
public class GameEntry {

    static CommandProcessor move = new CommandProcessor();
    public static void main(String[] args) {
        GameContainer container = GameContainer.getInstance();
        container.initializeDarkCharacters();
        container.initializeWeapons();
        MonsterResurrection res = new MonsterResurrection();
        res.startThread();

        while (true) {
            continuationloop();
            if (move.isStateSaved() || container.getPlayer().getHp() >= 1000) {
                res.setStopThread(true);
                res.stopThread();
                if (container.getPlayer().getHp() >= 1000) {
                    System.out.println("You Won, Galaxy is yours");
                } else {
                    System.out.println("Game state is saved! will be resumed from here when started again");
                }
                break;
            }
        }
    }

    public static void continuationloop() {
        move.parseNextCommand();
    }
}
