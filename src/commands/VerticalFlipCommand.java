package commands;

import model.Model;

/**
 * This class represents a command to flip the image vertically and interact with a Model object.
 */

public class VerticalFlipCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public VerticalFlipCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2) {
      return ("Invalid command" + "\n");
    }

    message = model.flipImage("vertical", args[1], args[0]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("Image vertically flipped: " + args[1] + "\n");
  }
}
