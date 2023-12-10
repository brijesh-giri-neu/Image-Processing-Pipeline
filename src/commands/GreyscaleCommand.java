package commands;

import model.Model;

/**
 * This class represents a command to get the greyscale of the image and interact with a Model
 * object.
 */


public class GreyscaleCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public GreyscaleCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2 && args.length != 4) {
      return ("Invalid command" + "\n");
    }
    if (args.length == 2) {
      message = model.convertToGreyscale(args[0], args[1]);
    } else {
      if (!args[2].equalsIgnoreCase("split")) {
        return "Invalid Command";
      }
      try {
        message = model.splitImage(args[0], args[1], Integer.parseInt(args[3]), "greyscale");
      } catch (NumberFormatException nfe) {
        return "The percentage entered in not a number. Please enter a valid number";
      }
    }
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("Successfully Greyscale of the Image: " + args[1] + "\n");
  }
}
