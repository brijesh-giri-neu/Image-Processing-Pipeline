package model.imagetransformer;

/**
 * A class that can be used to create a greyscale effect on the image provided.
 */
public class GreyscaleEffect extends Converter {

  private static final float[][] filterMatrix = {
      {0.2126f, 0.7152f, 0.0722f},

      {0.2126f, 0.7152f, 0.0722f},

      {0.2126f, 0.7152f, 0.0722f}
  };

  /**
   * A constructor that initializes the matrix which can be used to provide the greyscale effect on
   * the image.
   */
  public GreyscaleEffect() {
    super(filterMatrix);
  }

}
