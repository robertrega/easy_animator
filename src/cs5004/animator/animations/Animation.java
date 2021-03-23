package cs5004.animator.animations;

import cs5004.animator.shapes.Shape;

/**
 * A public interface representing all of the methods available to the user
 * for an animation object. All animations have a @Shape. Multiple animations
 * may be applied to the same shape object.
 */
public interface Animation {

  /**
   * Executes the animation up to the user-provided frame index.
   * @param frame - int - the frame the user would like the shape object to update to.
   */
  void execute(int frame);

  /**
   * Resets the shape to how it was originally initialized before this specific
   * animation was applied to it.
   */
  void reset();

  /**
   * Returns the shape of the animation.
   * @return the Shape object of the animation.
   */
  Shape getShape();

  /**
   * Returns a string representation of the animation.
   * @return
   */
  String toString();
}
