package model.adjustbrightness;

/**
 * Abstract class that implements AdjustBrightnessInterface to provide a way of adjusting
 * brightness. Concrete implementations must define the method for calculating the adjusted
 * brightness value.
 */

public abstract class BrightnessAdjusterInterface implements AdjustBrightnessInterface {

  @Override
  public int[][][] adjustBrightness(int[][][] srcImage, int value) {
    int height = srcImage.length;
    int width = srcImage[0].length;
    int[][][] adjustedImage = new int[height][width][3];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        for (int c = 0; c < 3; c++) {
          adjustedImage[y][x][c] = calculateAdjustedValue(srcImage[y][x][c], value);
        }
      }
    }
    return adjustedImage;
  }

  abstract int calculateAdjustedValue(int colorValue, int adjustmentValue);
}