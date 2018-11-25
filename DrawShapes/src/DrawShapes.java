
public class DrawShapes {

	public void Draw()
	{
		GameCanvas gameCanvas = new GameCanvas();
		
		GameWindow gameWindow = new GameWindow();
		gameWindow.setContentPane(gameCanvas);
		//gameWindow.add(gameCanvas);
		
		gameCanvas.Draw();
	}
}
