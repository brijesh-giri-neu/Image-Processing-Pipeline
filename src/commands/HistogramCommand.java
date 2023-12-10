package commands;

import model.Model;

/**
 * This class represents a command to get the histogram the image and interact with a Model object.
 */

public class HistogramCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public HistogramCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2) {
      return ("Invalid command" + "\n");
    }
    message = model.createHistogram(args[0], args[1]);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("Histogram of the Image is created and stored in: " + args[1] + "\n");
  }

}
