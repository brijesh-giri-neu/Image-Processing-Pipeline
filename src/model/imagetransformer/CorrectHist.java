package model.imagetransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements an ImageTransformer to perform histogram correction on an image by allying the peaks
 * of the R,G,B Histograms.
 */
public class CorrectHist implements ImageTransformer {

  @Override
  public int[][][] transformer(int[][][] image) {
    List<int[]> histograms = generateHistogram(image);
    int[] redHist = histograms.get(0);
    int[] greenHist = histograms.get(1);
    int[] blueHist = histograms.get(2);
    int redPeak = peak(redHist);
    int greenPeak = peak(greenHist);
    int bluePeak = peak(blueHist);

    int[][][] newImage = new int[image.length][image[0].length][3];
    int averagePeak = (redPeak + greenPeak + bluePeak) / 3;

    int redDiff = averagePeak - redPeak;
    int greenDiff = averagePeak - greenPeak;
    int blueDiff = averagePeak - bluePeak;

    for (int y = 0; y < image.length; y++) {
      for (int x = 0; x < image[y].length; x++) {
        newImage[y][x][0] = bound(image[y][x][0] + redDiff, 0, 255);
        newImage[y][x][1] = bound(image[y][x][1] + greenDiff, 0, 255);
        newImage[y][x][2] = bound(image[y][x][2] + blueDiff, 0, 255);
      }
    }

    return newImage;
  }

  private int bound(int value, int min, int max) {
    if (value < min) {
      return min;
    } else if (value > max) {
      return max;
    } else {
      return value;
    }
  }

  private int peak(int[] histogram) {
    int peakValue = 0;
    int peakIntensity = 0;
    for (int intensity = 10; intensity < 246; intensity++) {
      if (histogram[intensity] > peakValue) {
        peakValue = histogram[intensity];
        peakIntensity = intensity;
      }
    }
    return peakIntensity;
  }

  private List<int[]> generateHistogram(int[][][] image) {
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
}
