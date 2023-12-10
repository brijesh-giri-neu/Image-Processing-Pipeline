package model.adjustbrightness;

/**
 * Concrete implementation of BrightnessAdjusterInterface that decreases the brightness of an
 * image.
 */
public class DecreaseBrightnessInterfaceAdjuster extends BrightnessAdjusterInterface {

  @Override
  int calculateAdjustedValue(int colorValue, int decrement) {
    return Math.max(colorValue + decrement, 0);
  }
}