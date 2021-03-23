package cs5004.animator.animations;

import cs5004.animator.shapes.Shape;

/**
 * Represents an abstract implementation of the Animation interface. 
 */
public abstract class AbstractAnimation implements Animation {
  protected Shape shape;
  protected int startTime;
  protected int endTime;

  /**
   * Constructor for the attributes common to all animations like start time and end time.
   * Animations can only exist if they are tied to a shape, so every animation has a shape
   * as well. In this way multiple animations can be created using the same shape object.
   *
   * @param shape - a Shape - the shape to display the animation.
   * @param startTime - int - the time for the animation to start.
   * @param endTime - int - the time for the animation to end.
   * @throws IllegalArgumentException if the user attempts to enter a start time after
   *         the end time.
   */
  public AbstractAnimation(Shape shape, int startTime, int endTime)
          throws IllegalArgumentException {
    if (startTime > endTime) {
      throw new IllegalArgumentException("Animation must start before it ends.");
    }
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Returns the shape of the animation.
   * @return the Shape object of the animation.
   */
  @Override
  public Shape getShape() {
    return this.shape;
  }

  /**
   * Provides a string representation of an animation.
   * @return String representation of an animation.
   */
  @Override
  public String toString() {
    return "";
  }
}
