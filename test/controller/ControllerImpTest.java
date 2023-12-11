package controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a simple junit test file for the class ControllerImp.
 */
public class ControllerImpTest {

  private final String[] args = {"-text"};

  @Before
  public void setUp() {
    StringBuilder log = new StringBuilder();
    int uniqueCode = 987;
    MockModel mockModel = new MockModel(log, uniqueCode);
    int[][][] image = new int[][][]{{{255, 255, 255}}};
    String imageName = "testImage";
  }

  @Test
  public void testPutInMap() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 987);
    int[][][] image = {{{9}}};
    String imageName = "testImage";

    String result = mockModel.putInMap(image, imageName);
    String expectedCodeString = "987 putInMap";
    assertEquals(expectedCodeString, result);
    assertTrue(log.toString().contains("Input received - imageName: " + imageName));
  }


  @Test
  public void testGetFromMap() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 987);
    String filename = "testImage";

    int[][][] expectedImage = {{{987}}};
    int[][][] resultImage = mockModel.getFromMap(filename);

    assertArrayEquals(expectedImage, resultImage);
    assertTrue(log.toString().contains("Input received - filename: " + filename));
  }


  @Test
  public void testSaveImageInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("save /path/to/image imageName image\nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testRedComponentImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("red-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Component: red, Name: imageName, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testGreenComponentImageOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("green-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 getComponent"));
  }

  @Test
  public void testBlueComponentImageOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("BLUE-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 getComponent"));
  }

  @Test
  public void testRedComponentImageOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("rEd-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 getComponent"));
  }

  @Test
  public void testGreenComponentImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("green-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Component: green, Name: imageName, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testBlueComponentImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("BLUE-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Component: blue, Name: imageName, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testValueComponentImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("value-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Component: value, Name: imageName, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }


  @Test
  public void testValueComponentImageInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("value-component invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }


  @Test
  public void testlumaComponentImageInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("luma-component invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testIntensityComponentImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("Intensity-component srcImage imageName\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Component: intensity, Name: imageName, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }


  @Test
  public void testIntensityComponentInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("Intensity-component invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testFlipImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("horizontal-flip srcImage flippedImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Direction: horizontal, "
        + "Name: flippedImage, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testFlipImageOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 22);
    Reader in = new StringReader("horizontal-flip srcImage flippedImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("22 flipImage"));
  }

  @Test
  public void testFlipImageInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("horizontal-flip invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testFlipVerticalImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("vertical-flip srcImage flippedImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Direction: vertical, Name: flippedImage, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testFlipVerticalImageOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("vertical-flip srcImage flippedImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 flipImage"));
  }

  @Test
  public void testFlipVerticalInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("vertical-flip invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testAdjustBrightness() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("brighten 50 srcImage brightImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Value: 50, Name: brightImage, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testAdjustBrightnessOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("brighten 50 srcImage brightImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 adjustBrightness"));
  }

  @Test
  public void testAdjustBrightnessInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("brighten 50 invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testAdjustBrightnessInvalied1() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("brighten  invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testAdjustBrightnessdark() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("brighten -50 srcImage brightImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Value: -50, Name: brightImage, Src: srcImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testAdjustBrightnessdarkOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 12);
    Reader in = new StringReader("brighten -50 srcImage brightImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("12 adjustBrightness"));
  }

  @Test
  public void testAdjustBrightnessdarkInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("brighten invalid commend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testAdjustBrightnessdarkInvalied2() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("brighten -50 invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testSplitIntoRGB() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 14);
    Reader in = new StringReader("rgb-split koala koala-red koala-green koala-blue\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("14 splitIntoRGB"));
  }

  @Test
  public void testSplitIntoRGBout() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("rgb-split koala koala-red koala-green koala-blue\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: koala, "
        + "Red: koala-red, Green: "
        + "koala-green, Blue: koala-blue";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testSplitIntoRGBInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("rgb-split invalid commend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testSplitIntoRGBInvalied1() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("rgb-split koala koala-red koala-green \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testSplitIntoRGBInvalied2() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("rgb-split koala koala-red koala-green koala-blue image\nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testCombineRGBImages() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader(
        "rgb-combine koala-red-tint koala-red koala-green koala-blue\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - "
        + "RedImage: koala-red-tint, "
        + "GreenImage: koala-red, "
        + "BlueImage: koala-green, "
        + "DstName: koala-blue";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testCombineRGBImagesOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 18);
    Reader in = new StringReader(
        "rgb-combine koala-red-tint koala-red koala-green koala-blue\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("18 combineRGBImages"));
  }

  @Test
  public void testCombineRGBImagesInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("rgb-combine invalid commend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testCombineRGBImagesInvalied1() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("rgb-combine koala-red-tint koala-red koala-green \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testCombineRGBImagesInvalied2() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader(
        "rgb-combine koala-red-tint koala-red koala-green koala-blue other \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testBlurImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("blur srcImage blurredImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: blurredImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testBlurImageOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("blur srcImage blurredImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 blurImage"));
  }

  @Test
  public void testBlurImageInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("blur invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testSharpenImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("sharpeN srcImage sharpenedImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: sharpenedImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testSharpenImageOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 18);
    Reader in = new StringReader("sharpeN srcImage sharpenedImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("18 sharpenImage"));
  }

  @Test
  public void testSharpenImageOutputAllCaps() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 18);
    Reader in = new StringReader("SHARPEN srcImage sharpenedImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("18 sharpenImage"));
  }

  @Test
  public void testSharpenImageInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("sharpeN invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testConvertToSepia() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("Sepia srcImage sepiaImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: sepiaImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testConvertToSepiaOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("Sepia srcImage sepiaImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 convertToSepia"));
  }

  @Test
  public void testConvertToSepiaInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("Sepia invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testConvertToSepiaOutputSensitiveness1() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("SEPIA srcImage sepiaImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: sepiaImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testConvertToSepiaOutputSensitiveness2() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("SePiA srcImage sepiaImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 convertToSepia"));
  }

  @Test
  public void testMultiplecomments() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 22);
    Reader in = new StringReader(
        "SePiA srcImage sepiaImage\n"
            + "sharpeN srcImage sharpenedImage\n"
            + "blur srcImage blurredImage\n"
            + "vertical-flip srcImage flippedImage\n"
            + "exit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("22 convertToSepia"));
    assertTrue(out.toString().contains("22 sharpenImage"));
    assertTrue(out.toString().contains("22 blurImage"));
    assertTrue(out.toString().contains("22 flipImage"));


  }

  @Test
  public void testMultiplecomments1() throws IOException {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 22);
    Reader in = new StringReader("SePiA srcImage sepiaImage");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.execute("sharpeN srcImage sharpenedImage", args);
    controller.execute("blur srcImage sharpenedImage", args);

    controller.run(args);

    assertTrue(out.toString().contains("22 convertToSepia"));
    assertTrue(out.toString().contains("22 sharpenImage"));
    assertTrue(out.toString().contains("22 blurImage"));

  }

  @Test
  public void testMultiplecommendsInvalied() throws IOException {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 22);
    Reader in = new StringReader("SePiA srcImage sepiaImage");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.execute("sharpeN srcImage sharpenedImage", args);
    controller.execute("Inavlied srcImage sharpenedImage", args);

    controller.run(args);

    assertTrue(out.toString().contains("22 convertToSepia"));
    assertTrue(out.toString().contains("22 sharpenImage"));
    assertTrue(out.toString().contains("Invalid command"));


  }

  @Test
  public void testMultiplecommendsInvalied1() throws IOException {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 22);
    Reader in = new StringReader("SePiA srcImage sepiaImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.execute("sharpeN srcImage sharpenedImage", args);
    assertTrue(out.toString().contains("22 sharpenImage"));
    controller.execute("Inavlied srcImage sharpenedImage", args);
    assertTrue(out.toString().contains("Invalid command"));
    controller.run(args);

    assertTrue(out.toString().contains("22 convertToSepia"));

  }


  @Test
  public void testConvertToGreyscale() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("Greyscale srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: dstImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testConvertToGreyscaleOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("Greyscale srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("1 convertToGreyscale"));
  }

  @Test
  public void testConvertToGreyscaleInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("invalidCommand srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }


  @Test
  public void testCompressImageInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 2);
    Reader in = new StringReader("invalidCommand srcImage dstImage 50\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testSplitImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 3);
    Reader in = new StringReader("blur srcImage dstImage split 50\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: dstImage, Method: blur";
    assertEquals(expectedLog, log.toString());
  }


  @Test
  public void testSplitImageInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 3);
    Reader in = new StringReader("invalidCommand srcImage dstImage 50 method\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }


  @Test
  public void testCreateHistogram() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 4);
    Reader in = new StringReader("Histogram srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: dstImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testCreateHistogramOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 4);
    Reader in = new StringReader("Histogram srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("4 createHistogram"));
  }

  @Test
  public void testCreateHistogramInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 4);
    Reader in = new StringReader("invalidCommand srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testCorrectHistogram() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 5);
    Reader in = new StringReader("color-correct srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: dstImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testCorrectHistogramOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 5);
    Reader in = new StringReader("color-correct srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("5 correctHistogram"));
  }

  @Test
  public void testCorrectHistogramInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 5);
    Reader in = new StringReader("invalidCommand srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testAdjustLevels() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 6);
    Reader in = new StringReader("levels-adjust 0.1 0.5 0.9 srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: dstImage";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testAdjustLevelsOutput() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 6);
    Reader in = new StringReader("levels-adjust 0.1 0.5 0.9 srcImage dstImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("6 adjustLevels"));
  }

  @Test
  public void testAdjustLevelsInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 6);
    Reader in = new StringReader("invalidCommand srcImage dstImage 0.1 0.5 0.9\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }


  @Test
  public void testSplitImageLevelInvalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 7);
    Reader in = new StringReader("invalidCommand srcImage dstImage 50 0.1 0.5 0.9\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    assertTrue(out.toString().contains("Invalid command"));
  }



  @Test
  public void testMultiplecomments10() throws IOException {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 22);
    Reader in = new StringReader("SePiA srcImage sepiaImage");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.execute("sharpeN srcImage sharpenedImage", args);
    controller.execute("blur srcImage sharpenedImage", args);
    controller.execute("levels-adjust 0.1 0.5 0.9 srcImage dstImage split", args);
    controller.execute("levels-adjust 0.1 0.5 0.9 srcImage dstImage", args);
    controller.execute("color-correct srcImage dstImage", args);
    controller.run(args);

    assertTrue(out.toString().contains("22 convertToSepia"));
    assertTrue(out.toString().contains("22 sharpenImage"));
    assertTrue(out.toString().contains("22 blurImage"));
    assertTrue(out.toString().contains("22 correctHistogram"));
    assertTrue(out.toString().contains("22 adjustLevels"));
  }

  @Test
  public void testDitherImage() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("dither srcImage blurredImage\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    // Assert model logs. This checks whether model methods got invoked correctly.
    String expectedLog = "Input received - Src: srcImage, DstName: blurredImage";
    assertEquals(expectedLog, log.toString());
    // Assert the output sent to the view.
    assertTrue(out.toString().contains("1 ditherImage"));
  }

  @Test
  public void testDitherImageInvalied() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 1);
    Reader in = new StringReader("dither invalidcommend \nexit");
    StringBuffer out = new StringBuffer();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    // Assert model logs. This checks whether model methods got invoked correctly.
    String expectedLog = "";
    assertEquals(expectedLog, log.toString());
    // Assert the output sent to the view.
    assertTrue(out.toString().contains("Invalid command"));
  }

  @Test
  public void testSplitImageDither() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 3);
    Reader in = new StringReader("dither srcImage dstImage split 50\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: dstImage, Method: dither";
    assertEquals(expectedLog, log.toString());
  }

  @Test
  public void testSplitImageDither_Invalid() {
    StringBuilder log = new StringBuilder();
    MockModel mockModel = new MockModel(log, 3);
    Reader in = new StringReader("dither srcImage dstImage split -100\nexit");
    Appendable out = new StringBuilder();
    ControllerImp controller = new ControllerImp(mockModel, in, out);
    controller.run(args);

    String expectedLog = "Input received - Src: srcImage, DstName: dstImage, Method: dither";
    assertTrue(log.toString().contains(expectedLog));
    assertTrue(log.toString().contains("wrong percentage"));
  }
}