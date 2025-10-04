package commands;

import gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 *
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command {
    private String item;

    /**
    Creates a new Drop command for the specified item.
    Parameters:
    item - the name of the item to be dropped
    */
    public Drop(String item){
        this.item = item;
        this.commandType = CommandType.DROP;
    }

    /**
    Returns a string representation of the drop command, including its type and the target item.
    Overrides:
    toString in class Object
    Returns:
    a string describing the drop command
    */
    public String toString(){
        return "Drop " + item;
    }

    /**
    Executes the drop command. If the player possesses the specified item, it is removed from their inventory and added to the current room. Otherwise, an error message is returned.
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
        if(player.hasItem(item)){
            Item itemToDrop = player.getItemByName(item);
            player.removeFromInventory(itemToDrop);
            currentRoom.addItem(itemToDrop);
            return "You drop: " + itemToDrop.getName();
        } else if(player.hasEquipment(item)){
            Equipment equipmentToDrop = player.getEquipment(item);
            player.removeFromEquipment(equipmentToDrop);
            currentRoom.addEquipment(equipmentToDrop);
            return "You drop: " + equipmentToDrop.getName();
        }
        return "You cannot drop " + item;
    }
}
