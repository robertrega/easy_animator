package cs5004.animator.animations;

import cs5004.animator.shapes.Shape;

/**
 * An implementation of a scale animation.
 */
public class Scale extends AbstractAnimation {
  private final double newXDimension;
  private final double newYDimension;
  private final double oldXDim;
  private final double oldYDim;

  /**
   * A constructor for a scale animation with the parameters below.
   * @param shape - Shape - the shape to have its color changed.
   * @param startTime - int - the start time for the animation.
   * @param endTime - int - the end time for the animation.
   * @param newXDimension - double - how long the new x dimension will be.
   * @param newYDimension - double - how long the new y dimension will be.
   */
  public Scale(Shape shape, int startTime, int endTime,
               double newXDimension, double newYDimension) {
    super(shape, startTime, endTime);
    this.newXDimension = newXDimension;
    this.newYDimension = newYDimension;
    this.oldXDim = shape.getXDimension();
    this.oldYDim = shape.getYDimension();
  }

  /**
   * Executes the scale animation on the shape object up to the provided frame.
   * @param frame - int - the frame the user would like the shape object to update to.
   */
  @Override
  public void execute(int frame) {
    double fractionComplete =
            Math.min((frame - startTime)
                    / (double)(endTime - startTime), 1);
    if (fractionComplete < 0) {
      return;
    }
    double halfXDim = fractionComplete * (newXDimension - oldXDim);
    double halfYDim = fractionComplete * (newYDimension - oldYDim);
    shape.scale(halfXDim + this.oldXDim, halfYDim + this.oldYDim);
  }

  /**
   * Resets the shape to its original size.
   */
  @Override
  public void reset() {
    shape.scale(oldXDim, oldYDim);
  }

  /**
   * Returns a string representation of this animation.
   * @return - String - a representation of this animation.
   */
  @Override
  public String toString() {
    StringBuilder output  = new StringBuilder();
    output.append(shape.getName());
    output.append(" scales from width: " + oldXDim);
    output.append(", height: " + oldYDim);
    output.append(" to width: " + newXDimension);
    output.append(", height: " + newYDimension);
    output.append(" from t=" + startTime + " to t=" + endTime + "\n");

    return output.toString();
  }
}
