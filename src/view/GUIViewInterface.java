package view;

import controller.Feature;

/**
 * This is an interface for the GUI view of the application. It provides 2 methods one is for adding
 * new features to the GUI and one is to show any error messages associated with the application.
 */
public interface GUIViewInterface {

  /**
   * Function to add features to the GUI view of the application.
   *
   * @param feature the features interface which has the relevant features pertaining to the GUI
   *                view
   */

  void addFeatures(Feature feature);

  /**
   * Method to show the error message to the user.
   *
   * @param message the message to be shown to the user
   */
  void showErrorMessage(String message);

}
