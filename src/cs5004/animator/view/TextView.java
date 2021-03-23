package cs5004.animator.view;

import cs5004.animator.AnimationModel;
import cs5004.animator.shapes.Shape;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class only contains a method to turn an animation into a text file
 * containing that animation as a string.
 */
public class TextView {

  /**
   * Creates a file containing the text view form of an animation and prints it to
   * the resources subfolder in this project.
   * @param model -  the model to print.
   * @param outputFileName - a String, the user-provided name of the output file. If not provided,
   *                       will print to the terminal.
   * @throws IllegalStateException - if unable to write to a file.
   */
  public static void createTextView(AnimationModel model, String outputFileName)
          throws IllegalStateException {
    StringBuilder output = new StringBuilder();

    for (Shape s : model.getShapesAtFrame(0)) {
      output.append(s.simpleToString());
    }

    output.append("\n" + model.printAnimations());

    if (outputFileName.equals("")) {
      System.out.print(output.toString());
    }

    java.lang.String path = "./resources/" + outputFileName;


    try {
      Files.write(Paths.get(path), output.toString().getBytes());
    } catch (java.io.IOException e) {
      throw new IllegalStateException("Unable to write to file!");
    }
  }



}
