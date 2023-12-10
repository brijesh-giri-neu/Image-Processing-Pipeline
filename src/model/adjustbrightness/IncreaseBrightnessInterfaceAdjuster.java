package model.adjustbrightness;

/**
 * Concrete implementation of BrightnessAdjusterInterface that decreases the brightness of an
 * image.
 */
public class IncreaseBrightnessInterfaceAdjuster extends BrightnessAdjusterInterface {

  @Override
  int calculateAdjustedValue(int colorValue, int increment) {
    return Math.min(colorValue + increment, 255);
  }
}