package model;

import java.util.HashMap;
import java.util.Map;
import model.adjustbrightness.BrightnessAdjusterInterface;
import model.adjustbrightness.DecreaseBrightnessInterfaceAdjuster;
import model.adjustbrightness.IncreaseBrightnessInterfaceAdjuster;
import model.histcreation.Histogram;
import model.imagechange.ImageProcessor;
import model.imagecompression.ImageCompression;
import model.imageextractor.BlueComponentExtractor;
import model.imageextractor.ExtractorInterface;
import model.imageextractor.GreenComponentExtractor;
import model.imageextractor.IntensityComponentExtractor;
import model.imageextractor.LumaComponentExtractor;
import model.imageextractor.RedComponentExtractor;
import model.imageextractor.ValueComponentExtractor;
import model.imageflip.HorizontalFlipper;
import model.imageflip.ImageFlipInterface;
import model.imageflip.VerticalFlipper;
import model.imagetransformer.BlurEffect;
import model.imagetransformer.CorrectHist;
import model.imagetransformer.GreyscaleEffect;
import model.imagetransformer.ImageTransformer;
import model.imagetransformer.LevelAdj;
import model.imagetransformer.SepiaEffect;
import model.imagetransformer.SharpEffect;


/**
 * An implementation of the Model interface which represents an image application. It has
 * functionalities to load the image, to perform various operations on the image such as brighten
 * the image, split it into components, etc and then save the image.
 */
public class ModelImp implements Model {

  private final Map<String, int[][][]> images;

  private ModelImp() {
    images = new HashMap<>();
  }

  /**
   * A method for creating an object of the builder class.
   *
   * @return the object of the builder
   */
  public static Builder getBuilder() {
    return new Builder();
  }

  @Override
  public int[][][] getFromMap(String fileName) {
    int[][][] image;
    if (checkIfExists(fileName)) {
      image = images.get(fileName);
      return image;
    } else {
      return null;
    }
  }

  @Override
  public String putInMap(int[][][] image, String imageName) {
    try {
      images.put(imageName, image);
      return "Successful";
    } catch (Exception e) {
      return "Error loading the image";
    }

  }

  @Override
  public String getComponentImage(String component, String dstname, String src) {
    boolean check = checkIfExists(src);
    if (!check) {
      return "The image doesn't exist in the map. Please load the image first";
    }

    int[][][] srcImage = images.get(src);
    ExtractorInterface extractor;

    switch (component.toLowerCase()) {
      case "red":
        extractor = new RedComponentExtractor();
        break;
      case "green":
        extractor = new GreenComponentExtractor();
        break;
      case "blue":
        extractor = new BlueComponentExtractor();
        break;
      case "value":
        extractor = new ValueComponentExtractor();
        break;
      case "intensity":
        extractor = new IntensityComponentExtractor();
        break;
      case "luma":
        extractor = new LumaComponentExtractor();
        break;
      default:
        return "Invalid component type: " + component;
    }

    int[][][] componentImage = extractor.extractComponent(srcImage);

    images.put(dstname, componentImage);
    return "Successful";
  }

  @Override
  public String flipImage(String direction, String dstname, String src) {
    boolean check = checkIfExists(src);
    if (!check) {
      return "The image doesn't exist in the map. Please load the image first";
    }

    int[][][] srcImage = images.get(src);
    ImageFlipInterface flipper;
    if ("horizontal".equalsIgnoreCase(direction)) {
      flipper = new HorizontalFlipper();
    } else if ("vertical".equalsIgnoreCase(direction)) {
      flipper = new VerticalFlipper();
    } else {
      return "Invalid direction. Please specify 'horizontal' or 'vertical'.";
    }

    int[][][] flippedImage = flipper.flipImage(srcImage, direction);

    images.put(dstname, flippedImage);
    return "Successful";
  }

