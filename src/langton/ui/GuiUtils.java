package langton.ui;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Window;

/**
 * @author MacGregor
 *
 */
public class GuiUtils {

  public static void center(Window comp) {
    Point stred = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    stred.move(stred.x - (comp.getPreferredSize().width / 2),
        stred.y - (comp.getPreferredSize().height / 2));
    comp.setLocation(stred);
  }

}
