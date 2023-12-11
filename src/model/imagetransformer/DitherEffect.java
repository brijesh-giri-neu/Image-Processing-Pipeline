package model.imagetransformer;

import model.imageextractor.ExtractorInterface;
import model.imageextractor.IntensityComponentExtractor;

/**
 * A class for the creating an effect of dithering on the image.
 */
public class DitherEffect implements ImageTransformer {

  @Override
  public int[][][] transformer(int[][][] image) {
    int height = image.length;
    int width = image[0].length;

    ExtractorInterface componentExtractor = new IntensityComponentExtractor();
    int[][][] grayscaleImage = componentExtractor.extractComponent(image);

    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        // Take pixel value of any channel. All three have same value for intensity component.
        int oldColor = grayscaleImage[r][c][0];
        // Pick whichever is closer. Black or white.
        int newColor = (oldColor < 128) ? 0 : 255;
        int errorFactor = oldColor - newColor;

        // Set current pixel to black or white.
        setPixelValue(grayscaleImage[r][c], newColor);

        // Error diffusion to neighboring pixels.
        distributeError(grayscaleImage, r, c, height, width, errorFactor);
      }
    }
    clampPixels(grayscaleImage, height, width);
    // Implement dithering logic in the grayscale intensityComponent image.
    return grayscaleImage;
  }

  private void setPixelValue(int[] pixel, int value) {
    pixel[0] = value;
    pixel[1] = value;
    pixel[2] = value;
  }

  private void distributeError(int[][][] image, int r, int c, int height, int width, int error) {
    // If right pixel exists.
    if (c + 1 < width) {
      addValueToPixel(image[r][c + 1], (7.0 * error) / 16.0);
    }
    // If next row exists.
    if (r + 1 < height) {
      // If left pixel exists.
      if (c - 1 >= 0) {
        addValueToPixel(image[r + 1][c - 1], (3.0 * error) / 16.0);
      }
      addValueToPixel(image[r + 1][c], (5.0 * error) / 16.0);
      // If right pixel exists.
      if (c + 1 < width) {
        addValueToPixel(image[r + 1][c + 1], (1.0 * error) / 16.0);
      }
    }
  }

  private void addValueToPixel(int[] pixel, double value) {
    pixel[0] += (int) value;
    pixel[1] += (int) value;
    pixel[2] += (int) value;
  }

  private void clampPixels(int[][][] image, int height, int width) {
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        image[r][c][0] = clamp(image[r][c][0]);
        image[r][c][1] = clamp(image[r][c][1]);
        image[r][c][2] = clamp(image[r][c][2]);
      }
    }
  }

  private int clamp(double value) {
    // Truncate float to int.
    return Math.min(255, Math.max(0, (int) value));
  }
}
