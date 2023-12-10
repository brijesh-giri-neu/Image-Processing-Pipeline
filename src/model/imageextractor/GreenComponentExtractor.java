package model.imageextractor;

/**
 * This class is a concrete implementation of the ComponentExtractor for extracting the Green
 * component from an image. It overrides the processPixel method to get the Green component of each
 * pixel.
 */
public class GreenComponentExtractor extends ComponentExtractor {

  @Override
  protected int[] processPixel(int red, int green, int blue) {
    return new int[]{0, green, 0};
  }
}