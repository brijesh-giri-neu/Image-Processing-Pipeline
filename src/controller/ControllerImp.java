package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import model.Model;
import view.View;
import view.ViewInterface;

/**
 * An implementation of the interface ControllerInterface which represents a controller and has the
 * ability to run and execute any command used by the user.
 */
public class ControllerImp implements ControllerInterface {

  private final Model model;
  private final ViewInterface view;
  private final BufferedReader in;


  /**
   * A constructor to initialize the controller object when created.
   *
   * @param model the model that is being used
   * @param in    the input as given by the user/client
   * @param out   the output that needs to be displayed to the user/client
   */

  public ControllerImp(Model model, Readable in, Appendable out) {
    this.model = model;
    this.in = new BufferedReader((Reader) in);
    this.view = new View(out);
  }


  @Override
  public void run(String[] args) {
    String commandLine;
    if (args.length > 1) {
      try {
        execute("", args);
      } catch (IOException e) {
        view.displayMessage("An error occurred while executing the command line arguement: ");
      }

    } else if (args[0].equals("-text")) {
      try {
        view.start();
        while ((commandLine = in.readLine()) != null) {
          if (commandLine.equalsIgnoreCase("exit")) {
            view.close();
            return;
          }

          execute(commandLine, args);
        }
      } catch (IOException e) {
        view.displayMessage("An error occurred while reading the command: ");
      }
    } else {
      view.displayMessage("Invalid Command line argument entered");
    }
  }

  @Override
  public void execute(String commandLine, String[] args) throws IOException {
    Command command;
    if (args.length > 1) {
      if (args.length == 2 && args[0].equals("-file") && args[1].endsWith(".txt")) {
        view.start();
        command = createCommand("run", new String[]{args[1]});
        command.execute();
        view.close();
      } else {
        view.displayMessage("Invalid command line argument given\n");
      }
      System.exit(0);

    } else {
      String[] parts = commandLine.split(" ");
      command = createCommand(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
      command.execute();
    }
  }

  private Command createCommand(String command, String[] args) {
    return new ImageCommand(model, command, args, this.view);
  }

}
