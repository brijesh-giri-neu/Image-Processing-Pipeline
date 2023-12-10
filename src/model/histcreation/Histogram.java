package model.histcreation;


import java.util.ArrayList;
import java.util.List;

/**
 * Implements HistogramInterface interface to create histograms for the red, green, and blue color
 * channels of an image which can be viewed as an image.
 */
public class Histogram implements HistogarmInterface {

  private final int[][][] image;

  /**
   * Constructor to initialize the histogram with an image.
   *
   * @param image The image is for the original image.
   */
  public Histogram(int[][][] image) {
    this.image = image;
  }

  private List<int[]> generateHistogram() {
    int height = image.length;
    int width = image[0].length;

    int[] redHist = new int[256];
    int[] greenHist = new int[256];
    int[] blueHist = new int[256];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int red = image[y][x][0];
        int green = image[y][x][1];
        int blue = image[y][x][2];

        redHist[red]++;
        greenHist[green]++;
        blueHist[blue]++;
      }
    }

    List<int[]> histograms = new ArrayList<>();
    histograms.add(redHist);
    histograms.add(greenHist);
    histograms.add(blueHist);

    return histograms;
  }

  @Override
  public int[][][] createHistogramImage() {
    List<int[]> histograms = generateHistogram();
    int[] redHistogram = histograms.get(0);
    int[] greenHistogram = histograms.get(1);
    int[] blueHistogram = histograms.get(2);

    int height = 256;
    int width = 256;
    int channels = 3;
    int[][][] histogramImageArray = new int[height][width][channels];

    int[] lightGrayRGB = {192, 192, 192};
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        histogramImageArray[y][x] = lightGrayRGB.clone();
      }
    }

    for (int i = 0; i < width; i += 16) {
      int[] gridColor = {192, 192, 192};
      for (int j = 0; j < height; j++) {
        histogramImageArray[j][i] = gridColor;
        histogramImageArray[i][j] = gridColor;
      }
    }

    int max = findMaxValue(redHistogram, greenHistogram, blueHistogram);

    draw(histogramImageArray, redHistogram, max, new int[]{255, 0, 0});
    draw(histogramImageArray, greenHistogram, max, new int[]{0, 255, 0});
    draw(histogramImageArray, blueHistogram, max, new int[]{0, 0, 255});

    return histogramImageArray;
  }

  private void draw(int[][][] imageArray, int[] histogram, int max, int[] color) {
    int prevHeightValue = -1;

    for (int i = 0; i < 255; i++) {
      int heightValue = (int) ((histogram[i] / (double) max) * 255);

      if (prevHeightValue != -1) {
        connectDots(imageArray, i - 1, 255 - prevHeightValue, i, 255 - heightValue, color);
      }

      prevHeightValue = heightValue;
    }
  }

  private void connectDots(int[][][] imageArray, int x1, int y1, int x2, int y2, int[] color) {
    int dx = x2 - x1;
    int dy = y2 - y1;
    int steps = Math.max(Math.abs(dx), Math.abs(dy));

    float xInc = dx / (float) steps;
    float yInc = dy / (float) steps;

    float x = x1;
    float y = y1;

    for (int i = 0; i <= steps; i++) {
      if (x >= 0 && x < 256 && y >= 0 && y < 256) {
        imageArray[(int) y][(int) x] = color;
      }
      x += xInc;
      y += yInc;
    }
  }


  private int findMaxValue(int[] redHist, int[] greenHist, int[] blueHist) {
    int max = 0;
    for (int i = 0; i < redHist.length; i++) {
      max = Math.max(max, redHist[i]);
      max = Math.max(max, greenHist[i]);
      max = Math.max(max, blueHist[i]);
    }
    return max;
  }


}
