package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import org.junit.Test;
import view.GUIViewInterface;


/**
 * This is a simple junit file for the class ImageViewerGUI.
 */

public class ControllerImpViewTest {

  @Test
  public void viewTest() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Load Image");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString().contains("loadImage called with uniqueCode: 22"));

  }

  @Test
  public void testRedComponent() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Red Component");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(
        log1.toString().contains("Mock Component Image called for color: red with uniqueCode: 22"));
    assertTrue(log.toString()
        .contains("Input received - Component: red, Name: imageName2, Src: imageName"));
  }

  @Test
  public void testGreenComponent() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Green Component");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString()
        .contains("Mock Component Image called for color: green with uniqueCode: 22"));
    assertTrue(log.toString()
        .contains("Input received - Component: green, Name: imageName2, Src: imageName"));
  }

  @Test
  public void testBlueComponent() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Blue Component");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString()
        .contains("Mock Component Image called for color: blue with uniqueCode: 22"));
    assertTrue(log.toString()
        .contains("Input received - Component: blue, Name: imageName2, Src: imageName"));

  }

  @Test
  public void testFlipImageVertically() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
        "Flip Image Vertically");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString()
        .contains("Mock Flip Image called for direction: vertical with uniqueCode: 22"));
    assertTrue(log.toString()
        .contains("Input received - Direction: vertical, Name: imageName2, Src: imageName"));

  }

  @Test
  public void testFlipImageHorizontally() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
        "Flip Image Horizontally");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString()
        .contains("Mock Flip Image called for direction: horizontal with uniqueCode: 22"));
    assertTrue(log.toString()
        .contains("Input received - Direction: horizontal, Name: imageName2, Src: imageName"));
    assertTrue(log.toString()
        .contains("Input received - Direction: horizontal, Name: imageName2, Src: imageName"));
  }


  @Test
  public void testBlurImage() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Blur Image");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString().contains("Mock Blur Image called with uniqueCode: 22"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));

  }

  @Test
  public void testSharpenImage() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Sharpen Image");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString().contains("Mock Sharpen Image called with uniqueCode: 22"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));

  }

  @Test
  public void testConvertToGrayscaleLuma() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
        "Convert to Grayscale (Luma)");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(
        log1.toString().contains("Mock Convert to Grayscale (Luma) called with uniqueCode: 22"));
    assertTrue(log.toString()
        .contains("Input received - Component: luma, Name: imageName2, Src: imageName"));

  }

  @Test
  public void testConvertToSepiaTone() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
        "Convert to Sepia Tone");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString().contains("Mock Convert to Sepia Tone called with uniqueCode: 22"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));
  }

  @Test
  public void testCompressImage() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Compress Image");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString().contains("Mock Compress Image called with uniqueCode: 22"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));
  }

  @Test
  public void testAdjustLevels() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Adjust Levels");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString().contains("Mock Adjust Levels called with uniqueCode: 22"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));

  }

  @Test
  public void testColorCorrect() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Color Correct");

    ((MockView) gui).actionPerformed(mockEvent);
    assertTrue(log1.toString().contains("Mock Color Correct called with uniqueCode: 22"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));

  }

  @Test
  public void testSplitViewBlurOperationBlur() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "blur";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString()
        .contains("Input received - Src: imageName, DstName: tempImageName, Method: blur"));

  }

  @Test
  public void testSplitViewBlurOperationSharp() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "sharpen";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString()
        .contains("Input received - Src: imageName, DstName: tempImageName, Method: sharpen"));

  }

  @Test
  public void testSplitViewBlurOperationSepia() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "sepia";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));

  }

  @Test
  public void testSplitViewBlurOperationColorCorrect() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "color-correction";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString().contains(
        "Input received - Src: imageName, DstName: tempImageName, Method: color-correct"));

  }

  @Test
  public void testSplitBlurOperationLevelAdj() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "levels-adjustment";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString()
        .contains("Input received - Src: imageName, DstName: tempImageName, Method: Level-Adj"));

  }

  @Test
  public void testSplitBlurOperationGreyscale() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "levels-adjustment";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString()
        .contains("Input received - Src: imageName, DstName: tempImageName, Method: Level-Adj"));

  }


  @Test
  public void testMultiple() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "levels-adjustment";
    GUIViewInterface gui = new MockView(log1, 24, controller, operation);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Color Correct");
    ActionEvent mockEvent2 = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Compress Image");
    ActionEvent mockEvent3 = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);
    ((MockView) gui).actionPerformed(mockEvent2);
    ((MockView) gui).actionPerformed(mockEvent3);
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));
    assertTrue(log1.toString().contains("Mock Color Correct called with uniqueCode: 24"));
    assertTrue(log1.toString().contains("Mock Compress Image called with uniqueCode: 24"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));
    assertTrue(log1.toString().contains("Mock Open Split View Window called with uniqueCode: 24"));
    assertTrue(log.toString()
        .contains("Input received - Src: imageName, DstName: tempImageName, Method: Level-Adj"));
  }

  @Test
  public void testSplitBlurOperationGreyscaleInvalied() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "blur-Invalied";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString().contains(
        "Input received - Src: imageName, DstName: tempImageName, Method: blur wrong percentage"));

  }

  @Test
  public void testSplitSharpOperationGreyscaleInvalies() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "sharpen-Invalied";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString().contains(
        "Input received - Src: imageName, DstName: "
            + "tempImageName, Method: sharpen wrong percentage"));

  }

  @Test
  public void testSplitSepiaInvalied() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "sepia-Invalied";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString().contains(
        "Input received - Src: imageName, DstName: tempImageName, Method: sepia wrong percentage"));

  }

  @Test
  public void testSplitlevelsAdjustmentInvalied() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "levels-adjustment-Invalied";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    assertTrue(log1.toString().contains(
        "Input received - Src: imageName, DstName: tempImageName, Method: Level-AdjIncorrect"));
    assertTrue(log1.toString().contains("Please enter againIncorrect value entered for m"));

  }

  @Test
  public void testDitherImage() {
    StringBuilder log = new StringBuilder();
    StringBuilder log1 = new StringBuilder();

    MockModel mockModel = new MockModel(log, 22);
    Feature controller = new GUIController(mockModel);
    GUIViewInterface gui = new MockView(log1, 22, controller);
    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Dither Image");

    ((MockView) gui).actionPerformed(mockEvent);
    // Assert view logs. View got invoked correctly.
    assertTrue(log1.toString().contains("Mock Dither Image called with uniqueCode: 22"));
    assertTrue(log1.toString().contains("22 ditherImage"));
    // Assert model logs. Model methods got invoked correctly.
    assertTrue(log.toString().contains("Input received - Src: imageName, DstName: imageName2"));
  }

  @Test
  public void testSplitViewDitherOperation() {
    StringBuilder log1 = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log1, 22);
    Feature controller = new GUIController(mockModel);
    String operation = "dither";
    GUIViewInterface gui = new MockView(log, 22, controller, operation);

    ActionEvent mockEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Split View");
    ((MockView) gui).actionPerformed(mockEvent);

    // Assert view logs. View got invoked correctly.
    assertTrue(log.toString().contains("Mock Open Split View Window called with uniqueCode: 22"));
    // Assert model logs. Model methods got invoked correctly.
    assertTrue(log1.toString()
        .contains("Input received - Src: imageName, DstName: tempImageName, Method: dither"));

  }

  @Test
  public void testDitherImageFeatures(){
    StringBuilder modelLog = new StringBuilder();
    MockModel mockModel = new MockModel(modelLog, 22);
    Feature controller = new GUIController(mockModel);
    String output = controller.ditherImage(new String[]{"srcName", "dstName"});

    // Assert model logs. Model received given inputs.
    String expectedLog = "Input received - Src: srcName, DstName: dstName";
    assertEquals(expectedLog, modelLog.toString());
    // Assert the output sent to view.
    String expectedOutput = "22 ditherImage";
    assertEquals(expectedOutput, output);
  }

  @Test
  public void testDitherImageFeaturesInvalid(){
    StringBuilder modelLog = new StringBuilder();
    MockModel mockModel = new MockModel(modelLog, 22);
    Feature controller = new GUIController(mockModel);
    String output = controller.ditherImage(new String[]{"srcName"});

    // Assert model logs. Model received given inputs.
    String expectedLog = "";
    assertEquals(expectedLog, modelLog.toString());
    // Assert the output sent to view.
    String expectedOutput = "Invalid command\n";
    assertEquals(expectedOutput, output);
  }
}
