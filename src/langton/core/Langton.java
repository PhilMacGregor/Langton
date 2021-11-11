package langton.core;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MacGregor
 *
 */
public class Langton implements Processor {

  private final Collection<Ant> ants;

  private final Map<Point, Color> pixels;

  /**
   * constructor.
   * 
   * @param pixels
   */
  public Langton() {
    this.pixels = new HashMap<>();
    this.ants = new ArrayList<>();

    init();
  }

  private void init() {
    ants.add(redBlue(10, 0, Direction.UP));
  }

  private Ant redGreenWhite(int x, int y, Direction direction) {
    Ant ant = new Ant(x, y, direction);
    ant.addStep(Color.WHITE, Color.RED, Direction.LEFT);
    ant.addStep(Color.RED, Color.GREEN, Direction.LEFT);
    ant.addStep(Color.GREEN, Color.WHITE, Direction.RIGHT);
    return ant;
  }

  private Ant redBlue(int x, int y, Direction direction) {
    Ant ant = new Ant(x, y, direction);
    ant.addStep(Color.BLUE, Color.RED, Direction.RIGHT);
    ant.addStep(Color.RED, Color.BLUE, Direction.LEFT);
    return ant;
  }

  @Override
  public Map<Point, Color> update() {

    for (Ant ant : ants) {
      Point coords = ant.getCoords();
      Color from = pixels.get(coords);

      Color color = ant.step(from);
      pixels.put(coords, color);
    }

    return pixels;
  }

}
