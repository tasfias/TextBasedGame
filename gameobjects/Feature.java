package gameobjects;

/**
 * Represents a feature in the game, which is a type of game object that can be part of a room or environment.
 *
 * <p>
 * Features are typically static objects with a name, description, and visibility state, but they may
 * also serve as interactable elements in the game.
 * </p>
 */
public class Feature extends GameObject {

    /**
    Creates a new Feature object with the specified attributes.
    Parameters:
    id - the unique identifier for the feature
    name - the name of the feature
    description - the description of the feature
    hidden - whether the feature is initially hidden
    */
    public Feature(String id, String name, String description, boolean hidden){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hidden = hidden;
    }

    public Feature() {
    }

    /**
     * Returns a string representation of the feature by calling the superclass {@code GameObject}'s
     * {@code toString} method.
     *
     * @return a string describing the feature
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
