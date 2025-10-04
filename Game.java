import java.util.Scanner;

import commands.*;
import gameobjects.*;
import parser.*;
import utils.*;

/**
 * Main class for the game application. Handles game setup, input parsing, and game execution.
 *
 * <p>
 * This class initializes the game state, reads user input, processes commands, and maintains the game loop.
 * </p>
 */
public class Game {

    //initialise the gameState, parser and tokeniser + scanner
    public static GameState gameState;
    public static Scanner inputDevice;
    public static Parser parser;
    public static Tokeniser tokeniser;

    public Game(){
    }

    /**
    The main entry point for the game. Sets up the game and starts it.
    Parameters:
    args - command-line arguments (not used in this implementation)
    */
    public static void main(String[] args) throws CommandErrorException {
        System.out.println("Loading game...");
        try{
            setup(); //set up game
        } catch (Exception e) {
            System.out.println("Load unsuccessful"); //make player aware if the gameState didn't parse correctly
        }
        //start game if load successful
        start();
    }

    ///Sets up the game by initializing the game state, scanner, parser, and tokeniser. Loads the game data from a file and prepares the initial state.
    public static void setup(){
        //instantiate gameState, parser and tokeniser objects + scanner
        gameState = new GameState();
        inputDevice = new Scanner(System.in);
        parser = new Parser();
        tokeniser = new Tokeniser();

        //get the file from directory and parse it
        String fileName = "mygame.txt";
        gameState = GameStateFileParser.parse(fileName);

        System.out.println("Game loaded successfully."); //make player aware that gameState has been parsed correctly
        System.out.println();
        //set scene for player
        System.out.println("You are a spy; codename: Moonlight.");
        System.out.println("You have been tasked to get closer to your enemy in a particular way...");
        System.out.println("By making their favourite dessert.");
        System.out.println("However, time is ticking, and the night has dawned.");
        System.out.println("You may have to find the ingredients in not-so-legal ways...");
        System.out.println("Currently, you are at the mall, after lights out. You have entered through the first shop in the mall, and many closed shops surround you.");
        System.out.println("Luckily for you, some of them are still open, and you can get them very legally.");
        System.out.println("It is up to you to find all of the ingredients.");
        System.out.println();
        System.out.println("In the first shop, there are shops to your east and south.");
        System.out.println();
        //show status of the first and current room
        Look look = new Look("room");
        System.out.println(look.execute(gameState));
    }

    //Starts the game loop. Continuously reads input, tokenises it, and processes commands until the user decides to quit.
    public static void start() throws CommandErrorException {
        boolean quitGame = false; //sets to false for while loop

        //while loop to loop player inputs until player chooses to quit the game
        while(!quitGame){
            System.out.println();
            System.out.print(">> ");
            String input = inputDevice.nextLine(); //take player input
            tokeniser.tokenise(input); //tokenise input
            Command command = parser.parse(tokeniser.getTokens()); //parse tokens and assign to the correct command

            if(command.commandType == CommandType.USE || command.commandType == CommandType.COMBINE){ //checks if the command type token is use or combine
                //sets the command value to the values in the tokens array
                command.value = tokeniser.getTokens().get(1).getValue() + " " + tokeniser.getTokens().get(2).getValue() + " " + tokeniser.getTokens().get(3).getValue();
                turn(command); //executes the command
            }else if(command != null){ //otherwise if the command is any other command
                command.value = tokeniser.getTokens().get(1).getValue(); //sets the command value to the token at index 1 of the tokens array
                turn(command); //executes the command
            }else{
                System.out.println("Invalid command."); //make player aware that the command they inputted was invalid
            }

            if(input.equalsIgnoreCase("quit")){ //checks if player inputs quit
                quitGame = true; //set quitGame to true and exit while loop
            }
        }
    }

    /**
    Processes a single game turn based on the provided command.
    Parameters:
    command - the command to execute during the turn
    */
    public static void turn(Command command){
        //checks which command type has been inputted
        switch (command.commandType){
            case DROP:
                Drop drop = new Drop(command.value); //create new drop object to drop the command value which is the item to drop
                System.out.println(drop.execute(gameState)); //print out what is returned from the execute method in the drop class
                break;
            case GET:
                Get get = new Get(command.value);
                System.out.println(get.execute(gameState));
                break;
            case HELP:
                Help help = new Help(command.value);
                System.out.println(help.execute(gameState));
                break;
            case LOOK:
                Look look = new Look(command.value);
                System.out.println(look.execute(gameState));
                break;
            case MOVE:
                Move move = new Move(command.value);
                System.out.println(move.execute(gameState));
                break;
            case QUIT:
                Quit quit = new Quit(); //create new quit object
                System.out.println(quit.execute(gameState)); //print out what is returned from the execute method in the quit class
                break;
            case STATUS:
                Status status = new Status(command.value);
                System.out.println(status.execute(gameState));
                break;
            case USE:
                String[] partsUse = command.value.split("\\s+"); //split the command value by the spaces
                //check if valid use command
                if(partsUse.length == 3){
                    String equipmentName = partsUse[0]; //set equipment name as first part of command value
                    String target = partsUse[2]; //set target as part of command value at index 2
                    Use use = new Use(equipmentName, target); //create new use object with the equipmentName and target
                    System.out.println(use.execute(gameState)); //print out what is returned from the execute method in the use class
                } else{
                    System.out.println("Invalid use command");
                }
                break;
            case COMBINE:
                String[] partsCombine = command.value.split("\\s+");
                if(partsCombine.length == 3){
                    String item1 = partsCombine[0];
                    String item2 = partsCombine[2];
                    Combine combine = new Combine(item1, item2);
                    System.out.println(combine.execute(gameState));
                } else{
                    System.out.println("Invalid combine command");
                }
                break;
            default:
                System.out.println("Invalid command"); //else make player aware they have inputted an invalid command
                break;
        }
    }
}
