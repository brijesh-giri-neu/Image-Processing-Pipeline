package controller;

import java.io.IOException;

/**
 * This is an interface for the controller which has the functionality to run and execute a
 * particular command.
 */
public interface ControllerInterface {

  /**
   * Method to run the controller, managing the execution of commands.
   */
  void run(String[] args);

  /**
   * Method to execute a specific command.
   *
   * @param commandLine The command line input to be executed
   * @throws IOException if there is any issue executing the command
   */
  void execute(String commandLine, String[] args) throws IOException;


}
