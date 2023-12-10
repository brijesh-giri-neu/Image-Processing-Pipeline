package commands;

import model.Model;

/**
 * This class represents a command to flip the image horizontally and interact with a Model object.
 */

public class HorizontalFlipCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public HorizontalFlipCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2) {
      return ("Invalid command" + "\n");
    }

    message = model.flipImage("horizontal", args[1], args[0]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);

    }
    return ("Image horizontally flipped: " + args[1] + "\n");
  }
}
