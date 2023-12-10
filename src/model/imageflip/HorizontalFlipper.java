package model.imageflip;

/**
 * HorizontalFlipper is a concrete implementation of the ImageFlipperInterface that flips an image
 * horizontally.
 */
public class HorizontalFlipper extends ImageFlipperInterface {

  @Override
  int[] getNewCoordinates(int srcY, int srcX, int height, int width) {
    return new int[]{srcY, width - 1 - srcX};
  }
}