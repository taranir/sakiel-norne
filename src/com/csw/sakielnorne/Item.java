/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;
import java.lang.Object.*;
/**
 *
 * @author Owner
 */
public class Item {

    public String type;
    private long itemID;

    public Item (String t) {
        type = t;
        itemID = System.currentTimeMillis(); //doesn't actually do anything...
    }

    //Item effects
    //Written by Tian
    public void use() {
        if (type.equals("Small Health Potion") || type.equals("Small Mana Potion")) {
            Game.pc.currenthealth += 20;
        }

        if (type.equals("Medium Health Potion") || type.equals("Small Mana Potion")) {
            Game.pc.currenthealth += 30;
        }

        if (type.equals("Large Health Potion") || type.equals("Large Mana Potion")) {
            Game.pc.currenthealth += 50;
        }

        if (type.equals("Ramen")) {
            Game.pc.str += 2;
            Game.pc.intel += 2;
        }

        if (type.equals("Starfruit")) {
            Game.pc.luk += 3;
            Game.pc.intel += 1;
        }

        if (type.equals("Dragonfruit")) {
            Game.pc.agi += 1;
            Game.pc.intel += 2;
        }

        if (type.equals("Turkey Leg")) {
            Game.pc.str += 2;
            Game.pc.def += 2;
        }

        if (type.equals("Lamb Carcass")) {
            Game.pc.str -= 1;
            Game.pc.atk -= 1;
        }

        if (type.equals("Candied Bacon")) {
            Game.pc.atk += 2;
            Game.pc.agi += 1;
        }

        if (type.equals("Rotten Pineapple")) {
            Game.pc.currenthealth -= 5;
            Game.pc.str -= 1;
        }

        if (type.equals("Bubble Tea")) {
            Game.pc.def += 3;
        }

    }


}
