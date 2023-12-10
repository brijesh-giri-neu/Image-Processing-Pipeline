package controller;

import commands.CommandsInterface;
import model.Model;
import view.ViewInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * An implementation of the Command interface which is used to break commands into various peieces
 * and call the appropriate function to do the operation on the provided image as requested by the
 * user/client.
 */
public class ImageCommand implements Command {

  private final Model model;
  private final ViewInterface view;
  private String command;
  private String[] args;

  /**
   * A constructor to intialize the respective field which would be used to execute the command.
   *
   * @param model   the model that is being used
   * @param command the command that needs to be performed
   * @param args    the list of arguements that is passed by the user along with the command to be
   *                executed
   * @param view    the view that the user sees
   */
  public ImageCommand(Model model, String command, String[] args, ViewInterface view) {
    this.model = model;
    this.command = command;
    this.args = args;
    this.view = view;
  }

  @Override
  public void execute() throws IOException {
    try {
      String message;
      MapCommands commandMap = new MapCommands(args);
      if (command.equalsIgnoreCase("run")) {
        message = runCommand();
        view.displayMessage(message);
      } else {
        CommandsInterface commandsInterface = commandMap.getCommand(command.toLowerCase());
        if (commandsInterface != null) {
          message = commandsInterface.advance(model);
          view.displayMessage(message);
        } else {
          view.displayMessage("Invalid command: " + command);
        }
      }
    } catch (Exception e) {
      view.displayMessage("An error occurred while executing the command: ");
    }
  }


  private String runCommand() throws IOException {
    if (args.length != 1) {
      return ("Invalid command" + "\n");
    }
    String extension = args[0].substring(args[0].lastIndexOf('.'));
    if (!(extension.equals(".txt"))) {
      return ("Only text files are supported for running the script\n");
    }
    FileReader fileReader;
    BufferedReader bufferedReader;
    try {
      fileReader = new FileReader(args[0]);
    } catch (FileNotFoundException e) {
      return ("The given file does not exists\n");
    }

    try {
      bufferedReader = new BufferedReader(fileReader);
    } catch (Exception e) {
      return ("Not able to read the given file\n");
    }
    String commandLine;
    while ((commandLine = bufferedReader.readLine()) != null) {
      if (commandLine.equalsIgnoreCase("exit")) {
        view.close();
        break;
      } else {
        String[] commands = commandLine.split(" ");
        if (commands[0].substring(0, 1).contains("#")) {
          continue;
        }
        this.command = commands[0];
        this.args = Arrays.copyOfRange(commands, 1, commands.length);
        execute();
      }
    }
    return ("Script file execution completed\n");
  }


}
