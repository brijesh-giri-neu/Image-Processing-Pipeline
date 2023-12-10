package commands;

import java.io.File;
import java.io.IOException;
import model.Model;
import controller.imagereader.DefaultImageReaderWriter;
import controller.imagereader.ImageReaderWriter;
import controller.imagereader.PPMImageReaderWriter;

/**
 * This class represents a command to load the image and interact with a Model object.
 */

public class LoadCommand implements CommandsInterface {


  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the argument list
   */
  public LoadCommand(String[] args) {
    this.args = args;
  }

  @Override
  public String advance(Model model) {
    if (args.length != 2) {
      return ("Invalid command" + "\n");
    }
    ImageReaderWriter imageReader;
    if (args[0].contains("/")) {
      String newpath = args[0].substring(0, args[0].lastIndexOf('/'));
      File file = new File(newpath);
      if (!file.isDirectory()) {
        return "The given path does not exists";
      }
    }
    File file = new File(args[0]);
    if (!file.exists()) {
      return "The file to be read does not exists";
    }
    String fileExtension = getFileExtension(args[0]);
    try {
      if ("ppm".equalsIgnoreCase(fileExtension)) {
        imageReader = new PPMImageReaderWriter();
      } else {
        imageReader = new DefaultImageReaderWriter();
      }
    } catch (Exception e) {
      return "The image type isn't supported by the application";
    }

    try {
      int[][][] image = imageReader.readImage(args[0]);
      model.putInMap(image, args[1]);
    } catch (IOException e) {
      return e.getMessage();
    }
    return "Image loaded: " + args[1] + "\n";
  }

  private String getFileExtension(String filename) {
    int index = filename.lastIndexOf('.');
    return index == -1 ? "" : filename.substring(index + 1);
  }
}
