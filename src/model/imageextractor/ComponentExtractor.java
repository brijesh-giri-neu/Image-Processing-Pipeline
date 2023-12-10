package model.imageextractor;

/**
 * This abstract class defines the structure of an image component extractor. Subclasses must
 * implement the processPixel method to define the extraction.
 */

public abstract class ComponentExtractor implements ExtractorInterface {

  protected abstract int[] processPixel(int red, int green, int blue);

  @Override
  public int[][][] extractComponent(int[][][] srcImage) {
    int height = srcImage.length;
    int width = srcImage[0].length;
    int[][][] componentImage = new int[height][width][3];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int[] rgb = srcImage[y][x];
        int[] processedPixel = processPixel(rgb[0], rgb[1], rgb[2]);
        System.arraycopy(processedPixel, 0, componentImage[y][x], 0, 3);
      }
    }
    return componentImage;
  }
}