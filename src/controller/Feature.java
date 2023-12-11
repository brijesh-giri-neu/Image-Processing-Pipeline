package controller;

import view.GUIViewInterface;

/**
 * An interface for the controller which specifies the features that the GUI have for the image
 * manipulation.
 */
public interface Feature {

  /**
   * Method to set the GUI view for this controller.
   *
   * @param view the GUI view object
   */
  void setView(GUIViewInterface view);

  /**
   * Method to load the image from the file given by the user.
   *
   * @param arguments the arguments required by the program to load the image
   * @return the appropriate message whether the image loaded successfully or there was some error
   *     in loading the image.
   */
  String loadImage(String[] arguments);

  /**
   * Method to save the file to the particular location as selected by the user.
   *
   * @param arguments arguments required by the program to save the image
   * @return the appropriate message whether the image loaded successfully or there was some error
   *     in saving the image.
   */
  String saveImage(String[] arguments);

  /**
   * Method to get the particular component of the image as requested by the user.
   *
   * @param arguments arguments required by the program to get the component of the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String componentImage(String[] arguments);

  /**
   * Method to flip the image as requested by the user.
   *
   * @param arguments arguments required by the program to flip the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String flipImage(String[] arguments);

  /**
   * Method to blur the image as requested by the user.
   *
   * @param arguments arguments required by the program to blur the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String blurImage(String[] arguments);

  /**
   * Method to sharpen the image as requested by the user.
   *
   * @param arguments arguments required by the program to blur the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String sharpenImage(String[] arguments);

  /**
   * Method to get the luma component of the image as requested by the user.
   *
   * @param arguments arguments required by the program to get the luma component of the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String convertToGrayscaleLuma(String[] arguments);

  /**
   * Method to get the convert the image to greyscale as requested by the user.
   *
   * @param arguments arguments required by the program to convert the image to greyscale
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String convertToGreyScale(String[] arguments);

  /**
   * Method to get the convert the image to sepia tone as requested by the user.
   *
   * @param arguments arguments required by the program to convert the image to sepia tone
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */

  String convertToSepiaTone(String[] arguments);

  /**
   * Method to get the compressed version of the image as requested by the user.
   *
   * @param arguments arguments required by the program to get the greyscale version of the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String compressImage(String[] arguments);

  /**
   * Method to get the level adjusted version of the image as requested by the user.
   *
   * @param arguments arguments required by the program to get the level adjusted version of the
   *                  image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String adjustLevels(String[] arguments);

  /**
   * Method to color correct the image as requested by the user.
   *
   * @param arguments arguments required by the program to color correct the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String colorCorrect(String[] arguments);

  /**
   * Method to dither the image as requested by the user.
   *
   * @param arguments arguments required by the program to dither the image
   * @return the appropriate message whether the operation is successful or there was some error in
   *     performing the operation
   */
  String ditherImage(String[] arguments);

  /**
   * Method to get the histogram of the image as requested by the user.
   *
   * @param sourceImageName the source image name for which the histogram has to be created
   * @return the 3D array of pixels which represents the histogram
   */

  int[][][] getHistogram(String sourceImageName);

  /**
   * Method to get the pixel values of the image as requested by the user.
   *
   * @param imageName the image name as known to the program
   * @return the 3D array of the pixels of the image associated
   */
  int[][][] getImagePixels(String imageName);
}
