package model.imageextractor;

/**
 * This class is a concrete implementation of the ComponentExtractor for extracting the blue
 * component from an image. It overrides the processPixel method to get the blue component of each
 * pixel.
 */

public class BlueComponentExtractor extends ComponentExtractor {

  @Override
  protected int[] processPixel(int red, int green, int blue) {
    return new int[]{0, 0, blue};
  }
}