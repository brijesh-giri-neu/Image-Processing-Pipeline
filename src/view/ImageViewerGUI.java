package view;

import controller.Feature;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This is a concrete class that implements the GUIViewInterface, ActionListener Interface and
 * extends the JFrame class. This class provides the GUI view to the user using which the user can
 * interact the with and perform various operations on the image.
 */
public class ImageViewerGUI extends JFrame implements ActionListener, GUIViewInterface {

  private final JLabel textInfo;
  private final JLabel textInfo2;

  private final JLabel imageLabel;
  private final JLabel imageLabel2;

  private final JMenuItem sMenuItem;
  private final JMenuItem RComponentItem;
  private final JMenuItem GComponentItem;
  private final JMenuItem BComponentItem;
  private final JMenuItem flipVerticallyItem;

  private final JButton apply;
  private final JMenuItem flipHorizontallyItem;
  private final JMenuItem blurItem;
  private final JMenuItem sharpenItem;
  private final JMenuItem grayscaleItem;
  private final JMenuItem sepiaTItem;
  private final JMenuItem compressItem;
  private final JMenuItem adjustLevelItem;
  private final JMenuItem colorCorrectItem;
  private final JMenuItem splitViewItem;
  private final JMenuItem ditherItem;
  private final JFileChooser fileSelecter;
  private final String imageName;
  private final String tempImageName;
  private Feature feature;
  private boolean imageSaved;


  /**
   * Constructor to initialize the values and set up the GUI view for the user.
   */
  public ImageViewerGUI() {
    super("Image Viewer");

    this.imageName = "image";
    this.tempImageName = "tempImage";

    imageSaved = true;
    apply = new JButton("Apply");

    JPanel topPanel = new JPanel(new FlowLayout());
    textInfo = new JLabel("Welcome to the application. Please start by loading an image");
    topPanel.add(textInfo);

    textInfo2 = new JLabel(
        "Great!! Now you can perform various operations on the image supported by the application");
    textInfo2.setVisible(false);
    topPanel.add(textInfo2);

    JPanel centerPanel = new JPanel(new GridLayout(1, 2));
    imageLabel = new JLabel("", SwingConstants.CENTER);
    JScrollPane scrollPane = new JScrollPane(imageLabel);
    centerPanel.add(scrollPane);

    imageLabel2 = new JLabel("", SwingConstants.CENTER);
    JScrollPane scrollPane2 = new JScrollPane(imageLabel2);
    centerPanel.add(scrollPane2);

    this.setLayout(new BorderLayout());
    this.add(topPanel, BorderLayout.NORTH);
    this.add(centerPanel, BorderLayout.CENTER);

    fileSelecter = new JFileChooser();
    fileSelecter.setAcceptAllFileFilterUsed(false);
    fileSelecter.setFileFilter(
        new FileNameExtensionFilter("Image files", "jpg", "png", "ppm"));

    fileSelecter.setCurrentDirectory(new File(System.getProperty("user.dir")));

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");

    JMenuItem loadMenuItem = new JMenuItem("Load Image");
    sMenuItem = new JMenuItem("Save Image");

    loadMenuItem.addActionListener(this);
    sMenuItem.addActionListener(this);

    menu.add(loadMenuItem);
    menu.add(sMenuItem);
    menuBar.add(menu);

    this.setJMenuBar(menuBar);

    RComponentItem = new JMenuItem("Red Component");
    RComponentItem.addActionListener(this);
    menu.add(RComponentItem);

    GComponentItem = new JMenuItem("Green Component");
    GComponentItem.addActionListener(this);
    menu.add(GComponentItem);

    BComponentItem = new JMenuItem("Blue Component");
    BComponentItem.addActionListener(this);
    menu.add(BComponentItem);

    flipVerticallyItem = new JMenuItem("Flip Image Vertically");
    flipHorizontallyItem = new JMenuItem("Flip Image Horizontally");
    flipVerticallyItem.addActionListener(this);
    flipHorizontallyItem.addActionListener(this);
    menu.add(flipVerticallyItem);
    menu.add(flipHorizontallyItem);
    this.feature = null;
    blurItem = new JMenuItem("Blur Image");
    blurItem.addActionListener(this);
    menu.add(blurItem);
    sharpenItem = new JMenuItem("Sharpen Image");
    sharpenItem.addActionListener(this);
    menu.add(sharpenItem);
    grayscaleItem = new JMenuItem("Convert to Grayscale (Luma)");
    grayscaleItem.addActionListener(this);
    menu.add(grayscaleItem);
    sepiaTItem = new JMenuItem("Convert to Sepia Tone");
    sepiaTItem.addActionListener(this);
    menu.add(sepiaTItem);
    compressItem = new JMenuItem("Compress Image");
    compressItem.addActionListener(this);
    menu.add(compressItem);
    adjustLevelItem = new JMenuItem("Adjust Levels");
    adjustLevelItem.addActionListener(this);
    menu.add(adjustLevelItem);
    colorCorrectItem = new JMenuItem("Color Correct");
    colorCorrectItem.addActionListener(this);
    menu.add(colorCorrectItem);
    // Dither image.
    ditherItem = new JMenuItem("Dither Image");
    ditherItem.addActionListener(this);
    menu.add(ditherItem);

    splitViewItem = new JMenuItem("Split View");
    splitViewItem.addActionListener(this);
    menu.add(splitViewItem);

    sMenuItem.setEnabled(false);
    RComponentItem.setEnabled(false);
    BComponentItem.setEnabled(false);
    GComponentItem.setEnabled(false);
    flipHorizontallyItem.setEnabled(false);
    flipVerticallyItem.setEnabled(false);
    blurItem.setEnabled(false);
    sharpenItem.setEnabled(false);
    grayscaleItem.setEnabled(false);
    sepiaTItem.setEnabled(false);
    compressItem.setEnabled(false);
    adjustLevelItem.setEnabled(false);
    colorCorrectItem.setEnabled(false);
    splitViewItem.setEnabled(false);
    // Dither image.
    ditherItem.setEnabled(false);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(new Dimension(600, 400));
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  @Override
  public void addFeatures(Feature feature) {
    this.feature = feature;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Load Image":
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
        convertToGrayscale();
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
        openSplitViewWindow();
        break;
      // Dither Image.
      case "Dither Image":
        ditherImage();
        break;
      default:
        showErrorMessage("Invalid option selected");
        break;
    }
  }

