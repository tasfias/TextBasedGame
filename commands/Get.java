package commands;

import gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 *
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {
    private String item;

    /**
    Creates a new Get command for the specified item.
    Parameters:
    item - the name of the item to be picked up
    */
    public Get(String item){
        this.item = item;
        this.commandType = CommandType.GET;
    }

    /**
    Returns a string representation of the get command, including its type and the target item.
    Overrides:
    toString in class Object
    Returns:
    a string describing the get command
    */
    public String toString(){
        return "Move " + item;
    }

    /**
    Executes the get command. If the specified item is present in the current room and the player does not already have it, the item is added to the player's inventory. Otherwise, an appropriate message is returned.
    Specified by:
    execute in class Command
    Parameters:
    gameState - the current state of the game
    Returns:
    a string describing the outcome of the command
    */
    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        Map map = gameState.getMap();
        Room currentRoom = map.getCurrentRoom();
        if(currentRoom.hasItem(item)){
            Item itemToGet = currentRoom.getItemByName(item);
            if(player.hasItem(item)){
                return "You already have " + item;
            } else if(itemToGet != null){
                player.addItem(itemToGet);
                currentRoom.removeItem(itemToGet);
                return "You pick up: " + itemToGet.getName();
            }
        } else if(currentRoom.hasEquipment(item)){
            Equipment equipmentToGet = currentRoom.getEquipmentByName(item);
            if(player.hasEquipment(item)){
                return "You already have " + item;
            } else if(equipmentToGet != null){
                player.addEquipment(equipmentToGet);
                currentRoom.removeEquipment(equipmentToGet);
                return "You pick up: " + equipmentToGet.getName();
            }
        }
        return "No " + item + " to get.";
    }
}
