import java.awt.Graphics;
import javax.swing.JPanel;

// JPanel - It is a generic class used to group other Components together.

public class GameCanvas extends JPanel {

	public GameCanvas()
	{
	}
	
	public void Draw()
	{
		
		while(true)
		{
			try {
				
				repaint(); // this will make Java runtime invoke paintComponent
				
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw the rectangle here
		Ball ball = new Ball();
		ball.Draw(g);
	}
}
