package edu.frostburg.cosc310.Tripp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class to handle the file input for the Duck, Duck, Goose game
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class PlayersIO {
    
    private BufferedReader in;
    private String fPath;
    private CircuList<Child> playersList;
    
    /**
     * Public constructor for the class
     * @param fPath the file path for the game text file
     * @throws FileNotFoundException in cases where the file cannot be opened or found
     */
    public PlayersIO(String fPath) throws FileNotFoundException{
        this.fPath = fPath;
        in = new BufferedReader(new FileReader(fPath));
        playersList = new CircuList<>();
    }
    
    /**
     * Method to convert the lines of text in the input file to player objects
     * @return the list of players
     * @throws IOException in cases where the file may not be read
     */
    public CircuList<Child> getPlayers() throws IOException{
        while(in.ready()){
            String[] pInfo = in.readLine().split(" ");
            playersList.addLast(new Child(pInfo[0], Integer.parseInt(pInfo[1]), pInfo[2]));
        }
        in.close();
        return playersList;
    }
}
