package edu.frostburg.cosc310.Tripp;

import java.util.Random;

/**
 * This class handles the underlying rules and controls for the game Duck, Duck, Goose
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class Game {
    
    private Child It, Goose;
    private CircuList<Child> Players;
    private Random r;
    private int count;
    
    /**
     * Public constructor for the Game class
     * @param Players a circularly-linked list of Player objects that represent the children playing the game
     */
    public Game(CircuList<Child> Players){
        this.Players = Players;
        r = new Random();
    }
    
    /**
     * This method begins the game of Duck, Duck, Goose. Termination of the game is dependent upon the behavior of helper methods, and facilitated within this method.
     */
    public void play(){
        String gender;
        boolean quit = false, firstR = true;
        while(Players.size() >= 4 && quit == false){
            r = new Random();
            //Get the player to be "It"
            //If this is the first round, print the intro message
            if(firstR == true){
                getIt();
                printIntro();
                firstR = false;
            }
            //Selects the player to be "Goose", excluding the player who is already "It"
            do{
                Goose = getRandomPlayer();
            }while(It.equals(Goose));
            for(int i=0; i<count; i++){
                System.out.print(duck());
            }
            System.out.printf("Goose! %s chases " + It.getName() + "!\n", Goose.getName());
            //Print whichever player made it to the Goose player's spot first
            Child x = Goose;
            Child y = It;
            if(fasterPlayer().equals(x)){
                if(Goose.getGender().equals("M"))
                    gender = "his";
                else
                    gender = "her";
                System.out.printf(Goose.getName() + " makes it back to %s spot. " + It.getName() + " is it!\n", gender);
            } else {
                System.out.print(It.getName() + " makes it! " + Goose.getName() + " is it!\n");
            }
            
            //Players will leave the game at random
            if(r.nextInt(5) == 0){
                Child c = getRandomPlayer();
                if(c.getGender().equals("M"))
                    gender = "his";
                else
                    gender = "her";
                Players.removeFirst();
                System.out.printf("%s leaves to play Pokemon GO. %d players remain.\n", c.getName(), Players.size());
                
            }
            
            //Snack Time may be called which will end the game
            if(r.nextInt(50) == 5){
                System.out.print("Snack Time!\n");
                quit = true;
            }
        }
        System.out.println("Game Over");
    }
    
    /**
     * Gets an intro message for the game, including the number of players and the first player to be "It"
     * @return an intro message as a String that can be printed by the game
     */
    public String printIntro(){
        return String.format("%d children are playing Duck, Duck, Goose. %s is it!\n", Players.size(), It.getName());
    }
    
    /**
     * Selects a random Child from the list of players and rotates that player to the first position in the list.
     * @return the randomly selected Child
     */
    public Child getRandomPlayer(){
        count = 0;
        int p = r.nextInt(Players.size());
        for(int i=0; i<=p; i++){
            Players.rotate();
            count++;
        }
        return Players.first();
    }
    
    /**
     * Randomly selects a Child to assign as the "It" player
     */
    private void getIt(){It = getRandomPlayer();}
    
    /**
     * Determines whether the "It" or the "Goose" player is the fastest
     * @return the faster of the two children
     */
    private Child fasterPlayer(){
        Child c, x;
        if(It.getSpeed() >= Goose.getSpeed()){
            c = It;
            x = It;
            It = Goose;
            Goose = c;
            return x;
        }
        return Goose;
    }
    
    /**
     * Method to simplify the repeated printing of "Duck, " in the game text.
     * @return the string "Duck, "
     */
    private String duck(){return "Duck, ";}
}
