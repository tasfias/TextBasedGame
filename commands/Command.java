package commands;

import gameobjects.*;

/**
 * Represents an abstract command that can be executed within the game.
 *
 * <p>
 * Subclasses should define specific types of commands and their behavior by
 * implementing the {@link #execute(GameState)} method.
 * </p>
 */
public abstract class Command {

    ///The type of the command (e.g., MOVE, GET, DROP).
    public CommandType commandType;
    ///An optional value associated with the command, such as a target item or direction.
    public String value;

    public Command(){
    }

    /**
    Executes the command using the provided game state.
    Parameters:
    gameState - the current state of the game
    Returns:
    a string describing the outcome of the command execution
    */
    public abstract String execute(GameState gameState);
}
