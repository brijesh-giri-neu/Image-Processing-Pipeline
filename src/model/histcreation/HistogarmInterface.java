package model.histcreation;

/**
 * The interface is for creating histogram images.
 */


public interface HistogarmInterface {

  /**
   * Creates a 3D array values that can be converted into image. This method will analyze the color
   * intensity values of the image and produce a histogram image.
   *
   * @return A 3D array representing the histogram image for all three channels.
   */

  int[][][] createHistogramImage();
}
