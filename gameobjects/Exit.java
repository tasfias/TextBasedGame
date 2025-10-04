package gameobjects;

/**
 * Represents an exit in the game, allowing the player to move from one room to another.
 *
 * <p>
 * Exits have a destination (next room), a description, and can be hidden or visible based on game logic.
 * </p>
 */
public class Exit extends GameObject {

    private String nextRoom;

    /**
    Creates a new Exit object with the specified attributes.
    Parameters:
    id - the unique identifier for the exit
    name - the name of the exit
    description - a description of the exit
    nextRoom - the ID of the room this exit leads to
    hidden - whether the exit is initially hidden
    */
    public Exit(String id, String name, String description, String nextRoom, boolean hidden){
        this.id = id;
        this.name = name;
        this.description = description;
        this.nextRoom = nextRoom;
        this.hidden = hidden;
    }

    /**
    Retrieves the identifier of the next room connected by this exit.
    Returns:
    the ID of the next room
    */
    public String getNextRoom(){
        return this.nextRoom;
    }

    /**
     * Returns a string representation of the exit, including attributes inherited from {@code GameObject}
     * and the identifier of the next room.
     * Overrides: toString in class GameObject
     * @return a string describing the exit
     */
    @Override
    public String toString() {
        return super.toString() + ", nextRoom=" + nextRoom;
    }
}
