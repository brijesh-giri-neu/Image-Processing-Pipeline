package model.imageflip;

/**
 * This abstract class defines the structure of an image flipper. It provides the method to flip an
 * image in a specified direction. Subclasses must implement the getNewCoordinates method to define
 * the logic for flipping.
 */

public abstract class ImageFlipperInterface implements ImageFlipInterface {

  /**
   * Function to get the new coordinates of the image after the operation.
   *
   * @param srcY   the y coordinate of original image
   * @param srcX   the x coordinate of the original image
   * @param height the height of the image
   * @param width  the width of the image
   * @return the array containing the new coordinates
   */
  abstract int[] getNewCoordinates(int srcY, int srcX, int height, int width);

  @Override
  public int[][][] flipImage(int[][][] srcImage, String direction) {
    int height = srcImage.length;
    int width = srcImage[0].length;
    int[][][] flippedImage = new int[height][width][3];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int[] newCoords = getNewCoordinates(y, x, height, width);
        flippedImage[newCoords[0]][newCoords[1]][0] = srcImage[y][x][0];
        flippedImage[newCoords[0]][newCoords[1]][1] = srcImage[y][x][1];
        flippedImage[newCoords[0]][newCoords[1]][2] = srcImage[y][x][2];
      }
    }
    return flippedImage;
  }
}
