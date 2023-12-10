package commands;

import model.Model;

/**
 * This class represents a command to compress the image and interact with a Model object.
 */

public class CompressCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public CompressCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 3) {
      return ("Invalid command" + "\n");
    }

    try {
      message = model.compressImage(args[1], args[2], Integer.parseInt(args[0]));
    } catch (NumberFormatException nfe) {
      return ("The given percentage isn't a number: " + nfe.getMessage()
          + ". Please enter a valid Percentage");
    } catch (Exception e) {
      return ("An error occured " + e.getMessage());
    }
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("Compressed the Image: " + args[1] + "\n");
  }
}


