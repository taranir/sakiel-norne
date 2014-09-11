/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csw.sakielnorne;

/**
 *
 * @author Taranir
 */
public class Dialogue {

    //public static int dialogue_orien, dialogue_aryeon, dialogue_halcos, dialogue_laryos, dialogue_rowan, dialogue_sarin;


    //returns dialogue line depending on NPC and point specified
    //written by Tian; dialogue written by David (and Zack Li for one of them)
    public static String getText(int t) {

        if (t == 0) {
            return "Press backspace to return to town.";
        }

        //Orien's dialogue path
        if (t == 10) {
            return "Orien: Hello. I'd sell you the greatest armor \nand weapons you've ever seen, but this game has no money system.";
        }
        if (t == 11) {
            return "That sword looks so cool.";
        }
        if (t == 12) {
            return "Orien: I'd teach you how to make it, but there're no \n professions in this game either.";
        }

        //Aryon's dialogue path
        if (t == 20) {
            return "Aryeon: Hi!";
        }
        if (t == 21) {
            return "Hello.";
        }
        if (t == 22) {
            return "Aryeon: Whatcha doin?";
        }
        if (t == 23) {
            return "Looking for someone.";
        }
        if (t == 24) {
            return "Aryeon: What does she look like?";
        }
        if (t == 25) {
            return "Wait... how'd you know I was looking for a girl?";
        }
        if (t == 26) {
            return "Aryeon: Hehehehehe secrets.";
        }
        if (t == 27) {
            return "Um... okay.";
        }

        //Halcos's dialogue path
        if (t == 30) {
            return "Halcos: Hello, you seem a bit lost. I'm Halcos, a town guard. \n May I help you?";
        }
        if (t == 31) {
            return "I was wondering, where am I?";
        }
        if (t == 32) {
            return "Halcos: You're in Bareon, one of the safest towns in Arem.";
        }
        if (t == 33) {
            return "Wouldn't the only town also be the safest town, no matter what?";
        }
        if (t == 34) {
            return "Halcos: No.";
        }
        if (t == 35) {
            return "Why?";
        }
        if (t == 36) {
            return "The goblins say they have a town. It's not really safe\n at all over there.";
        }

        //Laryos's dialogue path
        if (t == 40) {
            return "Laryos: Hello, you look new around here. May I assist you?";
        }
        if (t == 41) {
            return "Who are you?";
        }
        if (t == 42) {
            return "Laryos: Oh, excuse me. My name is Laryos. I used to be a \n town guard, but then I took an arrow to the knee. \nWho are you?";
        }
        if (t == 43) {
            return "I'm not sure.";
        }
        if (t == 44) {
            return "Laryos: Amnesia eh? That's a tough one. This might help.";
        }
        if (t == 45) {
            return "What might...";
        }
        if (t == 46) {
            return "Laryos takes the flat of his sword and smacks " + Game.pc.name + " \nbehind the head.";
        }
        if (t == 47) {
            return "WHAT WAS THAT FOR?!";
        }
        if (t == 48) {
            return "Laryos: To jog your memory. Remember anything?";
        }
        if (t == 49) {
            return "Nothing except the SHARP PAIN IN MY HEAD.";
        }

        //Rowan's dialogue path, courtesy of Zack Li
        if (t == 50) {
            return "Rowan: Hello. I'm Fire Inspector Rowan!";
        }
        if (t == 51) {
            return "Fire Inspector?";
        }
        if (t == 52) {
            return "Rowan: Recently, there have been several house fires in this town. \nI was hired to investigate. \n \n \nShe beams.";
        }
        if (t == 53) {
            return "That's terrible. Has anyone been hurt?";
        }
        if (t == 54) {
            return "Rowan: Yes! An old woman named Granny Willa died when an old shed \nwas set aflame. \n \n \nShe appears to be genuinely upset.";
        }
        if (t == 55) {
            return "Rowan: We suspect an arsonist. Unfortunately, the fire destroys \neverything, leaving almost no evidence.";
        }
        if (t == 56) {
            return "Any other findings?";
        }
        if (t == 57) {
            return "Rowan: Hmm, well she seems to set the fires with a jar of oil and \na lit pipe, acting as a timed device.";
        }
        if (t == 58) {
            return "\n \n \nShe sure seems to know a lot about this arsonist.";
        }

        //Sarin's dialogue path
        if (t == 60) {
            return "Sarin: Hello. Can I make you a sword?";
        }
        if (t == 61) {
            return "Can I see what they look like?";
        }
        if (t == 62) {
            return "Sarin points to the broken swords on the wall happily.";
        }
        if (t == 63) {
            return "Those were made by you?";
        }
        if (t == 64) {
            return "Yes! /eyes sparkle Aren't they beautiful? Orien says I could do \nbetter, so I want to practice!";
        }
        if (t == 65) {
            return "Err, I don't need a sword at the moment. But you could \nmake one for fun.";
        }
        if (t == 66) {
            return "Okay.";
        }
                

        else {
            return "derp";
        }
    }
}
