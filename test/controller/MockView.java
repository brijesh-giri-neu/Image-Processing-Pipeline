package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.GUIViewInterface;

/**
 * A mock view class for testing the controller.
 */
public class MockView extends JFrame implements ActionListener, GUIViewInterface {

  private final StringBuilder log;
  private final int uniqueCode;
  private Feature feature;
  private String string;

  /**
   * Constructor of the mock view.
   *
   * @param log        the logger
   * @param uniqueCode the unique code
   * @param feature    the feature associated with the view
   */
  public MockView(StringBuilder log, int uniqueCode, Feature feature) {
    this.log = log;
    this.uniqueCode = uniqueCode;
    this.feature = feature;
  }

  /**
   * Constructor of the mock view.
   *
   * @param log        the logger
   * @param uniqueCode the unique code
   * @param feature    the feature
   * @param string     the string associated with it
   */
  public MockView(StringBuilder log, int uniqueCode, Feature feature, String string) {
    this.log = log;
    this.uniqueCode = uniqueCode;
    this.feature = feature;
    this.string = string;
  }

  @Override
  public void addFeatures(Feature feature) {
    this.feature = feature;
  }

  @Override
  public void showErrorMessage(String message) {
    String message1 = message;
  }

  private void method(String string) {
    this.string = string;
  }

  private void setImageIcon() {
    log.append("setImageIcon called with uniqueCode: ").append(uniqueCode);
    updateImageDisplay();
  }

