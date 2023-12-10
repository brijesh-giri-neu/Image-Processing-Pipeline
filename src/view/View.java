package view;

import java.io.IOException;


/**
 * An implementation of the view interface which is having functionalities to show the
 * starting/welcome message, display and message that is returned by the program and show the
 * closing message of the program.
 */
public class View implements ViewInterface {

  private final Appendable out;

  /**
   * Constructor to initialize the out message that will be displayed to the user/client.
   *
   * @param out the message that needs to be displayed
   */
  public View(Appendable out) {
    this.out = out;

  }

  @Override
  public void start() {
    try {
      out.append("Welcome to the Image Processing Application!\n");
      out.append("Please enter the command \n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void displayMessage(String message) {
    try {
      out.append(message + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void close() {
    try {
      out.append("Thank you for using the Image Processing Application!\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
