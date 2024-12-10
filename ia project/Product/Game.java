import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static String inventory[] = new String[20];
    public static boolean hackerdevice = false;
    public static boolean poweropen = false;
    public static boolean shield = false;
    public static boolean safeopen = false;
    public static int ending = 0;
    public static boolean alienalive = true;

    public static void main(String[] args) {
        beginning();
    }

    public static void beginning() {
        String inventory[] = new String[20];
        boolean hackerdevice = false;
        boolean poweropen = false;
        Scanner in = new Scanner(System.in);
        int hp = 100;
        String response = null;

        System.out.println(
                "Welcome to the game, to play just enter commands that will move your charater, ex. moveforward, moveright, moveleft, movebackward. You can also type 'observe' to get descriptions of the rooms that you enter and 'inventory' to look at your inventory (tip, type observe when you enter a new area to see what each action does)");
        System.out.println();
        System.out.println(
                "You wake up from your cryogenic sleep in the ship when you realize the power of the ship is not functional and the ship is running on emergency power. Everyone around you seems to be still in their slumber. It seems the backup power on your pod ran out first. Get the power back on before the other pods run out of power.");

        while (response != "moveright") {

            response = in.next();

            if (response.equals("observe")) {
                System.out.println(
                        "This is the cryogenic room, there are 9 other cryogenic pods with people in them, there appears to be an escape pod to the left and a door to a hallway to the right.");

            } else if (response.equals("moveforward") || response.equals("movebackward")) {
                System.out.println("There is nowhere to go");

            } else if (response.equals("moveleft")) {
                System.out.println("There is an escape pod here, it appears to be inactive due to the power outage");

            } else if (response.equals("moveright")) {
                System.out.println(
                        "There is a door, you open the door and enter a long hallway which leads to a 4 way intersection");

                fourwayfromcryo(response, in);

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void cryo(String response, Scanner in) {

        while (response != null) {
            response = in.next();

            if (response.equals("observe")) {
                System.out.println(
                        "The cryogenic room, there are 5 cryo units to the right and 5 to the left, there is an escape pod in front of you and your cryo pod to your left.");

            } else if (response.equals("moveright")) {
                System.out.println("There is nowhere to go");

            } else if (response.equals("movebackward")) {
                System.out.println("You enter the Hallway");
                fourwayfromcryo(response, in);

            } else if (response.equals("moveforward")) {
                if (ending == 0) {
                    System.out
                            .println("There is an escape pod here, it appears to be inactive due to the power outage");
                } else if (ending == 1) {
                    System.out.println(
                            "You enter the escape pod and blast out of the ship, you wonder why you did this as there is no reason that you needed to escape. You now cant reach your destination.");
                    System.exit(ending);

                } else if (ending == 2) {
                    System.out.println(
                            "You enter the escape pod and blast out of the ship, the ship explodes shortly after your escape. You now are alone in the vastness of space.");
                    System.exit(ending);
                }

            } else if (response.equals("moveleft")) {
                if (ending == 0) {
                    System.out.println("Your cryo pod. There is nothing you can do here");
                } else if (ending == 1) {
                    System.out.println(
                            "You enter your pod and go back to cryo sleep, hopefully you can get to your destination without any more problems");
                    System.exit(ending);
                }

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void fourwayfromcryo(String response, Scanner in) {

        while (response != null) {
            response = in.next();

            if (response.equals("observe")) {
                System.out.println(
                        "A 4 way intersection, the sign says that staff quarters is on the right, administrators office is on the left, power room is forward, and cryo is backward");

            } else if (response.equals("moveleft")) {
                System.out.println(
                        "The admin office door is locked, it needs some sort of password. (type enterpassword to type the password or quit to quit)");

                while (response != "quit") {
                    response = in.next();
                    if (response.equals("enterpassword")) {
                        System.out.println("Enter password below");
                        response = in.next();
                        if (response.equals("crumble")) {
                            System.out.println("the door opens and you enter admin");
                            admin(response, in);
                        } else if (response.equals("quit")) {
                            System.out.println("you have quit and returned to the intersection");
                        } else {
                            System.out.println("Incorrect password, try again, or press quit to quit");
                        }
                    } else if (response.equals("quit")) {
                        System.out.println("You have quit and returned to the intersection");
                        fourwayfromcryo(response, in);
                    } else {
                        System.out.println("invalid command");
                    }
                }

            } else if (response.equals("movebackward")) {
                System.out.println("You enter the Cryo room");
                cryo(response, in);

            } else if (response.equals("moveright")) {
                System.out.println("You enter the staff quarters");
                staff(response, in);

            } else if (response.equals("moveforward")) {
                if (poweropen == false) {
                    if (hackerdevice == false) {
                        System.out.println(
                                "The power room door is sealed, the lock is sophisticated and you cant open it.");
                    } else {
                        System.out.println("You place the hacker device over the lock");
                        hackerdeviceminigame(response, in);
                    }
                } else {
                    System.out.println("You enter the power room");
                    power(response, in);
                }

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void fourwayfromstaff(String response, Scanner in) {

        while (response != null) {
            response = in.next();

            if (response.equals("observe")) {
                System.out.println(
                        "A 4 way intersection, the sign says that power room is to the right, cryo room is to the left, administrators office is forward, and staff quarters is backward");

            } else if (response.equals("moveleft")) {
                System.out.println("You enter the cryo room");
                cryo(response, in);

            } else if (response.equals("movebackward")) {
                System.out.println("You enter the staff quarters");
                staff(response, in);

            } else if (response.equals("moveright")) {
                if (poweropen == false) {
                    if (hackerdevice == false) {
                        System.out.println(
                                "The power room door is sealed, the lock is sophisticated and you cant open it.");
                    } else {
                        System.out.println("You place the hacker device over the lock");
                        hackerdeviceminigame(response, in);
                    }
                } else {
                    System.out.println("You enter the power room");
                    power(response, in);
                }

            } else if (response.equals("moveforward")) {
                System.out.println(
                        "The admin office door is locked, it needs some sort of password. (type enterpassword to type the password or quit to quit)");

                while (response != "quit") {
                    response = in.next();
                    if (response.equals("enterpassword")) {
                        System.out.println("Enter password below");
                        response = in.next();
                        if (response.equals("crumble")) {
                            System.out.println("the door opens and you enter admin");
                            admin(response, in);
                        } else if (response.equals("quit")) {
                            System.out.println("you have quit and returned to the intersection");
                        } else {
                            System.out.println("Incorrect password, try again, or press quit to quit");
                        }
                    } else if (response.equals("quit")) {
                        System.out.println("You have quit and returned to the intersection");
                        fourwayfromstaff(response, in);
                    } else {
                        System.out.println("invalid command");
                    }
                }

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void fourwayfromadmin(String response, Scanner in) {

        while (response != null) {
            response = in.next();

            if (response.equals("observe")) {
                System.out.println(
                        "A 4 way intersection, the sign says that cryo room is to the right, power room is to the left, staff quarters is forwards, and administrator office is backward.");

            } else if (response.equals("moveleft")) {
                if (poweropen == false) {
                    if (hackerdevice == false) {
                        System.out.println("The power room door is sealed, the lock is sophisticated and you cant open it.");
                    } else {
                        System.out.println("You place the hacker device over the lock");
                        hackerdeviceminigame(response, in);
                    }
                } else {
                    System.out.println("You enter the power room");
                    power(response, in);
                }

            } else if (response.equals("movebackward")) {
                System.out.println(
                        "The admin office door is locked, it needs some sort of password. (type enterpassword to type the password or quit to quit)");

                while (response != "quit") {
                    response = in.next();
                    if (response.equals("enterpassword")) {
                        System.out.println("Enter password below");
                        response = in.next();
                        if (response.equals("crumble")) {
                            System.out.println("the door opens and you enter admin");
                            admin(response, in);
                        } else if (response.equals("quit")) {
                            System.out.println("you have quit and returned to the intersection");
                        } else {
                            System.out.println("Incorrect password, try again, or press quit to quit");
                        }
                    } else if (response.equals("quit")) {
                        System.out.println("You have quit and returned to the intersection");
                        fourwayfromadmin(response, in);
                    } else {
                        System.out.println("invalid command");
                    }
                }

            } else if (response.equals("moveright")) {
                System.out.println("You enter the Cryo room");
                cryo(response, in);

            } else if (response.equals("moveforward")) {
                System.out.println("You enter the staff quarters");
                staff(response, in);

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    } 
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void fourwayfrompower(String response, Scanner in) {

        while (response != null) {
            response = in.next();

            if (response.equals("observe")) {
                System.out.println(
                        "A 4 way intersection, the sign says that administrators office is to the right, staff quarters is to the left, cryo room is forward, and power room is backward.");

            } else if (response.equals("moveleft")) {
                System.out.println("You enter staff quarters");
                staff(response, in);

            } else if (response.equals("movebackward")) {
                System.out.println("You enter power room");
                power(response, in);

            } else if (response.equals("moveright")) {
                System.out.println(
                        "The admin office door is locked, it needs some sort of password. (type enterpassword to type the password or quit to quit)");

                while (response != null) {
                    response = in.next();
                    if (response.equals("enterpassword")) {
                        System.out.println("Enter password below");
                        response = in.next();
                        if (response.equals("crumble")) {
                            System.out.println("the door opens and you enter admin");
                            admin(response, in);
                        } else if (response.equals("quit")) {
                            System.out.println("you have quit and returned to the intersection");
                        } else {
                            System.out.println("Incorrect password, try again, or press quit to quit");
                        }
                    } else if (response.equals("quit")) {
                        System.out.println("You have quit and returned to the intersection");
                        fourwayfrompower(response, in);
                    } else {
                        System.out.println("invalid command");
                    }
                }

            } else if (response.equals("moveforward")) {
                System.out.println("You enter the cryo room");

                cryo(response, in);

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void staff(String response, Scanner in) {
        boolean keycard = false;
        boolean laser = false;
        boolean password = false;

        while (response != null) {
            response = in.next();

            if (response.equals("observe")) {
                System.out.print("staff quarters, there are a bunch of papers scattered about.");
                if (keycard == false) {
                    System.out.print(" A keycard is in front.");
                }

                if (laser == false) {
                    System.out.print(" A gun is to the right.");
                }

                if (password == false) {
                    System.out.print(" A note with some writing scribbled on it is to the left.");
                }

                System.out.println();

            } else if (response.equals("moveleft")) {
                if (password == false) {
                    password = true;
                    System.out.println("You pick up the note. It says, 'admin password: crumble'");
                    for (int i = 0; i < 20; i++) {
                        if (inventory[i] != null) {
                        } else {
                            inventory[i] = "admin password: crumble";
                            i = 20;
                        }
                    }
                } else
                    System.out.println("there is nothing here");

            } else if (response.equals("movebackward")) {
                System.out.println("You enter the 4 way intersection");
                fourwayfromstaff(response, in);

            } else if (response.equals("moveright")) {
                if (laser == false) {
                    laser = true;
                    System.out.println("You pick up the gun, a standard laser pistol, this might come in handy");
                    for (int i = 0; i < 20; i++) {
                        if (inventory[i] != null) {
                        } else {
                            inventory[i] = "Standard laser pistol";
                            i = 20;
                        }
                    }
                } else
                    System.out.println("there is nothing here");

            } else if (response.equals("moveforward")) {
                if (keycard == false) {
                    keycard = true;
                    System.out.println("You pick up the keycard, it is a vibrant yellow.");
                    for (int i = 0; i < 20; i++) {
                        if (inventory[i] != null) {
                        } else {
                            inventory[i] = "yellow keycard";
                            i = 20;
                        }
                    }
                } else
                    System.out.println("there is nothing here");

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void admin(String response, Scanner in) {
        boolean hascard = false;

        while (response != null) {
            response = in.next();

            if (response.equals("observe")) {
                System.out.print(
                        "The administration room, it is cleaner than the rest of the station, there is a desk with a safe underneath in front");
                if (shield == false) {
                    System.out.print(", and a shield to the right");
                }
                System.out.println();

            } else if (response.equals("moveleft")) {
                System.out.println("There is nothing here");

            } else if (response.equals("movebackward")) {
                System.out.println("You enter the 4 way intersection");

                fourwayfromadmin(response, in);

            } else if (response.equals("moveforward")) {
                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        if (inventory[i].equals("yellow keycard")) {
                            hascard = true;
                        }
                    } else
                        i = 20;
                }

                if (safeopen == false) {
                    if (hascard == false) {
                        System.out.println("The safe is locked, it needs some kind of keycard to open.");
                    } else {
                        System.out.println(
                                "You take out the yellow keycard and use it on the safe lock, the safe opens to reveal a lock hacker device. You take the device.");
                        hackerdevice = true;
                        safeopen = true;

                        for (int k = 0; k < 20; k++) {
                            if (inventory[k] != null) {
                            } else {
                                inventory[k] = "lock hacker device";
                                k = 20;
                            }
                        }
                    }
                } else {
                    System.out.println("The safe has already been opened");
                }
            } else if (response.equals("moveright")) {
                if (shield == false) {
                    System.out.println("You take the shield");
                    for (int i = 0; i < 20; i++) {
                        if (inventory[i] != null) {
                        } else {
                            inventory[i] = "shield";
                            i = 20;
                        }
                    }
                    shield = true;
                } else {
                    System.out.println("There is nothing here");
                }

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else
                System.out.println("invalid command");

        }
    }

    public static void hackerdeviceminigame(String response, Scanner in) {
        int counter = 1;
        int guess;
        Random myrand = new Random();
        int number;

        number = myrand.nextInt(10000);

        System.out.println(
                "The lock hacker device has narrowed the code needed to open the lock down to a number between 0 and 10000. Enter a number to narrow down the code.");

        guess = in.nextInt();

        while (guess != number) {
            counter++;
            if (guess > number) {
                System.out.println("Too High");
            } else {
                if (guess < number) {
                    System.out.println("Too Low");
                }
            }
            guess = in.nextInt();
        }
        System.out.println("You have opened the door and entered the power room.");
        power(response, in);
    }

    public static void power(String response, Scanner in) {
        int hp = 100;
        int alienhp = 100;
        boolean haveshield = false;
        boolean havegun = false;
        Random myrand = new Random();
        int damage;
        boolean stun = false;
        int blockdamage;

        if (alienalive = true) {
            System.out.println("A tall, green alien figure appears in front of you, and attacks you.");
            System.out.println("What is your move?");

            for (int i = 0; i < 20; i++) {
                if (inventory[i] != null) {
                    if (inventory[i].equals("shield")) {
                        haveshield = true;
                    } else if (inventory[i].equals("Standard laser pistol")) {
                        havegun = true;
                    }
                }
            }
            while (response != null) {
                System.out.println("");

                if (havegun == true) {
                    System.out.println("laser");
                }
                if (haveshield == true) {
                    System.out.println("block");
                }
                System.out.println("punch");
                System.out.println("");
                System.out.println("Your health: " + hp);
                System.out.println("Alien health: " + alienhp);
                System.out.println("What is your move?");

                response = in.next();

                if (response.equals("laser") && havegun == true) {
                    damage = myrand.nextInt(20);
                    alienhp = alienhp - damage;
                    System.out.println("You hit alien for " + damage + " damage");

                    if (stun == false) {
                        damage = myrand.nextInt(20);
                        hp = hp - damage;
                        System.out.println("Alien hit you for " + damage + " damage");
                    } else {
                        stun = false;
                    }

                } else if (response.equals("block") && haveshield == true) {
                    damage = myrand.nextInt(20);
                    if (damage < 11) {
                        System.out.println(
                                "You blocked its attack and bashed it with the shield. The alien has been stunned for 1 turn.");
                        stun = true;
                    } else {
                        blockdamage = damage - 10;
                        hp = hp - blockdamage;
                        System.out.println("You partially blocked its attack and took " + blockdamage
                                + " damage. You bashed the alien with the shield. The alien has been stunned for 1 turn.");
                        stun = true;
                    }
                } else if (response.equals("punch")) {
                    damage = myrand.nextInt(10);
                    alienhp = alienhp - damage;
                    System.out.println("You hit alien for " + damage + " damage");

                    if (stun == false) {
                        damage = myrand.nextInt(20);
                        hp = hp - damage;
                        System.out.println("Alien hit you for " + damage + " damage");
                    } else {
                        stun = false;
                    }

                } else {
                    System.out.println("invalid command");
                }

                if (hp <= 0) {
                    System.out.println("You died. GAME OVER");
                    System.exit(ending);
                    
                } else if (alienhp <= 0) {
                    System.out.println("You defeated the alien");
                    System.out.println("You can now explore the power room");
                    alienalive = false;
                    powerroom(response, in);
                }
            }
        } else {
            powerroom(response, in);
        }
    }

    private static void powerroom(String response, Scanner in) {
        while (response != null) {
            response = in.next();

            if (response.equals("moveforward")) {

                if (ending == 0) {
                    System.out.println(
                            "You approach the generator. It seems to be in rough shape, but nothing too serious. You open the generator to see 3 wires, a black wire to the left, and red and blue wires to the right. It appears that you have to connect the black wire with either the red or the blue wire. Which wires do you connect? (commands: blacktoblue, blacktored)");

                    while (response != null) {
                        response = in.next();

                        if (response.equals("blacktoblue")) {
                            System.out.println(
                                    "you connect the black wire with the blue wire.The power generator came back online and all power is functional, time for you to go back to your pod.");
                            ending = 1;
                            powerroom(response, in);

                        } else if (response.equals("blacktored")) {
                            System.out.println(
                                    "You connect the black wire with the red wire. The power generator starts emiting a loud beeping noise. The station's alarm is set off. 'GENERATOR MELDOWN IMMINENT' is repeated over the intercom. The generator will explode soon, you should get to the escape pod as fast as possible.");
                            ending = 2;
                            powerroom(response, in);
                        } else {
                            System.out.println("invalid command");
                        }
                    }
                } else if (ending == 1) {
                    System.out.println("You already fixed the generator");

                } else if (ending == 2) {
                    System.out.println("The generator is already in meltdown, there is nothing you can do");
                }

            } else if (response.equals("moveleft") || response.equals("moveright")) {
                System.out.println("There is nothing here");

            } else if (response.equals("movebackward")) {
                System.out.println("You enter the 4 way intersection");
                fourwayfrompower(response, in);

            } else if (response.equals("observe")) {
                System.out.println(
                        "This is the power room, it is a mess of cords and machinery, the power generator is ahead.");

            } else if (response.equals("inventory")) {

                for (int i = 0; i < 20; i++) {
                    if (inventory[i] != null) {
                        System.out.println(inventory[i]);
                    }
                }

            } else {
                System.out.println("invalid command");
            }
        }
    }
}