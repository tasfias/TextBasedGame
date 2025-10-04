package gameobjects;

import java.util.ArrayList;

/**
 * Represents the player in the game, including their name, inventory, and equipment.
 *
 * <p>
 * The player can carry items and equipment, interact with the game world, and perform
 * actions using their inventory or equipment.
 * </p>
 */
public class Player {

    //initialise player name, inventory, equipment and score
    private String name;
    private ArrayList<Item> inventory;
    private ArrayList<Equipment> equipmentArray;
    private int score;

    /**
        Constructs a new Player with the specified name and initializes their inventory and equipment.
        Parameters:
        name - the name of the player
        */
    public Player(String name){
        //instantiate name, inventory, equipment and score
        this.name = name;
        this.inventory = new ArrayList<>();
        this.equipmentArray = new ArrayList<>();
        this.score = 10; //set starting score to 10
    }

    ///Default constructor for Player.
    public Player(){
    }

    public void decreaseScore() { //decrease score by 1
        score--;
    }

    public void increaseScore() { //increase score by 10
        score += 10;
    }

    public int getScore() { //return the player's current score
        return score;
    }

    /**
    Retrieves the name of the player.
    Returns:
    the player's name
    */
    public String getName(){
        return this.name;
    }

    /**
    Retrieves the player's inventory.
    Returns:
    an ArrayList of Item objects in the player's inventory
    */
    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public void removeFromInventory(Item item){
        inventory.remove(item);
    }

    public void removeFromEquipment(Equipment equipment){
        equipmentArray.remove(equipment);
    }

    public Item getItemByName(String itemName){
        for(Item item : inventory){
            if(item.getName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }

    /**
    Checks if the player has an item with the specified name in their inventory.
    Parameters:
    itemName - the name of the item to check
    Returns:
    true if the item is found, false otherwise
    */
    public boolean hasItem(String itemName){
        for(Item item : inventory){
            if(item.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }

    /**
    Retrieves an item from the player's inventory by its name.
    Parameters:
    itemName - the name of the item to retrieve
    Returns:
    the Item object if found, or null if not found
    */
    public Item getItem(String itemName){
        for(Item item : inventory){
            if(item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }

    /**
    Adds an item to the player's inventory.
    Parameters:
    item - the Item to add
    */
    public void addItem(Item item){
        inventory.add(item);
    }

    /**
    Retrieves the player's equipment.
    Returns:
    an ArrayList of Equipment objects in the player's possession
    */
    public ArrayList<Equipment> getEquipment(){
        return equipmentArray;
    }

    /**
    Checks if the player has equipment with the specified name.
    Parameters:
    equipmentName - the name of the equipment to check
    Returns:
    true if the equipment is found, false otherwise
    */
    public boolean hasEquipment(String equipmentName){
        for(Equipment equipment : equipmentArray){
            if(equipment != null && equipment.getName().equals(equipmentName)){
                return true;
            }
        }
        return false;
    }

    /**
    Retrieves a piece of equipment by its name.
    Parameters:
    equipmentName - the name of the equipment to retrieve
    Returns:
    the Equipment object if found, or null if not found
    */
    public Equipment getEquipment(String equipmentName){
        for(Equipment equipment : equipmentArray){
            if(equipment.getName().equals(equipmentName)){
                return equipment;
            }
        }
        return null;
    }

    /**
    Adds a piece of equipment to the player's collection.
    Parameters:
    equipment - the Equipment to add
    */
    public void addEquipment(Equipment equipment){
        equipmentArray.add(equipment);
    }

    public String getStatus(){
        if(hasItem("buttercream") && hasItem("eggs") && hasItem("syrup") && hasItem("liquor") && hasItem("sweets") && hasItem("sugar")){
            System.out.println("Congratulations Moonlight. You have obtained all of the ingredients and have become a step closer to world peace.\n");
        }
        return "Player Name: " + this.name +
                "\nInventory: " + getDescriptions(inventory) +
                "\nEquipment: " + getDescriptions(equipmentArray) + 
                "\nScore: " + getScore();
    }

    public <T extends GameObject> String getDescriptions(ArrayList<T> objects){
        if(objects.isEmpty()){
            return "";
        }

        StringBuilder descriptions = new StringBuilder();
        for(GameObject object : objects){
            descriptions.append(object.getDescription()).append("\n");
        }
        return descriptions.toString();
    }

    /**
     * Returns a string representation of the player's current state, including their name,
     * inventory, and equipment descriptions.
     *
     * @return a string describing the player, their inventory, and equipment
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Player Name: " + this.name + "\nInventory:\n");
        for (Item i : this.inventory) {
            out.append("- ").append(i.getDescription()).append("\n");
        }
        out.append("Equipment:\n");
        for (Equipment e : this.equipmentArray) {
            out.append("- ").append(e.getDescription()).append("\n");
        }
        return out.toString();
    }
}
