package langton.core;

import java.awt.Point;
import java.util.Arrays;

/**
 * @author MacGregor
 *
 */
public enum Direction {

  UP(0, -1), LEFT(-1, 0), DOWN(0, 1), RIGHT(1, 0);

  private final Point vector;

  /**
   * constructor.
   * 
   * @param vector
   */
  private Direction(int x, int y) {
    this.vector = new Point(x, y);
  }

  public Point getVector() {
    return this.vector;
  }

  public Direction turn(Direction where) {
    int phase = this.ordinal() + where.ordinal();
    return getByPhase(phase % values().length);
  }

  private Direction getByPhase(int phase) {
    return Arrays.stream(values()).filter(d -> d.ordinal() == phase).findFirst()
        .orElseThrow(() -> new RuntimeException("Nesprávné číslo fáze: " + phase));
  }

}
