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
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class Eskiv extends JPanel implements KeyListener {

	EskivBall ball = new EskivBall(0, 0); // ball you control
	BufferedImage image; // rip idk what this does

	int x = 50;
	int y = 50; // positions of target

	boolean game = true; // game over?
	ArrayList<EnemyBall> eballs = new ArrayList<EnemyBall>(); // array of all enemy balls
	Rectangle r = new Rectangle(x, y, 20, 20); // rect of target
	int score = 0;

	public Eskiv() {
        setFocusable(true); //setting game and stuff
        JFrame frame = new JFrame("Eskivz");
        frame.setSize(586, 330);
        frame.add(this);
        frame.setVisible(true);
        addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try { //rip idk what this does

            image = ImageIO.read(new File("src/harrypotter.jpg"));

        } catch (Exception e) {
        }


        while (true){
			System.out.print("");
			while (game) { //if game not over....
				ball.move(); //move ball
				for (int x=0;x<eballs.size();x++){ //move enemy balls
					eballs.get(x).move();
				}
				for (EnemyBall e: eballs){ //hit enemy ball? game over?
					if (e.getBorder().intersects(ball.getBorder())){
						game=false;
					}
				}

				if (r.intersects(ball.getBorder())){ //if hits target: increment score, add ball
					score++;

					eballs.add(new EnemyBall());
					x=(int)(Math.random()*500)+1;
					y=(int)(Math.random()*270)+1;
					r = new Rectangle(x, y, 20, 20); //move target
				}

				repaint(); //repaint!

				try { //rip idk what this does

					Thread.sleep(5);

				} catch (Exception e) {

				}
			}
        }
    }

	public static void main(String[] args) { // ye. game
		Eskiv game = new Eskiv();
	}

	public void paintComponent(Graphics g) { // put on screen
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(image, 0, 0, null);
		g2d.setColor(Color.magenta);
		ball.paint(g2d);
		g2d.setColor(Color.blue);
		g2d.drawOval(x, y, 20, 20);
		g2d.setColor(Color.black);
		for (EnemyBall e : eballs) {
			e.paint(g2d);
		}

		Font font = new Font("Monospaced", Font.BOLD, 14); // 14 = font size
		// prints score
		g2d.setColor(Color.gray); // prints score
		g2d.setFont(font);
		g2d.drawString("Score:" + score, 5, 280); // (text, x, y)

		// game over?
		if (!game) {
			g2d.setColor(Color.gray);
			g2d.setFont(font);
			g2d.drawString("GAME OVER", 100, 100); // (text, x, y)
			g2d.drawString("Press space to restart", 95, 110); // (text, x, y)
		}
	}

	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_SPACE) && (!game)) {
			ball = new EskivBall(0, 0);
			BufferedImage image; // rip idk what this does

			x = 50;
			y = 50; // positions of target

			game = true; // game over?
			eballs = new ArrayList<EnemyBall>(); // array of all enemy balls

			r = new Rectangle(x, y, 20, 20); // rect of target
			score = 0;
			repaint();
		}

		ball.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		ball.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
		// not used
	}
}