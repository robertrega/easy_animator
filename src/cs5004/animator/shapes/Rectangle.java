package cs5004.animator.shapes;

import java.awt.Color;

/**
 * A concrete class extending @AbstractShape representing a rectangle.
 */
public class Rectangle extends AbstractShape {
  String type = "Rectangle";

  /**
   * The rectangle constructor. Contains many fields to begin but the user shouldn't be using it
   * directly.  I am expecting that we will have to parse some sort of text input.
   * @param name - String - user-provided name of the shape.
   * @param color - Color - the color of the object provided in an RGB triplet.
   * @param pos - Position - the position of the object. Represents the lower
   *            left corner of the rectangle.
   * @param xDimension - double - the x dimension of the object. Represents
   *                   the width of the rectangle.
   * @param yDimension - double - the y dimension of the object. Represents the
   *                   height of the rectangle.
   * @param appearTime - int - the frame that the shape should appear.
   * @param disappearTime - int - the frame that the shape should disappear.
   * @throws IllegalArgumentException if the user attempts to initialize an end time before a
   *         start time.
   */
  public Rectangle(String name, Color color, Position pos,
                   double xDimension, double yDimension, int appearTime, int disappearTime)
          throws IllegalArgumentException {
    super(name, color, pos, xDimension, yDimension, appearTime, disappearTime);
  }

  /**
   * A barebones constructor that initializes a Rectangle with just a name.
   * @param name - a String, the shape's id.
   */
  public Rectangle(String name) {
    super(name);
  }

  /**
   * Return a String of the type of shape this is.
   * @return - a String.
   */
  @Override
  public String getType() {
    return this.type;
  }


  /**
   * Returns a string form of the rectangle.
   * @return a String - the rectangle represented as a string.
   */
  @Override
  public String toString() {
    StringBuilder output  = new StringBuilder();
    output.append("Name: " + this.name + "\n");
    output.append("Type: Rectangle" + "\n");
    output.append("Min corner: " + this.pos.toString() + "\n");
    output.append("Height: " + this.yDimension + ", Width: " + this.xDimension + "\n");
    output.append("Color: " + this.color.toString());
    output.append("\nAppears at t=" + appearTime);
    output.append("\nDisappears at t=" + disappearTime);

    return output.toString();
  }
}
