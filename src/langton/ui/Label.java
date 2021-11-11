package langton.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JLabel;

/**
 * @author MacGregor
 *
 */
public class Label extends JLabel {

  private final Dimension pixelSize;

  private final Point center;

  private Map<Point, Color> pixels = Collections.emptyMap();

  /**
   * constructor.
   * 
   * @param pixelSize
   */
  public Label(Dimension preferredSize, Dimension pixelSize, Color bacgroundColor) {
    this.setPreferredSize(preferredSize);

    this.pixelSize = pixelSize;

    this.center = new Point(preferredSize.width / pixelSize.width / 2,
        preferredSize.height / pixelSize.height / 2);

    this.setBackground(bacgroundColor);
    this.setOpaque(true);
  }

  public void setPixels(Map<Point, Color> pixels) {
    this.pixels = pixels;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Entry<Point, Color> pixel : pixels.entrySet()) {

      fillRect(g, pixel.getKey(), pixel.getValue());

    }

  }

  private void fillRect(Graphics g, Point coords, Color color) {
    g.setColor(color);
    g.fillRect((center.x + coords.x) * pixelSize.width, (center.y + coords.y) * pixelSize.height,
        pixelSize.width, pixelSize.height);
  }

}
