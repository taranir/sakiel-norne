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
 *
 * @author Taranir
 */
public class SettingsState extends BasicGameState {

    int stateID;
    Image settingsBG;

    public SettingsState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    //loads background image
    //written by Tian
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        settingsBG = new Image("graphics/settings.png");
    }

    //goes back to Main Menu if you press backspace
    //written by Tian
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_BACK)) {
            g.enterState(Game.MAINMENU);
        }
    }
    //draws background onto screen. What are settings?
    //written by Tian
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        settingsBG.draw(0, 0);
    }
}
