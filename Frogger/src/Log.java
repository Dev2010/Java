import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Color;

public class Log extends Frog {

	int direction; // 0= backwards, 1=froward;

	public Log(int x, int y, int direction) {
		super(x, y);
		this.direction = direction;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(xPos, yPos, 120, 40);
	}

	public void move() {
		if (direction == 1) { // 1=forward
			xPos++;
		}
		if (direction == 0) {
			xPos--;
		}

	}

	public int getX() {
		return xPos;
	}

	public void setX(int x) {
		xPos = x;
	}

	public int getY() {
		return yPos;
	}

	public int getDirect() {
		return direction;
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public Rectangle getBorder() {
		return new Rectangle(xPos, yPos, 120, 40);
	}

}