package controller;

import commands.BlueComponentCommand;
import commands.BlurCommand;
import commands.ColorCorrectCommand;
import commands.CommandsInterface;
import commands.CompressCommand;
import commands.DitherCommand;
import commands.GreenComponentCommand;
import commands.GreyscaleCommand;
import commands.HistogramCommand;
import commands.HorizontalFlipCommand;
import commands.LevelAdjustmentCommand;
import commands.LoadCommand;
import commands.LumaComponentCommand;
import commands.RedComponentCommand;
import commands.SaveCommand;
import commands.SepiaCommand;
import commands.SharpenCommand;
import commands.VerticalFlipCommand;
import model.Model;
import view.GUIViewInterface;


/**
 * This is a concrete class which is an implementation of the Feature Interface. This class
 * implements the methods defined in the Feature interface and provides the functionalities to the
 * GUI view of the program. It has functions such as to load the image, save the image and perform
 * various operations on the image.
 */
public class GUIController implements Feature {

  private final Model model;

  /**
   * The constructor to initialize the model object.
   *
   * @param model the model object
   */
  public GUIController(Model model) {
    this.model = model;
  }

  @Override
  public void setView(GUIViewInterface view) {
    view.addFeatures(this);
  }

  @Override
  public String loadImage(String[] arguments) {
    CommandsInterface command = new LoadCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String saveImage(String[] arguments) {
    CommandsInterface command = new SaveCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String componentImage(String[] arguments) {
    CommandsInterface commandsInterface;
    String color = arguments[0];
    String[] commandArgs = {arguments[1], arguments[2]};
    if (color.equalsIgnoreCase("red")) {
      commandsInterface = new RedComponentCommand(commandArgs);
    } else if (color.equalsIgnoreCase("green")) {
      commandsInterface = new GreenComponentCommand(commandArgs);
    } else {
      commandsInterface = new BlueComponentCommand(commandArgs);
    }
    return commandsInterface.advance(model);
  }

  @Override
  public String flipImage(String[] arguments) {
    CommandsInterface commandsInterface;
    String orientation = arguments[0];
    String[] commandArgs = {arguments[1], arguments[2]};
    if (orientation.equalsIgnoreCase("horizontal")) {
      commandsInterface = new HorizontalFlipCommand(commandArgs);
    } else {
      commandsInterface = new VerticalFlipCommand(commandArgs);
    }
    return commandsInterface.advance(model);
  }

  @Override
  public String blurImage(String[] arguments) {
    CommandsInterface command = new BlurCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String sharpenImage(String[] arguments) {
    CommandsInterface command = new SharpenCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String convertToGrayscaleLuma(String[] arguments) {
    CommandsInterface command = new LumaComponentCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String convertToGreyScale(String[] arguments) {
    CommandsInterface command = new GreyscaleCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String convertToSepiaTone(String[] arguments) {
    CommandsInterface command = new SepiaCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String compressImage(String[] arguments) {

    CommandsInterface command = new CompressCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String adjustLevels(String[] arguments) {
    CommandsInterface command = new LevelAdjustmentCommand(arguments);
    return command.advance(model);
  }

  @Override
  public String colorCorrect(String[] arguments) {
    CommandsInterface command = new ColorCorrectCommand(arguments);
    return command.advance(model);

  }

  @Override
  public String ditherImage(String[] arguments) {
    CommandsInterface command = new DitherCommand(arguments);
    return command.advance(model);
  }

  @Override
  public int[][][] getHistogram(String sourceImageName) {
    String[] arguments = {sourceImageName, "histogram"};
    CommandsInterface command = new HistogramCommand(arguments);
    String message = command.advance(model);
    if (message.contains("Histogram of the Image")) {
      return getImagePixels("histogram");
    }
    return null;
  }

  @Override
  public int[][][] getImagePixels(String imageName) {
    return (model.getFromMap(imageName));
  }
}
