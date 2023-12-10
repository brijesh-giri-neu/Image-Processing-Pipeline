package model.imageextractor;

/**
 * This class is a concrete implementation of the ComponentExtractor for extracting the Value
 * component from an image. It overrides the processPixel method to get the Value component of each
 * pixel.
 */
public class ValueComponentExtractor extends ComponentExtractor {

  @Override
  protected int[] processPixel(int red, int green, int blue) {
    int maxComponent = Math.max(red, Math.max(green, blue));
    return new int[]{maxComponent, maxComponent, maxComponent};
  }
}