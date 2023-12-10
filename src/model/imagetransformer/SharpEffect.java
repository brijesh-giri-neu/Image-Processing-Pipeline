package model.imagetransformer;

/**
 * A class that can be used to sharpen the image provided.
 */
public class SharpEffect extends Transformer {

  private static final float[][] fliterMatrix = {
      {-1f / 8f, -1f / 8f, -1f / 8f, -1f / 8f, -1f / 8f},
      {-1f / 8f, 1f / 4f, 1f / 4f, 1f / 4f, -1f / 8f},
      {-1f / 8f, 1f / 4f, 1f, 1f / 4f, -1f / 8f},
      {-1f / 8f, 1f / 4f, 1f / 4f, 1f / 4f, -1f / 8f},
      {-1f / 8f, -1f / 8f, -1f / 8f, -1f / 8f, -1f / 8f}
  };

  /**
   * Constructor that is used to initialize the matrix to the appropriate matrix which can be used
   * to sharpen the image.
   */
  public SharpEffect() {
    super(fliterMatrix);
  }

}
