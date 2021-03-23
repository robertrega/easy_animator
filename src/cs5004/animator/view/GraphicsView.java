package cs5004.animator.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.util.List;

import cs5004.animator.shapes.Shape;

/**
 * A class representing an implementation of IView, specifically the visual
 * graphics rendering of an animation.
 */
public class GraphicsView extends JFrame {
  private final DrawingPanel panel;

  /**
   * Initializes a new graphics window to display an animation.
   */
  public GraphicsView() {
    super();
    setSize(1000, 1000);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    panel = new DrawingPanel();
    JScrollPane scroll = new JScrollPane(panel);

    add(scroll);

    setVisible(true);
  }

  /**
   * Provides the list of shapes (with animations attached) to the panel so that
   * it may paint them.
   * @param shapes - a list of Shape objects.
   */
  public void provideShapes(List<Shape> shapes) {
    panel.provideShapes(shapes);
  }

  /**
   * Refreshes the panel on each new frame.
   */
  public void refresh() {
    panel.repaint();
  }
}


