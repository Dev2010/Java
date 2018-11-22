import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Color;

public class Frog {

	int xPos;
	int yPos;
	boolean jerky;
	Point mid;

	int right, left, up, down = 0;
	BufferedImage image;

	public Frog(int x, int y) {
		try { // rip idk what this does

			image = ImageIO.read(new File("C:\\Users\\10010422\\Desktop\\forgotFlash\\frogger\\thisBetterBeIt.png"));

		} catch (Exception e) {
		}
		xPos = x;
		yPos = y;
		mid = new Point(xPos + 17, yPos + 14);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, xPos, yPos, null, null);
	}

	public void move() {
		if ((xPos <= 538) && (xPos >= 0)) {
			xPos += left + right;
			left = 0;
			right = 0;
			if (xPos > 538) {
				xPos = 538;
			} else if (xPos < 0) {
				xPos = 0;
			}
		}
		if ((yPos <= 660) && (yPos >= 0)) {
			yPos += up + down;
			up = 0;
			down = 0;
			if (yPos > 660) {
				yPos = 660;
			} else if (yPos < 0) {
				yPos = 0;
			}
		}

		if (yPos == 385) {
			yPos = 377;
		}
		mid = new Point(xPos + 17, yPos + 14);
	}

	public boolean win(Rectangle[] lilies) {
		for (int x = 0; x < lilies.length; x++) {
			if (lilies[x].contains(mid)) {
				return true;
			}
		}
		return false;
	}

	public boolean cruise(Log log) {
		int direct = log.getDirect();
		if (direct > 0) { // 1=forward
			xPos++;
			if (xPos > 550) {
				return false;
			}
		} else {
			xPos--;
			if (xPos < 0) {
				return false;
			}
		}
		if (!isWithin(log.getBorder())) {
			return false;
		}
		return true;
	}

	public boolean isWithin(Rectangle r) {
		return r.contains(mid);
	}

	public Point getMid() {
		return mid;
	}

	public int getY() {
		return yPos;
	}

	public int getX() {
		return xPos;
	}

	public void keyPressed(KeyEvent e) {
		if (jerky) {
			if (yPos >= 377) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					down = 47;
					try { // rip idk what this does

						image = ImageIO.read(
								new File("C:\\Users\\10010422\\Desktop\\forgotFlash\\frogger\\thisBetterBeItD.png"));

					} catch (Exception ex) {
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right = 47;
					try { // rip idk what this does

						image = ImageIO.read(
								new File("C:\\Users\\10010422\\Desktop\\forgotFlash\\frogger\\thisBetterBeItR.png"));

					} catch (Exception ex) {
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					up = -47;
					try { // rip idk what this does

						image = ImageIO.read(
								new File("C:\\Users\\10010422\\Desktop\\forgotFlash\\frogger\\thisBetterBeIt.png"));

					} catch (Exception ex) {
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					left = -47;
					try { // rip idk what this does

						image = ImageIO.read(
								new File("C:\\Users\\10010422\\Desktop\\forgotFlash\\frogger\\thisBetterBeItL.png"));

					} catch (Exception ex) {
					}
				}
			} else {
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					down = 47;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					right = 47;
				if (e.getKeyCode() == KeyEvent.VK_UP)
					up = -47;
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					left = -47;
			}
			jerky = false;
		}
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
		jerky = true;
	}

	public Rectangle getBorder() {
		return new Rectangle(xPos, yPos, 34, 28);
	}

}