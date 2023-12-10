package model.imagechange;

import model.imagetransformer.BlurEffect;
import model.imagetransformer.CorrectHist;
import model.imagetransformer.GreyscaleEffect;
import model.imagetransformer.ImageTransformer;
import model.imagetransformer.LevelAdj;
import model.imagetransformer.SepiaEffect;
import model.imagetransformer.SharpEffect;

/**
 * This class implements ImageSplit interface and  provide various image processing capabilities
 * such as blurring, sharpening, applying sepia tone, converting to greyscale, adjusting levels, and
 * color correction.
 */

public class ImageProcessor implements ImageSplit {

  private final int[][][] image;
  private final int percentage;
  private final String method;
  private double b;
  private double m;
  private double w;

  /**
   * Constructor to initialize the image processor.
   *
   * @param image      The original image.
   * @param percentage The percentage of the image width to apply the transformation.
   * @param method     The method of image transformation.
   * @param b          The value for the level adjustment 'b'.
   * @param m          The value for the level adjustment 'm'.
   * @param w          The value for the level adjustment 'w'.
   */
  public ImageProcessor(int[][][] image, int percentage, String method, double b, double m,
      double w) {
    this.image = image;
    this.percentage = percentage;
    this.method = method;
    this.b = b;
    this.m = m;
    this.w = w;

  }

  /**
   * Overloaded constructor to initialize the image processor with transformations that do not
   * require level adjustment parameters.
   *
   * @param image      The original image.
   * @param percentage The percentage of the image width to apply the transformation.
   * @param method     The method of image transformation.
   */

  public ImageProcessor(int[][][] image, int percentage, String method) {
    this.image = image;
    this.percentage = percentage;
    this.method = method;
  }


  @Override
  public int[][][] convert() {
    int height = image.length;
    int width = image[0].length;
    ImageTransformer imageTransformer = null;

    if ("blur".equalsIgnoreCase(method)) {
      imageTransformer = new BlurEffect();
    }
    if ("sharpen".equalsIgnoreCase(method)) {
      imageTransformer = new SharpEffect();
    }
    if ("sepia".equalsIgnoreCase(method)) {
      imageTransformer = new SepiaEffect();
    }
    if ("greyscale".equalsIgnoreCase(method)) {
      imageTransformer = new GreyscaleEffect();
    }
    if ("leveladj".equalsIgnoreCase(method)) {
      imageTransformer = new LevelAdj(b, m, w);
    }
    if ("color-correct".equalsIgnoreCase(method)) {
      imageTransformer = new CorrectHist();
    }

    int[][][] changedImage = imageTransformer.transformer(image);

    int pos = width * percentage / 100;

    int[][][] combinedImage = new int[height][width][3];

    for (int y = 0; y < height; y++) {
      if (pos >= 0) {
        System.arraycopy(changedImage[y], 0, combinedImage[y], 0, pos);
      }
    }

    for (int y = 0; y < height; y++) {
      if (width - pos >= 0) {
        System.arraycopy(image[y], pos, combinedImage[y], pos, width - pos);
      }
    }
    return combinedImage;
  }
}
