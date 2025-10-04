package gameobjects;

import java.util.ArrayList;

public class Equipment extends GameObject implements Usable {

    protected UseInformation useInformation;

    /**
    Creates a new Equipment object with the specified attributes.
    Parameters:
    id - the unique identifier for the equipment
    name - the name of the equipment
    description - the description of the equipment
    hidden - whether the equipment is initially hidden
    useInformation - the information about how the equipment is used
    */
    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hidden = hidden;
        this.useInformation = useInformation;
    }

    /**
    Sets the use information for this equipment.
    Specified by:
    setUseInformation in interface Usable
    Parameters:
    useInformation - the information detailing how the equipment is used
    */
    public void setUseInformation(UseInformation useInformation){
        this.useInformation = useInformation;
    }

    /**
    Retrieves the use information for this equipment.
    Specified by:
    getUseInformation in interface Usable
    Returns:
    the use information associated with this equipment
    */
    public UseInformation getUseInformation(){
        return this.useInformation;
    }

    /**
    Uses this equipment on the specified target, performing actions such as revealing or opening objects.
    Parameters:
    target - the game object the equipment is being used on
    gameState - the current state of the game
    Returns:
    a string describing the result of using the equipment
    */
    public String use(GameObject target, GameState gameState){
        Map map = gameState.getMap();
        Room currentRoom = map.getCurrentRoom();
        if(target.getName().equals("Treasure Chest")){
            Item item = currentRoom.getItemByName("Gold coin");
            if(item.getHidden()){
                item.setHidden(false);
                return "You opened the chest!";
            }
        } else if(target.getName().equals("chest")){
            Item item = currentRoom.getItemByName("ruby");
            if(item.getHidden()){
                item.setHidden(false);
                return "Something falls to the floor...";
            }
        }
        return "Cannot use this equipment";
    }

    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     * Overrides: toString in class GameObject
     * @return a string describing the equipment
     */
    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }
}
