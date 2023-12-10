package commands;

import model.Model;

/**
 * This class represents a command to combine the various component of the image and interact with a
 * Model object.
 */

public class RGBCombineCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public RGBCombineCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 4) {
      return ("Invalid command" + "\n");
    }
    message = model.combineRGBImages(args[0], args[1], args[2], args[3]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("RGB images combined into: " + args[3] + "\n");
  }
}