  @Override
  public void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }


  private void loadImage() {
    if (checkImageIsSaved()) {
      int returnValue = fileSelecter.showOpenDialog(this);
      if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileSelecter.getSelectedFile();

        String[] args = {selectedFile.getAbsolutePath(), imageName};
        String message = feature.loadImage(args);

        if (message.contains("Image loaded")) {

          int[][][] image = feature.getImagePixels(imageName);
          BufferedImage bufferedImage = createImageFromPixelArray(image);
          ImageIcon imageIcon = new ImageIcon(bufferedImage);
          setImageIcon(imageIcon);
          loadHistogramInUI(imageName);
          imageSaved = true;
          setMenuItemsToTrue();

        } else {
          showErrorMessage(message);
        }
      }
    }
  }

  private void saveImage() {

    int returnValue = fileSelecter.showSaveDialog(this);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      File fileToSave = fileSelecter.getSelectedFile();
      String savePath = fileToSave.getAbsolutePath();

      String[] args = {savePath, imageName};
      String message = feature.saveImage(args);

      if (message.contains("Image saved")) {
        JOptionPane.showMessageDialog(this, "Image saved successfully to " + savePath, "Success",
            JOptionPane.INFORMATION_MESSAGE);
        imageSaved = true;
      } else {
        showErrorMessage(message);
      }
    }
  }


  private void componentImage(String color) {

    String[] args = {color, imageName, imageName};
    String message = feature.componentImage(args);
    if (message.contains("blue-component for") || message.contains("green-component for")
        || message.contains("red-component for")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }

  private void flipImage(String direction) {
    String[] args = {direction, imageName, imageName};

    String message = feature.flipImage(args);
    if (message.contains("Image horizontally flipped") || message.contains(
        "Image vertically flipped")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }

  private void blurImage() {
    String[] args = {imageName, imageName};
    String message = feature.blurImage(args);
    if (message.contains("Blurred the Image")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }

  private void sharpenImage() {
    String[] args = {imageName, imageName};
    String message = feature.sharpenImage(args);
    if (message.contains("Sharpened the Image")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }

  private void convertToGrayscale() {

    String[] args = {imageName, imageName};

    String message = feature.convertToGrayscaleLuma(args);
    if (message.contains("Converted to luma-component")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }

  private void convertToSepiaTone() {

    String[] args = {imageName, imageName};
    String message = feature.convertToSepiaTone(args);
    if (message.contains("Sepia of the Image")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }

  }

  private void compressImage() {

    String compressionPercentage = JOptionPane.showInputDialog(
        this,
        "Enter the compression percentage (0-100):",
        "Compression Percentage",
        JOptionPane.QUESTION_MESSAGE
    );
    if (compressionPercentage == null || compressionPercentage.trim().isEmpty()) {
      showErrorMessage("Compression Percentage cannot be empty");
      return;
    }

    String[] args = {compressionPercentage, imageName, imageName};
    String message = feature.compressImage(args);
    if (message.contains("Compressed the Image")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }

  private void adjustLevels() {

    String b = JOptionPane.showInputDialog(this, "Enter the black point value (b):");
    if (b == null || b.trim().isEmpty()) {
      showErrorMessage("Black-point(b) value cannot be empty");
      return;
    }
    String m = JOptionPane.showInputDialog(this, "Enter the mid point value (m):");
    if (m == null || m.trim().isEmpty()) {
      showErrorMessage("Mid-point(m) value cannot be empty");
      return;
    }
    String w = JOptionPane.showInputDialog(this, "Enter the white point value (w):");
    if (w == null || w.trim().isEmpty()) {
      showErrorMessage("White-point(w) value cannot be empty");
      return;
    }
    String[] args = {b, m, w, imageName, imageName};
    String message = feature.adjustLevels(args);
    if (message.contains("Level adjusted for the image and stored in")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }

  }

  private void colorCorrect() {

    String[] args = {imageName, imageName};

    String message = feature.colorCorrect(args);
    if (message.contains("Color of the Image Corrected")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }

  private void setImageIcon(ImageIcon icon) {
    imageLabel.setIcon(icon);
  }

  private void setHistogramIcon(ImageIcon icon) {
    imageLabel2.setIcon(icon);
  }

  private BufferedImage createImageFromPixelArray(int[][][] pixelArray) {
    int width = pixelArray[0].length;
    int height = pixelArray.length;

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int[] rgb = pixelArray[y][x];
        int pixel = new Color(rgb[0], rgb[1], rgb[2]).getRGB();
        bufferedImage.setRGB(x, y, pixel);
      }
    }

    return bufferedImage;
  }

  private void loadImageInUI(String destinationImageName) {
    int[][][] image = feature.getImagePixels(destinationImageName.trim());
    BufferedImage bufferedImage = createImageFromPixelArray(image);
    ImageIcon imageIcon = new ImageIcon(bufferedImage);
    setImageIcon(imageIcon);
    loadHistogramInUI(imageName);
    imageSaved = false;
  }


  private boolean checkImageIsSaved() {
    if (!imageSaved) {
      int userChoice = JOptionPane.showConfirmDialog(
          this,
          "The image is not saved. Do you want to proceed?",
          "Image not saved",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.QUESTION_MESSAGE
      );
      return userChoice == JOptionPane.YES_OPTION;
    }
    return true;
  }


  private void loadHistogramInUI(String destinationImageName) {

    int[][][] image = feature.getHistogram(destinationImageName);

    BufferedImage bufferedImage = createImageFromPixelArray(image);
    ImageIcon imageIcon = new ImageIcon(bufferedImage);
    setHistogramIcon(imageIcon);
  }

  private void setMenuItemsToTrue() {
    sMenuItem.setEnabled(true);
    RComponentItem.setEnabled(true);
    BComponentItem.setEnabled(true);
    GComponentItem.setEnabled(true);
    flipHorizontallyItem.setEnabled(true);
    flipVerticallyItem.setEnabled(true);
    blurItem.setEnabled(true);
    sharpenItem.setEnabled(true);
    grayscaleItem.setEnabled(true);
    sepiaTItem.setEnabled(true);
    compressItem.setEnabled(true);
    adjustLevelItem.setEnabled(true);
    colorCorrectItem.setEnabled(true);
    splitViewItem.setEnabled(true);
    // Dither image.
    ditherItem.setEnabled(true);
    textInfo.setVisible(false);
    textInfo2.setVisible(true);
  }

  private void openSplitViewWindow() {
    JFrame splitViewFrame = new JFrame("Split View Operations");
    splitViewFrame.setLayout(new GridLayout(1, 2));
    splitViewFrame.setPreferredSize(new Dimension(800, 400));

    JLabel resultImageLabel = new JLabel();
    JScrollPane resultScrollPane = new JScrollPane(resultImageLabel);
    splitViewFrame.add(resultScrollPane);

    JPanel rightPanel = new JPanel(new GridLayout(2, 1));

    JTextField bField = new JTextField(5);
    JTextField mField = new JTextField(5);
    JTextField wField = new JTextField(5);

    bField.setVisible(false);
    mField.setVisible(false);
    wField.setVisible(false);

    JPanel inputPanel = new JPanel(new GridLayout(0, 2));
    JTextField percentageField = new JTextField(5);
    String[] operations = {"blur", "sharpen", "sepia", "greyscale", "color-correction",
        "levels-adjustment", "dither"};
    JComboBox<String> operationBox = new JComboBox<>(operations);
    operationBox.setSelectedItem(operations[0]);
    inputPanel.add(new JLabel("Split Percentage:"));
    inputPanel.add(percentageField);
    inputPanel.add(new JLabel("Operation Type:"));
    inputPanel.add(operationBox);
    JLabel blackPointLabel = new JLabel("Black Point (b):");
    blackPointLabel.setVisible(false);
    inputPanel.add(blackPointLabel);
    inputPanel.add(bField);
    JLabel midPointLabel = new JLabel("Mid Point (m):");
    midPointLabel.setVisible(false);
    inputPanel.add(midPointLabel);
    inputPanel.add(mField);
    JLabel whitePointLabel = new JLabel("White Point (w):");
    whitePointLabel.setVisible(false);
    inputPanel.add(whitePointLabel);
    inputPanel.add(wField);
    operationBox.addActionListener(ae -> {
      boolean isLevelAdj = "levels-adjustment".equals(operationBox.getSelectedItem());
      blackPointLabel.setVisible(isLevelAdj);
      bField.setVisible(isLevelAdj);
      midPointLabel.setVisible(isLevelAdj);
      mField.setVisible(isLevelAdj);
      whitePointLabel.setVisible(isLevelAdj);
      wField.setVisible(isLevelAdj);
    });

    JPanel buttonsPanel = new JPanel(new FlowLayout());
    JButton performOperationButton = new JButton("Perform Operation");
    performOperationButton.addActionListener(ae -> performSplitOperation(
        tempImageName, percentageField.getText(), operationBox.getSelectedItem().toString(),
        resultImageLabel,
        splitViewFrame, bField, mField, wField
    ));
    buttonsPanel.add(performOperationButton);

    apply.setEnabled(false);
    apply.addActionListener(
        ae -> applyMainWindow(operationBox.getSelectedItem().toString(), resultImageLabel,
            splitViewFrame, bField, mField, wField));
    buttonsPanel.add(apply);

    rightPanel.add(inputPanel);
    rightPanel.add(buttonsPanel);

    splitViewFrame.add(rightPanel);

    splitViewFrame.pack();
    splitViewFrame.setLocationRelativeTo(null);
    splitViewFrame.setVisible(true);

    loadInTempUI(imageName, resultImageLabel);
  }


  private void performSplitOperation(String tempImageName, String percentage, String operation,
      JLabel resultImageLabel, JFrame splitViewFrame, JTextField bField,
      JTextField mField, JTextField wField) {
    String message;
    try {
      if ("blur".equals(operation)) {
        String[] args = {imageName, tempImageName, "split", percentage};
        message = feature.blurImage(args);
      } else if ("sharpen".equals(operation)) {
        String[] args = {imageName, tempImageName, "split", percentage};
        message = feature.sharpenImage(args);
      } else if ("sepia".equals(operation)) {
        String[] args = {imageName, tempImageName, "split", percentage};
        message = feature.convertToSepiaTone(args);
      } else if ("greyscale".equals(operation)) {
        String[] args = {imageName, tempImageName, "split", percentage};
        message = feature.convertToGreyScale(args);
      } else if ("color-correction".equals(operation)) {
        String[] args = {imageName, tempImageName, "split", percentage};
        message = feature.colorCorrect(args);
      } else if ("dither".equals(operation)) {
        // Dither image.
        String[] args = {imageName, tempImageName, "split", percentage};
        message = feature.ditherImage(args);
      } else {
        String bValue = bField.getText();
        String mValue = mField.getText();
        String wValue = wField.getText();
        String[] args = {bValue, mValue, wValue, imageName, tempImageName, "split", percentage};
        message = feature.adjustLevels(args);
      }
      if (message.contains("Successfully")) {
        loadInTempUI(tempImageName, resultImageLabel);
        apply.setEnabled(true);
        splitViewFrame.revalidate();
        splitViewFrame.repaint();
      } else {
        showErrorMessage(message);
      }

    } catch (Exception ex) {
      showErrorMessage(ex.getMessage());
    }
  }

  private void loadInTempUI(String tempImageName, JLabel resultImageLabel) {
    int[][][] image = feature.getImagePixels(tempImageName);
    BufferedImage bufferedImage = createImageFromPixelArray(image);

    ImageIcon imageIcon = new ImageIcon(bufferedImage);
    resultImageLabel.setIcon(imageIcon);
  }

  private void applyMainWindow(String operation,
      JLabel resultImageLabel, JFrame splitViewFrame, JTextField bField,
      JTextField mField, JTextField wField) {
    performSplitOperation(imageName, "100", operation, resultImageLabel, splitViewFrame, bField,
        mField, wField
    );
    splitViewFrame.dispose();
    loadImageInUI(imageName);
  }

  private void ditherImage() {
    String[] args = {imageName, imageName};
    String message = feature.ditherImage(args);
    if (message.contains("Dithered the Image")) {
      loadImageInUI(imageName);
    } else {
      showErrorMessage(message);
    }
  }
}

