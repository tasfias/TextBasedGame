package gameobjects;

/**
 * Represents information about how an object can be used in the game.
 *
 * <p>
 * This class stores details about the usage of an object, such as whether it has
 * already been used, the type of action it performs, the target of the action,
 * the result of the action, and any associated message.
 * </p>
 */
public class UseInformation {

    private boolean isUsed;
    private String action;
    private String target;
    private String result;
    private String message;
    /**
    Constructs a new UseInformation object with the specified attributes.
    Parameters:
    isUsed - whether the object has already been used
    action - the type of action performed (e.g., "open", "reveal", "combine")
    target - the key of the game object being targeted
    result - the key of the resulting game object (e.g., revealed or dropped object)
    message - the message to display after the action
    */
    public UseInformation(boolean isUsed, String action, String target, String result, String message){
        this.isUsed = isUsed;
        this.action = action;
        this.target = target;
        this.result = result;
        this.message = message;
    }

    /**
    Checks if the object has already been used.
    Returns:
    true if the object has been used, false otherwise
    */
    public boolean isUsed(){
        if(isUsed){
            return true;
        }
        return false;
    }

    /**
    Sets whether the object has been used.
    Parameters:
    isUsed - true if the object has been used, false otherwise
    */
    public void setUsed(boolean isUsed){
        this.isUsed = isUsed;
    }

    /**
    Retrieves the type of action associated with this usage.
    Returns:
    the action type (e.g., "open", "reveal", "combine")
    */
    public String getAction(){
        return this.action;
    }

    /**
    Sets the type of action associated with this usage.
    Parameters:
    action - the action type (e.g., "open", "reveal", "combine")
    */
    public void setAction(String action){
        this.action = action;
    }

    /**
    Retrieves the key of the game object being targeted.
    Returns:
    the target object's key
    */
    public String getTarget(){
        return this.target;
    }

    /**
    Sets the key of the game object being targeted.
    Parameters:
    target - the target object's key
    */
    public void setTarget(String target){
        this.target = target;
    }

    /**
    Retrieves the key of the resulting game object.
    Returns:
    the result object's key
    */
    public String getResult(){
        return this.result;
    }

    /**
    Sets the key of the resulting game object.
    Parameters:
    result - the result object's key
    */
    public void setResult(String result){
        this.result = result;
    }

    /**
    Retrieves the message associated with this usage.
    Returns:
    the message to display after the action
    */
    public String getMessage(){
        return this.message;
    }

    /**
    Sets the message associated with this usage.
    Parameters:
    message - the message to display after the action
    */
    public void setMessage(String message){
        this.message = message;
    }

    /**
     * Returns a string representation of the usage information, including all attributes.
     *
     * @return a string describing the usage information
     */
    @Override
    public String toString() {
        return "UseInformation{" +
                "isUsed=" + isUsed +
                ", action='" + action + '\'' +
                ", target='" + target + '\'' +
                ", result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
