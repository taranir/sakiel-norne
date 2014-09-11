/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

import org.newdawn.slick.*;
import org.newdawn.slick.Input.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;

/**
 * The cutscenes are the screens that display right at the beginning of the game. Each new screen adds
 * on another block of text.
 * @author Tian
 */
public class CutsceneState extends BasicGameState {

    int stateID;
    Image one_1, one_2, one_3, one_4;
    Image currentImage;
    Music currentMusic, distance;

    public CutsceneState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    //Sets music and plays it
    //Written by Tian
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        GameData.time = 1.0;
        Game.currentMusic = Game.dialogue;
        Game.currentMusic.loop();
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    //Loads images and initializes game time.
    //Written by Tian
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        one_1 = new Image("graphics/cutscenes/1_1.png");
        one_2 = new Image("graphics/cutscenes/1_2.png");
        one_3 = new Image("graphics/cutscenes/1_3.png");
        one_4 = new Image("graphics/cutscenes/1_4.png");
        currentImage = one_1;

    }

/*
 * Sets current cutscene page depending on game time.
 * Written by Tian
 */
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            GameData.time += .25;
        }
        if (GameData.time == 1.0) {
            currentImage = one_1;
        }
        if (GameData.time == 1.25) {
            currentImage = one_2;
        }
        if (GameData.time == 1.50) {
            currentImage = one_3;
        }
        if (GameData.time == 1.75) {
            currentImage = one_4;
        }
        if (GameData.time == 2.00) {
            g.enterState(Game.EXPLORE, new FadeInTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        currentImage.draw(0, 0);
        
    }
}
