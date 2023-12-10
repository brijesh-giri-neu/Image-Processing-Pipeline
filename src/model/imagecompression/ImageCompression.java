package model.imagecompression;

/**
 * This class Implements ImageCompressionInterface interface and Implements an image compression
 * algorithm using the Haar wavelet transform.
 */
public class ImageCompression implements ImageCompressionInterface {

  private final double percentage;
  private final int[][][] image;

  /**
   * Constructor to initialize the compression with percentage and image.
   *
   * @param percentage The percentage of compression.
   * @param image      The original image.
   */

  public ImageCompression(double percentage, int[][][] image) {
    this.percentage = percentage;
    this.image = image;
  }

  @Override
  public int[][][] compressImage() {
    int height = image.length;
    int width = image[0].length;
    int channels = image[0][0].length;
    int[][][] newImage = new int[height][width][channels];

    int power = powerOfTwo(Math.max(width, height));
    double[][][] paddedImage = padding(image, power);

    for (int channel = 0; channel < channels; channel++) {
      double[][] eachChannel = new double[power][power];
      for (int i = 0; i < power; i++) {
        for (int j = 0; j < power; j++) {
          eachChannel[i][j] = paddedImage[i][j][channel];
        }
      }

      haarWaveletTransform(eachChannel);

      int percentage = (int) (power * power * (this.percentage / 100.0));
      makeCoefficientsZero(eachChannel, percentage);

      inverseHaarWaveletTransform(eachChannel);

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          newImage[i][j][channel] = (int) Math.max(0, Math.min(255, Math.round(eachChannel[i][j])));
        }
      }
    }

    return newImage;
  }

  private int powerOfTwo(int number) {
    int power = 1;
    while (power < number) {
      power *= 2;
    }
    return power;
  }

  private double[][][] padding(int[][][] originalImage, int newSize) {
    int height = originalImage.length;
    int width = originalImage[0].length;
    int channels = originalImage[0][0].length;
    double[][][] newImage = new double[newSize][newSize][channels];

    for (int i = 0; i < newSize; i++) {
      for (int j = 0; j < newSize; j++) {
        for (int k = 0; k < channels; k++) {
          if (i < height && j < width) {
            newImage[i][j][k] = originalImage[i][j][k];
          } else {
            newImage[i][j][k] = 0;
          }
        }
      }
    }

    return newImage;
  }

  private void makeCoefficientsZero(double[][] data, int numberOfCoefficientsToZero) {
    int size = data.length;
    for (int i = size - 1; i >= 0 && numberOfCoefficientsToZero > 0; i--) {
      for (int j = size - 1; j >= 0 && numberOfCoefficientsToZero > 0; j--) {
        data[i][j] = 0;
        numberOfCoefficientsToZero--;
      }
    }
  }

  private void haarWaveletTransform(double[][] data) {
    int size = data.length;
    while (size > 1) {
      for (int i = 0; i < size; i++) {
        transform(data[i], size);
      }
      for (int i = 0; i < size; i++) {
        double[] column = new double[size];
        for (int j = 0; j < size; j++) {
          column[j] = data[j][i];
        }
        transform(column, size);
        for (int j = 0; j < size; j++) {
          data[j][i] = column[j];
        }
      }
      size /= 2;
    }
  }

  private void inverseHaarWaveletTransform(double[][] data) {
    int size = 2;
    int maxSize = data.length;
    while (size <= maxSize) {
      for (int i = 0; i < size; i++) {
        double[] column = new double[maxSize];
        for (int j = 0; j < maxSize; j++) {
          column[j] = data[j][i];
        }
        inverseTransform(column, size);
        for (int j = 0; j < maxSize; j++) {
          data[j][i] = column[j];
        }
      }
      for (int i = 0; i < size; i++) {
        inverseTransform(data[i], size);
      }
      size *= 2;
    }
  }

  private void transform(double[] line, int size) {
    double[] temp = new double[size];
    int halfSize = size / 2;
    for (int i = 0; i < halfSize; i++) {
      temp[i] = (line[2 * i] + line[2 * i + 1]) / 2;
      temp[i + halfSize] = (line[2 * i] - line[2 * i + 1]) / 2;
    }
    System.arraycopy(temp, 0, line, 0, size);
  }

  private void inverseTransform(double[] line, int size) {
    double[] temp = new double[size];
    int halfSize = size / 2;
    for (int i = 0; i < halfSize; i++) {
      temp[2 * i] = line[i] + line[i + halfSize];
      temp[2 * i + 1] = line[i] - line[i + halfSize];
    }
    System.arraycopy(temp, 0, line, 0, size);
  }
}
