import javax.swing.JFrame;

import javax.swing.JPanel;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.RenderingHints;

import java.awt.event.*;

import java.io.File;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.awt.Rectangle;

public class Eskiv extends JPanel implements KeyListener {

	EskivBall ball = new EskivBall(0, 0);
	// EskivBall autBall=new EskivBall(20,20);
	BufferedImage image;
	int x = 50;
	int y = 50; // positions of bad guy
	boolean direct = false; // false=down, true=up

	public Eskiv() {

		setFocusable(true);

		JFrame frame = new JFrame("Eskiv");

		frame.setSize(586, 330);

		frame.add(this);

		frame.setVisible(true);

		addKeyListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {

			image = ImageIO.read(new File("src/harrypotter.jpg"));

		} catch (Exception e) {
		}

		while (true) {

			ball.move();

			if (direct) {
				if (y == 0) {
					direct = false;
				} else
					y--;
			} else {
				if (y == 270) {
					direct = true;
				} else
					y++;
			}

			Rectangle r = new Rectangle(x, y, 20, 20);

			if (r.intersects(ball.getBorder()))
				System.out.println("hit");

			// use a forloop to move all of the "bad guys" in an array

			// for..... i.move();

			repaint();

			try {

				Thread.sleep(5);

			} catch (Exception e) {
			}

		}

	}

	public static void main(String[] args) {

		Eskiv game = new Eskiv();

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(image, 0, 0, null);

		ball.paint(g2d);

		g2d.drawOval(x, y, 20, 20);

	}

	public void keyPressed(KeyEvent e) {

		ball.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {

		ball.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
		// not used
	}

}
