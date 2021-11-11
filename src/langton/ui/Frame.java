package langton.ui;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;
import javax.swing.JFrame;
import langton.Const;

/**
 * @author MacGregor
 *
 */
public class Frame extends JFrame {

  private final Label label;

  public Frame() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setTitle(Const.WINDOW_LABEL);

    this.label = new Label(Const.WINDOW_SIZE, Const.PIXEL_SIZE, Const.BACKGROUND_COLOR);
    this.add(label);

    GuiUtils.center(this);

    this.pack();
    this.setVisible(true);

  }

  public void update(Map<Point, Color> pixels) {
    this.label.setPixels(pixels);
    repaint();
  }

}
