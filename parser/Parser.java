package parser;

import java.util.ArrayList;

import commands.*;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 *
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {

    public Parser(){
    }

    /**
    Parses a list of tokens into a Command object.
    Parameters:
    tokens - the list of tokens to parse
    Returns:
    a Command object representing the parsed command
    Throws:
    CommandErrorException - if the command cannot be parsed or is invalid
    */
    public Command parse(ArrayList<Token> tokens) throws CommandErrorException{

        if(tokens == null || tokens.isEmpty()){
            throw new CommandErrorException("No command entered");
        }

        Token firstToken = tokens.get(0);
        TokenType commandType = firstToken.getTokenType();

        switch(commandType){
            case MOVE:
                return move(tokens);
            case GET:
                return get(tokens);
            case DROP:
                return drop(tokens);
            case LOOK:
                return look(tokens);
            case STATUS:
                return status(tokens);
            case HELP:
                return help(tokens);
            case QUIT:
                return quit(tokens);
            case USE:
                return use(tokens);
            case COMBINE:
                return combine(tokens);
            default:
                throw new CommandErrorException("Invalid command");
        }
    }

    private Command move(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
            throw new CommandErrorException("No direction specified");
        }
        String direction = tokens.get(1).getValue();
        return new Move(direction);
    }

    private Command get(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
            throw new CommandErrorException("No item specified");
        }
        String item = tokens.get(1).getValue();
        return new Get(item);
    }

    private Command drop(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
            throw new CommandErrorException("No item specified");
        }
        String item = tokens.get(1).getValue();
        return new Drop(item);
    }

    private Command look(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
            throw new CommandErrorException("No target specified");
        }
        String target = tokens.get(1).getValue();
        return new Look(target);
    }

    private Command status(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR){
            throw new CommandErrorException("No topic specified");
        }
        String topic = tokens.get(1).getValue();
        return new Status(topic);
    }

    private Command use(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.PREPOSITION || tokens.get(3).getTokenType() != TokenType.VAR){
            throw new CommandErrorException("No equipment or target specified");
        }
        String equipmentName = tokens.get(1).getValue();
        String target = tokens.get(3).getValue();
        return new Use(equipmentName, target);
    }

    private Command help(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.get(1).getTokenType() != TokenType.VAR){
            return new Help(null);
        }
        String topic = tokens.get(1).getValue();
        return new Help(topic);
    }

    private Command quit(ArrayList<Token> tokens) throws CommandErrorException{
        return new Quit();
    }

    private Command combine(ArrayList<Token> tokens) throws CommandErrorException{
        if(tokens.size() < 4 || tokens.get(1).getTokenType() != TokenType.VAR || tokens.get(2).getTokenType() != TokenType.PREPOSITION || tokens.get(3).getTokenType() != TokenType.VAR){
            throw new CommandErrorException("No two items specified");
        }
        String item1 = tokens.get(1).getValue();
        String item2 = tokens.get(3).getValue();
        return new Combine(item1, item2);
    }
}
