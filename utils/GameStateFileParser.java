package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class GameStateFileParser {

    public GameStateFileParser(){
    }

    /*
    Parses a game state from the specified file.
    Parameters:
    filename - the name of the file to parse
    Returns:
    the parsed GameState object
    */
    public static GameState parse(String filename) {
        GameState gameState = new GameState();
        Map map = new Map();
        Player player = null;
        Room currentRoom = null;

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Room newRoom = null;
            
            while((line = reader.readLine()) != null){
                String[] parts = line.split(":|,", -1);

                if(line.startsWith("player:")){
                    String playerName = parts[1].trim();
                    player = new Player(playerName);
                    gameState.setPlayer(player);
                } else if (line.startsWith("map:")) {
                    String mapId = parts[1].trim();
                    gameState.setMap(map);
                } else if (line.startsWith("room:")) {
                    String roomId = parts[1].trim();
                    String roomName = parts[2].trim();
                    String roomDescription = parts[3].trim();
                    boolean isHidden = Boolean.parseBoolean(parts[4].trim());

                    if(currentRoom == null){
                        currentRoom = new Room(roomId, roomName, roomDescription, isHidden);
                        map.addRoom(currentRoom);
                        map.setCurrentRoom(currentRoom.getId());
                    }else{
                        newRoom = new Room(roomId, roomName, roomDescription, isHidden);
                        map.addRoom(newRoom);
                    }
                } else if (line.startsWith("equipment:")) {
                    String equipmentId = parts[1].trim();
                    String equipmentName = parts[2].trim();
                    String equipmentDescription = parts[3].trim();
                    boolean equipmentHidden = Boolean.parseBoolean(parts[4].trim());
                    String action = parts[5].trim();
                    String target = parts[6].trim();
                    String result = parts[7].trim();
                    String description = parts[8].trim();

                    UseInformation info = new UseInformation(false, action, target, result, description);
                    Equipment equipment = new Equipment(equipmentId, equipmentName, equipmentDescription, equipmentHidden, info);

                    if(newRoom != null){
                        newRoom.addEquipment(equipment);
                    }else if(currentRoom != null){
                        currentRoom.addEquipment(equipment);
                    }
                } else if (line.startsWith("container:")) {
                    String containerId = parts[1].trim();
                    String containerName = parts[2].trim();
                    String containerDescription= parts[3].trim();
                    boolean containerHidden = Boolean.parseBoolean(parts[4].trim());

                    Container container = new Container(containerId, containerName, containerDescription, containerHidden);

                    if(newRoom != null){
                        newRoom.addFeature(container);
                    }else if(currentRoom != null){
                        currentRoom.addFeature(container);
                    }
                } else if (line.startsWith("item:")) {
                    String itemId = parts[1].trim();
                    String itemName = parts[2].trim();
                    String itemDescription = parts[3].trim();
                    boolean itemHidden = Boolean.parseBoolean(parts[4].trim());

                    Item item = new Item(itemId, itemName, itemDescription, itemHidden);

                    if(newRoom != null){
                        newRoom.addItem(item);
                    }else if(currentRoom != null){
                        currentRoom.addItem(item);
                    }
                } else if(line.startsWith("exit:")){
                    String exitId = parts[1].trim();
                    String exitName = parts[2].trim();
                    String exitDescription = parts[3].trim();
                    String nextRoomId = parts[4].trim();
                    boolean exitHidden = Boolean.parseBoolean(parts[5].trim());

                    Exit exit = new Exit(exitId, exitName, exitDescription, nextRoomId, exitHidden);

                    if(newRoom != null){
                        newRoom.addExit(exit);
                    }else if(currentRoom != null){
                        currentRoom.addExit(exit);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gameState;
    }
}
