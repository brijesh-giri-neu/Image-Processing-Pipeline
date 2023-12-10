package commands;

import model.Model;

/**
 * This class represents a command to brighten the image and interact with a Model object.
 */

public class BrightenCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public BrightenCommand(String[] args) {
    this.args = args;
  }


  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 3) {
      return ("Invalid command" + "\n");
    }

    message = model.adjustBrightness(Integer.parseInt(args[0]), args[2], args[1]);
    if (!message.equalsIgnoreCase("Successful")) {
      return message;
    }
    return ("Image brightened: " + args[2] + "\n");
  }
}
