package cs5004.animator;

import cs5004.animator.animations.Animation;
import cs5004.animator.shapes.Shape;

import java.util.List;

/**
 * An interface representing the full model as a list of cs5004.animator.animations.
 */
public interface AnimationModel {

  /**
   * Sets bounds of the window of the model.
   * @param xBound - int
   * @param yBound - int
   * @param width - int
   * @param height - int
   */
  void setWindowBounds(int xBound, int yBound, int width, int height);

  /**
   * Adds an animation to the interface.
   * @param anim - the animation to be added.
   */
  void addAnimation(Animation anim);

  /**
   * Adds a shape to the interface.
   * @param shape - the shape to be added.
   */
  void addShape(Shape shape);

  /**
   * If given a string of a shape's name or id, will return that shape object.
   * @param name - String - the id/ name of the shape
   * @return - the first shape object with that name.
   */
  public Shape getShapeByName(String name);

  /**
   * If given a frame, returns the a list of the shape objects visible at that frame.
   * @param frame - an int
   * @return - a list of Shape objects.
   */
  public List<Shape> getShapesAtFrame(int frame);

  /**
   * Prints a string form of all of the current animations.
   * @return a String.
   */
  String printAnimations();

  /**
   * Print state at given t. Will display shapes visible with size, color, position.
   */
  String printStateAtFrame(int frame);
}
