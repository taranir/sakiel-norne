/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

/**
 *
 * @author owner
 */
public class MonsterSkills {
/*
     * Since Tian talked about tears a lot, I am going to instead going to make tears of every flavor!
     * Sweet, Bitter, Sour, Salty, Tangy, Spicy, Umami! :D
     * Each attack has a different effect based on certain monster stats.
     * 
     * Written By: David Chen on 1/6/2012
     */
  public static void BitterTears(Character m, Character c) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.agi / 5) + (int) (Math.random() * 15) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("It rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! D:");
        } else {
            System.out.println("Miss! :Db");
        }

        while (hit > miss) {
            dmg = ((int) c.str / 5) + (int) (Math.random() * 6) + 1;
            miss = miss + 1;
        }

        System.out.println("It dealt " + dmg + " total damage");
        endHealth = Game.pc.currenthealth - dmg;
        Game.pc.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
        System.out.println("Those tears were really bitter.");
    }
  
  public static void SweetTears(Character m, Character c) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.agi / 5) + (int) (Math.random() * 15) + 1;
        if (roll > m.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("It rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! D:");
        } else {
            System.out.println("Miss! :Db");
        }

        while (hit > miss) {
            dmg = ((int) c.str / 5) + (int) (Math.random() * 8) + 1;
            miss = miss + 1;
        }

        System.out.println("It healed itself for " + dmg + " total health");
        endHealth = BattleState.currentMonsterchar.currenthealth + dmg;
        BattleState.currentMonsterchar.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
        System.out.println("You wish you could taste those sweet tears.");
    }
  
  public static void SourTears(Character m, Character c) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.agi / 5) + (int) (Math.random() * 8) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("It rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! D:");
        } else {
            System.out.println("Miss! :Db");
        }

        while (hit > miss) {
            dmg = ((int) c.str / 5) + (int) (Math.random() * 12) + 1;
            miss = miss + 1;
        }

        System.out.println("It dealt " + dmg + " total damage");
        endHealth = Game.pc.currenthealth - dmg;
        Game.pc.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
        System.out.println("Those tears were so sour, you even recoiled a bit.");
    }
  
  public static void SaltyTears(Character m, Character c) {
        System.out.println("Normal tears roll down its face, nothing happens.");
    }  
  
    public static void TangyTears(Character m, Character c) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.agi / 5) + (int) (Math.random() * 8) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("It rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! D:");
        } else {
            System.out.println("Miss! :Db");
        }

        while (hit > miss) {
            dmg = ((int) c.str / 5) + (int) (Math.random() * 12) + 1;
            miss = miss + 1;
        }

        System.out.println("It dealt " + dmg + " total damage");
        endHealth = Game.pc.currenthealth - dmg;
        Game.pc.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
        System.out.println("Tangy tears are tangy.");       
    }
   public static void SpicyTears(Character m, Character c) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.agi / 5) + (int) (Math.random() * 6) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("It rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! D:");
        } else {
            System.out.println("Miss! :Db");
        }

        while (hit > miss) {
            dmg = ((int) c.str / 5) + (int) (Math.random() * 20) + 1;
            miss = miss + 1;
        }

        System.out.println("It dealt " + dmg + " total damage");
        endHealth = Game.pc.currenthealth - dmg;
        Game.pc.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
        System.out.println("The spicy tears burn.");    
    }
   public static void UmamiTears(Character m, Character c) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.agi / 5) + (int) (Math.random() * 8) + 1;
        if (roll > m.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("It rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! D:");
        } else {
            System.out.println("Miss! :Db");
        }

        while (hit > miss) {
            dmg = ((int) c.str / 5) + (int) (Math.random() * 5) + 1;
            miss = miss + 1;
        }

        System.out.println("It healed you for " + dmg + " total health");
        endHealth = Game.pc.currenthealth + dmg;
        Game.pc.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
        System.out.println("Those umami tears were good.");
    }
}