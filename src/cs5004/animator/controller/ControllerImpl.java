package cs5004.animator.controller;

import cs5004.animator.AnimationModel;
import cs5004.animator.view.GraphicsView;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An implementation of the Animation controller.
 */
public class ControllerImpl implements Controller {
  private Timer timer;
  int currentFrame = 0;

  /**
   * The constructor takes in an animation model, a view and a speed and then
   * relegates these parameters to the view to produce the animation visual.
   * Creates a timer that, at every tick, receives updated frames and paints
   * them to the screen.
   * @param model - an Animation Model.
   * @param view - a Graphics view.
   * @param speed - int - the number of milliseconds of delay for the timer.
   */
  public ControllerImpl(AnimationModel model, GraphicsView view, int speed) {
    this.timer = new Timer(speed, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        view.provideShapes(model.getShapesAtFrame(currentFrame));
        view.refresh();
        if (!model.getShapesAtFrame(currentFrame + 1).isEmpty()) {
          currentFrame++;
        }
      }
    }
    );
  }

  /**
   * Starts the animation. The equivalent of a go method.
   */
  @Override
  public void animate() {
    timer.start();
  }
}
