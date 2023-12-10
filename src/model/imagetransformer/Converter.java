package model.imagetransformer;

/**
 * This class is for converting an image into another form by performing operations on all the pixel
 * of the image. The type of effect that needs to be associated with the image is decided by the
 * client.
 */

public class Converter implements ImageTransformer {

  private final float[][] filterMatrix;

  /**
   * A constructor to initialize the filter matrix which will be used to perform transformation on
   * all the pixels of the given image.
   *
   * @param filterMatrix the filtermatrix that is used based on the given operations
   */
  public Converter(float[][] filterMatrix) {
    this.filterMatrix = filterMatrix;
  }

  @Override
  public int[][][] transformer(int[][][] image) {
    int width = image[0].length;
    int height = image.length;
    int[][][] transformedImage = matmul(width, height, image);

    return transformedImage;
  }

  /**
   * Function to transform the image by multiplying each and every pixel with the given filter and
   * return the output.
   *
   * @param width  the width of the image
   * @param height the height of the image
   * @param image  the actual image on which the operation needs to be performed on
   * @return the transformed image
   */
  private int[][][] matmul(int width, int height, int[][][] image) {

    int[][][] newImage = new int[height][width][3];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int[] color = image[y][x];

        int red = color[0];
        int green = color[1];
        int blue = color[2];

        int newRed = (int) Math.min(255,
            filterMatrix[0][0] * red + filterMatrix[0][1] * green + filterMatrix[0][2] * blue);
        int newGreen = (int) Math.min(255,
            filterMatrix[1][0] * red + filterMatrix[1][1] * green + filterMatrix[1][2] * blue);
        int newBlue = (int) Math.min(255,
            filterMatrix[2][0] * red + filterMatrix[2][1] * green + filterMatrix[2][2] * blue);

        newImage[y][x][0] = newRed;
        newImage[y][x][1] = newGreen;
        newImage[y][x][2] = newBlue;
      }
    }
    return newImage;

  }
}
