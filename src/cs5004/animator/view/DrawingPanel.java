package cs5004.animator.view;

import cs5004.animator.shapes.Shape;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a helper class to GraphicsView that is able to paint each
 * frame to the screen.
 */
public class DrawingPanel extends JPanel {
  List<Shape> shapes = new ArrayList<>();

  /**
   * Initializes a drawingPanel object.
   */
  public DrawingPanel() {
    super();
    setPreferredSize(new Dimension(1000, 1000));
    setBackground(Color.WHITE);
  }

  /**
   * A method that allows input of a list of shapes to be painted later.
   * @param shapes -  a List of Shape objects.
   */
  public void provideShapes(List<Shape> shapes) {
    this.shapes = shapes;
  }


  /**
   * Paints all of the shapes in its list to the screen. Does not need to be called
   * explicitly.
   * @param g - a Graphics object.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Shape s : shapes) {
      g.setColor(s.getColor());
      if (s.getType().equalsIgnoreCase("oval")) {
        g.fillOval((int) s.getPosition().getX(), (int) s.getPosition().getY(),
                (int) s.getXDimension(), (int) s.getYDimension());
      } else if (s.getType().equalsIgnoreCase("rectangle")) {
        g.fillRect((int) s.getPosition().getX(), (int) s.getPosition().getY(),
                (int) s.getXDimension(), (int) s.getYDimension());
      }
    }
  }
}
