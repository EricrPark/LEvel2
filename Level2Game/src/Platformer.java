import javax.swing.JFrame;
public class Platformer {
	JFrame frame;
	static int width;
	static int length;
	GamePanel gamePanel;
	public Platformer() {
		gamePanel = new GamePanel();
		frame = new JFrame();
		width = 1920;
		length = 1080;
		frame.setSize(width, length);
		setup();
		frame.setVisible(true);
	}
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.add(gamePanel);
		frame.addKeyListener(gamePanel);
		gamePanel.startGame();
	}


	public static void main(String[] args) {
		Platformer gameFrame = new Platformer();
	}
}
