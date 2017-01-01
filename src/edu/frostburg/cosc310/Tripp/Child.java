package edu.frostburg.cosc310.Tripp;

import java.util.Random;

/**
 * This class represents a Child that will be playing the game Duck, Duck, Goose
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class Child {
    private String name;
    private int age;
    private String gender;
    private Random r;
        
    /**
     * Public constructor for the Child class
     * @param name the child's name
     * @param age the child's age
     * @param gender the child's gender
     */
    public Child(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    /**
     * Gets the name of the child
     * @return the name of the child
     */
    public String getName(){return name;}
    /**
     * Gets the age of the child
     * @return the age of the child
     */
    public int getAge(){return age;}
    /**
     * Gets the gender of the child
     * @return the gender of the child
     */
    public String getGender(){return gender;}
    /**
     * Gets the speed of the child, which varies depending on age.
     * There is overlap between each age group to allow for equal speeds
     * when older children do not run as fast as they possibly could and
     * match the speed of younger children.
     * @return 
     */
    public int getSpeed(){
        r = new Random(System.nanoTime());
        int n = r.nextInt(3);
        if(age >= 1 && age < 4)
            return n + 1;
        else if(age >= 4 && age < 7)
            return n + 2;
        else
            return n + 3;
    }
}
