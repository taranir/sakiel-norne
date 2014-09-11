/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

import org.newdawn.slick.*;
import org.newdawn.slick.Input.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Taranir
 */
public class BattleState extends BasicGameState {

    int stateID;
    public static Character currentMonsterchar;
    public static Image battleBG, pcBattlePortrait, health_bar_pc, health_bar_monster, health_incr;
    public static MouseOverArea basicattack, fireball, waterbolt, shockwave, poison, defend, useitem, donothing;
    public static String currentString = " ";
    public static String currentAttack = " ";
    boolean turntaken = false;

    /* This function is supposed to render the health bar based on the amount of health
     * the player character/current monster has left. It doesn't really work.
     * Written by Tian
     */
    /*public void renderHealth(Character pc, Character monster) {
    double percent_pc = (pc.currenthealth / pc.health) * 100;
    double percent_monster = (monster.currenthealth / monster.health) * 100;

    int bar_pc_x = 30; //starting x position for health increments
    for (int k = 0; k <= percent_pc; k++) {
    health_incr.draw(bar_pc_x, 67);
    bar_pc_x += 2;
    }

    int bar_monster_x = 410; //starting x position for health increments
    for (int k = 0; k <= percent_monster; k++) {
    health_incr.draw(bar_monster_x, 67);
    bar_monster_x += 2;
    }
    }*/


    /*
     * Determines monster attack. Rolls random number and picks from the attacks in the MonsterSkills file.
     * Written by Tian
     */
    public void monsterTurn() {
        double attacknum = Math.random() * 7;
        if (attacknum < 1) {
            MonsterSkills.BitterTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries bitter tears that kind of sting you.";
        } else if (attacknum < 2) {
            MonsterSkills.SweetTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries sweet tears. You wish you could taste them.";
        } else if (attacknum < 3) {
            MonsterSkills.SourTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries tears so sour, you recoil a bit.";
        } else if (attacknum < 4) {
            MonsterSkills.SaltyTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries pretty normal tears. Nothing really happens.";
        } else if (attacknum < 5) {
            MonsterSkills.TangyTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries tangy tears. Tangy tears are tangy.";
        } else if (attacknum < 6) {
            MonsterSkills.BitterTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries bitter tears that kind of sting you.";
        } else if (attacknum < 7) {
            MonsterSkills.SpicyTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries spicy tears that burn you.";
        } else if (attacknum < 8) {
            MonsterSkills.UmamiTears(currentMonsterchar, Game.pc);
            currentString = Game.currentMonster.name + " cries umami tears. They're really good...";
        }


    }
//Picks a random item and adds to player inventory.
//Written by Tian
    public String itemGrant() {
        int t = (int) (Math.random() * 10);
        String name = "nothing";
        if (t == 0) {
            Game.pc.inv.add(new Item("Small Health Potion"));
            name = "Small Health Potion";
        }
        if (t == 1) {
            Game.pc.inv.add(new Item("Medium Health Potion"));
            name = "Medium Health Potion";
        }
        if (t == 2) {
            Game.pc.inv.add(new Item("Large Health Potion"));
            name = "Large Health Potion";
        }
        if (t == 3) {
            Game.pc.inv.add(new Item("Ramen"));
            name = "Ramen";
        }
        if (t == 4) {
            Game.pc.inv.add(new Item("Starfruit"));
            name = "Starfruit";
        }
        if (t == 5) {
            Game.pc.inv.add(new Item("Dragonfruit"));
            name = "Dragonfruit";
        }
        if (t == 6) {
            Game.pc.inv.add(new Item("Turkey Leg"));
            name = "Turkey Leg";
        }
        if (t == 7) {
            Game.pc.inv.add(new Item("Lamb Carcass"));
            name = "Lamb Carcass";
        }
        if (t == 8) {
            Game.pc.inv.add(new Item("Candied Bacon"));
            name = "Candied Bacon";
        }
        if (t == 9) {
            Game.pc.inv.add(new Item("Rotten Pineapple"));
            name = "Rotten Pineapple";
        }
        if (t == 10) {
            Game.pc.inv.add(new Item("Bubble Tea"));
            name = "Bubble Tea";
        }

        return name;
    }

    public BattleState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    /*
     * Brings over the current monster from the main Game file; sets and plays the music for this state.
     * Written by Tian
     */
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        currentMonsterchar = Game.currentMonster;
        Game.currentMusic = Game.battle;
        Game.currentMusic.loop();
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    /*
     * Loads images and initializes mouseoverareas.
     * Written by Tian
     */
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        battleBG = new Image("graphics/battle.png");
        health_bar_pc = new Image("graphics/health_bar.png");
        health_bar_monster = new Image("graphics/health_bar.png");
        health_incr = new Image("graphics/health_incr.jpg");
        pcBattlePortrait = new Image("graphics/portraits/pc.png");

