package com.csw.sakielnorne;

import org.newdawn.slick.*;
import java.lang.System.*;
import java.util.ArrayList;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Taranir
 */
public class Game extends StateBasedGame {

    //sets ID numbers for each state
    public static final int MAINMENU = 0;
    public static final int BATTLE = 1;
    public static final int EXPLORE = 2;
    public static final int DIALOGUE = 3;
    public static final int CUTSCENE = 4;
    public static final int VILLAGE = 5;
    public static final int BLACKSMITH = 6;
    public static final int MAGEHOME = 7;
    public static final int INN = 8;
    public static final int SETTINGS = -1;
    public static final int CREDITS = -2;
    public static final int DEATH = -3;
    public static final int STATISTIC = -4;


    Image pcSprite;
    static Character pc, flame1, flame2, angel1, angel2, angel3, skull1, skull2, skull3, laryos, rowan, halcos, sarin, aryeon, orien, currentMonster, currentNPC;
    ArrayList<Character> charas = new ArrayList<Character>();
    public static UnicodeFont orator, orator_large;
    public static Music menu, lucerne, battle, village, dialogue, mage, inn, blacksmith, gameover, currentMusic;

    //adds states to the game
    //written by Tian
    public Game(String title) throws SlickException {
        super(title);
        this.addState(new MainMenuState(MAINMENU));
        this.addState(new BattleState(BATTLE));
        this.addState(new ExploreState(EXPLORE));
        this.addState(new DialogueState(DIALOGUE));
        this.addState(new SettingsState(SETTINGS));
        this.addState(new CreditsState(CREDITS));
        this.addState(new CutsceneState(CUTSCENE));
        this.addState(new DialogueState(DIALOGUE));
        this.addState(new VillageState(VILLAGE));
        this.addState(new DeathState(DEATH));
        this.addState(new StatisticState(STATISTIC));
        this.addState(new BlacksmithState(BLACKSMITH));
        this.addState(new InnState(INN));
        this.addState(new MageHomeState(MAGEHOME));
        this.enterState(MAINMENU);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////
//creates a new instance of the game and starts it
//written by Tian
    public static void main(String[] args) throws SlickException {
        AppGameContainer gameinstance = new AppGameContainer(new Game("Project Sakiel-Norne"), 640, 480, false);
        gameinstance.setShowFPS(false);
        gameinstance.start();
    }

    //Initializes every game state and creates all characters (see individual comments).
    //Written by Tian
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(BATTLE).init(gc, this);
        this.getState(CREDITS).init(gc, this);
        this.getState(DIALOGUE).init(gc, this);
        this.getState(EXPLORE).init(gc, this);
        this.getState(MAINMENU).init(gc, this);
        this.getState(VILLAGE).init(gc, this);
        this.getState(DIALOGUE).init(gc, this);
        this.getState(SETTINGS).init(gc, this);
        this.getState(CUTSCENE).init(gc, this);
        this.getState(DEATH).init(gc, this);
        this.getState(STATISTIC).init(gc, this);
        this.getState(BLACKSMITH).init(gc, this);
        this.getState(INN).init(gc, this);
        this.getState(MAGEHOME).init(gc, this);

        //creates player character and monsters, loads images
        pc = new Character("Marceil", 0, new Image("/graphics/sprites/pcSprite.png"), new Image("/graphics/portraits/sarin.png"));
        flame1 = new Character("Horkos's Ardor", 2, new Image("/graphics/sprites/flame.png"), new Image("/graphics/portraits/flame.png"));
        flame2 = new Character("Horkos's Ardor", 2, new Image("/graphics/sprites/flame.png"), new Image("/graphics/portraits/flame.png"));
        angel1 = new Character("Phrike's Caprice", 2, new Image("/graphics/sprites/angel.png"), new Image("/graphics/portraits/angel.png"));
        angel2 = new Character("Phrike's Caprice", 2, new Image("/graphics/sprites/angel.png"), new Image("/graphics/portraits/angel.png"));
        angel3 = new Character("Phrike's Caprice", 2, new Image("/graphics/sprites/angel.png"), new Image("/graphics/portraits/angel.png"));
        skull1 = new Character("Namtar's Vestige", 2, new Image("graphics/sprites/skull.png"), new Image("/graphics/portraits/skull.png"));
        skull2 = new Character("Namtar's Vestige", 2, new Image("graphics/sprites/skull.png"), new Image("/graphics/portraits/skull.png"));
        skull3 = new Character("Namtar's Vestige", 2, new Image("graphics/sprites/skull.png"), new Image("/graphics/portraits/skull.png"));



        //creates NPC characters and loads images
        halcos = new Character("Halcos", 2, new Image("graphics/sprites/halcos.png"), new Image("/graphics/portraits/halcos.png"));
        laryos = new Character("Laryos", 2, new Image("graphics/sprites/laryos.png"), new Image("/graphics/portraits/laryos.png"));
        rowan = new Character("Rowan", 2, new Image("graphics/sprites/rowan.png"), new Image("/graphics/portraits/rowan.png"));
        aryeon = new Character("Aryeon", 2, new Image("graphics/sprites/aryeon.png"), new Image("/graphics/portraits/aryeon.png"));
        orien = new Character("Orien", 2, new Image("graphics/sprites/orien.png"), new Image("/graphics/portraits/orien.png"));
        sarin = new Character("Sarin", 2, new Image("graphics/sprites/sarin.png"), new Image("/graphics/portraits/sarin.png"));

        //creates music files and loads them
        menu = new Music("/music/Menutheme.ogg");
        lucerne = new Music("/music/SunshineGrassLoop.ogg");
        battle = new Music("/music/Zephyr.ogg");
        village = new Music("/music/Village Waltz.ogg");
        dialogue = new Music("/music/The Longest Distance between Two Points is Time.ogg");
        mage = new Music("music/Mage.ogg");
        inn = new Music("music/Inn.ogg");
        blacksmith = new Music("music/Blacksmith.ogg");
        gameover = new Music("music/Game Over.ogg");

        //creates temporary objects. These names/images should never be seen, because usually current__ is set to some other object first
        currentMonster = new Character("Error", 2, new Image("graphics/sprites/angel.png"), new Image("/graphics/portraits/skull.png"));
        currentNPC = new Character("INCEPTIONPC", 0, new Image("graphics/sprites/pcSprite.png"), new Image("/graphics/portraits/sarin.png"));
        currentMusic = menu;

        //creates and loads font for displaying text
        orator = new UnicodeFont("graphics/orator.ttf", 12, false, false);
        orator.addAsciiGlyphs();
        orator.addGlyphs(400, 600);
        orator.getEffects().add(new ColorEffect(java.awt.Color.BLACK));
        orator.loadGlyphs();

        //creates and loads larger version of the same font
        orator_large = new UnicodeFont("graphics/orator.ttf", 25, false, false);
        orator_large.addAsciiGlyphs();
        orator_large.addGlyphs(400, 600);
        orator_large.getEffects().add(new ColorEffect(java.awt.Color.BLACK));
        orator_large.loadGlyphs();

    }
}
