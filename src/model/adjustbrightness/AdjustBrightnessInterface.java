package model.adjustbrightness;

/**
 * Interface for adjusting the brightness of an image.
 */

public interface AdjustBrightnessInterface {

  /**
   * Adjusts the brightness of the provided original image. This method should modify the brightness
   * of each pixel in the image by adding the specified value.
   *
   * @param srcImage The original image.
   * @param value    The value to adjust the brightness.
   * @return A 3D array representing the image after brightness adjustment.
   */
  int[][][] adjustBrightness(int[][][] srcImage, int value);
}
