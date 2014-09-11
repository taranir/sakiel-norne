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
public class VillageState extends BasicGameState {

    int stateID;
    ArrayList<Character> npcs = new ArrayList<Character>();
    ArrayList<Integer> buildings = new ArrayList<Integer>();
    ArrayList<Integer> npcX = new ArrayList<Integer>();
    ArrayList<Integer> npcY = new ArrayList<Integer>();
    ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    ArrayList<Polygon> buildingpolygons = new ArrayList<Polygon>();
    Polygon pcPolygon = new Polygon();
    Polygon tempPoly = new Polygon();
    Polygon blacksmith = new Polygon();
    Polygon inn = new Polygon();
    Polygon magehome = new Polygon();
    TiledMap villageMap, currentMap, blacksmithMap, mageMap;
    public static int pc_x, pc_y, map_x, map_y;
    boolean collided;
    //boolean[][] blocked;

//Checks if the player character polygon is overlapping or touching the specified polygon.
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
    //checks if player is on/near a building
    //Written by Tian

    public boolean buildingcollision(int itr_index) {
        collided = false;
        if (buildingpolygons.get(itr_index).intersects(pcPolygon) || buildingpolygons.get(itr_index).contains(pcPolygon)) {
            collided = true;
            System.out.println("!!!");
            return true;
        }

        return false;
    }
//Checks for collision with all the NPCs on the screen. If collision is true, enter DialogueState
//Written by Tian
    public void checkEncounter(GameContainer gc, StateBasedGame g) {
        for (int j = 0; j < npcs.size(); j++) {
            if (collision(j) && gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
                Game.currentNPC = npcs.get(j);
                System.out.println("Collision with " + Game.currentNPC.name);
                System.out.println("Time =  " + GameData.time);
                DialogueState.currentString = " ";
                GameData.fromstate = Game.VILLAGE;
                GameData.tostate = Game.DIALOGUE;
                g.enterState(Game.DIALOGUE);
            }
        }


    }
    //Checks encounter with buildings. If next to a building + press enter, goes into that building (if it's able to be entered).
    //Written by Tian
    public void checkEncounterBuilding(GameContainer gc, StateBasedGame g) {
        for (int j = 0; j < buildings.size(); j++) {
            if (buildingcollision(j) && gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
                GameData.fromstate = Game.VILLAGE;
                GameData.tostate = buildings.get(j);
                g.enterState(buildings.get(j));
            }
        }


    }
//Stuff that doesn't work. :( It's supposed to check if a tile on the map
//is defined as "collision" in its properties... but the getTileProperty() function apparently doesn't work.
    /*
    public boolean checkBlocked(int x, int y) {
    int tile_x = (int) x/640;
    int tile_y = (int) y/480;
    return blocked[tile_x][tile_y];
    }*/

    public VillageState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    /*
     * Fills array of npcs that need to be drawn on the map and
     * arrays of x/y positions for the npcs.
     * Fills list of buildings and draws polygons for each building
     * Updates and plays music
     * Updates state change history
     * Written by Tian
     */
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        GameData.fromstate2 = GameData.fromstate;
        Game.currentMusic = Game.village;
        if (GameData.fromstate != Game.STATISTIC) {
            Game.currentMusic.loop();
        }

        npcs.add(Game.laryos);
        npcX.add(256);
        npcY.add(304);

        buildings.add(Game.BLACKSMITH);
        blacksmith.addPoint(95, 116);
        blacksmith.addPoint(113, 116);
        blacksmith.addPoint(113, 137);
        blacksmith.addPoint(95, 137);
        buildingpolygons.add(blacksmith);

        buildings.add(Game.INN);
        inn.addPoint(80, 180);
        inn.addPoint(108, 180);
        inn.addPoint(108, 202);
        inn.addPoint(80, 202);
        buildingpolygons.add(inn);

        buildings.add(Game.MAGEHOME);

        magehome.addPoint(352, 163);
        magehome.addPoint(381, 163);
        magehome.addPoint(381, 186);
        magehome.addPoint(352, 186);
        buildingpolygons.add(magehome);

        //fills arraylist of polygons overlapping each npc
        for (int k = 0; k < npcs.size(); k++) {
            tempPoly.setX(npcX.get(k));
            tempPoly.setY(npcY.get(k));
            polygons.add(tempPoly.copy());
        }
        //sets player position if coming from explorestate
        if (GameData.fromstate == Game.EXPLORE) {
            if (ExploreState.pc_x < 480) {
                pc_x = ExploreState.pc_x;
            }
            else {
                pc_x = 464;
            }
            pc_y = 16;
        }

    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }
    
    //Loads map and sets player position. Initializes polygons for collision detection.
    //Written by Tian
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        villageMap = new TiledMap("graphics/maps/maps/village.tmx");
        currentMap = new TiledMap("graphics/maps/maps/village.tmx");
        currentMap = villageMap;
        pc_x = 16;
        pc_y = 16;
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
//lets user hold down arrow keys to move
        gc.getInput().enableKeyRepeat();


        //checks for blocked tiles (as set in the editor for creating the TiledMaps) but
        //apparently getTileProperty() "will not perform well"?! So
        //it doesn't work...
/*
        blocked = new boolean[villageMap.getWidth()][villageMap.getHeight()];
        for (int xpos=0; xpos<villageMap.getWidth(); xpos++) {
        for (int ypos=0; ypos<villageMap.getHeight(); ypos++) {
        int tileID = villageMap.getTileId(xpos, ypos, 1);
        String collisionblocked = villageMap.getTileProperty(tileID, "collision", "false");
        if ("true".equals(collisionblocked)) {
        blocked[xpos][ypos] = true;
        }
        }
        }*/

    }

    /*
     * If the PC collides with a NPC and presses enter, they begin dialogue. Also movement via arrow keys and
     * press S to go into the statistics viewing screen.
     * Written by Tian
     */
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {

        //press S key to go to statistics screen
        if (gc.getInput().isKeyPressed(Input.KEY_S)) {
            g.enterState(Game.STATISTIC);
        }

        if (gc.getInput().isKeyPressed(Input.KEY_LEFT) && pc_x > 0 /*&& !checkBlocked(pc_x-16, pc_y)*/) {
            pc_x -= 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_RIGHT) && pc_x < 448/* && !checkBlocked(pc_x+16, pc_y)*/) {
            pc_x += 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_UP) && pc_y > 0/* && !checkBlocked(pc_x, pc_y-16)*/) {
            pc_y -= 16;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_DOWN) && pc_y < 460 /*&& !checkBlocked(pc_x, pc_y+16)*/) {
            pc_y += 16;
        }

        if (pc_y < 10) {
            GameData.time += 1;
            g.enterState(Game.EXPLORE);
            ExploreState.pc_y = 450;
        }

        pcPolygon.setX(pc_x);
        pcPolygon.setY(pc_y);

        checkEncounter(gc, g);
        checkEncounterBuilding(gc, g);


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
