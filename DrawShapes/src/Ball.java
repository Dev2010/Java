import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball {

	public void Draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLUE);
		g2d.fillOval(20, 20, 20, 20);
	}
}
