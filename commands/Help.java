package commands;

import gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 *
 * <p>
 * The help command displays information on how to play the game, including details about
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {

    private String topic;
    /**
    Creates a new Help command for the specified topic.
    Parameters:
    topic - the topic for which help is requested (optional, can be general help)
    */
    public Help(String topic){
        this.topic = topic;
        this.commandType = CommandType.HELP;
    }

    /**
    Returns a string representation of the help command, including its type and topic.
    Overrides:
    toString in class Object
    Returns:
    a string describing the help command
    */
    public String toString(){
        if (topic == null || topic.isEmpty()) {
        return "null";
        } else {
            return "HELP: " + topic;
        }
    }

    /**
    Executes the help command. Provides detailed help information based on the specified topic or general game help if no specific topic is provided.
    Specified by:
    execute in class Command
    Parameters:
    gameState - the current state of the game (not used for help commands)
    Returns:
    a string containing help information for the player
    */
    public String execute(GameState gameState){
        if(topic == null || topic.isEmpty()){
            return generalHelp();
        }
        return topicHelp(topic);
    }

    private String generalHelp(){
        return "Welcome to the game! \n" +
                "Commands: \n" +
                "- MOVE <exit name>: Move to a different location \n" +
                "- LOOK <room|exit|features>|<item name>|<equipment name>|<feature name>: Look around the current room, at an exit, at a feature, or, at a specific item, equipment or feature \n" +
                "- GET <item name|equipment name>: Pick up an item or equipment from the current room \n" +
                "- DROP <item name|equipment name>: Drop an item or equipment from your inventory \n" +
                "- USE <equipment name> on|with <feature|item>: Use an item in your inventory on its own, or on a feature or item \n" +
                "- STATUS <inventory|player|item name|equipment name|map|score>: Check your current status, or inventory; or get more information about a specific item or equipment in your inventory. Also able to display the map and your score \n" +
                "- HELP <topic>: Display this help information or get help on a specific topic \n" +
                "- COMBINE <item1> and <item2>: Combine two items into a new item or equipment \n" +
                "- QUIT: Exit the game \n" + 
                "\nYou need to collect these ingredients: eggs, syrup, liquor, sweets, sugar, buttercream";
    }

    private String topicHelp(String topic){
        switch(topic.toLowerCase()){
            case "move":
                return "MOVE Command: Use the 'move' command \n" +
                        "Move to a different location in a direction \n" +
                        "Can move north, south, east or west";
            case "look":
                return "Look around the current room, at an exit, at a feature, or, at a specific item, equipment or feature";
            case "get":
                return "Pick up an item or equipment from the current room";
            case "drop":
                return "Drop an item or equipment from your inventory";
            case "use":
                return "Use an item in your inventory on its own, or on a feature or item";
            case "status":
                return "Check your current status, or inventory; or get more information about a specific item or equipment in your inventory. Also able to display the map and your score";
            case "help":
                return "Display this help information or get help on a specific topic";
            case "combine":
                return "Combine two items into a new item or equipment";
            case "quit":
                return "Exit the game";
            case "ingredients":
                return "Ingredients list: eggs, syrup, liquor, sweets, sugar, buttercream";
        }
        return "No help available for the topic: " + topic;
    }
}
