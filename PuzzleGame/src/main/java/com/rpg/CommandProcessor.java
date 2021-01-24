package com.rpg;

import com.rpg.monsters.DarkSoldier;
import com.rpg.util.Constants;
import com.rpg.util.HelperUtil;
import com.rpg.weapons.Weapon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.rpg.util.Constants.*;

/**
 * {@link CommandProcessor} operational logic after each command from the player
 */
public class CommandProcessor {

    HelperUtil util = new HelperUtil();
    Scanner sc = new Scanner(System.in);
    GameContainer container = GameContainer.getInstance();
    boolean stateSaved = false;

    public boolean isStateSaved() {
        return stateSaved;
    }

    public void setStateSaved(boolean stateSaved) {
        this.stateSaved = stateSaved;
    }

    public CommandProcessor() {
        // Fill Room information from text file
        container.getStars().add(new Star(0));
        List<String> roomInfo = null;
        try {
            roomInfo = util.readLines("StarsInfo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Star newStar = null;
        for (String line : roomInfo) {
            String words[] = line.split(":");
            if ("Number".equalsIgnoreCase(words[0])) {
                newStar = new Star(Integer.parseInt(words[1].trim()));
                container.getStars().add(newStar);
            } else if ("Name".equalsIgnoreCase(words[0])) {
                newStar.setName(words[1].trim());
            } else if ("Desc".equalsIgnoreCase(words[0])) {
                newStar.getFeatures().add(words[1].trim());
            } else if ("Exit".equalsIgnoreCase(words[0])) {
                newStar.getExits().add(words[1].trim());
            }
        }

    }
/*
    public List<String> readLines(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    } */

    public void parseNextCommand() {
        if (container.getPlayer().roomNum == 0) {
            // start game from scratch, i.e. create player character
            createPlayerChar();
        }
        System.out.println("Commands for Exploring: Explore(Explore surroundings) Explore Self" +
                "(Self)");
        System.out.println("Commands for Moving: Move North, Move South, Move West, Move East");
        System.out.println("Command for Attack: Attack <soldier-name>");
        System.out.println("Command for Saving the game state: Save");
        //System.out.println("Move direction? N(up) E(right) W(left) S(down)");
        String input = sc.nextLine();
        String[] inputWords = input.split(" ");
        processCommand(inputWords);
    }

    public void processCommand(String[] commands) {
        if (commands[0].equalsIgnoreCase(EXPLORE)) {
            explore(commands);
        } /*else if (commands[0].equalsIgnoreCase(CREATE)) {
            createWeapon(commands);
        } else if (commands[0].equalsIgnoreCase(ACQUIRE)) {
            acquireWeapon(commands);
        } */ else if (commands[0].equalsIgnoreCase(MOVE)) {
            move(commands);
        } else if (commands[0].equalsIgnoreCase(ATTACK)) {
            attack(commands);
        } else if (commands[0].equalsIgnoreCase(SAVE)) {
            save(commands);
        } else {
            System.out.println("Invalid command");
        }

    }


    public void createPlayerChar() {
        List<String> lines = null;
        try {
            String tempPath = System.getProperty("java.io.tmpdir");
            lines = util.readStatusFile(tempPath + File.separator + PLAYER_STATE_TXT_FILE);
            // write empty state to mark there is no state saved once read
            util.writeGameState(PLAYER_STATE_TXT_FILE, "");
        } catch (IOException e) {
            // ignore exception
            //System.out.println("No status file or failed to read it");
        }
        if (lines != null && lines.size() >= 3) {
            for (String line : lines) {
                String[] words = line.split(" ");
                if (NAME.trim().equalsIgnoreCase(words[0])) {
                    container.getPlayer().setName(words[1].trim());
                } else if (POINTS.trim().equalsIgnoreCase(words[0])) {
                    container.getPlayer().setHp(Integer.parseInt(words[1].trim()));
                } else if (ROOM.trim().equalsIgnoreCase(words[0])) {
                    container.getPlayer().setRoomNum(Integer.parseInt(words[1].trim()));
                }
            }
            container.getPlayer().accuracy = 75;
            System.out.println("Restored Player state");
            return;
        }

        System.out.println("Welcome to the Star's world. What do we call you");
        String name = sc.nextLine();
        container.getPlayer().name = name;
        System.out.println("Here comes " + name + " from planet Earth to conquer the galaxy");
        System.out.println("Master Yoda gives you 100 hp and 75 accuracy to start. " +
                "May the force be with you!");
        container.getPlayer().hp = 100;
        container.getPlayer().accuracy = 75;
        container.getPlayer().roomNum = 1;
    }

    public void attack(String[] commands) {
        if (commands.length == 1) {
            System.out.println("Attack whom?");
            return;
        }
        Star currStar = container.getStars().get(container.getPlayer().roomNum);
        boolean soldierFound = false;
        DarkSoldier currSoldier = null;
        for (DarkSoldier soldier : currStar.getSoldiers()) {
            if (commands[1].equalsIgnoreCase(soldier.getId())) {
                soldierFound = true;
                currSoldier = soldier;
                while (soldier.getHp() > 0) {
                    int playerpoints =
                            util.generateRandom(container.getPlayer().getAccuracy());
                    container.getPlayer().hp += playerpoints;
                    soldier.setHp(soldier.getHp() - playerpoints);
                    int monsterpoints = util.generateRandom(soldier.getAccuracy());
                    container.getPlayer().hp -= monsterpoints;
                    soldier.setHp(soldier.getHp() + monsterpoints);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Your points:");
                    explore(new String[]{Constants.EXPLORE, "self"});
                    System.out.println("Soldier points:");
                    explore(new String[]{Constants.EXPLORE, commands[1]});
                    if (soldier.getHp() <= 0) {
                        System.out.println("You Defeated soldier");
                        /*GameContainer.player1.roomNum = Integer.parseInt(
                                currRoom.getExits().get(0).trim().split(" ")[1].trim());
                        explore(new String[]{"room"});*/
                        break;
                    }
                    System.out.println("Run Away?(Yes/No)");
                    String command = sc.nextLine();
                    if (command.length() > 0 && (command.contains("Yes") ||
                            command.contains("yes"))) {
                        /*GameContainer.player1.roomNum = Integer.parseInt(
                                currRoom.getExits().get(0).trim().split(" ")[1].trim());
                        explore(new String[]{"room"});*/
                        break;
                    }
                }
            }
        }
        boolean elem = false;
        if (!soldierFound) {
            System.out.println("No soldier found with that name: " + commands[1] +
                    " Exiting from nearest gate");
        } else {
            elem = currStar.getSoldiers().remove(currSoldier);
        }
        String exit = currStar.getExits().get(0);
        container.getPlayer().roomNum = Integer.parseInt(exit.split(" ")[1].trim());
        explore(new String[]{"room"});
    }

    public void save(String[] commands) {
        String text = NAME + container.getPlayer().getName() + "\n" +
                POINTS + container.getPlayer().getHp() + "\n" +
                ROOM + container.getPlayer().getRoomNum();
        try {
            util.writeGameState(PLAYER_STATE_TXT_FILE, text);
            setStateSaved(true);
        } catch (IOException e) {
            System.out.println("Failed to save game state");
            e.printStackTrace();
        }
    }


    public void move(String[] commands) {
        if (commands.length == 1) {
            System.out.println("Move where?");
            return;
        }
        Star currStar = container.getStars().get(container.getPlayer().roomNum);
        boolean exitPresent = false;
        for (String exit : currStar.exits) {
            if (commands[1].equalsIgnoreCase(exit.split(" ")[0])) {
                exitPresent = true;
                container.getPlayer().roomNum = Integer.parseInt(exit.split(" ")[1].trim());
                explore(new String[]{"room"});
            }
        }
        if (!exitPresent) {
            System.out.println("No exit found in that direction");
            explore(new String[]{"room"});
        }
    }

    public void acquireWeapon(String[] commands) {
        if (commands.length == 1) {
            System.out.println("Mention the weapon name");
            return;
        }
        Star currStar = container.getStars().get(container.getPlayer().roomNum);
        for (Weapon weapon : currStar.getWeapons()) {
            if (commands[1].equalsIgnoreCase(weapon.getId())) {
                container.getPlayer().weapons.add(weapon);
                currStar.weapons.remove(weapon);
                System.out.println("Acquired weapon: " + commands[1] + " in room: " + currStar.getRoomNum());
            }
        }
    }
/*
    public void createWeapon(String[] commands) {
        if (commands.length == 1) {
            System.out.println("Mention the weapon name");
            return;
        }
        Star currStar = container.getStars().get(container.getPlayer().roomNum);
        for (Object weapon : container.getWeaponColl()) {
            if (commands[1].equalsIgnoreCase(((Weapon) weapon).getId())) {
                try {
                    currStar.weapons.add((Weapon) Class.forName(commands[1]).newInstance());
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("Created a weapon: " + commands[1] + " in room: " + currStar.getRoomNum());
            }
        }
    }
*/
    public void explore(String[] commands) {
        Star currStar = container.getStars().get(container.getPlayer().roomNum);
        if (commands.length >= 2) {
            boolean foundMatch = false;
            if (commands[1].equalsIgnoreCase("self")) {
                container.getPlayer().explore();
                foundMatch = true;
            } else {
                for (DarkSoldier soldier : currStar.soldiers) {
                    if (commands[1].equalsIgnoreCase(soldier.getId())) {
                        foundMatch = true;
                        soldier.explore();
                    }
                }
            }
            if (!foundMatch) {
                System.out.println("No match found");
            }
            return;
        }

        System.out.println("You are on a Star: " + currStar.roomNum + ", " + currStar.name + " . " +
                "Here are some details of it:");
        for (String feature : currStar.features) {
            System.out.println(feature);
        }
        System.out.println("Adjecent stars you can travel:");
        for (String exit : currStar.exits) {
            System.out.println(exit);
        }
        System.out.println("Soldiers you have to fight:");
        for (DarkSoldier soldier : currStar.soldiers) {
            System.out.println(soldier.getId() + "(" + soldier.getDesc() + ")");
        }
        System.out.println("Weapons you hold:");
        for (Weapon weapon : currStar.weapons) {
            System.out.println(weapon.getId() + " ; " + weapon.getDesc());
        }
    }
}
