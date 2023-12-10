package model.imageextractor;

/**
 * This class is a concrete implementation of the ComponentExtractor for extracting the Intensity
 * component from an image. It overrides the processPixel method to get the Intensity component of
 * each pixel.
 */
public class IntensityComponentExtractor extends ComponentExtractor {

  @Override
  protected int[] processPixel(int red, int green, int blue) {
    int intensity = (red + green + blue) / 3;
    return new int[]{intensity, intensity, intensity};
  }
}
