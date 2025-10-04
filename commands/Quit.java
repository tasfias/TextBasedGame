package commands;

import gameobjects.*;

/**
 * Represents the quit command, allowing the player to exit the game.
 *
 * <p>
 * The quit command signals the end of the game session and provides a summary of the player's
 * current status before termination.
 * </p>
 */
public class Quit extends Command {

    ///Creates a new Quit command.
    public Quit(){
        this.commandType = CommandType.QUIT;
    }

    /**
    Executes the quit command. This implementation returns a game-over message along with the player's current status.
    Specified by:
    execute in class Command
    Parameters:
    gameState - the current state of the game
    Returns:
    a string containing the game-over message and the player's status
    */
    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        return "Game over: Your current status is: \n" + player.getStatus();
    }
}
