package model.imagechange;

/**
 * Interface for splitting an image and applying a conversion process to parts of it.
 */

public interface ImageSplit {

  /**
   * Performs a conversion operation on an image. The method is expected to modify a portion of the
   * image based on an internal criteria defined in the implementing class.
   *
   * @return A new 3D array representing the converted image after applying the split operation.
   */
  int[][][] convert();
}
