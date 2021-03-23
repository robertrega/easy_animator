package cs5004.animator;

import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.util.Builder;
import cs5004.animator.view.TextView;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The main function of the EasyAnimator. Takes in parameters from the user and then runs
 * the animator.
 */
public final class EasyAnimator {
  /**
   * The Main function of the EasyAnimator. Takes in parameters from the user and then runs
   * the animator.
   * @param args - the user provided arguments (may be in any order):
   *             "-in" followed by the name of a text file to be read and animated. Program
   *             will look in the /resources folder. If no infile name is given, program
   *             will alert the user and then terminate.
   *             "-view" followed by either "visual" or "text". Visual will display the animation,
   *             text will output the text to a file if a name is given. If no view is specified,
   *             program will alert the user and then terminate.
   *             "-out" followed by what you want the name of a "-view text" output file to be. If
   *             not specified, will print to screen.
   *             "-speed" followed by an int representing the number of ticks per second for
   *             the animation to run.
   *             All of these inputs MUST be followed by the word go for the program to run.
   *             All inputs must be lower case.
   * @throws IllegalStateException if unable to read from file or unable to write to file.
   */
  public static void main(String[] args) throws IllegalStateException {
    String inputFileName = "";
    String outputFileName = "";
    String viewType = "";
    int speed = 1000;



    AnimationModel model = new AnimationModelImpl();
    AnimationBuilder<AnimationModel> animationBuilder = new Builder(model);
    AnimationReader reader = new AnimationReader();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      if (scanner.hasNext("-in")) {
        scanner.next();
        inputFileName = scanner.next();
      } else if (scanner.hasNext("-view")) {
        scanner.next();
        viewType = scanner.next();
        if (!viewType.toLowerCase().equals("visual")
            && !viewType.toLowerCase().equals("text")) {
          JOptionPane.showMessageDialog(new JFrame(), "Please enter either 'text' "
                  + "or 'visual' for view parameter.");
          System.exit(0);
        }
      } else if (scanner.hasNext("-out")) {
        scanner.next();
        outputFileName = scanner.next();
      } else if (scanner.hasNext("-speed")) {
        scanner.next();
        speed = 1000 / scanner.nextInt();
        if (speed < 1) {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid speed.");
          System.exit(0);
        }
      } else if (scanner.hasNext("go")) {
        break;
      }
    }

    if (viewType.equals("")) {
      JOptionPane.showMessageDialog(new JFrame(), "Please enter either 'text' "
              + "or 'visual' for view parameter.");
      System.exit(0);
    } else if (inputFileName.equals("")) {
      JOptionPane.showMessageDialog(new JFrame(), "Please enter an input file.");
      System.exit(0);
    }

    try {
      model = reader.parseFile(new FileReader("resources/" + inputFileName), animationBuilder);
    } catch (IOException e) {
      throw new IllegalStateException("Could not find file.");
    }

    if (viewType.toLowerCase().equals("visual")) {
      ControllerImpl controller = new ControllerImpl(model, new GraphicsView(), speed);
      controller.animate();
    } else if (viewType.toLowerCase().equals("text")) {
      TextView.createTextView(model, outputFileName);
    }


  }
}