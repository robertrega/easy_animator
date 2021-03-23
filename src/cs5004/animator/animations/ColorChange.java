package cs5004.animator.animations;

import cs5004.animator.shapes.Shape;
import java.awt.Color;

/**
 * Implementation of a color change animation.
 */
public class ColorChange extends AbstractAnimation {
  private final Color newColor;
  private final Color oldColor;

  /**
   * Constructor for a color change animation.
   * @param shape - Shape - the shape to have its color changed.
   * @param startTime - int - the start time for the animation.
   * @param endTime - int - the end time for the animation.
   * @param newColor - Color - the new color after the animation has happened.
   */
  public ColorChange(Shape shape, int startTime, int endTime, Color newColor) {
    super(shape, startTime, endTime);
    this.newColor = newColor;
    this.oldColor = shape.getColor();
  }

  /**
   * Executes the color change animation on the shape object up to the provided frame.
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
    int newR = (int)(fractionComplete * (newColor.getRed() - oldColor.getRed()));
    int newG = (int)(fractionComplete * (newColor.getGreen() - oldColor.getGreen()));
    int newB = (int)(fractionComplete * (newColor.getBlue() - oldColor.getBlue()));
    Color newColorByFrame = new Color(newR + oldColor.getRed(),
            newG + oldColor.getGreen(), newB + oldColor.getBlue());
    shape.changeColor(newColorByFrame);
  }

  /**
   * Resets the shape to its original color.
   */
  @Override
  public void reset() {
    shape.changeColor(oldColor);
  }

  /**
   * Returns a string representation of this animation.
   * @return - String - a representation of this animation.
   */
  @Override
  public String toString() {
    StringBuilder output  = new StringBuilder();
    output.append(shape.getName());
    output.append(" changes from "
            + shape.getColor().toString().substring(14, shape.getColor().toString().length()));
    output.append(" to " + newColor.toString().substring(14, newColor.toString().length()));
    output.append(" from t=" + startTime + " to t=" + endTime + "\n");

    return output.toString();
  }
}
