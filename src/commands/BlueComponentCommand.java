package commands;

import model.Model;

/**
 * This class represents a command to retrieve the blue component of an image and interact
 * with a Model object.
 */

public class BlueComponentCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public BlueComponentCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2) {
      return ("Invalid command" + "\n");
    }
    message = model.getComponentImage("blue", args[1], args[0]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);

    }
    return ("blue-component for: " + args[0] + "\n");
  }
}
