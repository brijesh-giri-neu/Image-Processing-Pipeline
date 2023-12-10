package model.imagetransformer;

/**
 * This class is for converting an image into another form by performing operations as a result of
 * convolution between the pixel of the image and the kernel. The type of kernel that needs to be
 * used is decided by the client on the basis of the operation selected.
 */

public class Transformer implements ImageTransformer {

  private final float[][] fliterMatrix;

  /**
   * A constructor to initialize the matrix which will be used to perform transformation of the
   * image.
   *
   * @param fliterMatrix the Matrix that is used based on the given operations
   */
  public Transformer(float[][] fliterMatrix) {
    this.fliterMatrix = fliterMatrix;
  }

  /**
   * Function to perform the convolution operation on each pixel that is provided.
   *
   * @param x     the row of the matrix
   * @param y     the column of the matrix
   * @param image the image on which the operation needs to be performed
   * @return the convolution result of the operation on a given pixel
   */
  private int[] applyFilter(int x, int y, int[][][] image) {
    float sumRed = 0;
    float sumGreen = 0;
    float sumBlue = 0;

    for (int ky = -1; ky <= 1; ky++) {
      for (int kx = -1; kx <= 1; kx++) {
        int[] pixelColor = image[y + ky][x + kx];
        sumRed += pixelColor[0] * fliterMatrix[ky + 1][kx + 1];
        sumGreen += pixelColor[1] * fliterMatrix[ky + 1][kx + 1];
        sumBlue += pixelColor[2] * fliterMatrix[ky + 1][kx + 1];
      }
    }

    return new int[]{
        Math.min(Math.max((int) sumRed, 0), 255),
        Math.min(Math.max((int) sumGreen, 0), 255),
        Math.min(Math.max((int) sumBlue, 0), 255)
    };
  }

  @Override
  public int[][][] transformer(int[][][] image) {
    int width = image[0].length;
    int height = image.length;
    int[][][] transformedImage = new int[height][width][3];

    for (int y = 1; y < height - 1; y++) {
      for (int x = 1; x < width - 1; x++) {
        int[] transformedPixel = applyFilter(x, y, image);
        transformedImage[y][x] = transformedPixel;
      }
    }

    return transformedImage;
  }

}
