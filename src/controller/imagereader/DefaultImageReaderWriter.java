package controller.imagereader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A class which is an implementation of ImageReaderWriter interface for the default image types
 * that we have. It performs various functions such as reading the image and saving the image on the
 * default image types.
 */

public class DefaultImageReaderWriter implements ImageReaderWriter {

  @Override
  public int[][][] readImage(String filename) throws IOException {
    String fileExtension = getFileExtension(filename);
    if ("png".equalsIgnoreCase(fileExtension) || "jpg".equalsIgnoreCase(fileExtension)) {
      BufferedImage image = ImageIO.read(new File(filename));
      int width = image.getWidth();
      int height = image.getHeight();
      int[][][] pixels = new int[height][width][3];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          Color color = new Color(image.getRGB(x, y));
          pixels[y][x][0] = color.getRed();
          pixels[y][x][1] = color.getGreen();
          pixels[y][x][2] = color.getBlue();
        }
      }
      return pixels;
    } else {
      throw new IOException("The image file isn't supported");
    }
  }

  @Override
  public void saveImage(int[][][] pixels, String path, String filename, String format)
      throws IOException {
    try {
      if (("png".equalsIgnoreCase(format) || "jpg".equalsIgnoreCase(format))) {

        int height = pixels.length;
        int width = pixels[0].length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
          for (int x = 0; x < width; x++) {
            int red = pixels[y][x][0];
            int green = pixels[y][x][1];
            int blue = pixels[y][x][2];
            Color color = new Color(red, green, blue);
            image.setRGB(x, y, color.getRGB());
          }
        }
        File directory;
        if (!path.equals("")) {
          directory = new File(path);
          if (!directory.exists()) {
            throw new IOException("The given path doesn't exists");

          } else {
            ImageIO.write(image, format, new File(directory, filename));
          }
        } else {
          ImageIO.write(image, format, new File(filename));
        }
      } else {
        throw new IOException("The file type isn't supported");
      }
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }

  private String getFileExtension(String filename) {
    int index = filename.lastIndexOf('.');
    return index == -1 ? "" : filename.substring(index + 1);
  }
}
