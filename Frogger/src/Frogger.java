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
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class Frogger extends JPanel implements KeyListener {

	Frog gorf = new Frog(250, 620); // frog you control
	BufferedImage image; // rip idk what this does
	boolean game = true; // game over?
	// boolean newf=false;
	Car[] cars = new Car[5]; // array of all cars
	Log[] logs = new Log[15];
	Rectangle[] lily = new Rectangle[5];
	int score = 0;

	public Frogger() {
		setFocusable(true); // setting game and stuff..tbh idk fr what this does
		JFrame frame = new JFrame("Frogger");
		frame.setSize(570, 716); // x, y
		frame.add(this);
		frame.setVisible(true);
		addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try { // rip idk what this does

			// image = ImageIO.read(new File("C:\\Demo\\harrypotter.jpg"));
			//image = ImageIO.read(new File("bkilogram.png"));
			image = ImageIO.read(getClass().getResource("bkilogram.png"));

		} catch (Exception e) {
		}

		for (int x = 0; x < lily.length; x++) {
			lily[x] = new Rectangle(x * 118 + 8, 25, 60, 50);
		}

		for (int x = 0; x < cars.length; x++) {
			cars[x] = new Car((int) (Math.random() * 550), 340 + (x + 1) * 47, (x + 1) % 2); // x, y NEVER CHANGE YPOS;
		}

		for (int x = 0; x < logs.length; x++) {
			logs[x] = new Log((int) (Math.random() * 550), 37 + (x + 3) / 3 * 47, (x / 3) % 2);
		}

		while (true) { // enables restarting
			System.out.print(""); // some delay thing idk
			while (game) { // if game not over....
				gorf.move(); // move frog by reading keypresses
				for (int x = 0; x < cars.length; x++) { // move cars
					cars[x].move();
				}
				for (int x = 0; x < logs.length; x++) { // move logs
					logs[x].move();
				}
				for (Car c : cars) { // hit car? game over.
					if (c.getBorder().intersects(gorf.getBorder())) {
						game = false;
					}
				}
				if ((gorf.getY() < 330) && !gorf.win(lily)) { // is it on the log?
					int g = -1;
					for (int x = 0; x < logs.length; x++) {
						if (gorf.isWithin(logs[x].getBorder())) {
							g = x;
						}
					}
					if (g < 0) {
						game = false;
					} else {
						if (!gorf.cruise(logs[g])) {
							game = false;
						}
					}
				}

				for (int x = cars.length - 1; x >= 0; x--) { // if car goes over border, reset to xPos end/beg
					if (cars[x].getX() < -60) {
						cars[x].setX(610);
					} else if (cars[x].getX() > 610) {
						cars[x].setX(-60);
					}
				}

				for (int x = logs.length - 1; x >= 0; x--) { // if log goes over border, reset to xPos end/beg
					if (logs[x].getX() < -120) {
						logs[x].setX(670);
					} else if (logs[x].getX() > 670) {
						logs[x].setX(-120);
					}
				}

				if (gorf.win(lily)) { // did you make it? score increment! next 1!
					score++;
					gorf = new Frog(250, 620);
				}

				repaint(); // repaint!

				try { // rip idk what this does

					Thread.sleep(6);

				} catch (Exception e) {

				}
			}
		}
	}

	public static void main(String[] args) { // ye. game
		Frogger game = new Frogger();
	}

	public void paintComponent(Graphics g) { // put on screen
		super.paintComponent(g); // stuff
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(image, 0, 0, null);

		for (int x = 0; x < cars.length; x++) { // show cars
			if (cars[x] instanceof Car) {
				cars[x].paint(g2d);
			}
		}

		g2d.setColor(new Color(100, 27, 12)); // show logs
		for (int x = 0; x < logs.length; x++) {
			if (logs[x] instanceof Log) {
				logs[x].paint(g2d);

			}
		}

		gorf.paint(g2d); // shows frog

		Font font = new Font("Monospaced", Font.BOLD, 26); // 14 = font size
		// prints score
		g2d.setColor(Color.red);
		g2d.setFont(font);
		g2d.drawString("Score:" + score, 5, 280); // (text, x, y)

		// game over?
		if (!game) {
			g2d.setColor(Color.white);
			g2d.setFont(font);
			g2d.drawString("GAME OVER", 100, 100); // (text, x, y)
			g2d.drawString("Press space to restart", 95, 120); // (text, x, y)
		}
	}

	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_SPACE) && (!game)) {
			gorf = new Frog(250, 620);
			BufferedImage image; // rip idk what this does

			game = true; // game over?
			for (int x = 0; x < cars.length; x++) {
				cars[x] = new Car((int) (Math.random() * 550), 340 + (x + 1) * 47, (x + 1) % 2); // x, y NEVER CHANGE
																									// YPOS;
			}
			score = 0;
			repaint();
		}
		gorf.keyPressed(e); // sending to frog class
	}

	public void keyReleased(KeyEvent e) {
		gorf.keyReleased(e); // sending to frog class
	}

	public void keyTyped(KeyEvent e) {
		// not used
	}
}