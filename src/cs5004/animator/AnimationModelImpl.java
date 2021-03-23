package cs5004.animator;

import cs5004.animator.animations.Animation;
import cs5004.animator.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the Animation Model. Its methods at this point serve
 * to add shapes and animations to the Model and to print string forms of them.
 * It also allows shapes to be updated to a certain frame altogether.
 */
public class AnimationModelImpl implements AnimationModel {
  private List<Animation> animations = new ArrayList<>();
  private List<Shape> shapes = new ArrayList<>();
  int xBound;
  int yBound;
  int width;
  int height;

  /**
   * Sets bounds of the window of the model.
   * @param xBound - int
   * @param yBound - int
   * @param width - int
   * @param height - int
   */
  public void setWindowBounds(int xBound, int yBound, int width, int height) {
    this.xBound = xBound;
    this.yBound = yBound;
    this.width = width;
    this.height = height;
  }

  /**
   * Adds an animation to the interface.
   * @param anim - the animation to be added.
   */
  @Override
  public void addAnimation(Animation anim) {
    animations.add(anim);
  }

  /**
   * Adds a shape to the model.
   * @param shape - the shape to be added.
   */
  @Override
  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  /**
   * If given a frame, returns the a list of the shape objects visible at that frame.
   * @param frame - an int
   * @return - a list of Shape objects.
   */
  @Override
  public List<Shape> getShapesAtFrame(int frame) {
    List<Shape> visibleShapes = new ArrayList<>();
    for (Animation a : animations) {
      a.execute(frame);
    }
    for (Shape s : shapes) {
      if (s.isVisible(frame)) {
        visibleShapes.add(s);
      }
    }
    return visibleShapes;
  }

  /**
   * If given a string of a shape's name or id, will return that shape object.
   * @param name - String - the id/ name of the shape
   * @return - the first shape object with that name.
   */
  public Shape getShapeByName(String name) {
    for (Shape s : shapes) {
      if (s.getName().equals(name)) {
        return s;
      }
    }
    return null;
  }

  /**
   * Prints a string form of all of the current animations.
   * @return a String.
   */
  @Override
  public String printAnimations() {
    StringBuilder output = new StringBuilder();
    for (Animation a : animations) {
      output.append(a.toString());
    }
    return output.toString();
  }

  /**
   * Print state at given t. Will display: shapes visible with size, color, position.
   */
  @Override
  public String printStateAtFrame(int frame) {
    StringBuilder output = new StringBuilder();
    for (Animation a : animations) {
      a.execute(frame);
    }
    for (Shape s : shapes) {
      if (s.isVisible(frame)) {
        output.append(s.toString());
      }
    }
    return output.toString();
  }
}
