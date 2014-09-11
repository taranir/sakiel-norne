package com.csw.sakielnorne;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.*;
import org.newdawn.slick.Input.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Taranir
 */
public class MainMenuState extends BasicGameState {
    int stateID;

    private Image mainmenuBG, newgameover, newgamenormal, loadgameover, loadgamenormal, settingsover, settingsnormal, creditsover, creditsnormal;
    private MouseOverArea newgame, loadgame, settings, credits;
    public String name = "NONAME";


    public MainMenuState(int s) {
        this.stateID = s;
    }

    public int getID() {
        return stateID;
        //Main Menu: 0, Battle: 1, Explore: 2, Settings = -1, Credits = -2;
    }

    //Update/play music and initialize player character health + game time
    @Override
    public void enter(GameContainer gc, StateBasedGame g) throws SlickException {
        Game.currentMusic = Game.menu;
        Game.currentMusic.loop();
        Game.pc.currenthealth = Game.pc.health;
        GameData.time = 0;
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame g) throws SlickException {
    }

    //Load graphics and mouseoverareas
    //Written by Tian
    public void init(GameContainer gc, StateBasedGame g) throws SlickException {
        mainmenuBG = new Image("graphics/mainmenu.png");
        newgameover = new Image("graphics/newgamehover.png");
        newgamenormal = new Image("graphics/newgamenormal.png");
        newgame = new MouseOverArea(gc, mainmenuBG, 85, 120, 250, 55);
        loadgame = new MouseOverArea(gc, mainmenuBG, 85, 188, 250, 55);
        settings = new MouseOverArea(gc, mainmenuBG, 85, 256, 250, 55);
        credits = new MouseOverArea(gc, mainmenuBG, 85, 324, 250, 55);


    }
    //Menu clicking things
    //Written by Tian
    public void update(GameContainer gc, StateBasedGame g, int delta) throws SlickException {
        

        if (newgame.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            System.out.println("New Game");
            GameData.fromstate = Game.MAINMENU;
            GameData.tostate = Game.CUTSCENE;
            g.enterState(Game.CUTSCENE);
        } else if (loadgame.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            System.out.println("Load Game");
        } else if (settings.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            System.out.println("Settings");
            GameData.fromstate = Game.MAINMENU;
            GameData.tostate = Game.SETTINGS;
            g.enterState(Game.SETTINGS);
        } else if (credits.isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            System.out.println("Credits");
            GameData.fromstate = Game.MAINMENU;
            GameData.tostate = Game.CREDITS;
            g.enterState(Game.CREDITS);
        }

    }
    //Draws background
    //Written by Tian
    public void render(GameContainer gc, StateBasedGame g, Graphics gr) throws SlickException {
        mainmenuBG.draw(0, 0);


    }
}