        basicattack = new MouseOverArea(gc, battleBG, 247, 67, 146, 20);
        fireball = new MouseOverArea(gc, battleBG, 247, 95, 146, 20);
        waterbolt = new MouseOverArea(gc, battleBG, 247, 122, 146, 20);
        shockwave = new MouseOverArea(gc, battleBG, 247, 150, 146, 20);
        poison = new MouseOverArea(gc, battleBG, 247, 178, 146, 20);
        defend = new MouseOverArea(gc, battleBG, 247, 206, 146, 20);
        useitem = new MouseOverArea(gc, battleBG, 247, 234, 146, 20);
        donothing = new MouseOverArea(gc, battleBG, 247, 262, 146, 20);

    }

    /*
     * Waits for user response (via mouse click on menu/keyboard) to attack or move to the monster's turn
    (by clicking away from the attacks menu after your turn is over)
     * Checks for monster/player death
     * Written by Tian
     */
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        //pressing the back key when the monster is dead will go back to the map
        if (gc.getInput().isKeyPressed(Input.KEY_BACK)) {
            if (currentMonsterchar.dead) {
                g.enterState(Game.EXPLORE);
            }

        }
        //attacks
        if (!currentMonsterchar.dead) {
            if (basicattack.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                PCSkills.BasicAttack(Game.pc, currentMonsterchar);
                currentString = "You fill your fists with spirit and punch " + currentMonsterchar.name +  " \nacross the face.";
                turntaken = true;

            } else if (fireball.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                PCSkills.Fireball(Game.pc, currentMonsterchar);
                currentString = "A ball of fire develops in your hands and you quickly allow it to \ngrow in intensity before you launch the scorching mass \ntowards " + currentMonsterchar.name;
                turntaken = true;

            } else if (waterbolt.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                PCSkills.WaterBolt(Game.pc, currentMonsterchar);
                currentString = "You create a bolt of water, then send it plummeting \ntowards " + currentMonsterchar.name + ".";
                turntaken = true;

            } else if (shockwave.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                PCSkills.Shockwave(Game.pc, currentMonsterchar);
                currentString = "You shoot lightning out of your hands like a Sith Lord.";
                turntaken = true;

            } else if (poison.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                PCSkills.Poison(Game.pc, currentMonsterchar);
                currentString = "You form a cloud of poisonous gas around " + currentMonsterchar.name + ",\nwho breathes it in and begins panting and wheezing.";
                turntaken = true;

            } else if (defend.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                PCSkills.Defend(Game.pc, currentMonsterchar);
                currentString = "You prepare yourself for the upcoming onslaught.";
                turntaken = true;

            } else if (useitem.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                String tempname;
                tempname = PCSkills.UseItem(Game.pc, currentMonsterchar);
                currentString = "You use a " + tempname + ".";
                turntaken = true;

            } else if (donothing.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && !turntaken) {
                PCSkills.DoNothing(Game.pc, currentMonsterchar);
                currentString = "You do nothing.";
                turntaken = true;
            }
        }

        //Checks if monster or player are dead
        if (currentMonsterchar.currenthealth <= 0) {
            currentMonsterchar.dead = true;
        }
        if (Game.pc.currenthealth <= 0) {
            Game.pc.dead = true;
        }

        //reacts to left-click. If the monster isn't dead,
        //goes to monster turn; otherwise, goes to end-battle text display.
        if (turntaken && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (currentMonsterchar.dead) {
                Game.pc.exp += 20;
                String itemname = itemGrant();
                currentString = currentMonsterchar.name + " has been defeated!\nYou pick up a " + itemname + ". \nPress backspace to return to the map.";
                turntaken = false;
                //checks for levelup
                if (Game.pc.exp >= 100)
                {
                    Character.levelup(Game.pc);
                    currentString = currentString.concat("\n" + Game.pc.name + " has gained a level! \n" + Game.pc.name + " is now level " + Game.pc.level + ".");
                }
                
                } else {
                monsterTurn();
                turntaken = false;
            }

        }

    }

    /*
     * Draws graphics onto screen.
     * Written by Tian
     */
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        battleBG.draw(0, 0);
        pcBattlePortrait.draw(25, 99);
        currentMonsterchar.portrait.draw(405, 99);
        Game.orator.drawString(70, 330, currentString);
        // Game.orator.drawString(80, 400, "Press backspace to return to the map.\nYou can't really kill monsters yet. 8(");
        Game.orator.drawString(25, 65, Integer.toString(Game.pc.currenthealth));
        Game.orator.drawString(600, 65, Integer.toString(currentMonsterchar.currenthealth));
    }
}
