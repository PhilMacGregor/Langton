package langton.core;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MacGregor
 *
 */
public class DrawHello implements Processor {

  private Map<Point, Color> pixels;

  public DrawHello() {
    this.pixels = new HashMap<>();

    init();
  }

  private void init() {
    this.pixels.putAll(drawHello());
  }

  @Override
  public Map<Point, Color> update() {

    this.pixels = pixels.entrySet().stream().collect(
        Collectors.toMap(e -> new Point(e.getKey().x - 1, e.getKey().y), e -> e.getValue()));

    return pixels;

  }

  private Map<Point, Color> drawHello() {

    Map<Point, Color> pixels = new HashMap<>();
    /*
     * A
     */
    pixels.put(new Point(-5, -4), Color.RED);
    pixels.put(new Point(-5, -3), Color.RED);
    pixels.put(new Point(-5, -2), Color.RED);
    pixels.put(new Point(-5, -1), Color.RED);
    pixels.put(new Point(-5, 0), Color.RED);

    pixels.put(new Point(-4, -5), Color.RED);
    pixels.put(new Point(-3, -5), Color.RED);
    pixels.put(new Point(-2, -5), Color.RED);

    pixels.put(new Point(-4, -2), Color.RED);
    pixels.put(new Point(-3, -2), Color.RED);
    pixels.put(new Point(-2, -2), Color.RED);

    pixels.put(new Point(-1, -4), Color.RED);
    pixels.put(new Point(-1, -3), Color.RED);
    pixels.put(new Point(-1, -2), Color.RED);
    pixels.put(new Point(-1, -1), Color.RED);
    pixels.put(new Point(-1, 0), Color.RED);

    /*
     * H
     */
    pixels.put(new Point(1, -5), Color.YELLOW);
    pixels.put(new Point(1, -4), Color.YELLOW);
    pixels.put(new Point(1, -3), Color.YELLOW);
    pixels.put(new Point(1, -2), Color.YELLOW);
    pixels.put(new Point(1, -1), Color.YELLOW);
    pixels.put(new Point(1, 0), Color.YELLOW);

    pixels.put(new Point(2, -2), Color.YELLOW);
    pixels.put(new Point(3, -2), Color.YELLOW);
    pixels.put(new Point(4, -2), Color.YELLOW);

    pixels.put(new Point(5, -5), Color.YELLOW);
    pixels.put(new Point(5, -4), Color.YELLOW);
    pixels.put(new Point(5, -3), Color.YELLOW);
    pixels.put(new Point(5, -2), Color.YELLOW);
    pixels.put(new Point(5, -1), Color.YELLOW);
    pixels.put(new Point(5, 0), Color.YELLOW);

    /*
     * O
     */
    pixels.put(new Point(7, -4), Color.GREEN);
    pixels.put(new Point(7, -3), Color.GREEN);
    pixels.put(new Point(7, -2), Color.GREEN);
    pixels.put(new Point(7, -1), Color.GREEN);

    pixels.put(new Point(8, -5), Color.GREEN);
    pixels.put(new Point(9, -5), Color.GREEN);
    pixels.put(new Point(10, -5), Color.GREEN);

    pixels.put(new Point(8, 0), Color.GREEN);
    pixels.put(new Point(9, 0), Color.GREEN);
    pixels.put(new Point(10, 0), Color.GREEN);

    pixels.put(new Point(11, -4), Color.GREEN);
    pixels.put(new Point(11, -3), Color.GREEN);
    pixels.put(new Point(11, -2), Color.GREEN);
    pixels.put(new Point(11, -1), Color.GREEN);

    /*
     * J
     */
    pixels.put(new Point(13, -1), Color.CYAN);

    pixels.put(new Point(14, 0), Color.CYAN);
    pixels.put(new Point(15, 0), Color.CYAN);
    pixels.put(new Point(16, 0), Color.CYAN);

    pixels.put(new Point(17, -5), Color.CYAN);
    pixels.put(new Point(17, -4), Color.CYAN);
    pixels.put(new Point(17, -3), Color.CYAN);
    pixels.put(new Point(17, -2), Color.CYAN);
    pixels.put(new Point(17, -1), Color.CYAN);

    return pixels;
  }

}
