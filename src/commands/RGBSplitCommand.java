package commands;

import model.Model;

/**
 * This class represents a command to split the image into it's various component and interact with
 * a Model object.
 */

public class RGBSplitCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */

  public RGBSplitCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 4) {
      return ("Invalid command" + "\n");
    }
    message = model.splitIntoRGB(args[0], args[1], args[2], args[3]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);

    }
    return ("RGB split completed for: " + args[0] + "\n");
  }
}
