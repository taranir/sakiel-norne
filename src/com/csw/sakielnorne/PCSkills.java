/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

/**
 *
 * @author Taranir
 */
public class PCSkills {
/*
     * In PCSkill, every attack is within a method. Each method performs a different attack. Each attack is 
     * clickable on the battle manu. Each of the attack deals a different amount of damage, and will have 
     * varying amounts of MP to cast.(may or may not be added depending on time factors and the fact that I
     * have SATs to study for. The attacks so far are: Basic Attack, Fireball, Water Bolt, Shockwave, Poison, 
     * Defend, Use Item, and Do Nothing. Each attack has an additional modifier that depends on the attack but
     * is usually inteligence. All and all these attacks are a lot like D&D attacks because I'm extremely unoriginal.
     * Each attack has a hit/miss counter and then it displays enemy health after each attack and how much damage 
     * was dealt per attack. Item usage has not been implemented yet so Use Item currently does nothing, may change
     * towards the future.
     * 
     * Written By: David Chen on 12/19/2011
     */
    public static void BasicAttack(Character m, Character c) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.agi / 5) + (int) (Math.random() * 20) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("You rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! :Db");
        } else {
            System.out.println("Miss! D:");
        }

        while (hit > miss) {
            dmg = ((int) c.str / 5) + (int) (Math.random() * 4) + 1;
            miss = miss + 1;
        }

        System.out.println("You dealt " + dmg + " total damage");
        endHealth = BattleState.currentMonsterchar.currenthealth - dmg;
        BattleState.currentMonsterchar.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
    }

    public static void Fireball(Character c, Character m) { //c = PC, m = monster
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.intel / 5) + (int) (Math.random() * 20) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("You rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! :Db");
        } else {
            System.out.println("Miss! D:");
        }

        while (hit > miss) {
            dmg = ((int) c.intel / 5) + (int) (Math.random() * 12) + 1;
            miss = miss + 1;
            
        }

        System.out.println("You dealt " + dmg + " total damage");
        endHealth = BattleState.currentMonsterchar.currenthealth - dmg;
        BattleState.currentMonsterchar.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
    }

    public static void WaterBolt(Character c, Character m) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.intel / 5) + (int) (Math.random() * 20) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("You rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! :Db");
        } else {
            System.out.println("Miss! D:");
        }

        while (hit > miss) {
            dmg = ((int) c.intel / 5) + (int) (Math.random() * 8) + 1;
            miss = miss + 1;
            
        }

        System.out.println("You dealt " + dmg + " total damage");
        endHealth = BattleState.currentMonsterchar.currenthealth - dmg;
        BattleState.currentMonsterchar.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
    }

    public static void Shockwave(Character c, Character m) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.intel / 5) + (int) (Math.random() * 20) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("You rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! :Db");
        } else {
            System.out.println("Miss! D:");
        }

        while (hit > miss) {
            dmg = ((int) c.intel / 5) + (int) (Math.random() * 10) + 1;
            miss = miss + 1;
            
        }

        System.out.println("You dealt " + dmg + " total damage");
        endHealth = BattleState.currentMonsterchar.currenthealth - dmg;
        BattleState.currentMonsterchar.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
    }

    public static void Poison(Character c, Character m) {
        int roll = 0;
        int hit = 0, miss = 0, dmg = 0;
        int endHealth = 0;

        roll = ((int) c.intel / 5) + (int) (Math.random() * 20) + 1;
        if (roll > c.def) {
            hit = hit + 1;
        } else {
            miss = miss + 1;
        }
        System.out.println("You rolled a " + roll + ".");

        if (hit > miss) {
            System.out.println("Hit! :Db");
        } else {
            System.out.println("Miss! D:");
        }

        while (hit > miss) {
            dmg = ((int) c.intel / 5) + (int) (Math.random() * 6) + 1;
            miss = miss + 1;
            
        }

        System.out.println("You dealt " + dmg + " total damage");
        endHealth = BattleState.currentMonsterchar.currenthealth - dmg;
        BattleState.currentMonsterchar.currenthealth = endHealth;
        System.out.println("Enemy health = " + endHealth);
    }

    public static void Defend(Character c, Character m) {
        Game.pc.currenthealth= Game.pc.currenthealth +5;
    }

    public static String UseItem(Character c, Character m) {
        String name = "nothing";
        if (!Game.pc.inv.isEmpty()) {
            int itemnum = (int)(Math.random()*Game.pc.inv.size());
            Game.pc.inv.get(itemnum).use();
            System.out.println("You used a " + Game.pc.inv.get(itemnum).type);
            name = Game.pc.inv.get(itemnum).type;
            Game.pc.inv.remove(itemnum);
        }
        else {
            System.out.println("Your inventory is empty.");
        }
        return name;
    }

    public static void DoNothing(Character c, Character m) {
        System.out.println("Do Nothing");
    }
}
