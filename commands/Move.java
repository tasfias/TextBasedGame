package commands;

import gameobjects.*;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 *
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {

    private String direction;
    /**
    Creates a new Move command for the specified direction.
    Parameters:
    direction - the direction in which the player wants to move
    */
    public Move(String direction){
        this.direction = direction;
        this.commandType = CommandType.MOVE;
    }

    /**
    Returns a string representation of the move command, including its type and direction.
    Overrides:
    toString in class Object
    Returns:
    a string describing the move command
    */
    public String toString(){
        return "Move " + direction;
    }

    /**
    Executes the move command. If the specified direction corresponds to an available exit in the current room, the player's location is updated to the connected room. Otherwise, no movement occurs.
    Specified by:
    execute in class Command
    Parameters:
    gameState - the current state of the game
    Returns:
    a string describing the result of the move command
    */
    public String execute(GameState gameState){
        Map map = gameState.getMap();
        Player player = gameState.getPlayer();
        Room currentRoom = map.getCurrentRoom();
        Exit exit = currentRoom.getExitByName(direction);

        if(exit != null){
            String nextRoomId = exit.getNextRoom();
            switch(direction.toLowerCase()){
                case "north":
                    if (currentRoom.getExitByName("north") != null && (!currentRoom.getExitByName("north").getHidden())) {
                        map.setCurrentRoom(nextRoomId);
                        player.decreaseScore();
                        return "Moving towards north\n";
                    }
                    break;
                case "south":
                    if (currentRoom.getExitByName("south") != null && (!currentRoom.getExitByName("south").getHidden())) {
                        map.setCurrentRoom(nextRoomId);
                        player.decreaseScore();
                        return "Moving towards south\n";
                    }
                    break;
                case "west":
                    if (currentRoom.getExitByName("west") != null && (!currentRoom.getExitByName("west").getHidden())) {
                        map.setCurrentRoom(nextRoomId);
                        player.decreaseScore();
                        return "Moving towards west\n";
                    }
                    break;
                case "east":
                    if (currentRoom.getExitByName("east") != null &&(!currentRoom.getExitByName("east").getHidden())) {
                        map.setCurrentRoom(nextRoomId);
                        player.decreaseScore();
                        return "Moving towards east\n";
                    }
                    break;
            }
        }
        return "No exit found in that direction.";
    }
}
