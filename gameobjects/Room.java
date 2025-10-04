package gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 *
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {

    private ArrayList<Exit> exits;
    private ArrayList<Item> items;
    private ArrayList<Feature> features;
    private ArrayList<Equipment> equipmentArray;
    private ArrayList<GameObject> allObjects;
    /**
    Constructs a new Room with the specified attributes.
    Parameters:
    id - the unique identifier for the room
    name - the name of the room
    description - the description of the room
    hidden - whether the room is initially hidden
    */
    public Room(String id, String name, String description, boolean hidden){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hidden = hidden;
        this.exits = new ArrayList<>();
        this.items = new ArrayList<>();
        this.features = new ArrayList<>();
        this.equipmentArray = new ArrayList<>();
        this.allObjects = new ArrayList<>();
    }

    ///Default constructor for Room.
    public Room(){
    }

    /**
    Sets the name of the room.
    Overrides:
    setName in class GameObject
    Parameters:
    name - the new name of the room
    */
    public void setName(String name){
        this.name = name;
    }

    /**
    Sets the description of the room.
    Overrides:
    setDescription in class GameObject
    Parameters:
    description - the new description of the room
    */
    public void setDescription(String description){
        this.description = description;
    }

    /**
    Retrieves the name of the room.
    Overrides:
    getName in class GameObject
    Returns:
    the name of the room
    */
    public String getName(){
        return this.name;
    }

    /**
    Retrieves the description of the room.
    Overrides:
    getDescription in class GameObject
    Returns:
    the description of the room
    */
    public String getDescription(){
        return this.description;
    }

    /**
    Retrieves the exits of the room.
    Returns:
    a list of exits in the room
    */
    public ArrayList<Exit> getExits(){
        return exits;
    }

    /**
    Adds an exit to the room.
    Parameters:
    exit - the exit to add
    */
    public void addExit(Exit exit){
        exits.add(exit);
        allObjects.add(exit);
    }

    /**
    Retrieves the items in the room.
    Returns:
    a list of items in the room
    */
    public ArrayList<Item> getItems(){
        return items;
    }

    /**
    Retrieves an item by its ID.
    Parameters:
    id - the ID of the item
    Returns:
    the item if found, otherwise null
    */
    public Item getItem(String id){
        for(Item item : items){
            if(item.getId().equalsIgnoreCase(id)){
                return item;
            }
        }
        return null;
    }

    /**
    Retrieves an item by its name.
    Parameters:
    name - the name of the item
    Returns:
    the item if found, otherwise null
    */
    public Item getItemByName(String name){
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;
    }

    public Item getItemById(String id){
        for(Item item : items){
            if(item.getId().equalsIgnoreCase(id)){
                return item;
            }
        }
        return null;
    }

    public boolean hasItemId(String id){
        if(getItemById(id) != null){
            return true;
        }
        return false;
    }

    public Equipment getEquipById(String id){
        for(Equipment equipment : equipmentArray){
            if(equipment.getId().equalsIgnoreCase(id)){
                return equipment;
            }
        }
        return null;
    }

    public boolean hasEquipmentId(String id){
        if(getEquipById(id) != null){
            return true;
        }
        return false;
    }

    /**
    Retrieves a feature by its name.
    Parameters:
    name - the name of the feature
    Returns:
    the feature if found, otherwise null
    */
    public Feature getFeatureByName(String name){
        for(Feature feature : features){
            if(feature.getName().equals(name)){
                return feature;
            }
        }
        return null;
    }

    /**
    Retrieves the equipment in the room.
    Returns:
    a list of equipment in the room
    */
    public ArrayList<Equipment> getEquipments(){
        return equipmentArray;
    }

    /**
    Retrieves equipment by its name.
    Parameters:
    name - the name of the equipment
    Returns:
    the equipment if found, otherwise null
    */
    public Equipment getEquipmentByName(String name){
        for(Equipment equipment : equipmentArray){
            if(equipment.getName().equalsIgnoreCase(name)){
                return equipment;
            }
        }
        return null;
    }

    /**
    Retrieves equipment by its ID.
    Parameters:
    id - the ID of the equipment
    Returns:
    the equipment if found, otherwise null
    */
    public Equipment getEquipment(String id){
        for(Equipment equipment : equipmentArray){
            if(equipment.getId().equalsIgnoreCase(id)){
                return equipment;
            }
        }
        return null;
    }

    /**
    Retrieves an exit by its ID.
    Parameters:
    id - the ID of the exit
    Returns:
    the exit if found, otherwise null
    */
    public Exit getExit(String id){
        for(Exit exit : exits){
            if(exit.getId().equalsIgnoreCase(id)){
                return exit;
            }
        }
        return null;
    }

    public Exit getExitByName(String name){
        for(Exit exit : exits){
            if(exit.getName().equalsIgnoreCase(name)){
                return exit;
            }
        }
        return null;
    }
    
    /**
    Adds equipment to the room.
    Parameters:
    equipment - the equipment to add
    */
    public void addEquipment(Equipment equipment){
        equipmentArray.add(equipment);
        allObjects.add(equipment);
    }

    /**
    Retrieves a feature by its id.
    Parameters:
    id - the id of the feature
    Returns:
    the feature if found, otherwise null
    */
    public Feature getFeature(String id){
        for(Feature feature : features){
            if(feature.getId().equalsIgnoreCase(id)){
                return feature;
            }
        }
        return null;
    }

    /**
    Adds an item to the room.
    Parameters:
    item - the item to add
    */
    public void addItem(Item item){
        items.add(item);
        allObjects.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
        allObjects.remove(item);
    }

    public void removeEquipment(Equipment equipment){
        equipmentArray.remove(equipment);
        allObjects.remove(equipment);
    }

    /**
    Retrieves the features in the room.
    Returns:
    a list of features in the room
    */
    public ArrayList<Feature> getFeatures(){
        return features;
    }

    /**
    Retrieves all game objects in the room.
    Returns:
    a list of all game objects in the room
    */
    public ArrayList<GameObject> getAll(){
        return allObjects;
    }

    /**
    Adds a feature to the room.
    Parameters:
    feature - the feature to add
    */
    public void addFeature(Feature feature){
        features.add(feature);
        allObjects.add(feature);
    }

    /**
    Checks if the room contains an item with the specified name.
    Parameters:
    itemName - the name of the item
    Returns:
    true if the item is found, false otherwise
    */
    public boolean hasItem(String itemName){
        if(getItemByName(itemName) != null){
            return true;
        }
        return false;
    }

    /**
    Checks if the room contains equipment with the specified name.
    Parameters:
    name - the name of the equipment
    Returns:
    true if the equipment is found, false otherwise
    */
    public boolean hasEquipment(String name){
        if(getEquipmentByName(name) != null){
            return true;
        }
        return false;
    }

    public boolean hasFeature(String name){
        if(getFeatureByName(name) != null){
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipmentArray) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
