package cs5004.animator.shapes;

import java.awt.Color;

/**
 * An abstract implementation of the Shape interface. Contains methods that are common to
 * all shape objects.
 */
public abstract class AbstractShape implements Shape {
  protected final String name;
  protected String type;
  public Color color;
  public Position pos;
  public double xDimension;
  public double yDimension;
  public int appearTime;
  public int disappearTime;

  /**
   * The shape constructor. Contains many fields to begin but the user shouldn't be using it
   * directly.  I am expecting that we will have to parse some sort of text input.
   * @param name - String - user-provided name of the shape.
   * @param color - Color - the color of the object provided in an RGB triplet.
   * @param pos - Position - the position of the object. Represents the center of an oval or the
   *            lower left corner of a rectangle.
   * @param xDimension - double - the x dimension of the object. Represents the x radius of an oval
   *                   or the width of a rectangle.
   * @param yDimension - double - the y dimension of the object. Represents the y radius of an oval
   *                   or the height of a rectangle.
   * @param appearTime - int - the frame that the shape should appear.
   * @param disappearTime - int - the frame that the shape should disappear.
   * @throws IllegalArgumentException if the user attempts to initialize an end time before a
   *         start time or if the user gives a dimension less than or equal to zero.
   */
  public AbstractShape(String name, Color color, Position pos, double xDimension, double yDimension,
                       int appearTime, int disappearTime) throws IllegalArgumentException {
    if (appearTime > disappearTime) {
      throw new IllegalArgumentException("Shape must disappear after if appears.");
    } else if (xDimension <= 0 || yDimension <= 0) {
      throw new IllegalArgumentException("The x and y dimensions of the shape must be greater"
              + "than zero.");
    }
    this.name = name;
    this.color = color;
    this.pos = pos;
    this.xDimension = xDimension;
    this.yDimension = yDimension;
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
  }

  public AbstractShape(String name) {
    this.name = name;
  }

  /**
   * Moves the shape to desired position.
   * @param newPos - a @Position - the destination position.
   */
  @Override
  public void move(Position newPos) {
    this.pos = newPos;
  }

  /**
   * Changes the shape's color.
   * @param newColor - a @Color - the new color desired.
   */
  @Override
  public void changeColor(Color newColor) {
    this.color = newColor;
  }

  /**
   * Scales the object to the new measurements given.
   * @param newXDimension - a double - the desired measure of the shape in the x direction.
   * @param newYDimension - a double - the desired measure of the shape in the y direction.
   */
  @Override
  public void scale(double newXDimension, double newYDimension) {
    this.yDimension = newYDimension;
    this.xDimension = newXDimension;
  }

  /**
   * Given a frame, returns if the shape is visible or not.
   * @param frame - int.
   * @return a boolean - whether or not shape is visible.
   */
  @Override
  public boolean isVisible(int frame) {
    if (appearTime == 0 && disappearTime == 0) {
      return true;
    }
    return frame >= appearTime && frame <= disappearTime;
  }

  /**
   * Returns the user-given name of the Shape object.
   * @return - a String - the name of the shape.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Returns the shape's position.
   * @return a @Position - the shape's position.
   */
  @Override
  public Position getPosition() {
    return this.pos;
  }

  /**
   * Returns the shape's color.
   * @return - a @Color - the shape's color.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Returns the x dimension of the shape. (x radius for ovals and width for rectangles)
   * @return a double - the x dimension of the shape.
   */
  @Override
  public double getXDimension() {
    return xDimension;
  }

  /**
   * Returns the y dimension of the shape. (y radius for ovals and height for rectangles)
   * @return a double - the y dimension of the shape.
   */
  @Override
  public double getYDimension() {
    return yDimension;
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
   * Returns a string form of the current shape.
   * @return a String - the shape represented as a string.
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * Produces a less detailed string form of this shape.
   * @return a String.
   */
  @Override
  public String simpleToString() {
    return this.name + " appears at time t=" + this.appearTime
            + " and disappears at time t=" + this.disappearTime + "\n";
  }
}
