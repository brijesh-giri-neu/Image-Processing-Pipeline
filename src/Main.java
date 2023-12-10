import controller.ControllerImp;
import controller.ControllerInterface;
import controller.Feature;
import controller.GUIController;
import java.io.InputStreamReader;
import model.Model;
import model.ModelImp;
import view.GUIViewInterface;
import view.ImageViewerGUI;

/**
 * The main class which is the starting point of the application. This is used to create the objects
 * of the respective class and then run the program.
 */
public class Main {

  /**
   * The main function of the program.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Model model = ModelImp.getBuilder().build();
    if (args.length == 0) {
      Feature controller = new GUIController(model);
      GUIViewInterface gui = new ImageViewerGUI();
      controller.setView(gui);
    } else {
      ControllerInterface controllerInterface = new ControllerImp(model,
          new InputStreamReader(System.in), System.out);
      controllerInterface.run(args);
    }
  }
}



