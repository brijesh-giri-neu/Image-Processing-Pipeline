package commands;

import model.Model;

/**
 * This class represents a command to dither an image and interact with a Model object.
 */
public class DitherCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Initialize the arguments for the command.
   *
   * @param args the arguments for the command
   */
  public DitherCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2 && args.length != 4) {
      return ("Invalid command" + "\n");
    }
    if (args.length == 2) {
      message = model.ditherImage(args[0], args[1]);
    } else {
      if (!args[2].equalsIgnoreCase("split")) {
        return "Invalid Command";
      }
      try {
        message = model.splitImage(args[0], args[1], Integer.parseInt(args[3]), "dither");
      } catch (NumberFormatException nfe) {
        return "The percentage entered in not a number. Please enter a valid number";
      }
    }
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("Successfully Dithered the Image: " + args[1] + "\n");
  }
}