  @Override
  public String adjustBrightness(int value, String dstname, String src) {
    boolean check = checkIfExists(src);
    if (!check) {
      return "The image doesn't exist in the map. Please load the image first";
    }

    int[][][] srcImage = images.get(src);
    int[][][] adjustedImage;

    BrightnessAdjusterInterface brightnessAdjuster;
    if (value >= 0) {
      brightnessAdjuster = new IncreaseBrightnessInterfaceAdjuster();
    } else {
      brightnessAdjuster = new DecreaseBrightnessInterfaceAdjuster();
    }

    adjustedImage = brightnessAdjuster.adjustBrightness(srcImage, value);

    images.put(dstname, adjustedImage);
    return "Successful";
  }

  @Override
  public String splitIntoRGB(String src, String redKey, String greenKey, String blueKey) {
    boolean check = checkIfExists(src);
    if (!check) {
      return "The image doesn't exists in the map. Please load the image first";
    }
    int[][][] srcImage = images.get(src);
    int height = srcImage.length;
    int width = srcImage[0].length;

    Map<String, int[][][]> rgbImages = new HashMap<>();
    rgbImages.put(redKey, new int[height][width][3]);
    rgbImages.put(greenKey, new int[height][width][3]);
    rgbImages.put(blueKey, new int[height][width][3]);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        rgbImages.get(redKey)[y][x][0] = srcImage[y][x][0];
        rgbImages.get(greenKey)[y][x][1] = srcImage[y][x][1];
        rgbImages.get(blueKey)[y][x][2] = srcImage[y][x][2];
      }
    }

    images.put(redKey, rgbImages.get(redKey));
    images.put(greenKey, rgbImages.get(greenKey));
    images.put(blueKey, rgbImages.get(blueKey));
    return "Successful";

  }

  @Override
  public String combineRGBImages(String redKey, String greenKey, String blueKey, String dstKey) {
    boolean checkgreen = checkIfExists(greenKey);
    boolean checkblue = checkIfExists(blueKey);
    boolean checkred = checkIfExists(redKey);

    if (!checkgreen || !checkblue || !checkred) {
      return "The image doesn't exists in the map. Please load the image first";
    }
    int[][][] redImage = images.get(redKey);
    int[][][] greenImage = images.get(greenKey);
    int[][][] blueImage = images.get(blueKey);

    int height = redImage.length;
    int width = redImage[0].length;

    int[][][] combinedImage = new int[height][width][3];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        combinedImage[y][x][0] = redImage[y][x][0];
        combinedImage[y][x][1] = greenImage[y][x][1];
        combinedImage[y][x][2] = blueImage[y][x][2];
      }
    }

    images.put(dstKey, combinedImage);
    return "Successful";

  }

  @Override
  public String blurImage(String srcKey, String dstKey) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exists in the map. Please load the image first";
    }

    ImageTransformer imageTransformer = new BlurEffect();

    int[][][] image = images.get(srcKey);
    int[][][] blurredImage = imageTransformer.transformer(image);
    images.put(dstKey, blurredImage);
    return "Successful";

  }

  @Override
  public String sharpenImage(String srcKey, String dstKey) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exists in the map. Please load the image first";
    }

    ImageTransformer imageTransformer = new SharpEffect();

    int[][][] image = images.get(srcKey);

    int[][][] sharpenedImage = imageTransformer.transformer(image);

    images.put(dstKey, sharpenedImage);
    return "Successful";


  }

  @Override
  public String convertToSepia(String srcKey, String dstKey) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exists in the map. Please load the image first";
    }
    int[][][] image = images.get(srcKey);
    int[][][] sepiaImage;

    ImageTransformer imageTransformer = new SepiaEffect();
    sepiaImage = imageTransformer.transformer(image);

    images.put(dstKey, sepiaImage);
    return "Successful";


  }

  @Override
  public String convertToGreyscale(String srcKey, String dstKey) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exists in the map. Please load the image first";
    }
    int[][][] image = images.get(srcKey);
    int width = image[0].length;
    int height = image.length;
    int[][][] greyscaleImage;

    ImageTransformer imageTransformer = new GreyscaleEffect();
    greyscaleImage = imageTransformer.transformer(image);

    images.put(dstKey, greyscaleImage);
    return "Successful";


  }

  @Override
  public String compressImage(String srcKey, String dstKey, int compressionPercentage) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exists in the map. Please load the image first";
    }

    if (compressionPercentage < 0 || compressionPercentage > 100) {
      return "The compression percentage should be between 0-100 only";
    }
    int[][][] image = images.get(srcKey);
    int width = image[0].length;
    int height = image.length;

    ImageCompression imageCompression = new ImageCompression(compressionPercentage, image);

    int[][][] compressedImage = imageCompression.compressImage();

    images.put(dstKey, compressedImage);
    return "Successful";
  }

  @Override
  public String adjustLevels(String srcKey, String dstKey, double b, double m, double w) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exist in the map. Please load the image first";
    }

    if (b < 0 || b > 255) {
      return "Incorrect value entered for b. Please enter again";
    }

    if (m < 0 || m > 255 || m < b) {
      return "Incorrect value entered for m. Please enter again";
    }

    if (w < 0 || w > 255 || w < b || w < m) {
      return "Incorrect value entered for w. Please enter again";
    }

    int[][][] srcImage = images.get(srcKey);

    ImageTransformer levelAdjuster = new LevelAdj(b, m, w);

    int[][][] adjustedImage = levelAdjuster.transformer(srcImage);

    images.put(dstKey, adjustedImage);

    return "Successful";
  }

  @Override
  public String splitImage(String srcKey, String dstKey, int percentage, String method) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exist in the map. Please load the image first";
    }
    if (percentage < 0 || percentage > 100) {
      return "The percentage value is incorrect.";
    }
    ImageProcessor imageProcessor;
    int[][][] srcImage = images.get(srcKey);
    imageProcessor = new ImageProcessor(srcImage, percentage, method);
    int[][][] processedImage = imageProcessor.convert();

    if (processedImage == null) {
      return "Wrong method given";
    }

    images.put(dstKey, processedImage);
    return "Successful";
  }

  @Override
  public String splitImageLevel(String srcKey, String dstKey, int percentage, double b, double m,
      double w) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exist in the map. Please load the image first";
    }
    if (percentage < 0 || percentage > 100) {
      return "The percentage value is incorrect.";
    }
    if (b < 0 || b > 255) {
      return "Incorrect value entered for b. Please enter again";
    }

    if (m < 0 || m > 255 || m < b) {
      return "Incorrect value entered for m. Please enter again";
    }

    if (w < 0 || w > 255 || w < b || w < m) {
      return "Incorrect value entered for w. Please enter again";
    }
    ImageProcessor imageProcessor;
    int[][][] srcImage = images.get(srcKey);
    imageProcessor = new ImageProcessor(srcImage, percentage, "leveladj", b, m, w);
    int[][][] processedImage = imageProcessor.convert();

    if (processedImage == null) {
      return "Wrong method given";
    }

    images.put(dstKey, processedImage);
    return "Successful";
  }

  @Override
  public String createHistogram(String srcKey, String dstKey) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exist in the map. Please load the image first";
    }

    int[][][] srcImage = images.get(srcKey);
    Histogram histogram = new Histogram(srcImage);
    int[][][] histogramImage = histogram.createHistogramImage();

    images.put(dstKey, histogramImage);
    return "Successful";
  }

  @Override
  public String correctHistogram(String srcKey, String dstKey) {
    boolean check = checkIfExists(srcKey);
    if (!check) {
      return "The image doesn't exists in the map. Please load the image first";
    }

    ImageTransformer imageTransformer = new CorrectHist();

    int[][][] image = images.get(srcKey);
    int[][][] correctHist = imageTransformer.transformer(image);
    images.put(dstKey, correctHist);
    return "Successful";
  }

  private boolean checkIfExists(String src) {
    return images.get(src) != null;
  }

  /**
   * Method for creating an object of the class so that it cannot be changed once created.
   */

  public static class Builder {

    /**
     * Method to create an object of the class ModelImp.
     *
     * @return the object of the class ModelImp
     */
    public ModelImp build() {
      return new ModelImp();
    }
  }
}
