package langton.core;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

/**
 * @author MacGregor
 *
 */
public interface Processor {

  Map<Point, Color> update();

}