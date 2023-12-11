package controller;

import commands.BlueComponentCommand;
import commands.BlurCommand;
import commands.BrightenCommand;
import commands.ColorCorrectCommand;
import commands.CommandsInterface;

import commands.CompressCommand;
import commands.DitherCommand;
import commands.GreenComponentCommand;
import commands.GreyscaleCommand;
import commands.HistogramCommand;
import commands.HorizontalFlipCommand;
import commands.IntensityComponentCommand;
import commands.LevelAdjustmentCommand;
import commands.LoadCommand;
import commands.LumaComponentCommand;
import commands.RGBCombineCommand;
import commands.RGBSplitCommand;
import commands.RedComponentCommand;
import commands.SaveCommand;
import commands.SepiaCommand;
import commands.SharpenCommand;
import commands.ValueComponentCommand;
import commands.VerticalFlipCommand;
import java.util.HashMap;
import java.util.Map;

/**
 * This class maps the command names to their respective implementations of the CommandsInterface
 * interface thereby providing a convenient way to retrieve a specific command based on its name.
 */
public class MapCommands {

  private final Map<String, CommandsInterface> commandMap = new HashMap<>();

  /**
   * Constructor to initialize the command map with supported commands.
   *
   * @param args The command-line arguments needed to execute the command successfully.
   */
  public MapCommands(String[] args) {
    commandMap.put("load", new LoadCommand(args));
    commandMap.put("brighten", new BrightenCommand(args));
    commandMap.put("vertical-flip", new VerticalFlipCommand(args));
    commandMap.put("horizontal-flip", new HorizontalFlipCommand(args));
    commandMap.put("value-component", new ValueComponentCommand(args));
    commandMap.put("intensity-component", new IntensityComponentCommand(args));
    commandMap.put("luma-component", new LumaComponentCommand(args));
    commandMap.put("red-component", new RedComponentCommand(args));
    commandMap.put("green-component", new GreenComponentCommand(args));
    commandMap.put("blue-component", new BlueComponentCommand(args));
    commandMap.put("save", new SaveCommand(args));
    commandMap.put("rgb-split", new RGBSplitCommand(args));
    commandMap.put("rgb-combine", new RGBCombineCommand(args));
    commandMap.put("sepia", new SepiaCommand(args));
    commandMap.put("blur", new BlurCommand(args));
    commandMap.put("sharpen", new SharpenCommand(args));
    commandMap.put("compress", new CompressCommand(args));
    commandMap.put("histogram", new HistogramCommand(args));
    commandMap.put("color-correct", new ColorCorrectCommand(args));
    commandMap.put("levels-adjust", new LevelAdjustmentCommand(args));
    commandMap.put("greyscale", new GreyscaleCommand(args));
    // Added Dithering
    commandMap.put("dither", new DitherCommand(args));
  }

  /**
   * Method to get the command implementation for the specified command name.
   *
   * @param operation The name of the command.
   * @return The CommandsInterface implementation for the specified command name.
   */

  public CommandsInterface getCommand(String operation) {
    return commandMap.get(operation);
  }

}
