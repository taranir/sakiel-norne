/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

import java.util.ArrayList;
import org.newdawn.slick.*;

/**
 *
 * @author Owner
 */
public class Character {

    public String name;
    public int type; //0 = pc, 2 = monster
    public ArrayList<Item> inv;
    public int atk, def, str, intel, agi, luk, health, currenthealth, level, exp;
    public Image sprite, portrait;
    public long charID;
    public double pc_x, pc_y;
    public boolean dead;
//Character constructor sets stats and name, sprite, portrait, etc. Type 0 is player character; type 2 is monster.

    public Character(String n, int t, Image i, Image p) {
        name = n;
        type = t;
        sprite = i;
        portrait = p;
        inv = new ArrayList<Item>();
        charID = System.currentTimeMillis();
        if (type == 0) {
            level = 1;
            str = 10;
            intel = 10;
            agi = 5;
            luk = 5;
            health = 200;
            currenthealth = health;
            atk = (level * 5) + str;
            def = (level * 5) + agi;
            exp = 0;
            inv.add(new Item("Small Health Potion"));
            inv.add(new Item("Small Health Potion"));
            inv.add(new Item("Small Health Potion"));
            inv.add(new Item("Small Mana Potion"));
            inv.add(new Item("Small Mana Potion"));
            inv.add(new Item("Small Mana Potion"));
        }
        if (type == 2) {
            level = Game.pc.level;
            str = 10;
            intel = 10;
            agi = 5;
            luk = 5;
            health = 50;
            currenthealth = health;
            atk = (level * 5) + str;
            def = (level * 5) + agi;
        }
    }

    public static void levelup(Character c) {
        c.level++;
        c.exp = 0;

        c.str += 1;
        c.intel += 1;
        c.luk += 1;
        c.health += 10;
        c.currenthealth = c.health;
        c.agi += 1;
        c.atk = (c.level * 5) + c.str;
        c.def = (c.level * 5) + c.agi;

    }
}
