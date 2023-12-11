package controller;

import model.Model;

/**
 * A mockModel Class that implements model and is used to test the controller.
 */
public class MockModel implements Model {

  private final int uniqueCode;
  private final StringBuilder log;

  public MockModel(StringBuilder log, int uniqueCode) {
    this.log = log;
    this.uniqueCode = uniqueCode;
  }

  private int toReturnOutput(int uniqueCode) {
    return this.uniqueCode;
  }

  @Override
  public String putInMap(int[][][] image, String imageName) {
    log.append("Input received - imageName: " + imageName);
    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " putInMap";
  }

  @Override
  public int[][][] getFromMap(String filename) {
    log.append("Input received - filename: " + filename);
    int[][][] ret = new int[1][1][1];
    ret[0][0][0] = uniqueCode;
    return ret;
  }


  @Override
  public String getComponentImage(String component, String name, String scr) {
    log.append("Input received - Component: " + component + ", Name: " + name + ", Src: " + scr);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " getComponent";
  }


  @Override
  public String flipImage(String direction, String name, String scr) {
    log.append("Input received - Direction: " + direction + ", Name: " + name + ", Src: " + scr);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " flipImage";
  }

  @Override
  public String adjustBrightness(int value, String name, String scr) {

    log.append("Input received - Value: " + value + ", Name: " + name + ", Src: " + scr);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " adjustBrightness";
  }

  @Override
  public String splitIntoRGB(String scr, String red, String green, String blue) {
    log.append(
        "Input received - Src: "
            + scr + ", Red: "
            + red + ", Green: "
            + green + ", Blue: " + blue);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " splitIntoRGB";
  }

  @Override
  public String combineRGBImages(String redImage, String greenImage, String blueImage,
      String dstname) {
    log.append(
        "Input received - RedImage: "
            + redImage + ", GreenImage: "
            + greenImage + ", BlueImage: "
            + blueImage + ", DstName: " + dstname);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " combineRGBImages";
  }

  @Override
  public String blurImage(String scr, String dstname) {

    log.append("Input received - Src: " + scr + ", DstName: " + dstname);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " blurImage";
  }

  @Override
  public String sharpenImage(String scr, String dstname) {

    log.append("Input received - Src: " + scr + ", DstName: " + dstname);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " sharpenImage";
  }

  @Override
  public String convertToSepia(String scr, String dstname) {

    log.append("Input received - Src: " + scr + ", DstName: " + dstname);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " convertToSepia";
  }

  @Override
  public String convertToGreyscale(String scr, String dstname) {

    log.append("Input received - Src: " + scr + ", DstName: " + dstname);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " convertToGreyscale";
  }

  @Override
  public String compressImage(String srcKey, String dstKey, int compressionPercentage) {
    log.append("Input received - Src: " + srcKey + ", DstName: " + dstKey);
    if (compressionPercentage < 0 || compressionPercentage > 100) {
      log.append(" wrong compressionPercentage");
    }
    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " compression";
  }

  @Override
  public String splitImage(String srcKey, String dstKey, int percentage, String method) {
    log.append("Input received - Src: " + srcKey + ", DstName: " + dstKey + ", Method: " + method);

    if (percentage < 0 || percentage > 100) {
      log.append(" wrong percentage");
    }
    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " splitImage";
  }

  @Override
  public String splitImageLevel(String srcKey, String dstKey, int percentage,
      double b, double m, double w) {
    log.append("Input received - Src: " + srcKey + ", DstName: " + dstKey + ", Method: Level-Adj");
    if (b < 0 || b > 255) {
      log.append("Incorrect value entered for b. Please enter again");
    }

    if (m < 0 || m > 255 || m < b) {
      log.append("Incorrect value entered for m. Please enter again");
    }

    if (w < 0 || w > 255 || w < b || w < m) {
      log.append("Incorrect value entered for w. Please enter again");
    }
    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " splitImageLevel";
  }


  @Override
  public String createHistogram(String srcKey, String dstKey) {
    log.append("Input received - Src: " + srcKey + ", DstName: " + dstKey);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " createHistogram";
  }

  @Override
  public String correctHistogram(String srcKey, String dstKey) {
    log.append("Input received - Src: " + srcKey + ", DstName: " + dstKey);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " correctHistogram";
  }

  @Override
  public String adjustLevels(String srcKey, String dstKey, double b, double m, double w) {
    log.append("Input received - Src: " + srcKey + ", DstName: " + dstKey);

    if (b < 0 || b > 255) {
      log.append("Incorrect value entered for b. Please enter again");
    }

    if (m < 0 || m > 255 || m < b) {
      log.append("Incorrect value entered for m. Please enter again");
    }

    if (w < 0 || w > 255 || w < b || w < m) {
      log.append("Incorrect value entered for w. Please enter again");
    }

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " adjustLevels";
  }

  @Override
  public String ditherImage(String scr, String dstname) {
    log.append("Input received - Src: " + scr + ", DstName: " + dstname);

    String uniqueCodeString = Integer.toString(uniqueCode);
    return uniqueCodeString + " ditherImage";
  }
}