  private void setHistogramIcon() {
    log.append("setHistogramIcon called with uniqueCode: ").append(uniqueCode);
    updateHistogramDisplay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Load Image":
        System.out.println("load Image");
        loadImage();
        break;
      case "Save Image":
        saveImage();
        break;
      case "Red Component":
        componentImage("red");
        break;
      case "Green Component":
        componentImage("green");
        break;
      case "Blue Component":
        componentImage("blue");
        break;
      case "Flip Image Vertically":
        flipImage("vertical");
        break;
      case "Flip Image Horizontally":
        flipImage("horizontal");
        break;
      case "Blur Image":
        blurImage();
        break;
      case "Sharpen Image":
        sharpenImage();
        break;
      case "Convert to Grayscale (Luma)":
        convertToGrayscaleLuma();
        break;
      case "Convert to Sepia Tone":
        convertToSepiaTone();
        break;
      case "Compress Image":
        compressImage();
        break;
      case "Adjust Levels":
        adjustLevels();
        break;
      case "Color Correct":
        colorCorrect();
        break;
      case "Split View":
        openSplitViewWindow(string);
        break;
      case "Dither Image":
        ditherImage();
        break;
      default:
        break;
    }
  }

  private void displayMessage(String message) {
    log.append("displayMessage called with message: ").append(message)
        .append(" and uniqueCode: ").append(uniqueCode);
    updateStatusMessage(message);
  }

  private void setMenuItemsToTrue() {
    log.append("setMenuItemsToTrue called with uniqueCode: ").append(uniqueCode);
    enableMenuItems();
  }


  private String getLog() {
    return log.toString();
  }

  private void updateImageDisplay() {
    log.append("updateImageDisplay called with imageIcon and uniqueCode: ").append(uniqueCode);
  }

  private void updateHistogramDisplay() {
    log.append("updateHistogramDisplay called with "
        + "histogramIcon and uniqueCode: ").append(uniqueCode);
  }

  private void updateStatusMessage(String message) {
    log.append("updateStatusMessage "
        + "called with message: ").append(message).append(" "
        + "and uniqueCode: ").append(uniqueCode);
  }

  private void enableMenuItems() {
    log.append("enableMenuItems called with uniqueCode: ").append(uniqueCode);
  }

  private void showSplitViewDialog() {
    log.append("showSplitViewDialog called with uniqueCode: ").append(uniqueCode);
  }

  private void loadImage() {

    log.append("loadImage called with uniqueCode: ").append(uniqueCode);
    String[] args = {"vertical", "imageName", "imageNameS"};
  }

  private void saveImage() {
    log.append("saveImage called with path: ").append(" and uniqueCode: ").append(uniqueCode);
  }

  private void applyImageOperation(String operation) {
    log.append("applyImageOperation called"
        + " with operation: ").append(operation).append(" "
        + "and uniqueCode: ").append(uniqueCode);
  }

  private void updateOperationStatus(boolean status) {
    log.append("updateOperationStatus called "
        + "with status: ").append(status).append(" "
        + "and uniqueCode: ").append(uniqueCode);
  }

  private void displayError(String errorMessage) {
    log.append("displayError called with "
        + "errorMessage: ").append(errorMessage).append(" "
        + "and uniqueCode: ").append(uniqueCode);
  }

  private void updateSplitView() {
    log.append("updateSplitView called with uniqueCode: ").append(uniqueCode);
  }

  private void resetView() {
    log.append("resetView called with uniqueCode: ").append(uniqueCode);
  }


  private void componentImage(String color) {
    log.append("Mock Component Image called "
        + "for color: ").append(color).append(" with "
        + "uniqueCode: ").append(uniqueCode);
    String[] args = {color, "imageName", "imageName2"};
    String message = feature.componentImage(args);
  }

  private void flipImage(String direction) {
    log.append("Mock Flip Image called for "
        + "direction: ").append(direction).append(" "
        + "with uniqueCode: ").append(uniqueCode);
    String[] args = {direction, "imageName", "imageName2"};
    String message = feature.flipImage(args);
  }

  private void blurImage() {
    log.append("Mock Blur Image called with uniqueCode: ").append(uniqueCode);
    String[] args = {"imageName", "imageName2"};
    String message = feature.blurImage(args);
  }

  private void sharpenImage() {
    log.append("Mock Sharpen Image called with uniqueCode: ").append(uniqueCode);
    String[] args = {"imageName", "imageName2"};
    String message = feature.sharpenImage(args);
  }

  private void convertToGrayscaleLuma() {
    log.append("Mock Convert to Grayscale (Luma) called with uniqueCode: ").append(uniqueCode);
    String[] args = {"imageName", "imageName2"};
    String message = feature.convertToGrayscaleLuma(args);
  }

  private void convertToSepiaTone() {
    log.append("Mock Convert to Sepia Tone called with uniqueCode: ").append(uniqueCode);
    String[] args = {"imageName", "imageName2"};
    String message = feature.convertToSepiaTone(args);
  }

  private void compressImage() {
    log.append("Mock Compress Image called with uniqueCode: ").append(uniqueCode);
    String[] args = {"10", "imageName", "imageName2"};
    String message = feature.compressImage(args);
  }

  private void adjustLevels() {
    log.append("Mock Adjust Levels called with uniqueCode: ").append(uniqueCode);
    String[] args = {"10", "10", "10", "imageName", "imageName2"};
    String message = feature.adjustLevels(args);
  }

  private void colorCorrect() {
    log.append("Mock Color Correct called with uniqueCode: ").append(uniqueCode);
    String[] args = {"imageName", "imageName2"};
    String message = feature.colorCorrect(args);
  }

  private void ditherImage() {
    log.append("Mock Dither Image called with uniqueCode: ").append(uniqueCode);
    String[] args = {"imageName", "imageName2"};
    String message = feature.ditherImage(args);
    log.append(message);
  }

  private void openSplitViewWindow(String operation) {
    performSplitViewOperation(operation);
    log.append("Mock Open Split View Window called with uniqueCode: ").append(uniqueCode);
  }

  private void performSplitViewOperation(String operation) {
    String message;
    if ("blur".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "10"};
      message = feature.blurImage(args);
    } else if ("blur-Invalied".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "1000"};
      message = feature.blurImage(args);
    } else if ("sharpen".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "10"};
      message = feature.sharpenImage(args);
    } else if ("sharpen-Invalied".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "1000"};
      message = feature.sharpenImage(args);
    } else if ("sepia".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "10"};
      message = feature.convertToSepiaTone(args);
    } else if ("sepia-Invalied".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "1000"};
      message = feature.convertToSepiaTone(args);
    } else if ("greyscale".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "10"};
      message = feature.convertToGrayscaleLuma(args);
    } else if ("greyscale-Invalied".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "1000"};
      message = feature.convertToGrayscaleLuma(args);
    } else if ("color-correction".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "10"};
      message = feature.colorCorrect(args);
    } else if ("levels-adjustment-Invalied".equals(operation)) {
      String[] args = {"10000000", "10000", "99990", "imageName", "tempImageName", "split", "10"};
      message = feature.adjustLevels(args);
    } else if ("dither".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "10"};
      message = feature.ditherImage(args);
    } else if ("dither-Invalid".equals(operation)) {
      String[] args = {"imageName", "tempImageName", "split", "1000"};
      message = feature.ditherImage(args);
    } else {
      String[] args = {"10", "10", "10", "imageName", "tempImageName", "split", "10"};
      message = feature.adjustLevels(args);
    }
  }

}
