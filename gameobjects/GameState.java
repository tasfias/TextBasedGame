package gameobjects;

/**
 * Represents the current state of the game, including the map and the player.
 *
 * <p>
 * The game state contains all necessary information about the game's progress, such as
 * the player's status and the state of the game map.
 * </p>
 */
public class GameState {

    private Map map;
    private Player player;
    /**
    Constructs a new GameState with the specified map and player.
    Parameters:
    map - the map representing the game world
    player - the player in the game
    */
    public GameState(Map map, Player player){
        this.map = map;
        this.player = player;
    }

    ///Default constructor for GameState.
    public GameState(){
    }

    /**
    Retrieves the map associated with the current game state.
    Returns:
    the map representing the game world
    */
    public Map getMap(){
        return this.map;
    }

    /**
    Retrieves the player associated with the current game state.
    Returns:
    the player in the game
    */
    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * Returns a string representation of the game state, including the map and player details.
     *
     * @return a string describing the game state
     */
    @Override
    public String toString() {
        return "GameState {" +
                "map=" + (map != null ? map.toString() : "null") + ", " +
                "player=" + (player != null ? player.toString() : "null") +
                '}';
    }
}
