package model.imageextractor;

/**
 * This interface is used to extract a particular component of the image by using the method extract
 * component.
 */
public interface ExtractorInterface {

  /**
   * Method that extracts the component of the image as requested by the user/client.
   *
   * @param srcImage the original image
   * @return the new image that has the extracted component
   */
  int[][][] extractComponent(int[][][] srcImage);
}
