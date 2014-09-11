/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.newdawn.slick.*;
import org.newdawn.slick.Input.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Taranir
 */
public class ExploreState extends BasicGameState {

    int stateID;
    ArrayList<Character> monsters = new ArrayList<Character>();
    ArrayList<Integer> monsterX = new ArrayList<Integer>();
    ArrayList<Integer> monsterY = new ArrayList<Integer>();
    ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    Character encountered = null;
    Polygon pcPolygon = new Polygon();
    Polygon tempPoly = new Polygon();
    TiledMap lucerne_fields, currentMap;
    public static int pc_x, pc_y, map_x, map_y, mcount;
    boolean collided;

    //Checks if Character b is touching Character a. No longer used.
    //Written by Tian
    /* public boolean collision(Image a, Image b, int ax, int ay, int bx, int by) {

    if ((bx >= ax && bx <= (ax + a.getWidth()) && by >= ay && by <= (ay + a.getHeight())) || ( ( (bx+b.getWidth()) ) >= ax && ( (bx+b.getWidth()) <= (ax + a.getWidth()) ) )) {
    return true;

    }
    return false;
    }*/


//Checks if the player character polygon is overlapping or touching the specified monster polygon.
//Written by Tian
    public boolean collision(int itr_index) {
        collided = false;
        if (polygons.get(itr_index).intersects(pcPolygon) || polygons.get(itr_index).contains(pcPolygon)) {
            collided = true;
            System.out.println("!!!");
            return true;
        }
        return false;
    }
//Checks for collision with al the monsters on the screen. If collision is true, take the collided monster
//off the screen and enter BattleState
//Written by Tian

    public void checkEncounter(StateBasedGame g) {
        for (int j = monsters.size() - 1; j >= 0; j--) {
            if (collision(j)) {
                Game.currentMonster = monsters.get(j);
                System.out.println("Collision with " + Game.currentMonster.name);
                GameData.time += .10;
                monsters.remove(j);
                polygons.remove(j);
                monsterX.remove(j);
                monsterY.remove(j);
                mcount--;
                System.out.println(mcount + " monsters left.");
                BattleState.currentString = " ";
                GameData.fromstate = Game.EXPLORE;
                GameData.tostate = Game.BATTLE;
                g.enterState(Game.BATTLE);
            }
        }


    }

    public ExploreState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }
    //Updates state history
    //Updates music and loops it
    //Loads things used in this state (see individual comments)
    //Written by Tian
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        GameData.fromstate2 = GameData.fromstate;

        //plays the music for this state
        Game.currentMusic = Game.lucerne;
        if (GameData.fromstate != Game.STATISTIC) {
            Game.currentMusic.loop();
        }

        //fills array of monsters that need to be drawn on the map and
        //arrays of random x/y positions for the monsters, dependent on game time.
        if (GameData.time == 2 && GameData.fromstate == Game.MAINMENU) {
            monsters.add(Game.flame1);
            monsters.add(Game.flame2);
            monsters.add(Game.angel1);
            monsters.add(Game.angel2);
            monsters.add(Game.angel3);
            monsters.add(Game.skull1);
            monsters.add(Game.skull2);
            monsters.add(Game.skull3);
            mcount = 8;

            //adds each monster at a random position on the map
            for (Character i : monsters) {
                monsterX.add((int) (Math.random() * 320) + 160);
                monsterY.add((int) (Math.random() * 318) + 112);
            }
            //adds a polygon to overlap every monster
            for (int k = 0; k < monsters.size(); k++) {
                tempPoly.setX(monsterX.get(k));
                tempPoly.setY(monsterY.get(k));
                polygons.add(tempPoly.copy());
            }
            //sets player character name
            Game.pc.name = JOptionPane.showInputDialog("What will be the name of the Main character?");
        }


    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    //Loads map and sets player position. Initializes polygons for collision detection.
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        lucerne_fields = new TiledMap("graphics/maps/maps/lucerne_fields.tmx");
        currentMap = lucerne_fields;
        pc_x = 319;
        pc_y = 114;

        //draws a polygon that overlaps the player character
        pcPolygon.addPoint(0, 0);
        pcPolygon.addPoint(18, 0);
        pcPolygon.addPoint(18, 30);
        pcPolygon.addPoint(0, 30);

        //draws a polygon that will be used for the monsters
        tempPoly.addPoint(0, 0);
        tempPoly.addPoint(18, 0);
        tempPoly.addPoint(18, 18);
        tempPoly.addPoint(0, 18);

        //lets user hold down arrow keys to move
        gc.getInput().enableKeyRepeat();
    }

    /*
     * If the PC collides with a NPC, they begin dialogue. Also movement via arrow keys and
     * press S to go into the statistics viewing screen.
     * Written by Tian
     */
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        //press S key to go to statistics screen
        if (gc.getInput().isKeyPressed(Input.KEY_S)) {
            GameData.fromstate = Game.EXPLORE;
            GameData.tostate = Game.STATISTIC;
            g.enterState(Game.STATISTIC);
        }
        if (gc.getInput().isKeyPressed(Input.KEY_B)) { //for testing (not normal gameplay)
            GameData.fromstate = Game.EXPLORE;
            GameData.tostate = Game.BLACKSMITH;
            g.enterState(Game.BLACKSMITH); 
        }
        if (gc.getInput().isKeyPressed(Input.KEY_I)) { //for testing (not normal gameplay)
            GameData.fromstate = Game.EXPLORE;
            GameData.tostate = Game.INN;
            g.enterState(Game.INN);
        }
        if (gc.getInput().isKeyPressed(Input.KEY_M)) { //for testing (not normal gameplay)
            GameData.fromstate = Game.EXPLORE;
            GameData.tostate = Game.MAGEHOME;
            g.enterState(Game.MAGEHOME);
        }
        //arrow key movements (step size added by David)
        if (gc.getInput().isKeyPressed(Input.KEY_LEFT) && pc_x > 0) {
            pc_x -= 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_RIGHT) && pc_x < 625) {
            pc_x += 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_UP) && pc_y > 0) {
            pc_y -= 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_DOWN) && pc_y < 465) {
            pc_y += 16;
        }
        //places polygon over the pc sprite's position
        pcPolygon.setX(pc_x);
        pcPolygon.setY(pc_y);

        //check for collision with a monster (whether you should enter battle)
        checkEncounter(g);

        //if the character is at the bottom of the screen, move to the village map
        if (pc_y >= 460) {
            VillageState.pc_y = 20;
            GameData.fromstate = Game.EXPLORE;
            GameData.tostate = Game.VILLAGE;
            g.enterState(Game.VILLAGE);
        }

    }

    //Draws graphics onto the screen (map + pc sprite + monster sprites)
    //Written by Tian
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        currentMap.render(0, 0);
        Game.pc.sprite.draw(pc_x, pc_y);
        for (int k = 0; k < monsters.size(); k++) {
            monsters.get(k).sprite.draw(monsterX.get(k), monsterY.get(k));
        }

        //draw polygons for debugging collision detection
        /*gr.setColor(Color.black);
        gr.draw(pcPolygon);
        for (int i = 0; i < polygons.size(); i++) {
        gr.draw(polygons.get(i));
        }*/


    }
}
