import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class EskivBall {

	int xPos;
	int yPos;

	int right, left, up, down = 0;

	public EskivBall(int x, int y) {

		xPos = x;

		yPos = y;

	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.fillOval(xPos, yPos, 30, 30);

	}

	public void move() {

		if ((xPos <= 540) && (xPos >= 0)) {
			xPos += left + right;
			if (xPos > 540) {
				xPos = 540;
			} else if (xPos < 0) {
				xPos = 0;
			}
		}

		if ((yPos <= 261) && (yPos >= 0)) {
			yPos += up + down;
			if (yPos > 261) {
				yPos = 261;
			} else if (yPos < 0) {
				yPos = 0;
			}
		}
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_DOWN)

			down = 1;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)

			right = 1;

		if (e.getKeyCode() == KeyEvent.VK_UP)

			up = -1;

		if (e.getKeyCode() == KeyEvent.VK_LEFT)

			left = -1;

	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_DOWN)

			down = 0;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)

			right = 0;

		if (e.getKeyCode() == KeyEvent.VK_UP)

			up = 0;

		if (e.getKeyCode() == KeyEvent.VK_LEFT)

			left = 0;

	}

	public Rectangle getBorder() {
		return new Rectangle(xPos, yPos, 27, 27);
	}

}