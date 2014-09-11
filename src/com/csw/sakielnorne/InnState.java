/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

import java.util.ArrayList;
import java.util.ListIterator;
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
public class InnState extends BasicGameState {

    int stateID;
    ArrayList<Character> npcs = new ArrayList<Character>();
    ArrayList<Integer> npcX = new ArrayList<Integer>();
    ArrayList<Integer> npcY = new ArrayList<Integer>();
    ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    Polygon pcPolygon = new Polygon();
    Polygon tempPoly = new Polygon();
    Polygon doorPolygon = new Polygon();
    TiledMap currentMap, innMap;
    public static int pc_x, pc_y, map_x, map_y;
    boolean collided;

//Checks if the player character polygon is overlapping or touching the specified npc polygon.
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
//Checks for collision with all the NPCs on the screen. If collision is true + player presses enter, enter DialogueState
//Written by Tian

    public void checkEncounter(GameContainer gc, StateBasedGame g) {
        for (int j = npcs.size() - 1; j >= 0; j--) {
            if (collision(j) && gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
                Game.currentNPC = npcs.get(j);
                System.out.println("Collision with " + Game.currentNPC.name);
                System.out.println("Time =  " + GameData.time);
                DialogueState.currentString = " ";
                GameData.fromstate = Game.INN;
                GameData.tostate = Game.DIALOGUE;
                g.enterState(Game.DIALOGUE);
            }
        }


    }

    public InnState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    /*
     * Fills array of npcs that need to be drawn on the map and
     * arrays of x/y positions for the npcs; also polygons for all npcs for collision detection.
     * Loads music and plays it.
     * Written by Tian
     */
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        GameData.fromstate2 = GameData.fromstate;

        Game.currentMusic = Game.inn;
        Game.currentMusic.loop();

        npcs.add(Game.aryeon);
        npcX.add(288);
        npcY.add(272);

        npcs.add(Game.halcos);
        npcX.add(304);
        npcY.add(240);

        npcs.add(Game.rowan);
        npcX.add(368);
        npcY.add(192);

        for (int k = 0; k < npcs.size(); k++) {
            tempPoly.setX(npcX.get(k));
            tempPoly.setY(npcY.get(k));
            polygons.add(tempPoly.copy());
        }

        if (GameData.fromstate == Game.EXPLORE || GameData.fromstate == Game.VILLAGE) {
            pc_x = 208;
            pc_y = 304;
        }

    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }


    //Loads map and sets player position. Initializes polygons for collision detection.
    //Written by Tian
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        innMap = new TiledMap("graphics/maps/maps/inn.tmx");

        currentMap = innMap;
        pc_x = 368;
        pc_y = 192;
//draws a polygon that overlaps the player character
        pcPolygon.addPoint(0, 0);
        pcPolygon.addPoint(18, 0);
        pcPolygon.addPoint(18, 30);
        pcPolygon.addPoint(0, 30);
//draws a polygon that will be used for the npcs
        tempPoly.addPoint(0, 0);
        tempPoly.addPoint(18, 0);
        tempPoly.addPoint(18, 18);
        tempPoly.addPoint(0, 18);

        //draws a polygon over the door
        doorPolygon.addPoint(0, 0);
        doorPolygon.addPoint(16, 0);
        doorPolygon.addPoint(16, 16);
        doorPolygon.addPoint(0, 16);

        doorPolygon.setX(208);
        doorPolygon.setY(300);

//lets user hold down arrow keys to move
        gc.getInput().enableKeyRepeat();
    }

    /*
     * If the PC collides with an NPC and presses enter, they begin dialogue.
     * If PC goes near door and presses enter, moves outside.
     * Also movement via arrow keys and
     * press S to go into the statistics viewing screen.
     * Written by Tian
     */
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {

        //press S key to go to statistics screen
        if (gc.getInput().isKeyPressed(Input.KEY_S)) {
            GameData.fromstate = Game.INN;
            GameData.tostate = Game.STATISTIC;
            g.enterState(Game.STATISTIC);
        }
        //if player is at door and presses enter, goes through the door
        if ((doorPolygon.intersects(pcPolygon) || doorPolygon.contains(pcPolygon)) && gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            GameData.fromstate = Game.INN;
            GameData.tostate = Game.VILLAGE;
            g.enterState(Game.VILLAGE);
        }

        if (gc.getInput().isKeyPressed(Input.KEY_LEFT) && pc_x > 220) {
            pc_x -= 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_RIGHT) && pc_x < 432) {
            pc_x += 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_UP) && pc_y > 176) {
            pc_y -= 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_DOWN) && pc_y < 272) {
            pc_y += 16;
        }
        

        pcPolygon.setX(pc_x);
        pcPolygon.setY(pc_y);

        checkEncounter(gc, g);


    }

    //Draws graphics onto the screen (map + pc sprite + npc sprites)
    //Written by Tian
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        currentMap.render(0, 0);
        Game.pc.sprite.draw(pc_x, pc_y);
        for (int k = 0; k < npcs.size(); k++) {
            npcs.get(k).sprite.draw(npcX.get(k), npcY.get(k));
        }


    }
}
