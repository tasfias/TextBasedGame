package commands;

import gameobjects.*;
import java.util.ArrayList;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 *
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {

    private String target;
    /**
    Creates a new Look command for the specified target.
    Parameters:
    target - the object or category to examine, such as "room", "exits", "features", or the name of a specific item
    */
    public Look(String target){
        this.target = target;
        this.commandType = CommandType.LOOK;
    }

    /**
    Returns a string representation of the look command, including its type and target.
    Overrides:
    toString in class Object
    Returns:
    a string describing the look command
    */
    public String toString(){
        return "Look " + target;
    }

    /**
    Executes the look command. Provides descriptions based on the specified target:
    If the target is "room", it displays the room's description and all visible objects.
    If the target is "exits", it lists the visible exits in the room.
    If the target is "features", it lists additional visible features in the room.
    If the target matches an item, feature or equipment name, it displays the description of that object.
    Hidden objects are not included unless they are explicitly revealed in the game state.
    Specified by:
    execute in class Command
    Parameters:
    gameState - the current state of the game
    Returns:
    a string describing the requested details about the room, exits, features, or specific object
    */
    public String execute(GameState gameState){
        Map map = gameState.getMap();
        Room currentRoom = map.getCurrentRoom();
        return lookTarget(target, currentRoom);
    }

    public String lookTarget(String target, Room room){
        switch(target){
            case "room":
                return room.getDescription() + "\nYou see:\n" + getDescriptions(room.getFeatures()) + getDescriptions(room.getEquipments()) + getDescriptions(room.getItems()) + getDescriptions(room.getExits());
            case "exits":
                return "The available exits are:\n" + getDescriptions(room.getExits());
            case "features":
                return "You also see:\n" + getDescriptions(room.getFeatures());
            case "key":
                return "A rusty old key.";
            case "poster":
                return "A poster with a peculiar acrostic poem - 'Dreaming Of Novel Unity Today'. You can safely assume that 'DONUT' is a code of some sort.";
        }
        return "";
    }

    public <T extends GameObject> String getDescriptions(ArrayList<T> objects){
        if(objects.isEmpty()){
            return "";
        }

        StringBuilder descriptions = new StringBuilder();
        for(GameObject object : objects){
            if(object instanceof Item && (((Item) object).getHidden() == true)){
                continue;
            }
            if(object instanceof Feature && (((Feature) object).getHidden() == true)){
                continue;
            }
            if(object instanceof Equipment && (((Equipment) object).getHidden() == true)){
                continue;
            }
            descriptions.append(object.getDescription()).append("\n");
        }
        return descriptions.toString();
    }
}
