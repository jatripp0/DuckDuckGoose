package edu.frostburg.cosc310.Tripp;

import java.io.IOException;

/**
 * This is the driver class for the Duck, Duck, Goose game. Here the input file is accepted and the game is executed.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class DuckDuckGoose {

    private static final String fPath = "../children.txt";
    
    /**
     * The main method for the driver class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            PlayersIO p = new PlayersIO(fPath);
            Game g = new Game(p.getPlayers());
            g.play();
        } catch(IOException e){
            System.out.print("Something went wrong. Please check the input file in the project folder.\nSee README.txt for detailed instructions");
        }
    }
    
}
