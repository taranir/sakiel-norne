/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

import org.newdawn.slick.*;
import org.newdawn.slick.Input.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/**
 * Activated by pressing S while in the explore map, StatisticState shows the character stats.
 * @author Taranir
 */
public class StatisticState extends BasicGameState {

    int stateID;
    Image bg;
    public String invlist = " ";

    public StatisticState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    //Updates list of items in inventory
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        if (!Game.pc.inv.isEmpty()) {
            invlist = "";
            for (Item i : Game.pc.inv) {
            invlist = invlist.concat("\n" + i.type);
        }
        }
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    //Loads background image
    //Written by Tian
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        bg = new Image("graphics/statistic.png");
    }

  //Go back to main menu if you press back
  //Written by Tian
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_BACK)) {
            GameData.fromstate = Game.STATISTIC;
            GameData.tostate = Game.EXPLORE;
            g.enterState(Game.EXPLORE);
        }
    }

// Draws text/stats onto the screen.
 // Written by Tian
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        bg.draw(0,0);
        Game.orator_large.drawString(162, 83, Integer.toString(Game.pc.str));
        Game.orator_large.drawString(215, 120, Integer.toString(Game.pc.intel));
        Game.orator_large.drawString(148, 157, Integer.toString(Game.pc.agi));
        Game.orator_large.drawString(109, 195, Integer.toString(Game.pc.luk));
        Game.orator_large.drawString(186, 232, Integer.toString(Game.pc.health));
        Game.orator_large.drawString(238, 269, Integer.toString(Game.pc.currenthealth));
        Game.orator_large.drawString(137, 307, Integer.toString(Game.pc.atk));
        Game.orator_large.drawString(151, 345, Integer.toString(Game.pc.def));
        Game.orator_large.drawString(485, 83, Integer.toString(Game.pc.level));
        Game.orator_large.drawString(460, 117, Integer.toString(Game.pc.exp));
        Game.orator.drawString(406, 176, invlist);

    }
}
