package model.imagetransformer;

/**
 * An interface that helps in the transformation of the image to another form according to the
 * operation that needs to be done on the image.
 */
public interface ImageTransformer {

  /**
   * Transforms an image from one form to another form based on the user request.
   *
   * @param image the input image on which the operation needs to be performed on
   * @return the transformed image
   */
  int[][][] transformer(int[][][] image);

}
