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
 * This screen displays when the player character dies.
 * Written by Tian
 * @author Taranir
 */
public class DeathState extends BasicGameState {

    int stateID;
    public static String currentString = "You're kind of dead. New game? (press enter)";


    public DeathState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        Game.currentMusic = Game.gameover;
        Game.currentMusic.play();
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    public void init(GameContainer gc, StateBasedGame g) throws SlickException {



    }
/*
 * Go back to main menu if you press back
 * Written by Tian
 */
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            g.enterState(Game.MAINMENU);
        }
    }
/*
 * Draws the text onto the screen.
 */
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        Game.orator.drawString(50, 50, currentString, Color.white);
    }
}
