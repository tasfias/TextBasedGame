package gameobjects;

/**
 * Represents an item in the game, which is a type of {@code GameObject}.
 *
 * <p>
 * Items can be collected, used, or interacted with by the player.
 * This class inherits common properties from {@code GameObject}.
 * </p>
 */
public class Item extends GameObject {

    /**
    Constructs a new Item with the specified attributes.
    Parameters:
    id - the unique identifier for the item
    name - the name of the item
    description - a description of the item
    hidden - whether the item is initially hidden
    */
    public Item(String id, String name, String description, boolean hidden){
        this.id = id;
        this.description = description;
        this.name = name;
        this.hidden = hidden;
    }

    /**
     * Returns a string representation of the item by calling the superclass's {@code toString} method.
     * Overrides: toString in class GameObject
     * @return a string describing the item
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
