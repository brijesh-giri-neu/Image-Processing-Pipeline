package model.imagetransformer;

import model.imageextractor.ExtractorInterface;
import model.imageextractor.IntensityComponentExtractor;

/**
 * A class for the creating an effect of dithering on the image.
 */
public class DitherEffect implements ImageTransformer {

  @Override
  public int[][][] transformer(int[][][] image) {
    ExtractorInterface componentExtractor = new IntensityComponentExtractor();
    int[][][] intensityComponent = componentExtractor.extractComponent(image);

    // Implement dithering logic in the grayscale intensityComponent image.
    return intensityComponent;
  }
}
