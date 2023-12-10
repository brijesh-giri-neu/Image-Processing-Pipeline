package view;


/**
 * An interface of the view which is used to display the messages to the user/client.
 */
public interface ViewInterface {

  /**
   * Method to start the view, displaying a welcome message or instructions.
   */
  void start();

  /**
   * Method to display messages to the user.
   *
   * @param message The message to be displayed.
   */
  void displayMessage(String message);

  /**
   * Method to close the view, used for cleanup and displaying a goodbye message.
   */
  void close();

}
