package cs5004.animator.shapes;

/**
 * A class representing a Cartesion coordinate. Has an x and a y value.
 */
public class Position {
  double x;
  double y;

  /**
   * Initializes a position - a Cartesion ordered pair.
   * @param x - double - the x position.
   * @param y - double - the y position.
   */
  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return the position's x value.
   * @return double - the x value of the position.
   */
  public double getX() {
    return this.x;
  }

  /**
   * Return the position's y value.
   * @return double - the y value of the position.
   */
  public double getY() {
    return this.y;
  }

  /**
   * Returned the position's ordered pair in the form (x,y).
   * @return a String representing the position.
   */
  public String toString() {
    return "(" + x + "," + y + ")";
  }


}
