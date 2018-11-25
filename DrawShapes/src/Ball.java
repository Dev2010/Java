import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball {

	int ballRadius = 20;
	int x = 0;
	int y = 0;
	
	public Ball() {}
	
	public Ball(int radius)
	{
		ballRadius = radius;
	}
	
	public void Draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLUE);
		g2d.fillOval(x++, y++, 2 * ballRadius, 2 * ballRadius);
	}
}
