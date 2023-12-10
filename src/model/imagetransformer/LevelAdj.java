package model.imagetransformer;

/**
 * This class implements ImageTransformer interface to perform level adjustments on an image. It
 * adjusts the brightness, tones, and contrast of an image based on the provided parameters.
 */

public class LevelAdj implements ImageTransformer {

  private final double b;
  private final double m;
  private final double w;

  /**
   * Constructs a LevelAdj transformer with b point, mid-tone, and w point.
   *
   * @param b the b point setting of the level adjustment.
   * @param m the mid level setting of the level adjustment.
   * @param w the w point setting of the level adjustment.
   */

  public LevelAdj(double b, double m, double w) {
    this.b = b;
    this.m = m;
    this.w = w;
  }

  @Override
  public int[][][] transformer(int[][][] image) {
    int width = image[0].length;
    int height = image.length;
    int[][][] transformedImage = new int[height][width][3];

    double[] coefficients = coefficientCalculations(b, m, w);
    double a = coefficients[0];
    double b_coefficient = coefficients[1];
    double c = coefficients[2];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        for (int channel = 0; channel < 3; channel++) {
          int originalValue = image[y][x][channel];
          int adjustedValue = adjustedValuesCalculation(originalValue, a, b_coefficient, c);
          transformedImage[y][x][channel] = adjustedValue;
        }
      }
    }
    return transformedImage;
  }

  private double[] coefficientCalculations(double b, double m, double w) {
    double aA = b * b * (m - w) - b * (m * m - w * w) + w * m * m - m * w * w;
    double aAA = -b * (128 - 255) + 128 * w - 255 * m;
    double aB = b * b * (128 - 255) + 255 * m * m - 128 * w * w;
    double aC = b * b * (255 * m - 128 * w) - b * (255 * m * m - 128 * w * w);
    double a = aAA / aA;
    double b_coefficient = aB / aA;
    double c = aC / aA;

    return new double[]{a, b_coefficient, c};
  }

  private int adjustedValuesCalculation(int originalValue, double a, double b, double c) {
    double newValue = a * Math.pow(originalValue, 2) + b * originalValue + c;

    newValue = Math.max(0, Math.min(255, newValue));

    return (int) Math.round(newValue);
  }

}
