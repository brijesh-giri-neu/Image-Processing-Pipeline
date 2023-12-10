package model.imageextractor;

/**
 * This class is a concrete implementation of the ComponentExtractor for extracting the Red
 * component from an image. It overrides the processPixel method to get the Red component of each
 * pixel.
 */
public class RedComponentExtractor extends ComponentExtractor {

  @Override
  protected int[] processPixel(int red, int green, int blue) {
    return new int[]{red, 0, 0};
  }
}