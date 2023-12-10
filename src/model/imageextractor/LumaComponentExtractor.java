package model.imageextractor;

/**
 * This class is a concrete implementation of the ComponentExtractor for extracting the Luma
 * component from an image. It overrides the processPixel method to get the Luma component of each
 * pixel.
 */
public class LumaComponentExtractor extends ComponentExtractor {

  @Override
  protected int[] processPixel(int red, int green, int blue) {
    int luma = (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);
    return new int[]{luma, luma, luma};
  }
}