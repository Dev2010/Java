import javax.swing.JFrame;

//A Frame is a top-level window with a title and a border.
//JFrame: An extended version of java.awt.Frame that adds support for the JFC/Swing component architecture.

public class GameWindow extends JFrame {

	public GameWindow()
	{
		super("Gaming Window");
		SetCanvasSize();
		Init();
	}
	
	public GameWindow(String name)
	{
		super(name);
		SetCanvasSize();
		Init();
	}
	
	public GameWindow(String name, int height, int width)
	{
		super(name);
		setSize(height, width);
		Init();
	}
	
	private void SetCanvasSize()
	{
		setSize(800,800);
	}
	
	private void Init()
	{
		setVisible(true);
	}
}