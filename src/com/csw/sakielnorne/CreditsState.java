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
public class CreditsState extends BasicGameState {

    int stateID;
    Image creditsBG;

    public CreditsState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
    }

    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        creditsBG = new Image("graphics/credits.png");
    }

    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_BACK)) {
            g.enterState(Game.MAINMENU);
        }
    }

    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        creditsBG.draw(0, 0);
    }
}
