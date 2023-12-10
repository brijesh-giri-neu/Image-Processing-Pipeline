package model;

/**
 * This is an interface of the model of the program. It represents an instance of an image
 * application with various functionalities such as loading the image, performing various operations
 * on the image and then saving the image.
 */
public interface Model {

  /**
   * Function to load a particular image from a particular location and store it in a variable.
   *
   * @param image     the actual image array
   * @param imageName the name of the image that needs to be stored in the Map
   */

  String putInMap(int[][][] image, String imageName);

  /**
   * Function to save the image at a particular location.
   *
   * @param filename the name of the image in the variable that needs to be saved
   */
  int[][][] getFromMap(String filename);

  /**
   * Function to split the image into the particular component as requested by the client.
   *
   * @param component the component which is requested by the client
   * @param name      the name of the image that needs to be stored in the variable so that it can
   *                  be referred to henceforth
   * @param scr       the name of the image that needs the operations to be done on
   */

  String getComponentImage(String component, String name, String scr);


  /**
   * Function to flip the image either horizontally or vertically based on the client's request.
   *
   * @param direction the direction which the client wants tot flip the image in - vertical or
   *                  horizontal
   * @param name      the name of the image that needs to be stored in the variable so that it can
   *                  be referred to henceforth
   * @param scr       the name of the image on which the operations needs to be performed
   */
  String flipImage(String direction, String name, String scr);

  /**
   * Function to adjust the brightness of an image by a particular value as requested by the
   * client.
   *
   * @param value the value by which the brightness of the image needs to be adjusted
   * @param name  the name of the image that needs to be stored in the variable so that it can be
   *              referred to henceforth
   * @param scr   the name of the image on which the operations needs to be performed
   */
  String adjustBrightness(int value, String name, String scr);

  /**
   * Function to split the image into it's red, blue and green components.
   *
   * @param scr   the name of the image on which the operations needs to be performed
   * @param red   the name of the red component of the  image that needs to be stored in the
   *              variable so that it can be referred to henceforth
   * @param green the name of the green component of the  image that needs to be stored in the
   *              variable so that it can be referred to henceforth
   * @param blue  the name of the blue component of the  image that needs to be stored in the
   *              variable so that it can be referred to henceforth
   */
  String splitIntoRGB(String scr, String red, String green, String blue);

  /**
   * Function to Combine the three greyscale images into a single image that gets its red, green and
   * blue components from the three images respectively.
   *
   * @param redImage   the red component of the image
   * @param greenImage the green component of the image
   * @param blueImage  the blue component of the image
   * @param dstname    name of the image that needs to be stored in the variable so that it can be
   *                   referred to henceforth
   */

  String combineRGBImages(String redImage, String greenImage, String blueImage, String dstname);

  /**
   * Function to blur the given image and store the result in another image with the given name.
   *
   * @param scr     the name of the image on which the operations needs to be performed
   * @param dstname the name of the image that needs to be stored in the variable so that it can be
   *                referred to henceforth
   */
  String blurImage(String scr, String dstname);

  /**
   * Function to sharpen the given image and store the result in another image with the given name.
   *
   * @param scr     the name of the image on which the operations needs to be performed
   * @param dstname the name of the image that needs to be stored in the variable so that it can be
   *                referred to henceforth
   */
  String sharpenImage(String scr, String dstname);

  /**
   * Function to produce a sepia-toned version of the given image and store the result in another
   * image with the given name.
   *
   * @param scr     the name of the image on which the operations needs to be performed
   * @param dstname the name of the image that needs to be stored in the variable so that it can be
   *                referred to henceforth
   */
  String convertToSepia(String scr, String dstname);

  /**
   * Function to produce a grey scale of the given image and store the result in another image with
   * the given name.
   *
   * @param scr     the name of the image on which the operations needs to be performed
   * @param dstname the name of the image that needs to be stored in the variable so that it can be
   *                referred to henceforth
   */
  String convertToGreyscale(String scr, String dstname);

  /**
   * Function to produce a compressed image by given percentage of the given image and store the
   * result in another image with the given name.
   *
   * @param compressionPercentage Percentage of compression needed.
   * @param srcKey                the name of the image on which the operations needs to be
   *                              performed
   * @param dstKey                the name of the image that needs to be stored in the variable so
   *                              that it can be referred to henceforth
   */

  String compressImage(String srcKey, String dstKey, int compressionPercentage);

  /**
   * Splits an image based on the specified method and percentage, and then applies Method Like
   * blur,Level Adjustment ect.
   *
   * @param srcKey     The name of the source image in the map.
   * @param dstKey     The name under which the processed image will be stored.
   * @param percentage The percentage of the image to be changed.
   * @param method     The method used for processing the image.
   * @return A string message indicating the success or failure of the operation.
   */

  String splitImage(String srcKey, String dstKey, int percentage, String method);

  /**
   * Splits an image based on the specified method and percentage, and then applies Method to
   * Adjusts the levels.
   *
   * @param srcKey     The name of the source image in the map.
   * @param dstKey     The name under which the processed image will be stored.
   * @param percentage The percentage of the image to be changed.
   * @param b          parameter for level adjustment.
   * @param m          parameter for level adjustment.
   * @param w          parameter for level adjustment.
   * @return A string message indicating the success or failure of the operation.
   */

  String splitImageLevel(String srcKey, String dstKey, int percentage, double b, double m,
      double w);

  /**
   * Creates a histogram image from the source image.
   *
   * @param srcKey The name of the source image in the map.
   * @param dstKey The name under which the histogram image will be stored.
   * @return A string message indicating the success of the histogram creation.
   */


  String createHistogram(String srcKey, String dstKey);

  /**
   * Corrects the histogram of the source image but aliening the peeks of the histograms of R,G,B
   * and stores the result.
   *
   * @param srcKey The name of the source image in the map.
   * @param dstKey The name under which the corrected histogram image will be stored.
   * @return A string message indicating the success of the histogram correction.
   */

  String correctHistogram(String srcKey, String dstKey);

  /**
   * Adjusts the levels of the source image using  parameters (b,m,w) and stores the result.
   *
   * @param srcKey The key of the source image in the map.
   * @param dstKey The key under which the adjusted image will be stored.
   * @param b      The 'b' parameter for level adjustment.
   * @param m      The 'm' parameter for level adjustment.
   * @param w      The 'w' parameter for level adjustment.
   * @return A string message indicating the success or failure of the level adjustment.
   */

  String adjustLevels(String srcKey, String dstKey, double b, double m, double w);

}
