package model.imagetransformer;

/**
 * A class that is used to provide the sepia effect on the image provided.
 */
public class SepiaEffect extends Converter {

  private static final float[][] filterMatrix = {
      {0.393f, 0.769f, 0.189f},
      {0.349f, 0.686f, 0.168f},
      {0.272f, 0.534f, 0.131f}
  };

  /**
   * A constructor that initializes the appropriate filter that can be used to create the sepia
   * effect on the image.
   */
  public SepiaEffect() {
    super(filterMatrix);
  }
}
