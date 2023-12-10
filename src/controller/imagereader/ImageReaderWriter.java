package controller.imagereader;

import java.io.IOException;

/**
 * An interface for performing functions on various image types. It has functionalities to read and
 * save a particular image.
 */
public interface ImageReaderWriter {

  /**
   * Function to read an image as requested by the client.
   *
   * @param filename the complete filepath of an image that needs to read.
   * @return the image
   * @throws IOException if the particular image doesn't exists at the particular location
   */
  int[][][] readImage(String filename) throws IOException;

  /**
   * Function to save the image at the particular location.
   *
   * @param image    the name of the image that needs to be saved
   * @param path     the path where the image needs to be stored
   * @param filename the name by which the image needs to be stored
   * @param format   the format of the image that needs to be stored
   * @throws IOException if the particular image doesn't exists
   */
  void saveImage(int[][][] image, String path, String filename, String format) throws IOException;

}
