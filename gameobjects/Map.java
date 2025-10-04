package gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import utils.*;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 *
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {

    //initialise rooms, currentRoom and map
    private ArrayList<Room> rooms;
    private Room currentRoom;
    private HashMap<String, String> map;

    ///Constructs a new, empty Map.
    public Map(){
        this.rooms = new ArrayList<>(); //instantiates room objects in an array
        this.map = new HashMap<>(); //instantiates map in a hashmap

        //creates 2x5 map
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 5; y++){
                String key = x + "," + y; //sets key as coordinates
                map.put(key, "□"); //displays rooms as boxes
            }
        }
    }

    //displays map
    public String display(){
        //loops through 2x5 map
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 5; y++){
                String key = x + "," + y;
                System.out.print(map.get(key) + " "); //gets the string at the key from the map and prints it with a space
            }
            System.out.println(); //prints a line
        }
        return ""; //return empty string
    }

    /**
    Retrieves the current room the player is in.
    Returns:
    the current room
    */
    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    /*
    Adds a room to the map.
    Parameters:
    room - the room to add to the map
    */
    public void addRoom(Room room){
        rooms.add(room);
    }

    /*
    Sets the current room based on the provided room ID.
    Parameters:
    roomId - the ID of the room to set as the current room
    */
    public void setCurrentRoom(String roomId){
        for(Room room : rooms){
            if(room.getId().equals(roomId)){
                currentRoom = room;
                return;
            }
        }
        System.out.println("No room with ID " + roomId);
    }

    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}
