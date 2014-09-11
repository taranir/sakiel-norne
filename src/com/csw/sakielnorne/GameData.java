/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csw.sakielnorne;

/**
 *
 * @author Taranir
 */
public class GameData {

 public static double time; //controls some things that should only happen once/happens in order, such as cutscene movement.
 public static int fromstate; //tracks what state you're leaving when you change state
 public static int fromstate2; //tracks what state you came from previously
 public static int tostate; //tracks what state you're going into when you change state

    public static double getTime() {
        return time;
    }
    
}
