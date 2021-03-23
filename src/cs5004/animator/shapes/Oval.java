package cs5004.animator.shapes;

import java.awt.Color;

/**
 * A concrete class representing an oval shape.
 */
public class Oval extends AbstractShape {
  String type = "Oval";

  /**
   * The oval constructor. Contains many fields to begin but the user shouldn't be using it
   * directly.  I am expecting that we will have to parse some sort of text input.
   * @param name - String - user-provided name of the shape.
   * @param color - Color - the color of the object provided in an RGB triplet.
   * @param pos - Position - the position of the object. Represents the center point of an oval.
   * @param xDimension - double - the x dimension of the object. Represents the x radius.
   * @param yDimension - double - the y dimension of the object. Represents the y radius.
   * @param appearTime - int - the frame that the shape should appear.
   * @param disappearTime - int - the frame that the shape should disappear.
   * @throws IllegalArgumentException if the user attempts to initialize an end time before a
   *         start time.
   */
  public Oval(String name, Color color, Position pos, double xDimension,
              double yDimension, int appearTime, int disappearTime)
          throws IllegalArgumentException {
    super(name, color, pos, xDimension, yDimension, appearTime, disappearTime);
  }

  /**
   * A barebones constructor that initializes an Oval with just its name.
   * @param name - a String, the shape's id.
   */
  public Oval(String name) {
    super(name);
  }

  @Override
  public String getType() {
    return this.type;
  }


  /**
   * Returns a string form of the oval.
   * @return a String - the oval represented as a string.
   */
  @Override
  public String toString() {
    StringBuilder output  = new StringBuilder();
    output.append("Name: " + this.name + "\n");
    output.append("Type: Oval" + "\n");
    output.append("Center: " + this.pos.toString() + "\n");
    output.append("X Radius: " + this.xDimension + ", Y Radius: " + this.yDimension + "\n");
    output.append("Color: " + this.color.toString());
    output.append("\nAppears at t=" + appearTime);
    output.append("\nDisappears at t=" + disappearTime);

    return output.toString();
  }


}
