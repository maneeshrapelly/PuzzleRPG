package com.rpg;

import com.rpg.monsters.DarkSoldier;
import com.rpg.util.HelperUtil;

import java.io.IOException;
import java.util.List;

/**
 * {@link MonsterResurrection} is responsible for starting and stopping resurrection thread for Monsters.
 */
public class MonsterResurrection {

    HelperUtil util = new HelperUtil();
    GameContainer container = GameContainer.getInstance();
    Thread resThread;
    boolean stopThread = false;
    public MonsterResurrection() {

    }

    public boolean isStopThread() {
        return stopThread;
    }

    public void setStopThread(boolean stopThread) {
        this.stopThread = stopThread;
    }

    public void startThread() {
        resThread = new Thread(() -> {
            try {
                while (!stopThread) {
                    resurrect();
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        resThread.start();
    }

    public void stopThread() {
        try {
            resThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted while stopping");
            e.printStackTrace();
        }
    }

    public void resurrect() {
        List<String> monsterInfo = null;
        try {
            monsterInfo = util.readLines("MonsterInfo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line: monsterInfo) {
            String[] words = line.split(" ");
            Star star = container.getStars().get(Integer.parseInt(words[2]));
            boolean alreadyPresent = false;
            for (DarkSoldier soldier: star.getSoldiers()) {
                if (words[1].equalsIgnoreCase(soldier.getId())) {
                    alreadyPresent = true;
                }
            }
            if (!alreadyPresent) {
                try {
                    star.getSoldiers().add((DarkSoldier) Class.forName("com.rpg.monsters." + words[1]).newInstance());
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
