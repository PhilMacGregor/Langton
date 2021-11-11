package langton;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;
import langton.core.Langton;
import langton.core.Processor;
import langton.ui.Frame;

/**
 * @author MacGregor
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // final Processor processor = new DrawHello();
    final Processor processor = new Langton();
    final Frame frame = new Frame();

    while (true) {
      final Map<Point, Color> pixels = processor.update();
      frame.update(pixels);

      try {
        Thread.sleep(Const.STEP_CLOCK);
      } catch (InterruptedException e) {
        e.printStackTrace(System.err);
        System.exit(1);
      }
    }

  }

}
