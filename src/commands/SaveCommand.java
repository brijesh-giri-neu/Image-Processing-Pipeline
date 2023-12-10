package commands;

import java.io.File;
import model.Model;
import controller.imagereader.DefaultImageReaderWriter;
import controller.imagereader.ImageReaderWriter;
import controller.imagereader.PPMImageReaderWriter;

/**
 * This class represents a command to save the image and interact with a Model object.
 */

public class SaveCommand implements CommandsInterface {

  private final String[] args;

  /**
   * Constructor to initialize the values to the variable.
   *
   * @param args the arguement list
   */
  public SaveCommand(String[] args) {
    this.args = args;
  }


  @Override
  public String advance(Model model) {
    String message;
    if (args.length != 2) {
      return ("Invalid command" + "\n");
    }

    String directory;
    String filenameWithExtension;
    String format;
    if (args[0].lastIndexOf('/') > 0) {
      directory = args[0].substring(0, args[0].lastIndexOf('/'));
      File file = new File(directory);
      if (!file.isDirectory()) {
        return ("The given file path does not exists \n");
      }
      filenameWithExtension = args[0].substring(args[0].lastIndexOf('/') + 1);

    } else {
      directory = "";
      filenameWithExtension = args[0];
    }
    format = filenameWithExtension.substring(filenameWithExtension.lastIndexOf('.') + 1);
    message = saveImage(model, directory, args[1], format, filenameWithExtension);
    if (!message.equalsIgnoreCase("Successful")) {
      return (message);
    }
    return ("Image saved: " + filenameWithExtension + "\n");
  }


  private String saveImage(Model model, String path, String filename, String format,
      String dstname) {
    ImageReaderWriter imageWriter;
    try {
      if ("ppm".equalsIgnoreCase(format)) {
        imageWriter = new PPMImageReaderWriter();
      } else {
        imageWriter = new DefaultImageReaderWriter();
      }
    } catch (Exception e) {
      return "The image type isn't supported by the application";
    }

    try {
      int[][][] imageToSave = model.getFromMap(filename);
      if (imageToSave != null) {
        imageWriter.saveImage(imageToSave, path, dstname, format);
        return "Successful";
      } else {
        return "Image not found ";
      }
    } catch (Exception e) {
      return "Failed to save the image: " + e.getMessage();
    }
  }
}
