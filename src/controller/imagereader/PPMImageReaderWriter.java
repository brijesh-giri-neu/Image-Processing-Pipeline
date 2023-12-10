package controller.imagereader;

import java.io.IOException;

/**
 * An implementation of the interface ImageReaderWriter for the PPM image type. It performs the
 * function of reading the image and saving the image at the specified path.
 */
public class PPMImageReaderWriter implements ImageReaderWriter {

  @Override
  public int[][][] readImage(String filename) throws IOException {
    return ImageUtil.readPPM(filename);
  }

  @Override
  public void saveImage(int[][][] image, String path, String filename, String format)
      throws IOException {
    if (!path.equals("")) {
      ImageUtil.writePPM(image, path + "/" + filename);
    } else {
      ImageUtil.writePPM(image, filename);
    }
  }
}