package commands;

import model.Model;

/**
 * This class represents a command to get the red component of the image and interact with a Model
 * object.
 */

public class RedComponentCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public RedComponentCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2) {
      return ("Invalid command" + "\n");
    }
    message = model.getComponentImage("red", args[1], args[0]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("red-component for: " + args[0] + "\n");
  }
}
