package cs5004.animator.animations;

import cs5004.animator.shapes.Position;
import cs5004.animator.shapes.Shape;

/**
 * An implementation of a move animation.
 */
public class Move extends AbstractAnimation {
  private final Position newPos;
  private final Position oldPos;

  /**
   * A constructor for a move animation with the parameters below.
   * @param shape - Shape - the shape to have its color changed.
   * @param startTime - int - the start time for the animation.
   * @param endTime - int - the end time for the animation.
   * @param newPos - Position - a final position for the Shape after the animation is finished.
   */
  public Move(Shape shape, int startTime, int endTime, Position newPos) {
    super(shape, startTime, endTime);
    this.newPos = newPos;
    this.oldPos = shape.getPosition();
  }

  /**
   * Executes the move animation on the shape object up to the provided frame.
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
    double newX = fractionComplete * (newPos.getX() - oldPos.getX());
    double newY = fractionComplete * (newPos.getY() - oldPos.getY());
    Position newPosByFrame = new Position(newX + oldPos.getX(), newY + oldPos.getY());
    shape.move(newPosByFrame);
  }

  /**
   * Resets the shape to its original position.
   */
  @Override
  public void reset() {
    shape.move(oldPos);
  }

  /**
   * Returns a string representation of this animation.
   * @return - String - a representation of this animation.
   */
  @Override
  public String toString() {
    StringBuilder output  = new StringBuilder();
    output.append(shape.getName());
    output.append(" moves from " + shape.getPosition().toString());
    output.append(" to " + newPos.toString());
    output.append(" from t=" + startTime + " to t=" + endTime + "\n");

    return output.toString();
  }
}
