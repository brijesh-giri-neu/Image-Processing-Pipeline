package model.imagetransformer;

/**
 * A class for the creating an effect of blur on the image.
 */
public class BlurEffect extends Transformer {

  private static final float[][] fliterMatrix = {
      {1f / 16f, 1f / 8f, 1f / 16f},
      {1f / 8f, 1f / 4f, 1f / 8f},
      {1f / 16f, 1f / 8f, 1f / 16f}
  };

  /**
   * A constructor that initializes the matrix that would be used for creating the blur effect.
   */

  public BlurEffect() {
    super(fliterMatrix);
  }
}
