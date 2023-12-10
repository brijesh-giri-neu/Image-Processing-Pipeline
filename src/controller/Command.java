package controller;

import java.io.IOException;

/**
 * An interface for the command which is used to execute a particular command as input by the user/
 * client.
 */
public interface Command {

  /**
   * This function executes the command that is input by the user/client.
   *
   * @throws IOException if there is an issue with the command
   */
  void execute() throws IOException;
}
