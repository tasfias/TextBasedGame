package commands;

import gameobjects.*;

import java.util.ArrayList;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 *
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Use extends Command {

    private String equipmentName;
    private String target;
    /**
    Creates a new Use command for the specified equipment and target.
    Parameters:
    equipmentName - the name of the equipment to use
    target - the name of the target on which the equipment will be used
    */
    public Use(String equipmentName, String target){
        this.equipmentName = equipmentName;
        this.target = target;
        this.commandType = CommandType.USE;
    }

    /**
    Returns a string representation of the use command, including its type, equipment, and target.
    Overrides:
    toString in class Object
    Returns:
    a string describing the use command
    */
    public String toString(){
        return "Use " + equipmentName + " on " + target;
    }

    /**
    Executes the use command. Checks if the player has the specified equipment and whether the equipment can interact with the target. If valid, the equipment is used on the target.
    Specified by:
    execute in class Command
    Parameters:
    gameState - the current state of the game
    Returns:
    a string describing the result of the command execution
    */
    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        Map map = gameState.getMap();
        Room room = map.getCurrentRoom();
        Feature container = room.getFeatureByName(target);

        if(player.hasEquipment(equipmentName)) {
            Equipment equipment = player.getEquipment(equipmentName);
            UseInformation info = equipment.getUseInformation();
            if(container == null){
                return "Invalid use target";
            } else if (!info.isUsed()) {
                if (info.getTarget().equals(container.getId())) {
                    if(room.hasItemId(info.getResult())){
                        Item item = room.getItemById(info.getResult());
                        if(item.getHidden()){
                            item.setHidden(false);
                        }
                    }else if(room.hasEquipmentId(info.getResult())){
                        Equipment hiddenEquip = room.getEquipById(info.getResult());
                        if(hiddenEquip.getHidden()){
                            hiddenEquip.setHidden(false);
                        }
                    }
                    player.increaseScore();
                    info.setUsed(true);
                    return info.getMessage();
                } else {
                    return "Invalid use target";
                }
            } else {
                return "You have already used " + equipmentName;
            }
        }
        return "You do not have " + equipmentName;
    }
}
