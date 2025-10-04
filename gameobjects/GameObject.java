package gameobjects;

/**
 * Represents a generic game object that can be part of the game world.
 *
 * <p>
 * Game objects have a name, description, unique identifier, and visibility state.
 * This abstract class serves as a base for more specific types of game objects.
 * </p>
 */
public abstract class GameObject {

    protected String description;
    protected boolean hidden;
    public String id;
    protected String name;

    /**
    Constructs a new GameObject with the specified attributes.
    Parameters:
    id - the unique identifier of the game object
    name - the name of the game object
    description - the description of the game object
    hidden - whether the game object is initially hidden
    */
    public GameObject(String id, String name, String description, boolean hidden){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hidden = hidden;
    }

    /**
    Default constructor for GameObject.
     */
    public GameObject(){
    }


    /**
    Sets the name of the game object.
    Parameters:
    name - the name of the game object
    */
    public void setName(String name){
        this.name = name;
    }

    /**
    Retrieves the name of the game object.
    Returns:
    the name of the game object
    */
    public String getName(){
        return this.name;
    }

    /**
    Retrieves the unique identifier of the game object.
    Returns:
    the ID of the game object
    */
    public String getId(){
        return this.id;
    }

    /**
    Sets the visibility state of the game object.
    Parameters:
    hidden - true to hide the object, false to make it visible
    */
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }

    /**
    Retrieves the visibility state of the game object.
    Returns:
    true if the object is hidden, false otherwise
    */
    public boolean getHidden(){
        return this.hidden;
    }

    /**
    Sets the description of the game object.
    Parameters:
    description - the description of the game object
    */
    public void setDescription(String description){
        this.description = description;
    }

    /**
    Retrieves the description of the game object.
    Returns:
    the description of the game object
    */
    public String getDescription(){
        return this.description;
    }

    /**
     * Returns a string representation of the game object, including its ID, name,
     * description, and visibility state.
     *
     * @return a string describing the game object
     */
    @Override
    public String toString() {
        return "GameObject {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hidden=" + hidden +
                '}';
    }
}
