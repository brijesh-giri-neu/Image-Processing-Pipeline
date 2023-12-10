package controller.imagereader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Utility class for reading and writing PPM (Portable Pixel Map) image files. Provides methods to
 * read from and write to PPM files.
 */
public class ImageUtil {

  /**
   * Reads pixel data from a PPM file and returns it as a 3D array.
   *
   * @param filename filename the path and name of the PPM file to read from
   * @return a 3D integer array representing the pixel data, the first two indices are for the
   *        pixelcoordinates and the last index is for the RGB color channels(3 channels)
   * @throws FileNotFoundException if the specified file does not exist
   */
  public static int[][][] readPPM(String filename) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileInputStream(filename));
    StringBuilder builder = new StringBuilder();

    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());

    if (!sc.next().equals("P3")) {
      throw new FileNotFoundException("Invalid PPM file: plain RAW file should begin with P3");
    }

    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    int[][][] pixels = new int[height][width][3];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        pixels[i][j][0] = sc.nextInt();
        pixels[i][j][1] = sc.nextInt();
        pixels[i][j][2] = sc.nextInt();
      }
    }

    sc.close();
    return pixels;
  }

  /**
   * Writes pixel data to a PPM file.
   *
   * @param pixels   a 3D integer array representing the pixel data, the first two indices * are for
   *                 the pixel coordinates and the last index is for the RGB color channels(3
   *                 channels)
   * @param filename the path and name of the PPM file to write to
   * @throws IOException if an I/O error occurs while writing to the file
   */
  public static void writePPM(int[][][] pixels, String filename) throws IOException {
    String directory;
    String filenameWithExtension;
    File fullFile;
    if (filename.lastIndexOf('/') > 0) {
      directory = filename.substring(0, filename.lastIndexOf('/'));
      filenameWithExtension = filename.substring(filename.lastIndexOf('/') + 1);
      File file = new File(directory);

      if (!file.exists()) {
        throw new IOException("An error occurred while creating the PPM file.");
      }
      fullFile = new File(directory, filenameWithExtension);
    } else {
      filenameWithExtension = filename;
      fullFile = new File(filenameWithExtension);
    }

    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullFile)))) {
      int height = pixels.length;
      int width = pixels[0].length;

      out.println("P3");
      out.println("# Created by ImageUtil");
      out.println(width + " " + height);
      out.println("255");

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          out.print(pixels[i][j][0] + " " + pixels[i][j][1] + " " + pixels[i][j][2] + " ");
        }
        out.println();
      }
    } catch (IOException e) {
      throw new IOException("An error occurred while saving the PPM file.");
    }
  }

}
