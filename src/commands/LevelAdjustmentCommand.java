package commands;

import model.Model;

/**
 * This class represents a command to level adjust the image and interact with a Model object.
 */

public class LevelAdjustmentCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public LevelAdjustmentCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 5 && args.length != 7) {
      return ("Invalid command" + "\n");
    } else {

      if (args.length == 5) {
        try {
          message = model.adjustLevels(args[3], args[4], Double.parseDouble(args[0]),
              Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        } catch (NumberFormatException nfe) {
          return ("The b,m and w value entered should be a number ");
        }

        if (!message.equalsIgnoreCase("Successful")) {
          return (message);
        }
        return ("Level adjusted for the image and stored in: " + args[4] + "\n");
      } else {
        if (!args[5].equalsIgnoreCase("split")) {
          return ("Invalid command" + "\n");
        }
        try {
          message = model.splitImageLevel(args[3], args[4], Integer.parseInt(args[6]),
              Double.parseDouble(args[0]), Double.parseDouble(args[1]),
              Double.parseDouble(args[2]));
        } catch (NumberFormatException nfe) {
          return ("The b,m, w and percentage value entered should be a number ");
        }

        if (!message.equalsIgnoreCase("Successful")) {
          return (message);
        }
        return ("Successfully Level adjusted for the image and stored in: " + args[4] + "\n");

      }
    }
  }

}
