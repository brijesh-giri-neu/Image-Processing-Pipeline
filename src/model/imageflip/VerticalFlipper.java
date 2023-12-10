package model.imageflip;

/**
 * VerticalFlipper is a concrete implementation of the ImageFlipperInterface that flips an image
 * vertically.
 */

public class VerticalFlipper extends ImageFlipperInterface {

  int[] getNewCoordinates(int srcY, int srcX, int height, int width) {
    return new int[]{height - 1 - srcY, srcX};
  }
}