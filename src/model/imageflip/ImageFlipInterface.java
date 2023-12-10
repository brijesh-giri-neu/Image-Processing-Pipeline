package model.imageflip;

/**
 * The ImageFlipInterface defines the contract for image flipping operations. Implementers of this
 * interface must provide an implementation for the flipImage method that flips an image in a
 * specified direction.
 */
public interface ImageFlipInterface {

  /**
   * Flips an image in the specified direction. Implementing classes will provide the specific logic
   * on how the image is flipped based on the direction parameter.
   *
   * @param srcImage  the source image.
   * @param direction the direction in which the image should be flipped.
   * @return a 3D array representing the flipped image.
   */
  int[][][] flipImage(int[][][] srcImage, String direction);
}
