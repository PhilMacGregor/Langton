package langton.core;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author MacGregor
 *
 */
public class Ant {

  private Point coords;

  private Direction direction;

  private Step defaultStep;

  private Map<Color, Step> steps;

  /**
   * constructor.
   * 
   * @param coords
   * @param direction
   */
  public Ant(int x, int y, Direction direction) {
    this.coords = new Point(x, y);
    this.direction = direction;
    this.steps = new HashMap<>();
  }

  public Point getCoords() {
    return this.coords;
  }

  public void addStep(Color from, Color to, Direction direction) {
    Step step = new Step(direction, to);

    if (defaultStep == null) {
      this.defaultStep = step;
    }
    this.steps.put(from, step);
    this.steps.put(to, defaultStep);
  }

  public Color step(Color color) {

    Step step = Optional.ofNullable(color).map(steps::get).orElse(defaultStep);

    this.direction = direction.turn(step.direction);
    Point vector = direction.getVector();

    this.coords = new Point(coords.x + vector.x, coords.y + vector.y);

    return step.color;

  }

  private class Step {

    private Direction direction;

    private Color color;

    /**
     * constructor.
     * 
     * @param direction
     * @param color
     */
    public Step(Direction direction, Color color) {
      this.direction = direction;
      this.color = color;
    }

  }

}
