package commands;

import gameobjects.*;

public class Combine extends Command {

    //initialise items to combine
    private String item1;
    private String item2;

    public Combine(String item1, String item2){
        //instantiate items and set command type to token COMBINE
        this.item1 = item1;
        this.item2 = item2;
        this.commandType = CommandType.COMBINE;
    }

    public String execute(GameState gameState){
        Player player = gameState.getPlayer(); //get player from the current gameState
        if(player.hasItem(item1) && player.hasItem(item2)){ //check if player has the inputted items
            //check if the items are items that can be combined
            if((player.getItemByName(item1).getName().equals("butter") && player.getItemByName(item2).getName().equals("cream")) || (player.getItemByName(item1).getName().equals("cream") && player.getItemByName(item2).getName().equals("butter"))){
                //gets the items from the player's inventory by their names
                Item item1Combine = player.getItemByName(item1);
                Item item2Combine = player.getItemByName(item2);
                player.removeFromInventory(item1Combine); //removes the first item from the inventory
                player.removeFromInventory(item2Combine); //removes the second item from the inventory
                Item buttercream = new Item("i8", "buttercream", "Buttercream you have made",false); //create the new item object that has been made from combining
                player.addItem(buttercream); //add the buttercream to the inventory
                player.increaseScore(); //increase the player's score
                return "You combine " + item1 + " and " + item2 + " to get " + buttercream.getName(); //return result
            }
        }
        return "You do not have the required items"; //make player aware that they don't have the items inputted or don't have the correct ones to combine
    }
}
