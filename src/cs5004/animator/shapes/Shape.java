package cs5004.animator.shapes;

import java.awt.Color;

/**
 * An interface representing a shape object. Includes methods visitble to the user
 * ans common to all cs5004.animator.shapes.
 */
public interface Shape {

  /**
   * Changes the shape's position.
   * @param newPos - a @Position - the destination position.
   */
  void move(Position newPos);

  /**
   * Changes the cs5004.animator.shapes color.
   * @param newColor - a @Color - the new color desired.
   */
  void changeColor(Color newColor);

  /**
   * Scales the shape larger or smaller.
   * @param newXDimension - a double - the desired measure of the shape in the x direction.
   * @param newYDimension - a double - the desired measure of the shape in the y direction.
   */
  void scale(double newXDimension, double newYDimension);

  /**
   * Given a frame, returns if the shape is visible or not.
   * @param frame - int.
   * @return a boolean - whether or not shape is visible.
   */
  boolean isVisible(int frame);

  /**
   * Returns the user-given name of the Shape object.
   * @return - a String - the name of the shape.
   */
  String getName();

  /**
   * Returns the shape's position.
   * @return a @Position - the shape's position.
   */
  Position getPosition();

  /**
   * Returns the shape's color.
   * @return - a @Color - the shape's color.
   */
  Color getColor();

  /**
   * Return a String of the type of shape this is.
   * @return - a String.
   */
  String getType();

  /**
   * Returns the x dimension of the shape. (x radius for ovals and width for rectangles)
   * @return a double - the x dimension of the shape.
   */
  double getXDimension();

  /**
   * Returns the y dimension of the shape. (y radius for ovals and height for rectangles)
   * @return a double - the y dimension of the shape.
   */
  double getYDimension();

  /**
   * Returns a string form of the current shape.
   * @return a String - the shape represented as a string.
   */
  String toString();

  /**
   * Produces a less detailed string form of this shape.
   * @return a String.
   */
  String simpleToString();

}
