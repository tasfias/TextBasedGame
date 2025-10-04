package gameobjects;

/**
 * Represents an interface for objects that can be used within the game.
 * 
 * <p>
 * Objects implementing this interface must define methods to manage their use
 * information and provide their name.
 * </p>
 */
public interface Usable {

    /**
    Sets the use information for the object.
    Parameters:
    useInfo - the UseInformation detailing how the object can be used
    */
    void setUseInformation(UseInformation useInfo);

    /**
    Retrieves the use information for the object.
    Returns:
    the UseInformation associated with the object
    */
    UseInformation getUseInformation();

    /**
    Retrieves the name of the object.
    Returns:
    the name of the object
    */
    String getName();
}
