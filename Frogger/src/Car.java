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

public class Car extends Frog {

	int direction; // 0= backwards, 1=froward;

	public Car(int x, int y, int direction) {
		super(x, y);
		this.direction = direction;

		try { // rip idk what this does

			if (direction > 0) {
				//image = ImageIO.read(new File("carro.gif"));
				image = ImageIO.read(getClass().getResource("carro.gif"));
				
			} else
				//image = ImageIO.read(new File("carroflip.gif"));
			image = ImageIO.read(getClass().getResource("carroflip.gif"));

		} catch (Exception e) {
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, xPos, yPos, Color.black, null);
	}

	public void move() {
		if (direction > 0) { // 1=forward
			xPos++;
		} else
			xPos--;
	}

	public int getX() {
		return xPos;
	}

	public void setX(int x) {
		xPos = x;
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public Rectangle getBorder() {
		return new Rectangle(xPos, yPos, 58, 28);
	}

}