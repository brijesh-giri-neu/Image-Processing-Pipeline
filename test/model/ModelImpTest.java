package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * A simple junit test file for the class ModelImp.
 */
public class ModelImpTest {

  private int[][][] image;
  Model model;

  @Before
  public void setup() {
    this.image = new int[][][]{
        {{255, 0, 0}, {0, 255, 0}, {0, 0, 255}},
        {{255, 255, 0}, {0, 255, 255}, {255, 0, 255}},
        {{255, 0, 255}, {0, 255, 0}, {255, 255, 0}}
    };
    this.model = ModelImp.getBuilder().build();
    this.model.putInMap(image, "image");
  }


  @Test
  public void testBuilder() {
    Model model = ModelImp.getBuilder().build();
    assertNotNull(model);
  }

  @Test
  public void testPutInMap() {
    Model model = ModelImp.getBuilder().build();
    String message = model.putInMap(image, "image");
    assertEquals("Successful", message);
  }

  @Test
  public void testGetFromMap() {
    Model model = ModelImp.getBuilder().build();
    model.putInMap(image, "image");
    int[][][] expected = model.getFromMap("image");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], image[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testGetFromMapFail() {
    Model model = ModelImp.getBuilder().build();
    int[][][] expected = model.getFromMap("image");
    assertNull(expected);
  }

  @Test
  public void testGetValueComponentImageSuccessfully() {
    String result = model.getComponentImage("value", "dstname", "image");
    assertEquals("Successful", result);
  }

  @Test
  public void testGetValueComponentImageNotFound() {
    String result = model.getComponentImage("value", "dstname", "non_existent_image");
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testGetIntensityComponentImageSuccessfully() {
    String result = model.getComponentImage("intensity", "dstname", "image");
    assertEquals("Successful", result);
  }

  @Test
  public void testGetIntensityComponentImageNotFound() {
    String result = model.getComponentImage("intensity", "dstname", "abcd");
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testGetLumaComponentImageSuccessfully() {
    String result = model.getComponentImage("luma", "dstname", "image");
    assertEquals("Successful", result);
  }

  @Test
  public void testGetLumaComponentImageNotFound() {
    String result = model.getComponentImage("luma", "dstname", "abc");
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testFlipImageHorizontally() {
    String result = model.flipImage("horizontal", "flipped_image", "image");
    assertEquals("Successful", result);
  }

  @Test
  public void testFlipImageVertically() {
    String result = model.flipImage("vertical", "flipped_image", "image");
    assertEquals("Successful", result);
  }

  @Test
  public void testFlipImageNotFound() {
    String result = model.flipImage("horizontal", "flipped_image", "koala");
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testIncreaseBrightness() {
    String result = model.adjustBrightness(50, "brightened_image", "image");
    assertEquals("Successful", result);
  }

  @Test
  public void testDecreaseBrightness() {
    String result = model.adjustBrightness(-50, "brightened_image", "image");
    assertEquals("Successful", result);
  }

  @Test
  public void testAdjustBrightnessImageNotFound() {
    String result = model.adjustBrightness(-50, "brightened_image", "image_not_found");
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testSplitIntoRGBSuccessfully() {
    String result = model.splitIntoRGB("image", "redKey", "greenKey", "blueKey");
    assertEquals("Successful", result);
  }

  @Test
  public void testSplitIntoRGBImageNotFound() {
    String result = model.splitIntoRGB("non_existent_image", "redKey", "greenKey", "blueKey");
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testCombineRGBImagesSuccessfully() {
    model.splitIntoRGB("image", "redKey", "greenKey", "blueKey");
    String result = model.combineRGBImages("redKey", "greenKey", "blueKey", "combinedImage");
    assertEquals("Successful", result);
  }

  @Test
  public void testCombineRGBImagesNotFound() {
    String result = model.combineRGBImages("non_existent_redKey", "greenKey", "blueKey",
        "combinedImage");
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testBlurImageSuccessfully() {
    String result = model.blurImage("image", "blurred_image");
    assertEquals("Successful", result);
  }

  @Test
  public void testBlurImageNotFound() {
    String result = model.blurImage("non_existent_image", "blurred_image");
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testSharpenImageSuccessfully() {
    String result = model.sharpenImage("image", "sharpened_image");
    assertEquals("Successful", result);
  }

  @Test
  public void testSharpenImageNotFound() {
    String result = model.sharpenImage("non_existent_image", "sharpened_image");
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testConvertToSepiaSuccessfully() throws IOException {
    String result = model.convertToSepia("image", "dest_image");

    assertEquals("Successful", result);
  }

  @Test
  public void testConvertToSepiaImageNotFound() {
    String result = model.convertToSepia("non_existent_image", "sepia_image");
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testCompressionSuccessful() {
    String result = model.compressImage("image", "new_image", 90);
    assertEquals("Successful", result);
  }

  @Test
  public void testCompressionImageNotFound() {
    String result = model.compressImage("non_existent_image", "new_image", 90);
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testCompressionWrongValues() {
    String result = model.compressImage("non_existent_image", "new_image", -90);
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testCompressionWrongValues2() {
    String result = model.compressImage("non_existent_image", "new_image", 1000);
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testHistogramSuccessful() {
    String result = model.createHistogram("image", "new_image");
    assertEquals("Successful", result);
  }

  @Test
  public void testHistogramImageNotFound() {
    String result = model.createHistogram("image_no", "new_image");
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testColorCorrectSuccessful() {
    String result = model.correctHistogram("image", "new_image");
    assertEquals("Successful", result);
  }

  @Test
  public void testColorCorrectImageNotFound() {
    String result = model.correctHistogram("image_no", "new_image");
    assertEquals("The image doesn't exists in the map. Please load the image first", result);
  }

  @Test
  public void testLevelAdjustSuccessful() {
    String result = model.adjustLevels("image", "new_image", 0, 10, 255);
    assertEquals("Successful", result);
  }

  @Test
  public void testLevelAdjustImageNotFound() {
    String result = model.adjustLevels("image_no", "new_image", 0, 10, 255);
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testLevelAdjustWrongValues() {
    String result = model.adjustLevels("image", "new_image", 0, 10, 355);
    assertEquals("Incorrect value entered for w. Please enter again", result);
  }

  @Test
  public void testLevelAdjustWrongValues2() {
    String result = model.adjustLevels("image", "new_image", 100, 10, 255);
    assertEquals("Incorrect value entered for m. Please enter again", result);
  }

  @Test
  public void testLevelAdjustWrongValues3() {
    String result = model.adjustLevels("image", "new_image", 100, -10, 255);
    assertEquals("Incorrect value entered for m. Please enter again", result);
  }

  @Test
  public void testSplitSuccessful() {
    String result = model.splitImage("image", "new_image", 90, "blur");
    assertEquals("Successful", result);
  }

  @Test
  public void testSplitImageNotFound() {
    String result = model.splitImage("image_old", "new_image", 90, "blur");
    assertEquals("The image doesn't exist in the map. Please load the image first", result);
  }

  @Test
  public void testSplitWrongValues() {
    String result = model.splitImage("image", "new_image", -90, "blur");
    assertEquals("The percentage value is incorrect.", result);
  }

  @Test
  public void testSplitWrongValues2() {
    String result = model.splitImage("image", "new_image", 190, "blur");
    assertEquals("The percentage value is incorrect.", result);
  }

  @Test
  public void testBrightenCorrectness() {
    model.adjustBrightness(10, "Koala-brighter", "image");
    int[][][] actual = model.getFromMap("Koala-brighter");
    int[][][] expected = {
        {{255, 10, 10}, {10, 255, 10}, {10, 10, 255}},
        {{255, 255, 10}, {10, 255, 255}, {255, 10, 255}},
        {{255, 10, 255}, {10, 255, 10}, {255, 255, 10}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testDarkenCorrectness() throws FileNotFoundException {
    model.adjustBrightness(-10, "Koala-brighter", "image");
    int[][][] actual = model.getFromMap("Koala-brighter");
    int[][][] expected = {
        {{245, 0, 0}, {0, 245, 0}, {0, 0, 245}},
        {{245, 245, 0}, {0, 245, 245}, {245, 0, 245}},
        {{245, 0, 245}, {0, 245, 0}, {245, 245, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }


  @Test
  public void testRedComponentCorrectness() throws FileNotFoundException {
    model.getComponentImage("red", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");
    int[][][] expected = {
        {{255, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{255, 0, 0}, {0, 0, 0}, {255, 0, 0}},
        {{255, 0, 0}, {0, 0, 0}, {255, 0, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testBlueComponentCorrectness() throws FileNotFoundException {
    model.getComponentImage("blue", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");
    int[][][] expected = {
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 255}},
        {{0, 0, 0}, {0, 0, 255}, {0, 0, 255}},
        {{0, 0, 255}, {0, 0, 0}, {0, 0, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testGreenComponentCorrectness() throws FileNotFoundException {
    model.getComponentImage("green", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");

    int[][][] expected = {
        {{0, 0, 0}, {0, 255, 0}, {0, 0, 0}},
        {{0, 255, 0}, {0, 255, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 255, 0}, {0, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testFlipHorizontalCorrectness() throws FileNotFoundException {
    model.flipImage("horizontal", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");
    int[][][] expected = {
        {{0, 0, 255}, {0, 255, 0}, {255, 0, 0}},
        {{255, 0, 255}, {0, 255, 255}, {255, 255, 0}},
        {{255, 255, 0}, {0, 255, 0}, {255, 0, 255}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testFlipVerticalCorrectness() throws FileNotFoundException {
    model.flipImage("vertical", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");
    int[][][] expected = {
        {{255, 0, 255}, {0, 255, 0}, {255, 255, 0}},
        {{255, 255, 0}, {0, 255, 255}, {255, 0, 255}},
        {{255, 0, 0}, {0, 255, 0}, {0, 0, 255}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testValueCorrectness() throws FileNotFoundException {
    model.getComponentImage("value", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");
    int[][][] expected = {
        {{255, 255, 255}, {255, 255, 255}, {255, 255, 255}},
        {{255, 255, 255}, {255, 255, 255}, {255, 255, 255}},
        {{255, 255, 255}, {255, 255, 255}, {255, 255, 255}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testLumaCorrectness() throws FileNotFoundException {
    model.getComponentImage("luma", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");
    int[][][] expected = {
        {{54, 54, 54}, {182, 182, 182}, {18, 18, 18}},
        {{236, 236, 236}, {200, 200, 200}, {72, 72, 72}},
        {{72, 72, 72}, {182, 182, 182}, {236, 236, 236}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testIntensityCorrectness() throws FileNotFoundException {
    model.getComponentImage("intensity", "Koala-new", "image");
    int[][][] actual = model.getFromMap("Koala-new");
    int[][][] expected = {
        {{85, 85, 85}, {85, 85, 85}, {85, 85, 85}},
        {{170, 170, 170}, {170, 170, 170}, {170, 170, 170}},
        {{170, 170, 170}, {85, 85, 85}, {170, 170, 170}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testSplittingIntoChannelCorrectness() throws FileNotFoundException {
    model.splitIntoRGB("image", "koala-red", "koala-green", "koala-blue");
    int[][][] actualRed = model.getFromMap("koala-red");
    int[][][] actualGreen = model.getFromMap("koala-green");
    int[][][] actualBlue = model.getFromMap("koala-blue");
    int[][][] expectedRed = {
        {{255, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{255, 0, 0}, {0, 0, 0}, {255, 0, 0}},
        {{255, 0, 0}, {0, 0, 0}, {255, 0, 0}}
    };

    int[][][] expectedBlue = {
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 255}},
        {{0, 0, 0}, {0, 0, 255}, {0, 0, 255}},
        {{0, 0, 255}, {0, 0, 0}, {0, 0, 0}}
    };

    int[][][] expectedGreen = {
        {{0, 0, 0}, {0, 255, 0}, {0, 0, 0}},
        {{0, 255, 0}, {0, 255, 0}, {0, 0, 0}},
        {{0, 0, 0}, {0, 255, 0}, {0, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {

          assertEquals(expectedRed[i][j][k], actualRed[i][j][k]);
          assertEquals(expectedGreen[i][j][k], actualGreen[i][j][k]);
          assertEquals(expectedBlue[i][j][k], actualBlue[i][j][k]);

        }
      }
    }
  }

  @Test
  public void testCombineImagesCorrectness() throws FileNotFoundException {
    model.splitIntoRGB("image", "koala-red", "koala-green", "koala-blue");
    model.combineRGBImages("koala-red", "koala-green", "koala-blue", "koala-expected");
    int[][][] actual = model.getFromMap("koala-expected");
    int[][][] expected = {
        {{255, 0, 0}, {0, 255, 0}, {0, 0, 255}},
        {{255, 255, 0}, {0, 255, 255}, {255, 0, 255}},
        {{255, 0, 255}, {0, 255, 0}, {255, 255, 0}}
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testBlurImagesCorrectness() throws FileNotFoundException {
    model.blurImage("image", "expected-koala");
    int[][][] actual = model.getFromMap("expected-koala");
    int[][][] expected = {
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {111, 175, 127}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testSharpenImagesCorrectness() throws FileNotFoundException {
    model.sharpenImage("image", "expected-koala");
    int[][][] actual = model.getFromMap("expected-koala");
    int[][][] expected = {
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        {{0, 0, 0}, {223, 255, 63}, {0, 0, 0}},
        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testSepiaImagesCorrectness() throws FileNotFoundException {
    model.convertToSepia("image", "expected-koala");
    int[][][] actual = model.getFromMap("expected-koala");
    int[][][] expected = {
        {{100, 88, 69}, {196, 174, 136}, {48, 42, 33}},
        {{255, 255, 205}, {244, 217, 169}, {148, 131, 102}},
        {{148, 131, 102}, {196, 174, 136}, {255, 255, 205}}
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testMultipleCommands() throws FileNotFoundException {
    model.convertToSepia("image", "expected-koala");
    model.flipImage("vertical", "expected-koala-flip", "expected-koala");
    int[][][] actual = model.getFromMap("expected-koala-flip");
    int[][][] expected = {
        {{148, 131, 102}, {196, 174, 136}, {255, 255, 205}},
        {{255, 255, 205}, {244, 217, 169}, {148, 131, 102}},
        {{100, 88, 69}, {196, 174, 136}, {48, 42, 33}}
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testCompressionCorrectness() {
    model.compressImage("image", "image-c", 90);
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{96, 128, 64}, {96, 128, 64}, {64, 32, 64}},
        {{96, 128, 64}, {96, 128, 64}, {64, 32, 64}},
        {{96, 128, 64}, {96, 128, 64}, {64, 32, 64}}
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testColorCorrectCorrectness() {
    model.correctHistogram("image", "image-c");
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{255, 0, 0}, {0, 255, 0}, {0, 0, 255}},
        {{255, 255, 0}, {0, 255, 255}, {255, 0, 255}},
        {{255, 0, 255}, {0, 255, 0}, {255, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testLevelAdjustCorrectness() {
    model.adjustLevels("image", "image-c", 20, 128, 255);
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{255, 0, 0}, {0, 255, 0}, {0, 0, 255}},
        {{255, 255, 0}, {0, 255, 255}, {255, 0, 255}},
        {{255, 0, 255}, {0, 255, 0}, {255, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testSplitCorrectness() {
    model.splitImage("image", "image-c", 50, "blur");
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{0, 0, 0}, {0, 255, 0}, {0, 0, 255}},
        {{0, 0, 0}, {0, 255, 255}, {255, 0, 255}},
        {{0, 0, 0}, {0, 255, 0}, {255, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testHistogramCorrectness() {
    int[][][] newImage = {
        {{255, 255, 255}, {255, 255, 255}, {255, 255, 255}},
        {{255, 255, 255}, {255, 255, 255}, {255, 255, 255}},
        {{255, 255, 255}, {255, 255, 255}, {255, 255, 255}}
    };
    model.putInMap(newImage, "new_image");
    model.createHistogram("new_image", "image-c");
    int[][][] actual = model.getFromMap("image-c");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(192, actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testSplitCorrectnessDithering() {
    model.splitImage("image", "image-c", 50, "dither");
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{0, 0, 0}, {0, 255, 0}, {0, 0, 255}},
        {{255, 255, 255}, {0, 255, 255}, {255, 0, 255}},
        {{255, 255, 255}, {0, 255, 0}, {255, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testSplitCorrectnessDithering0() {
    model.splitImage("image", "image-c", 0, "dither");
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{255, 0, 0}, {0, 255, 0}, {0, 0, 255}},
        {{255, 255, 0}, {0, 255, 255}, {255, 0, 255}},
        {{255, 0, 255}, {0, 255, 0}, {255, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testSplitCorrectnessDithering100() {
    model.splitImage("image", "image-c", 100, "dither");
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{0, 0, 0}, {0, 0, 0}, {255, 255, 255}},
        {{255, 255, 255}, {255, 255, 255}, {0, 0, 0}},
        {{255, 255, 255}, {0, 0, 0}, {255, 255, 255}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test (expected = NullPointerException.class)
  public void testSplitCorrectnessDitheringLowBound() {
    model.splitImage("image", "image-c", -50, "dither");
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{85, 85, 85}, {0, 255, 0}, {0, 0, 255}},
        {{170, 170, 170}, {0, 255, 255}, {255, 0, 255}},
        {{170, 170, 170}, {0, 255, 0}, {255, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test (expected = NullPointerException.class)
  public void testSplitCorrectnessDitheringHighBound() {
    model.splitImage("image", "image-c", 500, "dither");
    int[][][] actual = model.getFromMap("image-c");
    int[][][] expected = {
        {{85, 85, 85}, {0, 255, 0}, {0, 0, 255}},
        {{170, 170, 170}, {0, 255, 255}, {255, 0, 255}},
        {{170, 170, 170}, {0, 255, 0}, {255, 255, 0}}
    };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }

  @Test
  public void testDitherImagesCorrectness() throws FileNotFoundException {
    model.ditherImage("image", "expected-koala");
    int[][][] actual = model.getFromMap("expected-koala");
    int[][][] expected = {
        {{0, 0, 0}, {0, 0, 0}, {255, 255, 255}},
        {{255, 255, 255}, {255, 255, 255}, {0, 0, 0}},
        {{255, 255, 255}, {0, 0, 0}, {255, 255, 255}}
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          assertEquals(expected[i][j][k], actual[i][j][k]);
        }
      }
    }
  }
}
