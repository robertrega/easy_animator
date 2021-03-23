package cs5004.animator.util;

import cs5004.animator.AnimationModel;
import cs5004.animator.animations.ColorChange;
import cs5004.animator.animations.Move;
import cs5004.animator.animations.Scale;
import cs5004.animator.shapes.Oval;
import cs5004.animator.shapes.Position;
import cs5004.animator.shapes.Rectangle;
import cs5004.animator.shapes.Shape;

import java.awt.Color;

/**
 * An implementation of the AnimationBuilder interface that lines up with my
 * animation model.
 */
public final class Builder implements AnimationBuilder<AnimationModel> {
  private final AnimationModel model;

  public Builder(AnimationModel model) {
    this.model = model;
  }

  /**
   * Builds the model.
   * @return a blank Animation Model.
   */
  @Override
  public AnimationModel build() {
    return this.model;
  }

  /**
   * Sets the window size for the model.
   * @param x The leftmost x value
   * @param y The topmost y value
   * @param width The width of the bounding box
   * @param height The height of the bounding box
   * @return the model
   */
  @Override
  public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
    this.model.setWindowBounds(x, y, width, height);
    return this;
  }

  /**
   * Declares an empty shape from a parsed string.
   * @param name The unique name of the shape to be added.
   *             No shape with this name should already exist.
   * @param type The type of shape (e.g. "ellipse", "rectangle") to be added.
   *             The set of supported shapes is unspecified, but should
   *             include "ellipse" and "rectangle" as a minimum.
   * @return the model with new shapes added.
   */
  @Override
  public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
    switch (type) {
      case "ellipse":
        Shape oval = new Oval(name);
        this.model.addShape(oval);
        break;
      case "rectangle":
        Shape rectangle = new Rectangle(name);
        this.model.addShape(rectangle);
        break;
      default:
        break;
    }
    return this;
  }

  /**
   * Adds animations to the model.
   * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   * @return the model with animations added.
   */
  @Override
  public AnimationBuilder<AnimationModel> addMotion(String name,
                                                    int t1, int x1, int y1, int w1,
                                                    int h1, int r1, int g1, int b1,
                                                    int t2, int x2, int y2, int w2,
                                                    int h2, int r2, int g2, int b2) {

    this.model.getShapeByName(name).changeColor(new Color(r1, g1, b1));
    this.model.getShapeByName(name).scale(w1, h1);
    this.model.getShapeByName(name).move(new Position(x1, y1));

    if ((r1 != r2) || (g1 != g2) || (b1 != b2)) {
      this.model.addAnimation(new ColorChange(this.model.getShapeByName(name),
              t1, t2, new Color(r2, g2, b2)));
    }
    if ((this.model.getShapeByName(name).getXDimension() != w2)
            || (this.model.getShapeByName(name).getYDimension() != h2)) {
      this.model.addAnimation(new Scale(this.model.getShapeByName(name),
              t1, t2, w2, h2));
    }
    if ((this.model.getShapeByName(name).getPosition().getX() != x2)
            || (this.model.getShapeByName(name).getPosition().getY() != y2)) {
      this.model.addAnimation(new Move(this.model.getShapeByName(name),
              t1, t2, new Position(x2, y2)));
    }

    return this;
  }
}