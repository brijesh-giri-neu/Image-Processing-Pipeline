package model.imagecompression;

/**
 * Interface for doing a for image compression.
 */

public interface ImageCompressionInterface {

  /**
   * Compresses an image according to the Haar compression algorithm. Implementations of this method
   * should reduce the size of the image data.
   *
   * @return A new 3D array of color intensity values representing the compressed image.
   */

  int[][][] compressImage();
}
