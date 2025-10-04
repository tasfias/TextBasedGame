package gameobjects;

/**
 * Represents a container in the game, which is a type of feature that may contain items
 * or serve as an interactable object within a room.
 *
 * <p>
 * Container can have a name, description, and visibility state, which determines if they
 * are initially hidden or visible to the player.
 * </p>
 */
public class Container extends Feature {

    /**
    Creates a new Container with the specified attributes.
    Parameters:
    id - the unique identifier for the container
    name - the name of the container
    description - the description of the container
    hidden - whether the container is initially hidden
    */
    public Container(String id, String name, String description, boolean hidden){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hidden = hidden;
    }

    /**
    Retrieves the name of the container.
    Overrides:
    getName in class GameObject
    Returns:
    the name of the container
    */
    public String getName(){
        return this.name;
    }

    /**
     * Returns a string representation of the container.
     * Overrides: toString in class Feature
     * @return a string containing the container's id, name, description, and hidden status
     */
    @Override
    public String toString() {
        return "Container {" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", hidden=" + getHidden() +
                '}';

    }

}
