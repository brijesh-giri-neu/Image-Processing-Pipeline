package commands;

import model.Model;

/**
 * Interface for the command design pattern. It offers various functionality. It defines a method to
 * run a particular command based on the object created during runtime.
 */
public interface CommandsInterface {

  /**
   * Method to run the particular command based on the object that is created during the runtime.
   *
   * @param model the model object of the code
   * @return the message whether the given operation was successful or had some error
   */

  String advance(Model model);

}
