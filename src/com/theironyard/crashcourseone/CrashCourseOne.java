package com.theironyard.crashcourseone;

import java.util.Scanner;

/**
 * Created by kdrudy on 8/5/16.
 */
public class CrashCourseOne {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scan.nextLine();

        System.out.println("Greetings, " + name + "!");

        System.out.println("What shall your weapon be?");
        String weapon = scan.nextLine();

        System.out.println(weapon + " is a fine choice!");

        Entity player = new Entity();
        Entity ogre = new Entity(50.0, 20.0);
//        ogre.health = 50.0;

        System.out.println("You see an ogre, what shall you do?");
        boolean fighting = true;

        //Main game loop
        while(player.health > 0 && ogre.health > 0 && fighting) {

            //Give info and possible options
            System.out.println("Player Health: " + player.health + " -- Ogre Health: " + ogre.health);
            System.out.println("[1] Fight the ogre.");
            System.out.println("[2] Run from the ogre.");
            System.out.println("Choose option 1 or 2");


            //Perform option selected
            String option = scan.nextLine();
            if("1".equals(option)) {
                System.out.println("You attack the ogre and the ogre retaliates!");
                player.health = player.health - ogre.damage;
                ogre.health = ogre.health - player.damage;
            } else if("2".equals(option)) {
                int chance = (int) (Math.random()*2);
                if(chance == 0) {
                    System.out.println("You can't escape the ogre, he attacks while you run away!");
                    player.health = player.health - ogre.damage - ogre.damage;
                } else {
                    fighting = false;
                }
            } else {
                System.out.println("Unknown option " + option);
                continue;
            }
        }

        //Game ending states
        if(!fighting && player.health > 0 && ogre.health > 0) {
            System.out.println("You successfully ran away from the ogre, you both live long happy lives.");
        } else {
            if(player.health <= 0) {
                System.out.println("You were defeated by the ogre, he takes your " + weapon + " as a trophy.");
            } else if(ogre.health <=0) {
                System.out.println("You defeated the ogre! You are the hero of all the land!");
            }
        }
    }
}

class Entity {

    double health = 100.0;
    double damage = 10.0;

    public Entity() { }
    public Entity(double health, double damage) {
        this.health = health;
        this.damage = damage;
    }
}
