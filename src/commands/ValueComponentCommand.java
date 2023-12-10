package commands;

import model.Model;

/**
 * This class represents a command to value component of the image and interact with a Model
 * object.
 */

public class ValueComponentCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public ValueComponentCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2) {
      return ("Invalid command" + "\n");

    }
    message = model.getComponentImage("value", args[1], args[0]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);

    }
    return ("Converted to value-component: " + args[1] + "\n");
  }
}
