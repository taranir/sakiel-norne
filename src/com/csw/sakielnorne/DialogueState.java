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
public class DialogueState extends BasicGameState {

    int stateID;
    public static Image dialogueBG, pcDialoguePortrait;
    public static String currentString;
    boolean turntaken = false;
    int dialoguestart;
    int dialoguepoint;
    int maxpoint;

    public void turn() {
    }

    public DialogueState(int s) {
        stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }


    //Updates state history
    //Updates music and loops it
    //Checks current NPC and initializes dialogue path accordingly
    //Written by Tian
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        GameData.fromstate2 = GameData.fromstate;
        Game.currentMusic = Game.dialogue;
        Game.currentMusic.loop();
        currentString = "Click the left mouse button to talk to " + Game.currentNPC.name + ".";

        if (Game.currentNPC.equals(Game.orien)) {
            dialoguestart = 10;
            maxpoint = 12;
        }
        if (Game.currentNPC.equals(Game.aryeon)) {
            dialoguestart = 20;
            maxpoint = 27;
        }
        if (Game.currentNPC.equals(Game.halcos)) {
            dialoguestart = 30;
            maxpoint = 36;
        }
        if (Game.currentNPC.equals(Game.laryos)) {
            dialoguestart = 40;
            maxpoint = 49;
        }
        if (Game.currentNPC.equals(Game.rowan)) {
            dialoguestart = 50;
            maxpoint = 58;
        }
        if (Game.currentNPC.equals(Game.sarin)) {
            dialoguestart = 60;
            maxpoint = 66;
        }

        dialoguepoint = dialoguestart;
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }
    //Loads images and sets dialogue at beginning
    //Written by Tian
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        dialogueBG = new Image("graphics/dialogue.png");
        pcDialoguePortrait = new Image("graphics/portraits/pcdialogue.png");
        dialoguestart = 0;

    }
    //Reacts to user input/moves dialogue forward
    //Written by Tian
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        //return to previous state if backspace is pressed
        if (gc.getInput().isKeyPressed(Input.KEY_BACK)) {
            g.enterState(GameData.fromstate2);
        }
        //moves dialogue forward, unless it's at the end of a path, in which case it skips to default "press back" text
        if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (dialoguepoint > maxpoint) {
                currentString = Dialogue.getText(0);
                
            } else {
                currentString = Dialogue.getText(dialoguepoint);
                dialoguepoint++;
            }
                }


    }
    //Renders graphics and text on screen
    //Written by Tian
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        dialogueBG.draw(0, 0);
        pcDialoguePortrait.draw(25, 14);
        Game.currentNPC.portrait.draw(315, 14);
        Game.orator.drawString(80, 350, currentString);
    }
}
