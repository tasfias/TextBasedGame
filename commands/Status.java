package commands;

import gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 *
 * <p>
 * The status command can display a list of items in the player's inventory,
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {

    private String topic;
    /**
    Creates a new Status command for the specified topic.
    Parameters:
    topic - the topic to retrieve the status for, such as "inventory", "player", or an item name
    */
    public Status(String topic){
        this.topic = topic;
        this.commandType = CommandType.STATUS;
    }

    /**
    Returns a string representation of the status command, including its type and topic.
    Overrides:
    toString in class Object
    Returns:
    a string describing the status command
    */
    public String toString(){
        return "Status " + topic;
    }

    /**
    Executes the status command. Retrieves and displays information based on the specified topic.
    If the topic is "inventory", it lists all items in the player's inventory.
    If the topic matches an item name, it displays the item's description.
    If the topic is "player", it displays the player's general status.
    Specified by:
    execute in class Command
    Parameters:
    gameState - the current state of the game
    Returns:
    a string describing the requested status information
    */
    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        Map map = gameState.getMap();
        if(topic.equalsIgnoreCase("inventory")){
            StringBuilder inventory = new StringBuilder();
            for(Item item : player.getInventory()){
                inventory.append(item.getName()).append(" ");
            }
            for(Equipment equipment : player.getEquipment()){
                inventory.append(equipment.getName()).append(" ");
            }
            return inventory.toString();
        }

        for(Item item : player.getInventory()){
            if(item.getName().equalsIgnoreCase(topic)){
                return item.getDescription();
            }
        }

        for(Equipment equipment : player.getEquipment()){
            if(equipment.getName().equalsIgnoreCase(topic)){
                return equipment.getDescription();
            }
        }

        if(topic.equalsIgnoreCase("player")){
            return player.getStatus();
        }
        
        if(topic.equalsIgnoreCase("map")){
            return map.display();
        }

        if(topic.equalsIgnoreCase("score")){
            StringBuilder score = new StringBuilder();
            score.append(player.getScore());
            return score.toString();
        }
        
        return "";
    }
}
